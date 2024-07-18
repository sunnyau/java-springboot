package com.example.springboot.controller;

import com.example.springboot.repository.Person;
import com.example.springboot.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person/all")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @PostMapping(value = "/person", produces = "application/json")
    public ResponseEntity<Person> update(@RequestBody Person person) {
        Person savedPerson = personService.save(person);
        return new ResponseEntity<Person>(savedPerson, HttpStatus.OK);
    }
    
}
