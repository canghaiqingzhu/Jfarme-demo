package com.xiehui.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.xiehui.util.RowMapper;





public class XiaoMapper implements RowMapper{

	public Vector rowMap(ResultSet rs) {
		Vector data1=new Vector();
		try {
			data1.add(rs.getObject("thingId"));
			data1.add(rs.getObject("number"));
			data1.add(rs.getObject("time"));
			data1.add(rs.getObject("zhiyuan"));
			return data1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
