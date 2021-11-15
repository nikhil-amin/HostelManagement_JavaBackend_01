package com.hostelmanagement.backend.rooms.controller;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;
import com.hostelmanagement.backend.rooms.service.RoomsService;
import com.hostelmanagement.backend.util.ParsingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value="/rooms/insertRooms", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertRooms(HttpServletRequest req, HttpServletResponse res, @RequestBody String roomsJson) throws ServiceException {
        try{
            List<RoomDTO> rooms = (List<RoomDTO>) (List<?>) ParsingUtil
                    .convertJsonStringToList(roomsJson.toString(), RoomDTO.class);

            roomsService.insertRooms(rooms);
        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] insertRooms() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] insertRooms() ", e);
        }
    }
}
