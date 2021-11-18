package com.hostelmanagement.backend.students.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.students.dao.StudentsDAO;
import com.hostelmanagement.backend.students.dao.constants.QueryConstants;
import com.hostelmanagement.backend.students.dto.StudentsDTO;
import com.hostelmanagement.backend.util.LiteralConstants;
import com.hostelmanagement.backend.util.ParsingUtil;

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
    
    @Override
    public void insertStudents(List<StudentsDTO> students) throws DBException {
        try{

            jdbcTemplate.batchUpdate(QueryConstants.INSERT_STUDENT, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1, students.get(i).getStudentName());
                    ps.setString(2, students.get(i).getStudentUsn());
                    ps.setString(3, students.get(i).getStudentPhone());
                    ps.setString(4, students.get(i).getStudentEmail());
                    ps.setInt(5, students.get(i).getRoomID());
                    ps.setString(6, students.get(i).isMessFacilityOpted()? LiteralConstants.YES : LiteralConstants.NO);
                }

                @Override
                public int getBatchSize() {
                    return students.size();
                }
            });

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] insertStudents() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] insertStudents() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] insertStudents() ",e);
        }
    }

	@Override
	public void insertStudent(StudentsDTO student) throws DBException {
		try{
            jdbcTemplate.update(QueryConstants.INSERT_STUDENT, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                	ps.setString(1, student.getStudentName());
                    ps.setString(2, student.getStudentUsn());
                    ps.setString(3, student.getStudentPhone());
                    ps.setString(4, student.getStudentEmail());
                    ps.setInt(5, student.getRoomID());
                    ps.setString(6, student.isMessFacilityOpted()? LiteralConstants.YES : LiteralConstants.NO);
                }
            });

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] insertRoom() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] insertRoom() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] insertRoom() ",e);
        }
		
	}

	@Override
	public void updateStudentByStudentID(StudentsDTO student, int studentID) throws DBException {
		try{
            jdbcTemplate.update(QueryConstants.UPDATE_ROOM_BY_ROOM_ID, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                	ps.setString(1, student.getStudentName());
                    ps.setString(2, student.getStudentUsn());
                    ps.setString(3, student.getStudentPhone());
                    ps.setString(4, student.getStudentEmail());
                    ps.setInt(5, student.getRoomID());
                    ps.setString(6, student.isMessFacilityOpted()? LiteralConstants.YES : LiteralConstants.NO);
                    ps.setInt(7, studentID);
                }
            });

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] updateStudentByStudentID() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] updateStudentByStudentID() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] updateStudentByStudentID() ",e);
        }
		
	}
}
