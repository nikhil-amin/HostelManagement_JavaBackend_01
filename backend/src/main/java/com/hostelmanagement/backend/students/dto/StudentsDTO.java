package com.hostelmanagement.backend.students.dto;

import java.io.Serializable;

public class StudentsDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private int studentID;
    private String studentName;
    private String studentUsn;
    private String studentPhone;
    private String studentEmail;
    private int roomID;
    private boolean messFacilityOpted;
    
    public StudentsDTO() {
    }

	public StudentsDTO(String studentName, String studentUsn, String studentPhone, String studentEmail, int roomID, boolean messFacilityOpted) {
		this.studentName = studentName;
		this.studentUsn = studentUsn;
		this.studentPhone = studentPhone;
		this.studentEmail = studentEmail;
		this.roomID = roomID;
		this.messFacilityOpted = messFacilityOpted;
	}

	public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentUsn() {
        return studentUsn;
    }

    public void setStudentUsn(String studentUsn) {
        this.studentUsn = studentUsn;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public boolean isMessFacilityOpted() {
        return messFacilityOpted;
    }

    public void setMessFacilityOpted(boolean messFacilityOpted) {
        this.messFacilityOpted = messFacilityOpted;
    }
}
