package com.hostelmanagement.backend.rooms.controller;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;
import com.hostelmanagement.backend.rooms.service.RoomsService;
import com.hostelmanagement.backend.util.ParsingUtil;
import org.json.JSONObject;
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

    @RequestMapping(value="/rooms/getRooms", method= RequestMethod.GET, produces = "application/json")
    public List<RoomDTO> getRooms() throws ServiceException {
        try{
            return roomsService.getRooms();
        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] getRoomsList() ",se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getRoomsList() ",e);
        }
    }

    @RequestMapping(value="/rooms/getRoomByRoomNumber/{roomNumber}", method= RequestMethod.GET, produces = "application/json")
    public RoomDTO getRoomByRoomNumber(@PathVariable("roomNumber") int roomNumber) throws ServiceException {
        try{
            return roomsService.getRoomByRoomNumber(roomNumber);
        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] getRoomByRoomNumber() ",se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getRoomByRoomNumber() ",e);
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

    @RequestMapping(value="/rooms/insertRoom", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertRoom(HttpServletRequest req, HttpServletResponse res, @RequestBody String roomJson) throws ServiceException {
        try{
            JSONObject jsonObject = new JSONObject(ParsingUtil.validateString(roomJson));
            int roomNumber = Integer.parseInt(jsonObject.get("roomNumber").toString());
            String roomType = jsonObject.get("roomType").toString();
            int totalNumberOfBeds = Integer.parseInt(jsonObject.get("totalNumberOfBeds").toString());
            int occupiedNumberOfBeds = Integer.parseInt(jsonObject.get("occupiedNumberOfBeds").toString());
            int roomPrice = Integer.parseInt(jsonObject.get("roomPrice").toString());
            String roomDescription = jsonObject.get("roomDescription").toString();

            RoomDTO room = new RoomDTO(roomNumber, roomType, totalNumberOfBeds, occupiedNumberOfBeds, roomPrice, roomDescription);

            roomsService.insertRoom(room);

        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] insertRooms() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] insertRooms() ", e);
        }
    }

    @RequestMapping(value="/rooms/updateRoom/{roomID}", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void updateRoom(HttpServletRequest req, HttpServletResponse res,
                           @RequestBody String roomJson, @PathVariable("roomID") int roomID) throws ServiceException {
        try{
            JSONObject jsonObject = new JSONObject(ParsingUtil.validateString(roomJson));
            int roomNumber = Integer.parseInt(jsonObject.get("roomNumber").toString());
            String roomType = jsonObject.get("roomType").toString();
            int totalNumberOfBeds = Integer.parseInt(jsonObject.get("totalNumberOfBeds").toString());
            int occupiedNumberOfBeds = Integer.parseInt(jsonObject.get("occupiedNumberOfBeds").toString());
            int roomPrice = Integer.parseInt(jsonObject.get("roomPrice").toString());
            String roomDescription = jsonObject.get("roomDescription").toString();

            RoomDTO room = new RoomDTO(roomNumber, roomType, totalNumberOfBeds, occupiedNumberOfBeds, roomPrice, roomDescription);

            roomsService.updateRoom(room, roomID);

        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] updateRoom() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] updateRoom() ", e);
        }
    }

    @RequestMapping(value="/rooms/deleteRoomByRoomID/{roomID}", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void deleteRoomByRoomID(HttpServletRequest req, HttpServletResponse res, @PathVariable("roomID") int roomID) throws ServiceException {
        try{
            roomsService.deleteRoomByRoomID(roomID);

        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] deleteRoomByRoomID() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] deleteRoomByRoomID() ", e);
        }
    }
}
