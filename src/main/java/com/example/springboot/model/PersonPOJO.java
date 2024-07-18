package com.example.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonPOJO {

    private Long id;
    private String name;
    private String title;
}
