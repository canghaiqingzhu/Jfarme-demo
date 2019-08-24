package com.xiehui.util;

import java.util.Vector;
import com.xiehui.util.JDBCTemplate;

import com.xiehui.mapper.MassageMapper;

public class ABSearch {
	private Vector data;
	private JDBCTemplate temp = new JDBCTemplate();
	private Object id;
	public ABSearch(Object id){
		this.id = id;
		String sql = "select * from thingmassage where thingId=?";
		RowMapper um = new MassageMapper();
		Object[] array={id};
		data = temp.query(sql, um,array);
		System.out.println("data"+data);
	}
	
	public String ABSearchName(){
		Object data1 = data.get(0);
		Object c =((Vector) data1).get(2);
		String b = c.toString();
		return b;
	}
	public String ABSearchMoney(){
		Object data1 = data.get(0);
		Object c =((Vector) data1).get(3);
		String b = c.toString();
		return b;
	}
}
