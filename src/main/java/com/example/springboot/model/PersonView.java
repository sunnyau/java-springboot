package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@Data
@RequiredArgsConstructor
public class PersonView {

    @JsonFormat
    private final Long id;
    @JsonFormat
    private final String name;
    @JsonFormat
    private final String title;
}
