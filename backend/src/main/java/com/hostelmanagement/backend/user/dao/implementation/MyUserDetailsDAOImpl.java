package com.hostelmanagement.backend.user.dao.implementation;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hostelmanagement.backend.exception.DBException;
import com.hostelmanagement.backend.user.dao.MyUserDetailsDAO;
import com.hostelmanagement.backend.user.dao.constants.QueryConstants;
import com.hostelmanagement.backend.user.dto.UserDetailsDTO;
import com.hostelmanagement.backend.util.LiteralConstants;
import com.hostelmanagement.backend.util.ParsingUtil;

@Repository
public class MyUserDetailsDAOImpl implements MyUserDetailsDAO{
	
	private JdbcTemplate jdbcTemplate;

    public MyUserDetailsDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

	@Override
	public UserDetailsDTO findUserByUsername(String username) throws DBException {
		UserDetailsDTO userDetails = new UserDetailsDTO();
		try {
			
			List<Map<String, String>> rows = ParsingUtil.queryForList(jdbcTemplate, QueryConstants.GET_USER_BY_USERNAME, username);
			
			userDetails.setUserID(Integer.parseInt(rows.get(0).get(LiteralConstants.USER_ID)));
			userDetails.setUserName(rows.get(0).get(LiteralConstants.USERNAME));
			userDetails.setPassword(rows.get(0).get(LiteralConstants.PASSWORD));
			userDetails.setFullName(null != rows.get(0).get(LiteralConstants.FULLNAME) ? rows.get(0).get(LiteralConstants.FULLNAME) : "");
			userDetails.setEmail(null != rows.get(0).get(LiteralConstants.EMAIL) ? rows.get(0).get(LiteralConstants.EMAIL) : "");
			
		}catch (DataAccessException dae){
            throw new DBException("[ERROR:DAE] getUserByUsername() ", dae);
        }catch(NumberFormatException nfe){
            throw new DBException("[ERROR:NFE] getUserByUsername() ", nfe);
        }catch (Exception e){
            throw new DBException("[ERROR:E] getUserByUsername() ", e);
        }
		
		return userDetails;
	}

}
