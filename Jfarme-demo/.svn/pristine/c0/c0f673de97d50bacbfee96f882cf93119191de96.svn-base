package com.xiehui.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.xiehui.util.RowMapper;





public class UserMapper implements RowMapper{

	public Vector rowMap(ResultSet rs) {
		Vector data1=new Vector();
		try {			
			data1.add(rs.getObject("id"));
			data1.add(rs.getObject("username"));
			data1.add(rs.getObject("password"));
			data1.add(rs.getObject("root"));
			return data1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
