package com.example.demo.controller;

import com.example.demo.model.StudentDTO;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody StudentDTO stu) {
        studentService.createStudent(stu);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/get")
    public StudentDTO getStudent(@RequestBody StudentDTO stu) {
       return studentService.readStudent(stu);
    }

    @PostMapping("/modify")
    public ResponseEntity<?> modifyStudent(@RequestBody StudentDTO stu) {
        studentService.updateStudent(stu);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/remove")
    public ResponseEntity<?> removeStudent(@RequestBody StudentDTO stu) {
        studentService.deleteStudent(stu);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/list")
    public Collection<StudentDTO> listStudents() {
        return studentService.getAll();
    }

    @GetMapping("/getLastnameLike")
    public Set<StudentDTO> listStudentsWithLastnameLike(@RequestParam String lastname) {
        return studentService.getStudentsWithLastnameLike2(lastname);
    }

    @GetMapping("/getLastnameLike3")
    public List<StudentDTO> listStudentsWithLastnameLike3(@RequestParam String lastname) {
        return studentService.getStudentsWithLastnameLike3(lastname);
    }

    @GetMapping("/getLastnameLike4")
    public List<StudentDTO> listStudentsWithLastnameLike4(@RequestParam String lastname) {
        return studentService.getStudentsWithLastnameLike4(lastname);
    }


}
