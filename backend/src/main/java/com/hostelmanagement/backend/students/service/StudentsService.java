package com.hostelmanagement.backend.students.service;

import java.util.List;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.students.dto.StudentsDTO;

public interface StudentsService {

    public List<StudentsDTO> getStudentsList() throws ServiceException;
    
    public StudentsDTO getStudentByUsn(String studentUsn) throws ServiceException;
    
    public void insertStudents(List<StudentsDTO> students) throws ServiceException;

	public void insertStudent(StudentsDTO student) throws ServiceException;
	
    public void updateStudentByStudentID(StudentsDTO student, int studentID) throws ServiceException;

	public void deleteStudentByStudentID(int studentID) throws ServiceException;

	public void deleteAllStudents() throws ServiceException;

}
