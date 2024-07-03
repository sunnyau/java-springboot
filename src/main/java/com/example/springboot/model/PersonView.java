package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PersonView {

    @JsonFormat
    private final Integer id;
    @JsonFormat
    private final String name;
    @JsonFormat
    private final String title;
}
