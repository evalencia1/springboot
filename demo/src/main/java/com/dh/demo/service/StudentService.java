package com.dh.demo.service;

import com.dh.demo.domain.Student;
import com.dh.demo.repository.StudentRepository;
import com.dh.demo.web.StudentController;
import com.dh.demo.web.StudentController.StudentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ElmerVL on 10/06/2017.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(StudentRequestDTO studentDTO) {
        Student student = new Student();
        student.setCi(studentDTO.getCi());
        student.setName(studentDTO.getName());
        student.setCodeSis(studentDTO.getCodeSis());

        studentRepository.save(student);
    }
}
