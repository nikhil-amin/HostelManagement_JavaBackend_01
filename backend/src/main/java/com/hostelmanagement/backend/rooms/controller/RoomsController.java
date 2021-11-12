package com.hostelmanagement.backend.rooms.controller;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;
import com.hostelmanagement.backend.rooms.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomsController {

    @Autowired
    private RoomsService roomsService;

    @RequestMapping(value="/rooms/getRoomsList", method= RequestMethod.GET, produces = "application/json")
    public List<RoomDTO> getRoomsList() throws ServiceException {
        try{
            return roomsService.getRoomsList();
        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] getRoomsList() ",se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getRoomsList() ",e);
        }
    }
}
