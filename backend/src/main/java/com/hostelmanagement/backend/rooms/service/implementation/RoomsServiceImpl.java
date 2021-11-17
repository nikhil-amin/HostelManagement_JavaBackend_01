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
    public List<RoomDTO> getRooms() throws ServiceException {
        try{
            return roomsDAO.getRooms();
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] getRooms() ",de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getRooms() ",e);
        }
    }

    @Override
    public RoomDTO getRoomByRoomNumber(int roomNumber) throws ServiceException {
        try{
            return roomsDAO.getRoomByRoomNumber(roomNumber);
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] getRoomByRoomNumber() ",de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getRoomByRoomNumber() ",e);
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

    @Override
    public void updateRoom(RoomDTO room, int roomID) throws ServiceException {
        try{
            roomsDAO.updateRoom(room, roomID);
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] updateRoom()", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] updateRoom() ", e);
        }
    }

    @Override
    public void deleteRoomByRoomID(int roomID) throws ServiceException {
        try{
            roomsDAO.deleteRoomByRoomID(roomID);
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] deleteRoomByRoomID()", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] deleteRoomByRoomID() ", e);
        }
    }

    @Override
    public void deleteAllRooms() throws ServiceException {
        try{
            roomsDAO.deleteAllRooms();
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] deleteAllRooms()", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] deleteAllRooms() ", e);
        }
    }
}
