package com.example.springboot.service;

import com.example.springboot.model.PersonView;
import com.example.springboot.repository.Person;
import com.example.springboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.Iterator;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonView> getAll() {
        System.out.println("PersonService is called");
        // Iterable<Person> personIterable = personRepository.findAll();
        // Iterator<Person> iterator = personIterable.iterator();
        // System.out.println("before iterator");
        // while( personIterable.iterator().hasNext() ) {
        //     System.out.println(iterator.next());
        // }
        // System.out.println("after iterator");
        // return Collections.emptyList();

        List<Person> personList = personRepository.findAll();
        System.out.println("personList size is " + personList.size());
        Function<Person,PersonView> convertUserToPersonView = person -> PersonView.builder().id(person.getId()).name(person.getName()).title(person.getTitle()).build();
        return personList.stream().map(convertUserToPersonView).collect(toList());
    }
}
