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
public class CandidateDto {

    private String name;

    private String lastname;

    private String documentType;

    private Integer documentNumber;

    private Date birthdate;
}
