package com.hostelmanagement.backend.rooms.dao.implementation;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.rooms.dao.RoomsDAO;
import com.hostelmanagement.backend.rooms.dto.RoomDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomsDAOImpl implements RoomsDAO {

    public List<RoomDTO> getRoomsList() throws DBException {
        List<RoomDTO> rooms = new ArrayList<RoomDTO>();
        try{

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] getRoomsList() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:DAE] getRoomsList() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] getRoomsList() ",e);
        }
        return rooms;
    }
}
