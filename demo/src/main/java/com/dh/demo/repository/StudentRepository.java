package com.dh.demo.repository;

import com.dh.demo.domain.Student;
import com.dh.demo.web.StudentController;
import com.dh.demo.web.StudentController.StudentRequestDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ElmerVL on 10/06/2017.
 */
public interface StudentRepository extends MongoRepository<Student, String> {
}
