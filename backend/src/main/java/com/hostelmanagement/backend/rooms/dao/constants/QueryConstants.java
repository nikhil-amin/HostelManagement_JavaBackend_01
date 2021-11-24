package com.hostelmanagement.backend.rooms.dao.constants;

public class QueryConstants {

    public final static String GET_ROOMS = "SELECT * FROM rooms order by room_id";

    public static final String GET_ROOM_BY_ROOM_NUMBER = "SELECT * FROM rooms WHERE room_number = ? order by room_id";

    public final static String INSERT_ROOM = "INSERT INTO rooms(room_number, room_type, total_number_of_beds, occupied_number_of_beds, room_price, room_description) VALUES (?, ?, ?, ?, ?, ?)";

    public static final String UPDATE_ROOM_BY_ROOM_ID = "UPDATE rooms SET room_number = ?, room_type = ?, total_number_of_beds = ?, occupied_number_of_beds = ?, room_price = ?, room_description = ? WHERE room_id = ?";

    public static final String DELETE_STUDENTS_IN_ROOM = "DELETE FROM students WHERE room_id = ?";

    public static final String DELETE_ROOM = "DELETE FROM rooms WHERE room_id = ?";

    public static final String DELETE_ALL_ROOMS = "TRUNCATE TABLE rooms CASCADE";
}
