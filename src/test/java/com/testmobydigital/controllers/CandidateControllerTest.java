package com.testmobydigital.controllers;

import com.google.gson.Gson;
import com.testmobydigital.models.entities.Candidate;
import com.testmobydigital.services.CandidateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static com.testmobydigital.Testutils.TestEntityFactory.getCandidate;
import static com.testmobydigital.Testutils.TestEntityFactory.getCandidateDto;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CandidateControllerTest {

    @MockBean
    CandidateService candidateService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveTest() throws Exception {
        when(candidateService.save(getCandidateDto())).thenReturn(getCandidate());

        String candidateDto = new Gson().toJson(getCandidateDto());

        mockMvc.perform(post("/candidate/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(candidateDto))
                .andExpect(status().isCreated());
    }

    @Test
    void findAllTest() throws Exception {
        List<Candidate> candidates = new ArrayList<>();
        when(candidateService.findAll()).thenReturn(candidates);

        mockMvc.perform(get("/candidate/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTest() throws Exception {
        mockMvc.perform(delete("/candidate/delete/1")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
