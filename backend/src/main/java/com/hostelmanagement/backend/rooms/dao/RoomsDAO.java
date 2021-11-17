package com.hostelmanagement.backend.rooms.dao;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;

import java.util.List;

public interface RoomsDAO {

    public List<RoomDTO> getRooms() throws DBException;

    public void insertRooms(List<RoomDTO> rooms) throws DBException;

    public void insertRoom(RoomDTO room) throws DBException;
}
