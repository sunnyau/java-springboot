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
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonView> getAll() {
        List<Person> personList = personRepository.findAll();
        Function<Person, PersonView> convertPersonToPersonView = person -> PersonView.builder().id(person.getId())
                .name(person.getName()).title(person.getTitle()).build();
        return personList.stream().map(convertPersonToPersonView).collect(toList());
    }

    public Person save(Person person) {
        return personRepository.saveAndFlush(person);
    }
}
