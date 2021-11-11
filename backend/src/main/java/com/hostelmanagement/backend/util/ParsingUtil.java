package com.hostelmanagement.backend.util;

import com.hostelmanagement.backend.exception.DBException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.util.HtmlUtils;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ParsingUtil {

    //execute query and return List<Map<String, String>>
    public static List<Map<String, String>> queryForList(
            JdbcTemplate jdbcTemplate, final String query, final Object... args)
            throws DBException {
        List<Map<String, String>> tempList = new ArrayList<Map<String, String>>();
        List<Map<String, String>> finalList = new ArrayList<Map<String, String>>();

        try{
            for(Map<String, Object> m : jdbcTemplate.queryForList(query, args)){
                tempList.add(convertMapObjectToMapString(m));
            }
            for(Map<String, String> r : tempList){
                Map<String, String> c = new LinkedCaseInsensitiveHashMap<String, String>();
                for(Map.Entry<String, String> e : r.entrySet()){
                    c.put(validateString(e.getKey()), validateString(e.getValue()));
                }
                finalList.add(c);
            }

        }catch (DataAccessException dae) {
            throw new DBException("[ERROR] queryForList ", dae);
        }
        return finalList;
    }

    //convert Map<String, Object> to Map<String, String>
    private static Map<String, String> convertMapObjectToMapString(Map<String, Object> mapObject){
        Map<String, String> mapString = new LinkedHashMap<String, String>();

        for(Map.Entry<String, Object> e : mapObject.entrySet()){
            if(null != e.getValue()){
                mapString.put(e.getKey(), e.getValue().toString());
            }else{
                mapString.put(e.getKey(), null);
            }
        }

        return mapString;
    }

    //validate String
    public static String validateString(String string){
        if(null == string){
            return null;
        }

        string = string.replaceAll("\n", "%XyZ");
        string = string.replaceAll("\032", "");
        string = string.replaceAll("\u00a5", "");
        string = string.replaceAll("\u20a9", "");
        string = string.replaceAll("%XyZ", "\n");
        string = string.replaceAll("%0D", "");
        string = string.replaceAll("%0A", "");

        string = Normalizer.normalize(string, Normalizer.Form.NFKC);
        string = HtmlUtils.htmlEscape(string);
        string = HtmlUtils.htmlUnescape(string);

        return string;
    }
}
