package com.testmobydigital.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "candidates")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @NotBlank
    @Column(name = "documentType")
    private String documentType;

    @NotBlank
    @Column(name = "documentNumber")
    private Integer documentNumber;

    //@NotNull
    @Column(name = "birthdate")
    private Date birthdate;

    //private List<Technology> technologies;
}
