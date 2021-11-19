package com.hostelmanagement.backend.mess.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.mess.dto.MessDTO;
import com.hostelmanagement.backend.mess.service.MessService;
import com.hostelmanagement.backend.util.ParsingUtil;

@RestController
public class MessController {

    @Autowired
    private MessService messService;

    @RequestMapping(value = "/mess/getMess", method = RequestMethod.GET, produces = "application/json")
    public List<MessDTO> getMess() throws ServiceException{
        try{
            return messService.getMess();
        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] getMess() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getMess() ", e);
        }
    }
    
    @RequestMapping(value="/mess/getMessByItemID/{itemID}", method= RequestMethod.GET, produces = "application/json")
    public MessDTO getMessByItemID(@PathVariable("studentUsn") int itemID) throws ServiceException {
        try{
            return messService.getMessByItemID(itemID);
        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] getMessByItemID() ",se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getMessByItemID() ",e);
        }
    }
    
    @RequestMapping(value="/mess/insertMessList", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertMessList(HttpServletRequest req, HttpServletResponse res, @RequestBody String messListJson) throws ServiceException {
        try{
            List<MessDTO> messList = (List<MessDTO>) (List<?>) ParsingUtil
                    .convertJsonStringToList(messListJson.toString(), MessDTO.class);

            messService.insertMessList(messList);
        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] insertMessList() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] insertMessList() ", e);
        }
    }
    
    @RequestMapping(value="/mess/insertMess", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertMess(HttpServletRequest req, HttpServletResponse res, @RequestBody String messJson) throws ServiceException {
        try{
            JSONObject jsonObject = new JSONObject(ParsingUtil.validateString(messJson));
            String itemName = jsonObject.get("studentName").toString();
            int itemQuantity = Integer.parseInt(jsonObject.get("itemQuantity").toString());
            int totalPrice = Integer.parseInt(jsonObject.get("totalPrice").toString());
            String monthName = jsonObject.get("monthName").toString();
            int year = Integer.parseInt(jsonObject.get("year").toString());

            MessDTO mess = new MessDTO(itemName, itemQuantity, totalPrice, monthName, year);

            messService.insertMess(mess);

        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] insertMess() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] insertMess() ", e);
        }
    }
    
    @RequestMapping(value="/mess/updateMessByItemID/{itemID}", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void updateMessByItemID(HttpServletRequest req, HttpServletResponse res,
                           @RequestBody String messJson, @PathVariable("itemID") int itemID) throws ServiceException {
        try{
        	JSONObject jsonObject = new JSONObject(ParsingUtil.validateString(messJson));
            String itemName = jsonObject.get("studentName").toString();
            int itemQuantity = Integer.parseInt(jsonObject.get("itemQuantity").toString());
            int totalPrice = Integer.parseInt(jsonObject.get("totalPrice").toString());
            String monthName = jsonObject.get("monthName").toString();
            int year = Integer.parseInt(jsonObject.get("year").toString());

            MessDTO mess = new MessDTO(itemName, itemQuantity, totalPrice, monthName, year);

            messService.updateMessByItemID(mess, itemID);

        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] updateMessByItemID() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] updateMessByItemID() ", e);
        }
    }
    
    @RequestMapping(value="/mess/deleteMessByItemID/{itemID}", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void deleteMessByItemID(HttpServletRequest req, HttpServletResponse res, @PathVariable("itemID") int itemID) throws ServiceException {
        try{
        	messService.deleteMessByItemID(itemID);

        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] deleteMessByItemID() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] deleteMessByItemID() ", e);
        }
    }
    
    @RequestMapping(value="/mess/deleteAllMess", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllMess() throws ServiceException {
        try{
        	messService.deleteAllMess();

        }catch (ServiceException se){
            throw new ServiceException("[ERROR:SE] deleteAllMess() ", se);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] deleteAllMess() ", e);
        }
    }
}
