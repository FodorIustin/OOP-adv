package mainDemo;

import java.sql.SQLException;


import structureDAO.SoccerDAO;
import workPOJO.Team;

public class MainSoccer {

	public static void main(String[] args) throws SQLException {
		/*	ArrayList<Team> teams =SoccerDAO.getAll();
		for(Team f:teams) {
			System.out.println(s.getId() + " "+ s.getTeam_name());
		}
		
		Team f1 = StudentDAO.read();
		if(f1!=null) {
			System.out.println("Echipa are numele " +s1.getTeam_name());
		}
		else {
			System.out.println("Nu exista echipa");
		}
	//	s1.setId(1);
		//s1.setNume("");
		
		/*boolean actualizat = SoccerDAO.update(f1);
		if(actualizat == true) {
			System.out.println("Echipa a fost actualizata");
		}else {
			System.out.println("Echipa nu a fost gaista");
		}*/
	//	String delete = StudentDAO.delete("");
	//	System.out.println(delete);
		
		Team Real = new Team("La Liga", "Real Madrid",2, 30);
		SoccerDAO.create(Real);
		workHelpers.DBhelper.closeConnection();
	}

}
