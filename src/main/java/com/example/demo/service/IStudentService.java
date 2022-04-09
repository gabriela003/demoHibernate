package com.example.demo.service;

import com.example.demo.model.StudentDTO;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IStudentService {

    void createStudent(StudentDTO stu);
    StudentDTO readStudent(StudentDTO stu);
    void updateStudent(StudentDTO stu);
    void deleteStudent(StudentDTO stu);

    Collection<StudentDTO> getAll();
    Set<StudentDTO> getStudentsWithLastnameLike(String lastname);
    Set<StudentDTO> getStudentsWithLastnameLike2(String lastname);
    List<StudentDTO> getStudentsWithLastnameLike3(String lastname);
    List<StudentDTO> getStudentsWithLastnameLike4(String lastname);
}
