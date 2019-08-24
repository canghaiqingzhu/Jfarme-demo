package com.xiehui.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class JDBCTemplate {
	private DBBase db = new DBBase();
	

	public Vector query(String sql,RowMapper rm,Object[] arg) {
		Connection conn = db.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		Vector data=new Vector();
		try {
			stmt = conn.prepareStatement(sql);
			for(int i=0;i<arg.length;i++){
				stmt.setObject(i+1, arg[i]);
			}

			rs=stmt.executeQuery();
			while(rs.next()){
				Vector data1=rm.rowMap(rs);
				data.add(data1);
			}
			return data;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			db.close(conn, stmt, null);
		}
		return null;
	}

	public void modify(String sql,Object[] arg) {
		Connection conn = db.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(sql);
			for(int i=0;i<arg.length;i++){
				stmt.setObject(i+1, arg[i]);
			}
			stmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			db.close(conn, stmt, null);
		}

	}
}
