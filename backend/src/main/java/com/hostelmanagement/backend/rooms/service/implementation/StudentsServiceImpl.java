package com.hostelmanagement.backend.rooms.service.implementation;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.rooms.dao.StudentsDAO;
import com.hostelmanagement.backend.rooms.dto.StudentsDTO;
import com.hostelmanagement.backend.rooms.service.StudentsService;
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
}
