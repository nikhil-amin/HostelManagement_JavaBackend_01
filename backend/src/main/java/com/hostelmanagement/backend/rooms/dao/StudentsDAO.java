package com.hostelmanagement.backend.rooms.dao;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.rooms.dto.StudentsDTO;

import java.util.List;

public interface StudentsDAO {

    public List<StudentsDTO> getStudentsList() throws DBException;
}
