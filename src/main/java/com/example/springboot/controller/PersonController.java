package com.example.springboot.controller;

import com.example.springboot.model.PersonPOJO;
import com.example.springboot.repository.Person;
import com.example.springboot.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


// use Controller, not RestController to use thymeleaf
@Controller
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

    @PostMapping(value = "/person/json", produces = "application/json")
    public ResponseEntity<Person> postPersonJson(@RequestBody Person person) {
        System.out.println("postPersonJson is called");
        Person savedPerson = personService.save(person);
        return new ResponseEntity<Person>(savedPerson, HttpStatus.OK);
    }
    
    @GetMapping("/person")
    public String showPersonForm(Model model) {
        model.addAttribute("person", new PersonPOJO());
        return "person";
    }

    @PostMapping("/person")
    public String postPerson(PersonPOJO personPOJO) {
        System.out.println("postPerson is called " + personPOJO);
        Person person = new Person();
        person.setName(personPOJO.getName());
        person.setTitle(personPOJO.getTitle());        
        Person savedPerson = personService.save(person);
        return "redirect:/person";
    }    
}
