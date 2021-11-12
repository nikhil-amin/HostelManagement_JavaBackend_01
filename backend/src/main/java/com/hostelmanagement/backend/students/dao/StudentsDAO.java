package com.hostelmanagement.backend.students.dao;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.students.dto.StudentsDTO;

import java.util.List;

public interface StudentsDAO {

    public List<StudentsDTO> getStudentsList() throws DBException;
}
