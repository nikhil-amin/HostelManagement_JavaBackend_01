package com.hostelmanagement.backend.mess.service.implementation;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.mess.dao.MessDAO;
import com.hostelmanagement.backend.mess.dto.MessDTO;
import com.hostelmanagement.backend.mess.service.MessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessServiceImpl implements MessService {

    @Autowired
    private MessDAO messDAO;

    public List<MessDTO> getMessList() throws ServiceException{
        try{
            return messDAO.getMessList();
        }catch (DBException de){
            throw new ServiceException("[ERROR:DE] getMessList() ", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getMessList() ", e);
        }
    }
}
