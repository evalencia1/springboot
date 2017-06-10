package com.dh.demo.web;

import com.dh.demo.domain.Teacher;
import com.dh.demo.service.TeacherService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author  ElmerVL on 03/06/2017.
 */

@RestController
@RequestMapping("/teachers")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void addTeacher(@RequestBody TeacherRequestDTO teacher) {
        teacherService.addTeacher(teacher);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Teacher> getTeacher(@PathVariable String id) {
        return teacherService.getTeacher(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable String id, @RequestBody Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacher(id);
    }

    //DTO
    public static class TeacherRequestDTO {

        private String name;

        private long cI;

        private String profession;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getcI() {
            return cI;
        }

        public void setcI(long cI) {
            this.cI = cI;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }
    }
}
