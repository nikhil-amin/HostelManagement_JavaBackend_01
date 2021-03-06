package com.hostelmanagement.backend.students.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @RequestMapping(value = "/students/getStudents", method = RequestMethod.GET, produces = "application/json")
    public List<StudentsDTO> getStudents() throws ServiceException{
        try{
            return studentsService.getStudents();
        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] getStudents() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getStudents() ", e);
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
    
    @RequestMapping(value="/students/insertStudent", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertRoom(HttpServletRequest req, HttpServletResponse res, @RequestBody String studentJson) throws ServiceException {
        try{
            JSONObject jsonObject = new JSONObject(ParsingUtil.validateString(studentJson));
            String studentName = jsonObject.get("studentName").toString();
            String studentUsn = jsonObject.get("studentUsn").toString();
            String studentPhone = jsonObject.get("studentPhone").toString();
            String studentEmail = jsonObject.get("studentEmail").toString();
            int roomID = Integer.parseInt(jsonObject.get("roomID").toString());
            boolean messFacilityOpted = "YES".equalsIgnoreCase(jsonObject.get("messFacilityOpted").toString());

            StudentsDTO student = new StudentsDTO(studentName, studentUsn, studentPhone, studentEmail, roomID, messFacilityOpted);

            studentsService.insertStudent(student);

        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] insertRooms() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] insertRooms() ", e);
        }
    }
    
    @RequestMapping(value="/students/updateStudentByStudentID/{studentID}", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void updateStudentByStudentID(HttpServletRequest req, HttpServletResponse res,
                           @RequestBody String studentJson, @PathVariable("studentID") int studentID) throws ServiceException {
        try{
            JSONObject jsonObject = new JSONObject(ParsingUtil.validateString(studentJson));
            String studentName = jsonObject.get("studentName").toString();
            String studentUsn = jsonObject.get("studentUsn").toString();
            String studentPhone = jsonObject.get("studentPhone").toString();
            String studentEmail = jsonObject.get("studentEmail").toString();
            int roomID = Integer.parseInt(jsonObject.get("roomID").toString());
            boolean messFacilityOpted = "YES".equalsIgnoreCase(jsonObject.get("messFacilityOpted").toString());

            StudentsDTO student = new StudentsDTO(studentName, studentUsn, studentPhone, studentEmail, roomID, messFacilityOpted);

            studentsService.updateStudentByStudentID(student, studentID);

        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] updateStudentByStudentID() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] updateStudentByStudentID() ", e);
        }
    }
    
    @RequestMapping(value="/students/deleteStudentByStudentID/{studentID}", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentByStudentID(HttpServletRequest req, HttpServletResponse res, @PathVariable("studentID") int studentID) throws ServiceException {
        try{
        	studentsService.deleteStudentByStudentID(studentID);

        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] deleteStudentByStudentID() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] deleteStudentByStudentID() ", e);
        }
    }
    
    @RequestMapping(value="/students/deleteAllStudents", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllStudents() throws ServiceException {
        try{
        	studentsService.deleteAllStudents();

        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] deleteAllStudents() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] deleteAllStudents() ", e);
        }
    }

}
