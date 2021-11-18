package com.hostelmanagement.backend.students.dao;

import java.util.List;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.students.dto.StudentsDTO;

public interface StudentsDAO {

    public List<StudentsDTO> getStudentsList() throws DBException;
    
    public StudentsDTO getStudentByUsn(String studentUsn) throws DBException;
    
    public void insertStudents(List<StudentsDTO> students) throws DBException;

	public void insertStudent(StudentsDTO student) throws DBException;

	public void updateStudentByStudentID(StudentsDTO student, int studentID) throws DBException;
    
}
