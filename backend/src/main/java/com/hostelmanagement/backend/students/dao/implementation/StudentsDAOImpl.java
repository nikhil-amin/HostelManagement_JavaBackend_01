package com.hostelmanagement.backend.students.dao.implementation;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;
import com.hostelmanagement.backend.students.dao.StudentsDAO;
import com.hostelmanagement.backend.students.dao.constants.QueryConstants;
import com.hostelmanagement.backend.students.dto.StudentsDTO;
import com.hostelmanagement.backend.util.LiteralConstants;
import com.hostelmanagement.backend.util.ParsingUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class StudentsDAOImpl implements StudentsDAO {

    private JdbcTemplate jdbcTemplate;

    public StudentsDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<StudentsDTO> getStudentsList() throws DBException{
        List<StudentsDTO> students = new ArrayList<StudentsDTO>();
        try{

            List<Map<String, String>> rows = ParsingUtil.queryForList(jdbcTemplate, QueryConstants.GET_STUDENTS_LIST);

            for(Map<String, String> row : rows){
                StudentsDTO student = new StudentsDTO();
                student.setStudentID(Integer.parseInt(row.get(LiteralConstants.STUDENT_ID)));
                student.setStudentName(row.get(LiteralConstants.STUDENT_NAME));
                student.setStudentUsn(row.get(LiteralConstants.STUDENT_USN));
                student.setStudentPhone(row.get(LiteralConstants.STUDENT_PHONE));
                student.setStudentEmail(row.get(LiteralConstants.STUDENT_EMAIL));
                student.setRoomID(Integer.parseInt(row.get(LiteralConstants.ROOM_ID)));
                student.setMessFacilityOpted("YES".equals(row.get(LiteralConstants.MESS_FACILITY_OPTED)));
                students.add(student);
            }
        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] getStudentsList() ", dae);
        }catch(NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] getStudentsList() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] getStudentsList() ", e);
        }
        return students;
    }
    
    @Override
    public StudentsDTO getStudentByUsn(String studentUsn) throws DBException {
    	StudentsDTO student = new StudentsDTO();
        try{
            List<Map<String, String>> rows = ParsingUtil.queryForList(jdbcTemplate, QueryConstants.GET_STUDENTS_BY_USN, studentUsn);

            if(0 != rows.size()){
            	student.setStudentID(Integer.parseInt(rows.get(0).get(LiteralConstants.STUDENT_ID)));
                student.setStudentName(rows.get(0).get(LiteralConstants.STUDENT_NAME));
                student.setStudentUsn(rows.get(0).get(LiteralConstants.STUDENT_USN));
                student.setStudentPhone(rows.get(0).get(LiteralConstants.STUDENT_PHONE));
                student.setStudentEmail(rows.get(0).get(LiteralConstants.STUDENT_EMAIL));
                student.setRoomID(Integer.parseInt(rows.get(0).get(LiteralConstants.ROOM_ID)));
                student.setMessFacilityOpted("YES".equals(rows.get(0).get(LiteralConstants.MESS_FACILITY_OPTED)));
            }

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] getStudentByUsn() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] getStudentByUsn() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] getStudentByUsn() ",e);
        }
        return student;
    }
}
