package com.work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WoodDao {
	
	
	public Wood getById(int id) throws SQLException, ClassNotFoundException {
		Connection con = DBHelper.getConnection();
		String query = "select * from woods where id =?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Wood w =new Wood(rs.getInt("id"),
					rs.getString("material"),
					rs.getDouble("height"),
					rs.getDouble("width"),
					rs.getString("date"));
			DBHelper.closeConnection();
			return w;
		}
		DBHelper.closeConnection();
		return null;
	}
}
