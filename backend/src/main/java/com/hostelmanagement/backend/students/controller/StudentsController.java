package com.hostelmanagement.backend.students.controller;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;
import com.hostelmanagement.backend.students.dto.StudentsDTO;
import com.hostelmanagement.backend.students.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/students/getStudentsList", method = RequestMethod.GET, produces = "application/json")
    public List<StudentsDTO> getStudentsList() throws ServiceException{
        try{
            return studentsService.getStudentsList();
        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] getStudentsList() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getStudentsList() ", e);
        }
    }
    
    @RequestMapping(value="/students/getStudentByUsn/{studentUsn}", method= RequestMethod.GET, produces = "application/json")
    public StudentsDTO getStudentByUsn(@PathVariable("studentUsn") String studentUsn) throws ServiceException {
        try{
            return studentsService.getStudentByUsn(studentUsn);
        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] getStudentByUsn() ",se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getStudentByUsn() ",e);
        }
    }
}
