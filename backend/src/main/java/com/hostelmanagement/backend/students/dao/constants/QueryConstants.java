package com.hostelmanagement.backend.students.dao.constants;

public class QueryConstants {

    public final static String GET_STUDENTS_LIST = "SELECT * FROM students";
    
    public final static String GET_STUDENTS_BY_USN = "SELECT * FROM students WHERE student_usn = ?";
    
    public final static String INSERT_STUDENTS = "INSERT INTO students(student_name, student_usn, student_phone, student_email, room_id, mess_facility_opted) VALUES (?, ?, ?, ?, ?, ?)";
}
