package com.hostelmanagement.backend.mess.dao.constants;

public class QueryConstants {

    public final static String GET_MESS = "SELECT * FROM mess";
    
	public final static String GET_MESS_BY_ITEM_ID = "SELECT * FROM mess WHERE item_id = ?";
	
	public final static String INSERT_MESS = "INSERT INTO mess(item_name, item_quantity, total_price, month_name, year) VALUES (?, ?, ?, ?, ?)";
	
	public final static String UPDATE_MESS_BY_ITEM_ID = "UPDATE mess SET item_name = ? item_quantity = ? total_price = ? month_name = ? year = ? WHERE item_id = ?";
	
	public final static String DELETE_MESS = "DELETE FROM mess WHERE item_id = ?";
	
	public final static String DELETE_ALL_MESS = "TRUNCATE TABLE mess";
}
