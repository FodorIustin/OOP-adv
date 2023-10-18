package structureDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import workHelpers.DBhelper;
import workPOJO.Book;

public class BookDAO {
	
	public static ArrayList<Book> getAll() throws SQLException {
		ArrayList<Book> result = new ArrayList<Book>();

		Connection conn = DBhelper.getConnection();
		Statement stmt = conn.createStatement();
		String query = "select * from books";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Book b = new Book();
			b.setId(rs.getInt("id"));
			b.setTitle(rs.getString("Title"));
			b.setPrice(rs.getInt("Pice"));
			b.setAuthor(rs.getString("Author"));
			result.add(b);

		}

		return result;

	}
	public static Book getById(int id) throws SQLException {
		Book result = null;
		Connection conn = DBhelper.getConnection();
		String query = "select * from books where id= ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			result = new Book();
			result.setId(rs.getInt("id"));
			result.setTitle(rs.getString("Title"));
			result.setPrice(rs.getInt("Pice"));
			result.setAuthor(rs.getString("Author"));
			
		}
		return result;
	}
	//insert
	public static void create(Book b) throws SQLException {
		Connection c = DBhelper.getConnection();
		String query ="insert into books(title, price, author) values (?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, b.getTitle());
		ps.setInt(2, b.getPrice());
		ps.setString(3, b.getAuthor());
		
		ps.executeUpdate();
		System.out.println("S-a inserat cu succes" + b.getTitle());
		
	}
	//update
	public static  boolean update(Book b)throws SQLException {
		
		Connection c = DBhelper.getConnection();
		String query = "update books set title = ?, price = ? , author = ? where id = ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, b.getTitle());
		ps.setInt(2, b.getPrice());
		ps.setString(3, b.getAuthor());
		ps.setInt(4,b.getId());
		
		
		int ar = ps.executeUpdate();
		
		return ar == 0 ? false:true;
		}
	//delete	
	public static String delete(String nume)throws SQLException {
		Connection c = DBhelper.getConnection();
		String DeleteQuerry = "delete from books where title = ?";
		PreparedStatement ps = c.prepareStatement(DeleteQuerry);
		ps.setString(1, nume);
		int deletedRecords =ps.executeUpdate();
		if(deletedRecords == 0)
			return "nu s-au facut stergeri";
		else return "s-au sters " + deletedRecords;
	}
}
