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

    public List<RoomDTO> getRoomsList() throws DBException {
        List<RoomDTO> rooms = new ArrayList<RoomDTO>();
        try{
            List<Map<String, String>> output = ParsingUtil.queryForList(jdbcTemplate, QueryConstants.GET_ROOMS_LIST);
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
