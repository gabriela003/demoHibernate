package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.StudentDTO;
import com.example.demo.repository.IStudentDAO;
import com.example.demo.repository.IStudentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentDAO studentDAO;

    @Autowired
    IStudentRepository studentRepository;

    @Autowired
    ModelMapper mapper;

    @PersistenceContext
    EntityManager em;

    @Override
    public void createStudent(StudentDTO stu) {
        saveStudent(stu);
    }

     @Override
    public StudentDTO readStudent(StudentDTO stu) {
        Student found = studentDAO.findById(stu.getId()).orElseThrow(() -> new EntityNotFoundException());
        return mapper.map(found, StudentDTO.class);
    }

    @Override
    public void updateStudent(StudentDTO stu) {
        saveStudent(stu);
    }

    @Override
    public void deleteStudent(StudentDTO stu) {
        studentDAO.deleteById(stu.getId());
    }

    @Override
    public Collection<StudentDTO> getAll() {
        Collection<Student> allStudents = studentRepository.findAll(Sort.by(Sort.Direction.DESC, "lastname"));

       // return allStudents.stream().map(student -> mapper.map(student, StudentDTO.class))
       // .collect(Collectors.toList());

       return mapper.map(allStudents, new TypeToken<List<StudentDTO>>() {}.getType());
    }

    @Override
    public Set<StudentDTO> getStudentsWithLastnameLike(String lastname) {
        Set<Student> allStudents = studentRepository.findByLastnameContaining(lastname);

        return mapper.map(allStudents, new TypeToken<Set<StudentDTO>>() {}.getType());
    }

    @Override
    public Set<StudentDTO> getStudentsWithLastnameLike2(String lastname) {
        Set<Student> allStudents = studentRepository.getStudentByLastnameLike(lastname);

        return mapper.map(allStudents, new TypeToken<Set<StudentDTO>>() {}.getType());
    }

    @Override
    public List<StudentDTO> getStudentsWithLastnameLike3(String lastname) {
        List students = em.createQuery("from Student s where s.lastname like ?1")
                .setParameter(1, "%" + lastname + "%")
                .getResultList();

        return mapper.map(students, new TypeToken<List<StudentDTO>>() {}.getType());
    }

    @Override
    public List<StudentDTO> getStudentsWithLastnameLike4(String lastname) {
        TypedQuery<Student> query = em.createNamedQuery("query1", Student.class)
                .setParameter("lastname", "%" + lastname + "%");

        return mapper.map(query.getResultList(), new TypeToken<List<StudentDTO>>() {}.getType());
    }

    private void saveStudent(StudentDTO stu) {
        Student newStudent = mapper.map(stu, Student.class);
        studentDAO.save(newStudent);
    }
}
