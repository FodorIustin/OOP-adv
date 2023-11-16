package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WatchDao {
	
	//getById, metoda care returneaza un watch
	public Watch getById(int id) throws SQLException, ClassNotFoundException {
		Connection con = DBhelper.getConnection();
		String query = "select * from watches where id =?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Watch w =new Watch(rs.getInt("id"),
					rs.getString("brand"),
					rs.getInt("price"));
			DBhelper.closeConnection();
			return w;
		}
		DBhelper.closeConnection();
		return null;
	}
	public Watch getAllWatches
	
}
