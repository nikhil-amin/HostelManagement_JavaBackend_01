package com.hostelmanagement.backend.rooms.dao.implementation;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.rooms.dao.RoomsDAO;
import com.hostelmanagement.backend.rooms.dao.constants.QueryConstants;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;
import com.hostelmanagement.backend.util.LiteralConstants;
import com.hostelmanagement.backend.util.ParsingUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class RoomsDAOImpl implements RoomsDAO {

    private JdbcTemplate jdbcTemplate;

    public RoomsDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<RoomDTO> getRoomsList() throws DBException {
        List<RoomDTO> rooms = new ArrayList<RoomDTO>();
        try{
            List<Map<String, String>> rows = ParsingUtil.queryForList(jdbcTemplate, QueryConstants.GET_ROOMS_LIST);

            for(Map<String, String> row : rows){
                RoomDTO room = new RoomDTO();
                room.setRoomNumber(Integer.parseInt(row.get(LiteralConstants.ROOM_NUMBER)));
                room.setRoomType(row.get(LiteralConstants.ROOM_TYPE));
                room.setTotalNumberOfBeds(Integer.parseInt(row.get(LiteralConstants.TOTAL_NUMBER_OF_BEDS)));
                room.setOccupiedNumberOfBeds(Integer.parseInt(row.get(LiteralConstants.OCCUPIED_NUMBER_OF_BEDS)));
                room.setRoomPrice(Integer.parseInt(row.get(LiteralConstants.ROOM_PRICE)));
                room.setRoomDescription(row.get(LiteralConstants.ROOM_DESCRIPTION));
                rooms.add(room);
            }
        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] getRoomsList() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] getRoomsList() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] getRoomsList() ",e);
        }
        return rooms;
    }

    @Override
    public void insertRooms(List<RoomDTO> rooms) throws DBException {
        try{

            jdbcTemplate.batchUpdate(QueryConstants.INSERT_ROOMS, new BatchPreparedStatementSetter() {
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
}
