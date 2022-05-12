package com.testmobydigital.services.impl;

import com.testmobydigital.models.entities.Technology;
import com.testmobydigital.models.view.TechnologyDto;
import com.testmobydigital.repository.TechnologyRepository;
import com.testmobydigital.services.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImp  implements TechnologyService {

    @Autowired
    TechnologyRepository technologyRespository;

    @Override
    public Technology save(TechnologyDto technologyDto) {
        Technology technology = Technology.builder()
                .name(technologyDto.getName())
                .version(technologyDto.getVersion())
                .build();
        return technologyRespository.save(technology) ;
    }

    @Override
    public List<Technology> findAll() {
        return technologyRespository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        technologyRespository.deleteById(id);
    }
}
