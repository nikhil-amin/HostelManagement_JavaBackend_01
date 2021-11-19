package com.hostelmanagement.backend.mess.dao;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.mess.dto.MessDTO;

import java.util.List;

public interface MessDAO {

    public List<MessDTO> getMess() throws DBException;
}
