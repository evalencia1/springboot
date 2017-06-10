package com.dh.demo.service;

import com.dh.demo.domain.Room;
import com.dh.demo.domain.Student;
import com.dh.demo.domain.Subscription;
import com.dh.demo.domain.Teacher;
import com.dh.demo.repository.RoomRepository;
import com.dh.demo.repository.StudentRepository;
import com.dh.demo.repository.SubscriptionRepository;
import com.dh.demo.repository.TeacherRepository;
import com.dh.demo.web.SubscriptionController;
import com.dh.demo.web.SubscriptionController.SubscriptionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ElmerVL on 10/06/2017.
 */
@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public void addSubscription(SubscriptionRequestDTO subscriptionDTO) {
        Subscription subscription = new Subscription();
        Student student = studentRepository.findOne(subscriptionDTO.getStudentId());
        Teacher teacher = teacherRepository.findOne(subscriptionDTO.getTeacherId());
        Room room = roomRepository.findOne(subscriptionDTO.getRoomId());
        subscription.setStudent(student);
        subscription.setTeacher(teacher);
        subscription.setRoom(room);
        subscription.setSubDate(subscriptionDTO.getSubDate());

        subscriptionRepository.save(subscription);
    }
}
