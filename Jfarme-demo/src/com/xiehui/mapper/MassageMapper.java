package com.xiehui.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.xiehui.util.RowMapper;





public class MassageMapper implements RowMapper{

	public Vector rowMap(ResultSet rs) {
		Vector data1=new Vector();
		try {
			data1.add(rs.getObject("id"));
			data1.add(rs.getObject("thingId"));
			data1.add(rs.getObject("thingName"));
			data1.add(rs.getObject("shangjia"));
			data1.add(rs.getObject("jinjia"));
			data1.add(rs.getObject("shoujia"));
			return data1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
