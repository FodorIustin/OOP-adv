package ro.library.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.library.helpers.DBhelper;
import ro.library.pojo.Section;


public class SectionDao {

	//getById c,returneaza un watch 
		public static Section getById(int id) throws SQLException,IOException  {
			Connection conn=DBhelper.getConnection();
			String query="select * from  sections where id_section=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Section section=new Section(rs.getInt("id_section"),
						rs.getString("name"),
						rs.getInt("amount"));
				DBhelper.closeConnection();
				return section;
			}
			DBhelper.closeConnection();
			return null;
				
		}
		
		public static ArrayList<Section> getAllSections() throws SQLException {
			
			Connection conn=DBhelper.getConnection();
			String query="select * from sections";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			ArrayList<Section>sections=new ArrayList<>();
			while(rs.next()) {
				Section section=new Section(rs.getInt("id_section"),rs.getString("name"),
						rs.getInt("amount"));
				sections.add(section);		}
			conn.close();
			return sections;		
		}
		
		public static void create(Section s) throws SQLException {
			SectionDao.create(s.getName(),s.getAmount());
		}
		
		
		public static void create(String name, int amount) throws SQLException {
			// instructiunea sql
			String insert = "insert into sections (name, amount)" + "value(?,?)";

			// conexiune
			Connection con = DBhelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(insert);
			stmt.setString(1, name);
			stmt.setInt(2, amount);

			// executie stmt
			stmt.executeUpdate();

			DBhelper.closeConnection();
		}

		public static void update(Section s) throws SQLException {

			String update = "update sections set name=?, amount=? where id_section=?";

			// conexiune
			Connection con = DBhelper.getConnection();

			// prepared statement
			PreparedStatement stmt = con.prepareStatement(update);
			stmt.setString(1, s.getName());
			stmt.setInt(2, s.getAmount());
			stmt.setInt(3, s.getIdSection());

			// executie stmt
			stmt.executeUpdate();

			DBhelper.closeConnection();
		}

		public static void delete(Section s) throws SQLException {
			SectionDao.delete(s.getIdSection());
		}

		public static void delete(int id) throws SQLException {
			String delete = "delete from sections where id_section=?";
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
