package com.hostelmanagement.backend.rooms.service;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.rooms.dto.StudentsDTO;

import java.util.List;

public interface StudentsService {

    public List<StudentsDTO> getStudentsList() throws ServiceException;
}
