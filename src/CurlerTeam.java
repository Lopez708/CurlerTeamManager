import java.util.ArrayList;

/**
 * The purpose of the CurlerTeam class is to manage a team of Curler Players through an ArrayList.
 * @author Juan Lopez
 */
public class CurlerTeam {
	
	ArrayList<CurlerPlayer> players;
	private String teamName;
	private String playas;
	private String pos;
	static int numPlayers;
	static int numSweepers;
	static int numSkip;
	static int numThrowers;
	
	/**
	 * This constructor initializes the Arraylist of CurlerPlayers as well as the counters for the player positions.
	 * @param x - String parameter is the team name of the team being created.
	 */
	public CurlerTeam(String x) {
		teamName = x;
		players = new ArrayList<CurlerPlayer>();
		numPlayers = 0;
		numSweepers = 0;
		numSkip = 0;		
	}
	
	/**
	 * Adds a player to the arraylist based on how many players are already in the team.
	 * @param fName - A string representing the players first name
	 * @param lName - A string representing the players last name
	 * @param pos - A string representing the players position
	 * @return null if the player has been added
	 */
	public String addPlayer(String fName, String lName, String pos) {
		int counter = 0;
		
		if (pos.equals("sweeper")){
			for (int x = 0; x < players.size(); x++) {
				if (players.get(x).getPosition().equals(pos)) {
					counter++;
					}
				if (counter == 2) {
					return "There is already a "+ pos + " on this team\nPlayer not added";
				}
			}
			players.add(new CurlerPlayer(fName,lName,CurlerPosition.sweeper));
			numPlayers++;
			numSweepers++;
			return null;
		} else {
			for (int x = 0; x < players.size(); x++) {
				if (players.get(x).getPosition().equals(pos)) {
					return "There is already a "+ pos + " on this team\nPlayer not added";
				}
			}
			if (pos.equals("skip")) {
				players.add(new CurlerPlayer(fName,lName,CurlerPosition.skip));
				numPlayers++;
				numSkip++;
				return null;
			} else {
				players.add(new CurlerPlayer(fName,lName,CurlerPosition.thrower));
				numPlayers++;
				numThrowers++;
				return null;
			}
		}	
	}
	
	/**
	 * Gives the number of players that are currently in the team
	 * @return int - total number of players in team
	 */
	public static int getNumPlayers() {
		return numPlayers;
	}
	
	/**
	 * Gives the string representation of the current team roster 
	 * @return String - Team name and roster
	 */
	public String printTeam() {
		playas = "";
		
		for (int x = 0; x < players.size(); x++) {
			if (!(players.get(x).equals("null"))) {
				playas += players.get(x).getName() + " " + "Position: " + players.get(x).getPosition() + "\n";
			}
		}
		return teamName + "\n" + playas;
	}
	
}
	

