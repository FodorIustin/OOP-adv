package com.work;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WoodDao {
	
	
	
	  public Wood getById(int id) throws SQLException, ClassNotFoundException {
	  Connection con = DBHelper.getConnection(); 
	  String query = "select * from doors where id =?"; 
	  PreparedStatement ps = con.prepareStatement(query); 
	  ps.setInt(1, id);
	  
	  ResultSet rs = ps.executeQuery();
	  
	  while(rs.next()) { Wood w =new Wood(rs.getInt("id"),
				rs.getInt("height"),
				rs.getInt("width"),
				rs.getString("material"),
				rs.getDate("installationDate")); DBHelper.closeConnection();
	  return w; } DBHelper.closeConnection(); return null; }
	 
	public ArrayList<Wood> getAllWoods() throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "select * from doors";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<Wood> woods = new ArrayList<>();
		while(rs.next()) {
			Wood w = new Wood(rs.getInt("id"),
					rs.getInt("height"),
					rs.getInt("width"),
					rs.getString("material"),
					rs.getDate("installationDate"));
			woods.add(w);
		}
		con.close();
		return woods;
		
	}
	public void insertDoor(Wood wood) throws SQLException {
		Connection con = DBHelper.getConnection();
		String query = "insert into doors (height, width,material,installationDate) values (?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setDouble(1, wood.getHeight());
		ps.setDouble(2, wood.getWidth());
		ps.setString(3, wood.getMaterial());
		ps.setDate(4, wood.getInstallationdate());
		ps.executeUpdate();
	}
	
	
}
