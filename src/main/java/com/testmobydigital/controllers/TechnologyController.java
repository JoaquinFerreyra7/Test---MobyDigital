package com.testmobydigital.controllers;

import com.testmobydigital.models.entities.Technology;
import com.testmobydigital.models.view.TechnologyDto;
import com.testmobydigital.services.TechnologyService;
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

@RequestMapping("/technology")
@RestController
public class TechnologyController {

    @Autowired
    TechnologyService technologyService;

    @PostMapping(value = "/create")
    public ResponseEntity<Technology> save(@RequestBody TechnologyDto technology){
        return new ResponseEntity<>(technologyService.save(technology), HttpStatus.CREATED);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Technology>> findAll(){
        return new ResponseEntity<>(technologyService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        technologyService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
