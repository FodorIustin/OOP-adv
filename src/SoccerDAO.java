package structureDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import workHelpers.DBhelper;
import workPOJO.Team;


public class SoccerDAO {
	public static ArrayList<Team> getAll() throws SQLException {
		ArrayList<Team> result = new ArrayList<Team>();

		Connection conn = DBhelper.getConnection();
		Statement stmt = conn.createStatement();
		String query = "select * from football";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Team f = new Team();
			f.setLeague(rs.getString("league"));
			f.setTeam_name(rs.getString("team_name"));
			f.setPosition(rs.getInt("Position"));
			f.setPlayers_nr(rs.getInt("Players_name"));
			result.add(f);

		}

		return result;

	}
	public static Team read(Team f) throws SQLException {
		Connection conn = workHelpers.DBhelper.getConnection();
		String query = "select * from fotbal where team_name= ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			stmt = (PreparedStatement) new Team();
			stmt.setLeague(rs.getString("league"));
			stmt.setTeam_name(rs.getString("team_name"));
			stmt.setPosition(rs.getInt("Position"));
			stmt.setPlayers_nr(rs.getInt("Players_name"));
			
		}
		return stmt;
	}
	//insert
	public static void create(Team f) throws SQLException {
		Connection c = workHelpers.DBhelper.getConnection();
		String query ="insert into football(league, team_name, position, player_nr) values (?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setLeague(1, f.getLeague());
		ps.setTeam_name(2, f.getTeam_name());
		ps.setPosition(3, f.getPosition());
		ps.setPlayers_nr(4,f.getPlayers_nr();
		
		ps.executeUpdate();
		System.out.println("S-a inserat cu succes" + f.getTeam_name());
		
	}
	//update
	public static  boolean update(Team f)throws SQLException {
		
		Connection c = workHelpers.DBhelper.getConnection();
		String query = "update fotbal set league = ?, position = ? , players_name = ? where team_name = ?";
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(1, f.getLeague());
		ps.setString(2, f.getTeam_name());
		ps.setInt(3, f.getPosition());
		ps.setInt(4,f.getPlayers_nr());
		
		
		int ar = ps.executeUpdate();
		
		return ar == 0 ? false:true;
		}
	//delete	
	public static String delete(String team_name)throws SQLException {
		Connection c = workHelpers.DBhelper.getConnection();
		String DeleteQuerry = "delete from football where team_name = ?";
		PreparedStatement ps = c.prepareStatement(DeleteQuerry);
		ps.setString(1, team_name);
		int deletedRecords =ps.executeUpdate();
		if(deletedRecords == 0)
			return "nu s-au facut stergeri";
		else return "s-au sters " + deletedRecords;
	}
}
