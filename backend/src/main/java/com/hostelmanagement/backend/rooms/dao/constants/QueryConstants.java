package com.hostelmanagement.backend.rooms.dao.constants;

public class QueryConstants {

    public final static String GET_ROOMS_LIST = "select * from rooms";

    public final static String INSERT_ROOMS = "INSERT INTO rooms(room_number, room_type, total_number_of_beds, occupied_number_of_beds, room_price, room_description) VALUES (?, ?, ?, ?, ?, ?)";

}
