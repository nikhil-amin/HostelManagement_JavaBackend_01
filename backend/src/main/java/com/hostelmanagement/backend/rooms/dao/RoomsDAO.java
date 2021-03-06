package com.hostelmanagement.backend.rooms.dao;

import java.util.List;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;

public interface RoomsDAO {

    public List<RoomDTO> getRooms() throws DBException;

    public void insertRooms(List<RoomDTO> rooms) throws DBException;

    public void insertRoom(RoomDTO room) throws DBException;

    public RoomDTO getRoomByRoomNumber(int roomNumber) throws DBException;

    public void updateRoomByRoomID(RoomDTO room, int roomID) throws DBException;

    public void deleteRoomByRoomID(int roomID) throws DBException;

    public void deleteAllRooms() throws DBException;
}
