package com.dh.demo.service;

import com.dh.demo.domain.Teacher;
import com.dh.demo.repository.TeacherRepository;
import com.dh.demo.web.TeacherController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  ElmerVL on 03/06/2017.
 */

@Service
public class TeacherService {

    //injection de dependencia
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        //TODO user repository

        List<Teacher> teacherList =  teacherRepository.findAll();

        return teacherList;

    }

    public void addTeacher(TeacherController.TeacherRequestDTO teacherDTO) {
        //TODO add DATA-BASE
        Teacher teacher = new Teacher();
        teacher.setName(teacherDTO.getName());
        teacher.setcI(teacherDTO.getcI());
        teacher.setProfession(teacherDTO.getProfession());

        teacherRepository.save(teacher);

    }

    public List<Teacher> getTeacher(String id) {
        List<Teacher> teacherList = new ArrayList<>();
        Teacher teacher = teacherRepository.findOne(id);

        teacherList.add(teacher);

        return teacherList;
    }

    public void updateTeacher(String id, Teacher teacher) {

        teacherRepository.delete(id);

        teacher.setId(id);

        teacherRepository.save(teacher);
    }

    public void deleteTeacher(String id) {
        teacherRepository.delete(id);
    }
}
