package com.example.springboot.service;

import com.example.springboot.model.PersonView;
import com.example.springboot.repository.Person;
import com.example.springboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository userRepository) {
        this.personRepository = userRepository;
    }

    public List<PersonView> getAll() {
        List<Person> userList = personRepository.findAll();
        Function<Person,PersonView> convertUserToPersonView = person -> PersonView.builder().id(person.getId()).name(person.getName()).title(person.getTitle()).build();
        return userList.stream().map(convertUserToPersonView).collect(toList());
    }
}
