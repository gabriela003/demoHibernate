package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    Set<Student> findByLastnameContainingOrderByLastnameAsc(String lastname);

    @Query("from Student s where s.lastname like %:lastname%")
    Set<Student> getStudentByLastnameLike(@Param("lastname") String lastname);


    Set<Student> findByLastnameContaining(String lastname);
}
