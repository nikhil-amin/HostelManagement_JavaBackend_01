package com.hostelmanagement.backend.rooms.service.implementation;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.rooms.dao.RoomsDAO;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;
import com.hostelmanagement.backend.rooms.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomsServiceImpl implements RoomsService {

    @Autowired
    private RoomsDAO roomsDAO;

    @Override
    public List<RoomDTO> getRoomsList() throws ServiceException {
        try{
            return roomsDAO.getRoomsList();
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] getRoomsList() ",de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getRoomsList() ",e);
        }
    }

    @Override
    public void insertRooms(List<RoomDTO> rooms) throws ServiceException {
        try{
            roomsDAO.insertRooms(rooms);
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] insertRooms()", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] insertRooms() ", e);
        }
    }

    @Override
    public void insertRoom(RoomDTO room) throws ServiceException {
        try{
            roomsDAO.insertRoom(room);
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] insertRoom()", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] insertRoom() ", e);
        }
    }
}
