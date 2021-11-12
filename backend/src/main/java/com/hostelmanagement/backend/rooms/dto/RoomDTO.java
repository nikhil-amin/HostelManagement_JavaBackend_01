package com.hostelmanagement.backend.rooms.dto;

import java.io.Serializable;

public class RoomDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private int roomID;
    private int roomNumber;
    private String roomType;
    private int totalNumberOfBeds;
    private int occupiedNumberOfBeds;
    private int roomPrice;
    private String roomDescription;

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getTotalNumberOfBeds() {
        return totalNumberOfBeds;
    }

    public void setTotalNumberOfBeds(int totalNumberOfBeds) {
        this.totalNumberOfBeds = totalNumberOfBeds;
    }

    public int getOccupiedNumberOfBeds() {
        return occupiedNumberOfBeds;
    }

    public void setOccupiedNumberOfBeds(int occupiedNumberOfBeds) {
        this.occupiedNumberOfBeds = occupiedNumberOfBeds;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }
}
