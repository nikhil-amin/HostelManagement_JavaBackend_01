package com.hostelmanagement.backend.mess.dao;

import java.util.List;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.mess.dto.MessDTO;

public interface MessDAO {

    public List<MessDTO> getMess() throws DBException;

	public MessDTO getMessByItemID(int itemID) throws DBException;

	public void insertMessList(List<MessDTO> messList) throws DBException;

	public void insertMess(MessDTO mess) throws DBException;

	public void updateMessByItemID(MessDTO mess, int itemID) throws DBException;

	public void deleteMessByItemID(int itemID) throws DBException;

	public void deleteAllMess() throws DBException;
}
