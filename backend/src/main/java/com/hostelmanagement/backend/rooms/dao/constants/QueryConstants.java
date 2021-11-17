package com.hostelmanagement.backend.rooms.dao.constants;

public class QueryConstants {

    public final static String GET_ROOMS = "select * from rooms";

    public final static String INSERT_ROOM = "INSERT INTO rooms(room_number, room_type, total_number_of_beds, occupied_number_of_beds, room_price, room_description) VALUES (?, ?, ?, ?, ?, ?)";

}
