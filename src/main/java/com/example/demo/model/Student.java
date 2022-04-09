package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Students")
@Getter @Setter
@NamedQuery(name = "query1", query = "from Student s where s.lastname like :lastname")
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastname;

    @ManyToMany(cascade = CascadeType.ALL)
    @OrderBy("name ASC")
    private Set<Subject> subjects;
}
