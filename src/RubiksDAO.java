package structureDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import workHelpers.DBhelper;
import workPOJO.Rubik;

public class RubiksDAO {

	ArrayList<Rubik> result = new ArrayList<Rubik>();

	Connection conn = DBhelper.getConnection();
	Statement stmt = conn.createStatement();
	String query = "select * from rubikscube";
	ResultSet rs = stmt.executeQuery(query);
	while (rs.next()) {
		Rubik r = new Rubik();
		r.setBrand(rs.getString("Brand"));
		r.setWeight(rs.getDouble("Weight"));
		r.setSides(rs.getInt("Sides"));
		r.setManfufactured(rs.getString("Manufactured"));
		result.add(r);

	}

	return result;

}
public static Rubik getByBrand(String brand) throws SQLException {
	Rubik result = null;
	Connection conn = workHelpers.DBhelper.getConnection();
	String query = "select * from rubikscube where brand= ?";
	PreparedStatement stmt = conn.prepareStatement(query);
	stmt.setString(1, brand);
	ResultSet rs = stmt.executeQuery();
	if(rs.next()) {
		result = new Rubik();
		result.setBrand(rs.getString("Brand"));
		result.setWeight(rs.getDouble("Weight"));
		result.setSides(rs.getInt("Sides"));
		result.setManfufactured(rs.getString("Manufactured"));
		
	}
	return result;
}
//insert
public static void create(Rubik  r) throws SQLException {
	Connection c = workHelpers.DBhelper.getConnection();
	String query ="insert into rubikscube(date, weight, sides) values (?,?,?)";
	PreparedStatement ps = c.prepareStatement(query);
	ps.setString(1, r.getManfufactured());
	ps.setDouble(2, r.getWeight());
	ps.setInt(3, r.getSides());
	
	ps.executeUpdate();
	System.out.println("S-a inserat cu succes" + r.getBrand());
	
}
//update
public static  boolean update(Rubik r)throws SQLException {
	
	Connection c = workHelpers.DBhelper.getConnection();
	String query = "update rubikscube set manufactured = ?, weight = ? , sides = ? where brand = ?";
	PreparedStatement ps = c.prepareStatement(query);
	ps.setString(1, r.getManfufactured());
	ps.setDouble(2, r.getWeight());
	ps.setInt(3, r.getSides());
	ps.setString(4,r.getBrand());
	
	
	int ar = ps.executeUpdate();
	
	return ar == 0 ? false:true;
	}
//delete	
public static String delete(String brand)throws SQLException {
	Connection c = workHelpers.DBhelper.getConnection();
	String DeleteQuerry = "delete from rubikscube where brand = ?";
	PreparedStatement ps = c.prepareStatement(DeleteQuerry);
	ps.setString(1, brand);
	int deletedRecords =ps.executeUpdate();
	if(deletedRecords == 0)
		return "nu s-au facut stergeri";
	else return "s-au sters " + deletedRecords;
}
}
