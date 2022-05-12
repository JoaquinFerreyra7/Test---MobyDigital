package com.testmobydigital.models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "candidatextechnology")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateByTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "technology_id", referencedColumnName= "id")
    private Technology technology;

    @Column(name = "years_experience")
    private Integer yearsExperience;

}
