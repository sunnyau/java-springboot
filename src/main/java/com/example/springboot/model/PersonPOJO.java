package com.example.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * To allow the /person page to submit a Person
 */
@Data
@NoArgsConstructor
public class PersonPOJO {

    private Long id;
    private String name;
    private String title;
}
