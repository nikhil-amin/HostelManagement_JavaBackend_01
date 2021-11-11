package com.hostelmanagement.backend.rooms.service;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;

import java.util.List;

public interface RoomsService {

    public List<RoomDTO> getRoomsList() throws ServiceException;
}