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

    public List<StudentsDTO> getStudentsList() throws ServiceException{
        try{
            return studentsDAO.getStudentsList();
        }catch (DBException de){
            throw new ServiceException("[ERROR:DE] getStudentsList() ", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getStudentsList() ", e);
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
    
}
