package ro.library.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.library.helpers.*;
import ro.library.pojo.Book;



public class BookDao {
	
	//getById c,returneaza un watch 
		public static Book getById(int id) throws SQLException,IOException  {
			Connection conn=DBhelper.getConnection();
			String query="select * from  books where id=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();		
			while(rs.next()) {
				Book book=new Book(rs.getInt("id"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getInt("price"));
				DBhelper.closeConnection();
				return book;
			}
			DBhelper.closeConnection();
			return null;
				
		}
		
		public static ArrayList<Book> getAllBooks() throws SQLException {
			
			Connection conn=DBhelper.getConnection();
			String query="select * from books";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			ArrayList<Book>books=new ArrayList<>();
			while(rs.next()) {
				Book book=new Book(rs.getInt("id"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getInt("price"));
				books.add(book);		}
			conn.close();
			return books;		
		}
		
		public static void create(Book b) throws SQLException {
			BookDao.create(b.getTitle(),b.getAuthor(), b.getPrice());
		}
		
		
		public static void create(String title,String author, int price) throws SQLException {
			// instructiunea sql
			String insert = "insert into books (title,author,price)" + "value(?,?,?)";

			// conexiune
			Connection con = DBhelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(insert);
			stmt.setString(1, title);
			stmt.setString(2, author);
			stmt.setInt(3, price);

			// executie stmt
			stmt.executeUpdate();

			DBhelper.closeConnection();
		}

		public static void update(Book b) throws SQLException {

			String update = "update books set title=?,author=?, price=? where id=?";

			// conexiune
			Connection con = DBhelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(update);
			stmt.setString(1, b.getTitle());
			stmt.setString(2, b.getAuthor());
			stmt.setInt(3, b.getPrice());
			stmt.setInt(4, b.getId());

			// executie stmt
			stmt.executeUpdate();

			DBhelper.closeConnection();
		}

		public static void delete(Book b) throws SQLException {
			BookDao.delete(b.getId());
		}

		public static void delete(int id) throws SQLException {
			String delete = "delete from books where id=?";
			// conexiune
			Connection con = DBhelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(delete);
			stmt.setInt(1, id);

			// executie stmt
			stmt.executeUpdate();

			DBhelper.closeConnection();
		}
}
