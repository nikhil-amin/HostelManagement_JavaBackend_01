package com.hostelmanagement.backend.mess.service;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.mess.dto.MessDTO;

import java.util.List;

public interface MessService {

    public List<MessDTO> getMessList() throws ServiceException;
}
