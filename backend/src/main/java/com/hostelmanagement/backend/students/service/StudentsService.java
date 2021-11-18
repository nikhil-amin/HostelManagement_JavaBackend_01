package com.hostelmanagement.backend.students.service;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.students.dto.StudentsDTO;

import java.util.List;

public interface StudentsService {

    public List<StudentsDTO> getStudentsList() throws ServiceException;
    
    public StudentsDTO getStudentByUsn(String studentUsn) throws ServiceException;
}
