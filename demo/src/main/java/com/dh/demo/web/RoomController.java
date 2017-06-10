package com.dh.demo.web;

import com.dh.demo.domain.Room;
import com.dh.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ElmerVL on 10/06/2017.
 */
@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Room> getAllStudents() {
        return roomService.getAllRooms();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void addStudent(@RequestBody RoomRequestDTO room) {
        roomService.addRoom(room);
    }

    //DTO
    public static class RoomRequestDTO {

        private Integer capacity;

        public Integer getCapacity() {
            return capacity;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }
    }

}
