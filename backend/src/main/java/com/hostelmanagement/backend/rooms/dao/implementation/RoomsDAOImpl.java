package com.hostelmanagement.backend.rooms.dao.implementation;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.rooms.dao.RoomsDAO;
import com.hostelmanagement.backend.rooms.dao.constants.QueryConstants;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;
import com.hostelmanagement.backend.util.ParsingUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
                room.setRoomNumber(Integer.parseInt(row.get("room_number")));
                room.setRoomType(row.get("room_type"));
                room.setTotalNumberOfBeds(Integer.parseInt(row.get("total_number_of_beds")));
                room.setOccupiedNumberOfBeds(Integer.parseInt(row.get("occupied_number_of_beds")));
                room.setRoomPrice(Integer.parseInt(row.get("room_price")));
                room.setRoomDescription(row.get("room_description"));
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
}
