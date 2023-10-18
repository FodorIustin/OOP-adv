package workPOJO;

public class Team {
	
	private String league;
	private String team_name;
	private int position;
	private int players_nr;
	
	public Team(String league, String team_name, int position, int players_nr) {
		this.league = league;
		this.team_name = team_name;
		this.position = position;
		this.players_nr = players_nr;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPlayers_nr() {
		return players_nr;
	}

	public void setPlayers_nr(int players_nr) {
		this.players_nr = players_nr;
	}
	
	
	
}
