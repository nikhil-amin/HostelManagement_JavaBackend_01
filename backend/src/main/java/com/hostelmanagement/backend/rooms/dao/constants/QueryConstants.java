package com.hostelmanagement.backend.rooms.dao.constants;

public class QueryConstants {

    public final static String GET_ROOMS = "SELECT * FROM rooms";

    public static final String GET_ROOM_BY_ROOM_NUMBER = "SELECT * FROM rooms WHERE room_number = ?";

    public final static String INSERT_ROOM = "INSERT INTO rooms(room_number, room_type, total_number_of_beds, occupied_number_of_beds, room_price, room_description) VALUES (?, ?, ?, ?, ?, ?)";

    public static final String UPDATE_ROOM = "UPDATE rooms SET room_number = ?, room_type = ?, total_number_of_beds = ?, occupied_number_of_beds = ?, room_price = ?, room_description = ? WHERE room_id = ?";
}
