package com.testmobydigital.controllers;

import com.google.gson.Gson;
import com.testmobydigital.models.entities.Technology;
import com.testmobydigital.services.TechnologyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static com.testmobydigital.Testutils.TestEntityFactory.getTechnology;
import static com.testmobydigital.Testutils.TestEntityFactory.getTechnologyDto;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles
@AutoConfigureMockMvc
public class TechnologyControllerTest {

    @MockBean
    TechnologyService technologyService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void saveTest() throws Exception {
        when(technologyService.save(getTechnologyDto())).thenReturn(getTechnology());

        String technologyDto = new Gson().toJson(getTechnologyDto());

        mockMvc.perform(post("/technology/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(technologyDto))
                .andExpect(status().isCreated());
    }

    @Test
    void findAllTest() throws Exception {
        List<Technology> technologies = new ArrayList<>();
        when(technologyService.findAll()).thenReturn(technologies);

        mockMvc.perform(get("/technology/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTest() throws Exception {
        mockMvc.perform(delete("/technology/delete/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
