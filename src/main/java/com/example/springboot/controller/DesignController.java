package com.example.springboot.controller;

import com.example.springboot.model.PersonPOJO;
import com.example.springboot.repository.Person;
import com.example.springboot.service.PersonService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
public class DesignController {

    private final PersonService personService;

    @Autowired
    public DesignController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/design")
    public String showDesignForm(Model model) {
        model.addAttribute("design", new PersonPOJO());
        return "design";
    }

    @PostMapping("/design")
    public String postMethodName(PersonPOJO personPOJO) {
        //TODO: process POST request
        System.out.println("postMethodName is called " + personPOJO);
        // PersonPOJO personPOJO = (PersonPOJO)model.getAttribute("design");
        // String name = personPOJO.getName();
        // String title = personPOJO.getTitle();
        // System.out.println(personPOJO.getName());
        // System.out.println(personPOJO.getTitle());
        Person person = new Person();
        person.setName(personPOJO.getName());
        person.setTitle(personPOJO.getTitle());
        
        Person savedPerson = personService.save(person);
        // return new ResponseEntity<Person>(savedPerson, HttpStatus.OK);        
        return "redirect:/design";
    }
    

}
