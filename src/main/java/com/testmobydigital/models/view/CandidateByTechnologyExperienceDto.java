package com.testmobydigital.models.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CandidateByTechnologyExperienceDto {

    private String name;

    private String lastName;

    private Integer documentNumber;

    private Date birthdate;

    private String technologyName;

    private Integer version;

    private Integer yearsExperience;
}
