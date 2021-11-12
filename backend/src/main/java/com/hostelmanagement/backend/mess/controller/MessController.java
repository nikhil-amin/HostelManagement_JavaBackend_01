package com.hostelmanagement.backend.mess.controller;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.mess.dto.MessDTO;
import com.hostelmanagement.backend.mess.service.MessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessController {

    @Autowired
    private MessService messService;

    @RequestMapping(value = "/mess/getMessList", method = RequestMethod.GET, produces = "application/json")
    public List<MessDTO> getMessList() throws ServiceException{
        try{
            return messService.getMessList();
        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] getMessList() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getMessList() ", e);
        }
    }
}
