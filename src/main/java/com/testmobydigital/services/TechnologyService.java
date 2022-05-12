package com.testmobydigital.services;

import com.testmobydigital.models.entities.Technology;
import com.testmobydigital.models.view.TechnologyDto;

import java.util.List;

public interface TechnologyService {

    Technology save(TechnologyDto technology);

    List<Technology> findAll();

    void deleteById(Long id);
}
