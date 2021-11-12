package com.hostelmanagement.backend.mess.dao.implementation;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.mess.dao.MessDAO;
import com.hostelmanagement.backend.mess.dao.constants.QueryConstants;
import com.hostelmanagement.backend.mess.dto.MessDTO;
import com.hostelmanagement.backend.util.LiteralConstants;
import com.hostelmanagement.backend.util.ParsingUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MessDAOImpl implements MessDAO {

    private JdbcTemplate jdbcTemplate;

    public MessDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MessDTO> getMessList() throws DBException{
        List<MessDTO> mess = new ArrayList<MessDTO>();
        try{

            List<Map<String, String>> rows = ParsingUtil.queryForList(jdbcTemplate, QueryConstants.GET_MESS_LIST);

            for(Map<String, String> row : rows){
                MessDTO messData = new MessDTO();
                messData.setItemID(Integer.parseInt(row.get(LiteralConstants.ITEM_ID)));
                messData.setItemName(row.get(LiteralConstants.ITEM_NAME));
                messData.setItemQuantity(Integer.parseInt(row.get(LiteralConstants.ITEM_QUANTITY)));
                messData.setTotalPrice(Integer.parseInt(row.get(LiteralConstants.TOTAL_PRICE)));
                messData.setMonthName(row.get(LiteralConstants.MONTH_NAME));
                messData.setYear(Integer.parseInt(row.get(LiteralConstants.YEAR)));
                mess.add(messData);
            }
        }catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] getMessList() ", dae);
        }catch(NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] getMessList() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] getMessList() ", e);
        }
        return mess;
    }
}
