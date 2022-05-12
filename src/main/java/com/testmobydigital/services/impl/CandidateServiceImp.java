package com.testmobydigital.services.impl;

import com.testmobydigital.models.entities.Candidate;
import com.testmobydigital.models.entities.CandidateByTechnology;
import com.testmobydigital.models.view.CandidateByTechnologyExperienceDto;
import com.testmobydigital.models.view.CandidateDto;
import com.testmobydigital.models.view.CandidateByTechnologyDto;
import com.testmobydigital.projection.CandidateByTechnologiesNameProjection;
import com.testmobydigital.repository.CandidateByTechnologyRepository;
import com.testmobydigital.repository.CandidateRepository;
import com.testmobydigital.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateServiceImp implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    CandidateByTechnologyRepository candidateByTechnologyRepository;


    @Override
    public Candidate save(CandidateDto candidateDto) {
        Candidate candidate = Candidate.builder()
                .name(candidateDto.getName())
                .lastname(candidateDto.getLastname())
                .documentType(candidateDto.getDocumentType())
                .documentNumber(candidateDto.getDocumentNumber())
                .birthdate(candidateDto.getBirthdate())
                .build();
        return candidateRepository.save(candidate);
    }

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        candidateRepository.deleteById(id);
    }

    @Override
    public CandidateByTechnology saveYearsExperience(CandidateByTechnologyDto candidateByTechnologyDto) {
        CandidateByTechnology candidateByTechnology = CandidateByTechnology.builder()
                .candidate(candidateByTechnologyDto.getCandidate())
                .technology(candidateByTechnologyDto.getTechnology())
                .yearsExperience(candidateByTechnologyDto.getYearsExperience())
                .build();
        return candidateByTechnologyRepository.save(candidateByTechnology);
    }

    @Override
    public List<CandidateByTechnologyExperienceDto> listCandidatesByTechnologyName(String technologyName) {
        List<CandidateByTechnologyExperienceDto> listCandidates = new ArrayList<>();
        List<CandidateByTechnologiesNameProjection> listProjection = candidateByTechnologyRepository.listCandidatesByTechnologyName(technologyName);

        for(CandidateByTechnologiesNameProjection ct : listProjection){
            CandidateByTechnologyExperienceDto cte = CandidateByTechnologyExperienceDto.builder()
                    .name(ct.getName())
                    .lastName(ct.getLastname())
                    .birthdate(ct.getBirthdate())
                    .documentNumber(ct.getDocument_number())
                    .technologyName(ct.getTechnology_name())
                    .version(ct.getVersion())
                    .yearsExperience(ct.getYears_experience())
                    .build();
            listCandidates.add(cte);
        }
        return listCandidates;
    }
}
