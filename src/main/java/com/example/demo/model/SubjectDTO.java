package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class SubjectDTO {

    private Long id;
    private String name;
    private String leader;

    private Set<StudentDTO> students;
}
