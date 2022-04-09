package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class StudentDTO {

    private Long id;
    private String name;
    private String lastname;

    private Set<SubjectDTO> subjects;
}
