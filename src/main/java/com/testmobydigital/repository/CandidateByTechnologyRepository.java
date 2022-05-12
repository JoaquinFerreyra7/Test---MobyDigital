package com.testmobydigital.repository;

import com.testmobydigital.models.entities.Candidate;
import com.testmobydigital.models.entities.CandidateByTechnology;
import com.testmobydigital.projection.CandidateByTechnologiesNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateByTechnologyRepository extends JpaRepository<CandidateByTechnology,Long> {

    @Query(value = "SELECT c.name,c.lastname,c.document_number,c.birthdate,t.name,t.version, ct.years_experience FROM candidatextechnology ct INNER JOIN candidates c ON ct.candidate_id = c.id INNER JOIN technologies t ON ct.technology_id = t.id WHERE t.name LIKE ?1", nativeQuery = true)
    List<CandidateByTechnologiesNameProjection> listCandidatesByTechnologyName(String technologyName);
}
