package com.hostelmanagement.backend.students.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.students.dto.StudentsDTO;
import com.hostelmanagement.backend.students.service.StudentsService;
import com.hostelmanagement.backend.util.ParsingUtil;

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
    
    @RequestMapping(value="/students/insertStudents", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertStudents(HttpServletRequest req, HttpServletResponse res, @RequestBody String studentsJson) throws ServiceException {
        try{
            List<StudentsDTO> students = (List<StudentsDTO>) (List<?>) ParsingUtil
                    .convertJsonStringToList(studentsJson.toString(), StudentsDTO.class);

            studentsService.insertStudents(students);
        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] insertStudents() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] insertStudents() ", e);
        }
    }

}
