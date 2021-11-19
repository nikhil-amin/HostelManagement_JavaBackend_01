package com.hostelmanagement.backend.mess.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.mess.dao.MessDAO;
import com.hostelmanagement.backend.mess.dao.constants.QueryConstants;
import com.hostelmanagement.backend.mess.dto.MessDTO;
import com.hostelmanagement.backend.util.LiteralConstants;
import com.hostelmanagement.backend.util.ParsingUtil;

@Repository
public class MessDAOImpl implements MessDAO {

    private JdbcTemplate jdbcTemplate;

    public MessDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MessDTO> getMess() throws DBException {
        List<MessDTO> messList = new ArrayList<MessDTO>();
        try{

            List<Map<String, String>> rows = ParsingUtil.queryForList(jdbcTemplate, QueryConstants.GET_MESS);

            for(Map<String, String> row : rows){
                MessDTO mess = new MessDTO();
                mess.setItemID(Integer.parseInt(row.get(LiteralConstants.ITEM_ID)));
                mess.setItemName(row.get(LiteralConstants.ITEM_NAME));
                mess.setItemQuantity(Integer.parseInt(row.get(LiteralConstants.ITEM_QUANTITY)));
                mess.setTotalPrice(Integer.parseInt(row.get(LiteralConstants.TOTAL_PRICE)));
                mess.setMonthName(row.get(LiteralConstants.MONTH_NAME));
                mess.setYear(Integer.parseInt(row.get(LiteralConstants.YEAR)));
                messList.add(mess);
            }
        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] getMess() ", dae);
        }catch(NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] getMess() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] getMess() ", e);
        }
        return messList;
    }

	@Override
	public MessDTO getMessByItemID(int itemID) throws DBException {
		MessDTO mess = new MessDTO();
        try{
            List<Map<String, String>> rows = ParsingUtil.queryForList(jdbcTemplate, QueryConstants.GET_MESS_BY_ITEM_ID, itemID);

            if(0 != rows.size()){
            	mess.setItemID(Integer.parseInt(rows.get(0).get(LiteralConstants.ITEM_ID)));
            	mess.setItemName(rows.get(0).get(LiteralConstants.ITEM_NAME));
            	mess.setItemQuantity(Integer.parseInt(rows.get(0).get(LiteralConstants.ITEM_QUANTITY)));
            	mess.setTotalPrice(Integer.parseInt(rows.get(0).get(LiteralConstants.TOTAL_PRICE)));
            	mess.setMonthName(rows.get(0).get(LiteralConstants.MONTH_NAME));
            	mess.setYear(Integer.parseInt(rows.get(0).get(LiteralConstants.YEAR)));
            }

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] getMessByItemID() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] getMessByItemID() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] getMessByItemID() ",e);
        }
        return mess;
	}

	@Override
	public void insertMessList(List<MessDTO> messList) throws DBException {
		try{

            jdbcTemplate.batchUpdate(QueryConstants.INSERT_MESS, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setString(1, messList.get(i).getItemName());
                    ps.setInt(2, messList.get(i).getItemQuantity());
                    ps.setInt(3, messList.get(i).getTotalPrice());
                    ps.setString(4, messList.get(i).getMonthName());
                    ps.setInt(5, messList.get(i).getYear());
                }

                @Override
                public int getBatchSize() {
                    return messList.size();
                }
            });

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] insertMessList() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] insertMessList() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] insertMessList() ",e);
        }
	}

	@Override
	public void insertMess(MessDTO mess) throws DBException {
		try{
            jdbcTemplate.update(QueryConstants.INSERT_MESS, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                	ps.setString(1, mess.getItemName());
                    ps.setInt(2, mess.getItemQuantity());
                    ps.setInt(3, mess.getTotalPrice());
                    ps.setString(4, mess.getMonthName());
                    ps.setInt(5, mess.getYear());
                }
            });

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] insertMess() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] insertMess() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] insertMess() ",e);
        }
	}

	@Override
	public void updateMessByItemID(MessDTO mess, int itemID) throws DBException {
		try{
            jdbcTemplate.update(QueryConstants.UPDATE_MESS_BY_ITEM_ID, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                	ps.setString(1, mess.getItemName());
                    ps.setInt(2, mess.getItemQuantity());
                    ps.setInt(3, mess.getTotalPrice());
                    ps.setString(4, mess.getMonthName());
                    ps.setInt(5, mess.getYear());
                    ps.setInt(6, itemID);
                }
            });

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] updateMessByItemID() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] updateMessByItemID() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] updateMessByItemID() ",e);
        }
	}

	@Override
	public void deleteMessByItemID(int itemID) throws DBException {
		try{

            jdbcTemplate.update(QueryConstants.DELETE_MESS, new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps) throws SQLException {
                    ps.setInt(1, itemID);
                }
            });

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] deleteMessByItemID() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] deleteMessByItemID() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] deleteMessByItemID() ",e);
        }
	}

	@Override
	public void deleteAllMess() throws DBException {
		try{

            jdbcTemplate.update(QueryConstants.DELETE_ALL_MESS);

        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] deleteAllMess() ", dae);
        }catch (NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] deleteAllMess() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] deleteAllMess() ",e);
        }
	}
}
