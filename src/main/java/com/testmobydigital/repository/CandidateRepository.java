package com.testmobydigital.repository;

import com.testmobydigital.models.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository  extends JpaRepository<Candidate,Long> {
}
