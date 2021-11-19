package com.hostelmanagement.backend.mess.service;

import com.hostelmanagement.backend.exception.ServiceException;
import com.hostelmanagement.backend.mess.dto.MessDTO;

import java.util.List;

public interface MessService {

    public List<MessDTO> getMess() throws ServiceException;

	public MessDTO getMessByItemID(int itemID) throws ServiceException;

	public void insertMessList(List<MessDTO> messList) throws ServiceException;

	public void insertMess(MessDTO mess) throws ServiceException;

	public void updateMessByItemID(MessDTO mess, int itemID) throws ServiceException;

	public void deleteMessByItemID(int itemID) throws ServiceException;

	public void deleteAllMess() throws ServiceException;
    
    
}
