package com.hostelmanagement.backend.rooms.dao.implementation;

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
import com.hostelmanagement.backend.rooms.dao.RoomsDAO;
import com.hostelmanagement.backend.rooms.dao.constants.QueryConstants;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;
import com.hostelmanagement.backend.util.LiteralConstants;
import com.hostelmanagement.backend.util.ParsingUtil;

@Repository
public class RoomsDAOImpl implements RoomsDAO {

    private JdbcTemplate jdbcTemplate;

    public RoomsDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<RoomDTO> getRooms() throws DBException {
        List<RoomDTO> rooms = new ArrayList<RoomDTO>();
        try{
            List<Map<String, String>> rows = ParsingUtil.queryForList(jdbcTemplate, QueryConstants.GET_ROOMS);

            for(Map<String, String> row : rows){
                RoomDTO room = new RoomDTO();
                room.setRoomID(Integer.parseInt(row.get(LiteralConstants.ROOM_ID)));
                room.setRoomNumber(Integer.parseInt(row.get(LiteralConstants.ROOM_NUMBER)));
                room.setRoomType(row.get(LiteralConstants.ROOM_TYPE));
                room.setTotalNumberOfBeds(Integer.parseInt(row.get(LiteralConstants.TOTAL_NUMBER_OF_BEDS)));
                room.setOccupiedNumberOfBeds(Integer.parseInt(row.get(LiteralConstants.OCCUPIED_NUMBER_OF_BEDS)));
                room.setRoomPrice(Integer.parseInt(row.get(LiteralConstants.ROOM_PRICE)));
                room.setRoomDescription(row.get(LiteralConstants.ROOM_DESCRIPTION));
                rooms.add(room);
            }
        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] getRooms() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] getRooms() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] getRooms() ",e);
        }
        return rooms;
    }

    @Override
    public RoomDTO getRoomByRoomNumber(int roomNumber) throws DBException {
        RoomDTO room = new RoomDTO();
        try{
            List<Map<String, String>> rows = ParsingUtil.queryForList(jdbcTemplate, QueryConstants.GET_ROOM_BY_ROOM_NUMBER, roomNumber);

            if(0 != rows.size()){
            	room.setRoomID(Integer.parseInt(rows.get(0).get(LiteralConstants.ROOM_ID)));
                room.setRoomNumber(Integer.parseInt(rows.get(0).get(LiteralConstants.ROOM_NUMBER)));
                room.setRoomType(rows.get(0).get(LiteralConstants.ROOM_TYPE));
                room.setTotalNumberOfBeds(Integer.parseInt(rows.get(0).get(LiteralConstants.TOTAL_NUMBER_OF_BEDS)));
                room.setOccupiedNumberOfBeds(Integer.parseInt(rows.get(0).get(LiteralConstants.OCCUPIED_NUMBER_OF_BEDS)));
                room.setRoomPrice(Integer.parseInt(rows.get(0).get(LiteralConstants.ROOM_PRICE)));
                room.setRoomDescription(rows.get(0).get(LiteralConstants.ROOM_DESCRIPTION));
            }

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] getRoomByRoomNumber() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] getRoomByRoomNumber() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] getRoomByRoomNumber() ",e);
        }
        return room;
    }

    @Override
    public void insertRooms(List<RoomDTO> rooms) throws DBException {
        try{

            jdbcTemplate.batchUpdate(QueryConstants.INSERT_ROOM, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setInt(1, rooms.get(i).getRoomNumber());
                    ps.setString(2, rooms.get(i).getRoomType());
                    ps.setInt(3, rooms.get(i).getTotalNumberOfBeds());
                    ps.setInt(4, rooms.get(i).getOccupiedNumberOfBeds());
                    ps.setInt(5, rooms.get(i).getRoomPrice());
                    ps.setString(6, rooms.get(i).getRoomDescription());
                }

                @Override
                public int getBatchSize() {
                    return rooms.size();
                }
            });

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] insertRooms() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] insertRooms() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] insertRooms() ",e);
        }
    }

    @Override
    public void insertRoom(RoomDTO room) throws DBException {
        try{
            jdbcTemplate.update(QueryConstants.INSERT_ROOM, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setInt(1, room.getRoomNumber());
                    ps.setString(2, room.getRoomType());
                    ps.setInt(3, room.getTotalNumberOfBeds());
                    ps.setInt(4, room.getOccupiedNumberOfBeds());
                    ps.setInt(5, room.getRoomPrice());
                    ps.setString(6, room.getRoomDescription());
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
    public void updateRoomByRoomID(RoomDTO room, int roomID) throws DBException {
        try{
            jdbcTemplate.update(QueryConstants.UPDATE_ROOM_BY_ROOM_ID, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setInt(1, room.getRoomNumber());
                    ps.setString(2, room.getRoomType());
                    ps.setInt(3, room.getTotalNumberOfBeds());
                    ps.setInt(4, room.getOccupiedNumberOfBeds());
                    ps.setInt(5, room.getRoomPrice());
                    ps.setString(6, room.getRoomDescription());
                    ps.setInt(7, roomID);
                }
            });

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] updateRoomByRoomID() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] updateRoomByRoomID() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] updateRoomByRoomID() ",e);
        }
    }

    @Override
    public void deleteRoomByRoomID(int roomID) throws DBException {
        try{

            //deleting students records in the room
            jdbcTemplate.update(QueryConstants.DELETE_STUDENTS_IN_ROOM, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setInt(1, roomID);
                }
            });

            jdbcTemplate.update(QueryConstants.DELETE_ROOM, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setInt(1, roomID);
                }
            });

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] deleteRoomByRoomID() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] deleteRoomByRoomID() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] deleteRoomByRoomID() ",e);
        }
    }

    @Override
    public void deleteAllRooms() throws DBException {
        try{

            jdbcTemplate.update(QueryConstants.DELETE_ALL_ROOMS);

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] deleteAllRooms() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] deleteAllRooms() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] deleteAllRooms() ",e);
        }
    }
}
