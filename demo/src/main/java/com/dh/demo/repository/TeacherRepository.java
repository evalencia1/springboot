package com.dh.demo.repository;

import com.dh.demo.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by ElmerVL on 03/06/2017.
 */
public interface TeacherRepository extends MongoRepository<Teacher, String> {
    @Query("{_id: ?0}")
    Teacher getTeacherById(Integer id);
}
