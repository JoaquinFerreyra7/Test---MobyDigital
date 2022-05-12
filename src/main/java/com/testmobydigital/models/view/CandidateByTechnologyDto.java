package com.testmobydigital.models.view;

import com.testmobydigital.models.entities.Candidate;
import com.testmobydigital.models.entities.Technology;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CandidateByTechnologyDto {

    private Candidate candidate;

    private Technology technology;

    private Integer yearsExperience;
}
