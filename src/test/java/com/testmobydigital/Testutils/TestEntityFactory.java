package com.testmobydigital.Testutils;

import com.testmobydigital.models.entities.Candidate;
import com.testmobydigital.models.entities.Technology;
import com.testmobydigital.models.view.CandidateDto;
import com.testmobydigital.models.view.TechnologyDto;

import java.util.Date;

public class TestEntityFactory {

    public static CandidateDto getCandidateDto(){
        CandidateDto candidateDto = CandidateDto.builder()
                .name("Joaquin")
                .lastname("Ferreyra")
                .documentType("DNI")
                .documentNumber(33345)
                .birthdate(null)
                .build();
        return candidateDto;
    }

    public static Candidate getCandidate(){
        Candidate candidate = Candidate.builder()
                .name("Joaquin")
                .lastname("Ferreyra")
                .documentType("DNI")
                .documentNumber(33345)
                .birthdate(null)
                .build();
        return candidate;
    }

    public static TechnologyDto getTechnologyDto(){
        TechnologyDto technologyDto = TechnologyDto.builder()
                .name("Java")
                .version(8)
                .build();
        return technologyDto;
    }

    public static Technology getTechnology(){
        Technology technology = Technology.builder()
                .name("Java")
                .version(8)
                .build();
        return technology;
    }
}
