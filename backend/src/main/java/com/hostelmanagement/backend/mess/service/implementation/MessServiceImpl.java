package com.hostelmanagement.backend.mess.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.mess.dao.MessDAO;
import com.hostelmanagement.backend.mess.dto.MessDTO;
import com.hostelmanagement.backend.mess.service.MessService;

@Service
public class MessServiceImpl implements MessService {

    @Autowired
    private MessDAO messDAO;

    public List<MessDTO> getMess() throws ServiceException {
        try{
            return messDAO.getMess();
        }catch (DBException de){
            throw new ServiceException("[ERROR:DE] getMess() ", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getMess() ", e);
        }
    }

	@Override
	public MessDTO getMessByItemID(int itemID) throws ServiceException {
		try{
            return messDAO.getMessByItemID(itemID);
        }catch (DBException de){
            throw new ServiceException("[ERROR:DE] getMessByItemID() ", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] getMessByItemID() ", e);
        }
	}

	@Override
	public void insertMessList(List<MessDTO> messList) throws ServiceException {
		try{
            messDAO.insertMessList(messList);
        }catch (DBException de){
            throw new ServiceException("[ERROR:DE] insertMessList() ", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] insertMessList() ", e);
        }
	}

	@Override
	public void insertMess(MessDTO mess) throws ServiceException {
		try{
            messDAO.insertMess(mess);
        }catch (DBException de){
            throw new ServiceException("[ERROR:DE] insertMess() ", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] insertMess() ", e);
        }
	}

	@Override
	public void updateMessByItemID(MessDTO mess, int itemID) throws ServiceException {
		try{
            messDAO.updateMessByItemID(mess, itemID);
        }catch (DBException de){
            throw new ServiceException("[ERROR:DE] updateMessByItemID() ", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] updateMessByItemID() ", e);
        }
	}

	@Override
	public void deleteMessByItemID(int itemID) throws ServiceException {
		try{
            messDAO.deleteMessByItemID(itemID);
        }catch (DBException de){
            throw new ServiceException("[ERROR:DE] deleteMessByItemID() ", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] deleteMessByItemID() ", e);
        }
	}

	@Override
	public void deleteAllMess() throws ServiceException {
		try{
            messDAO.deleteAllMess();
        }catch (DBException de){
            throw new ServiceException("[ERROR:DE] deleteAllMess() ", de);
        }catch (Exception e){
            throw new ServiceException("[ERROR:E] deleteAllMess() ", e);
        }
	}
}
