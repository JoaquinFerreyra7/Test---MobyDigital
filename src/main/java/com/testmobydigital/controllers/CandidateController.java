package com.testmobydigital.controllers;

import com.testmobydigital.models.entities.Candidate;
import com.testmobydigital.models.entities.CandidateByTechnology;
import com.testmobydigital.models.view.CandidateByTechnologyExperienceDto;
import com.testmobydigital.models.view.CandidateDto;
import com.testmobydigital.models.view.CandidateByTechnologyDto;
import com.testmobydigital.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/candidate")
@RestController
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping(value = "/create")
    public ResponseEntity<Candidate> save(@RequestBody CandidateDto candidate){
        return new ResponseEntity<>(candidateService.save(candidate), HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Candidate>> findAll(){
        return new ResponseEntity<>(candidateService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        candidateService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping(value = "/saveYears")
    public ResponseEntity<CandidateByTechnology> saveYearsExperience(@RequestBody CandidateByTechnologyDto candidateByTechnologyDto){
        return new ResponseEntity<>(candidateService.saveYearsExperience(candidateByTechnologyDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/listTechnologies/{technologyName}")
    public ResponseEntity<List<CandidateByTechnologyExperienceDto>> listCandidatesByTechnologyName(@PathVariable String technologyName){
        return new ResponseEntity<>(candidateService.listCandidatesByTechnologyName(technologyName), HttpStatus.OK);
    }
    
}
