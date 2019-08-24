package com.xiehui.util;

import java.sql.ResultSet;
import java.util.Vector;

public interface RowMapper {
	public Vector rowMap(ResultSet rs);

}
