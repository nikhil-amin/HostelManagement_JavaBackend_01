package com.hostelmanagement.backend.rooms.service;

import java.util.List;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;

public interface RoomsService {

    public List<RoomDTO> getRooms() throws ServiceException;

    public void insertRooms(List<RoomDTO> rooms) throws ServiceException;

    public void insertRoom(RoomDTO room) throws ServiceException;

    public RoomDTO getRoomByRoomNumber(int roomNumber) throws ServiceException;

    public void updateRoomByRoomID(RoomDTO room, int roomID) throws ServiceException;

    public void deleteRoomByRoomID(int roomID) throws ServiceException;

    public void deleteAllRooms() throws ServiceException;

}
