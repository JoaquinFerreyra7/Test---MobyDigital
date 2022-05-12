package com.testmobydigital.services;

import com.testmobydigital.models.entities.Candidate;
import com.testmobydigital.models.entities.CandidateByTechnology;
import com.testmobydigital.models.view.CandidateByTechnologyExperienceDto;
import com.testmobydigital.models.view.CandidateDto;
import com.testmobydigital.models.view.CandidateByTechnologyDto;

import java.util.List;

public interface CandidateService {

    Candidate save(CandidateDto candidate);

    List<Candidate> findAll();

    void deleteById(Long id);

    CandidateByTechnology saveYearsExperience(CandidateByTechnologyDto candidateByTechnologyDto);

    List<CandidateByTechnologyExperienceDto> listCandidatesByTechnologyName(String technologyName);
}
