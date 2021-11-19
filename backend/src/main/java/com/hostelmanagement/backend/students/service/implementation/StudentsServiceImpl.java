package com.hostelmanagement.backend.students.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.students.dao.StudentsDAO;
import com.hostelmanagement.backend.students.dto.StudentsDTO;
import com.hostelmanagement.backend.students.service.StudentsService;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsDAO studentsDAO;

    public List<StudentsDTO> getStudents() throws ServiceException {
        try{
            return studentsDAO.getStudents();
        }catch (DBException de){
            throw new ServiceException("[ERROR:DE] getStudents() ", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getStudents() ", e);
        }
    }
    
    @Override
    public StudentsDTO getStudentByUsn(String studentUsn) throws ServiceException {
        try{
            return studentsDAO.getStudentByUsn(studentUsn);
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] getStudentByUsn() ",de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getStudentByUsn() ",e);
        }
    }
    
    @Override
    public void insertStudents(List<StudentsDTO> students) throws ServiceException {
        try{
        	studentsDAO.insertStudents(students);
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] insertStudents()", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] insertStudents() ", e);
        }
    }

	@Override
	public void insertStudent(StudentsDTO student) throws ServiceException {
		try{
        	studentsDAO.insertStudent(student);
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] insertStudent()", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] insertStudent() ", e);
        }
	}

	@Override
	public void updateStudentByStudentID(StudentsDTO student, int studentID) throws ServiceException {
		try{
        	studentsDAO.updateStudentByStudentID(student, studentID);
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] updateStudentByStudentID()", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] updateStudentByStudentID() ", e);
        }
	}

	@Override
	public void deleteStudentByStudentID(int studentID) throws ServiceException {
		try{
        	studentsDAO.deleteStudentByStudentID(studentID);
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] deleteStudentByStudentID()", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] deleteStudentByStudentID() ", e);
        }
	}

	@Override
	public void deleteAllStudents() throws ServiceException {
		try{
        	studentsDAO.deleteAllStudents();
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] deleteAllStudents()", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] deleteAllStudents() ", e);
        }
	}
    
}
