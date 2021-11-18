package com.hostelmanagement.backend.students.service.implementation;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;
import com.hostelmanagement.backend.students.dao.StudentsDAO;
import com.hostelmanagement.backend.students.dto.StudentsDTO;
import com.hostelmanagement.backend.students.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public StudentsDTO getStudentsByUsn(String studentUsn) throws ServiceException {
        try{
            return studentsDAO.getStudentsByUsn(studentUsn);
        }catch (DBException de){
            throw new ServiceException("[ERROR:SE] getStudentsByUsn() ",de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getStudentsByUsn() ",e);
        }
    }
    
}
