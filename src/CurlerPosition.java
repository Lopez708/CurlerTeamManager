/**
 * The CurlerPosition enumerated type manages the players position on the team.
 * @author Juan Lopez
 *
 */
public enum CurlerPosition {
	skip("skip"),
	thrower("thrower"),
	sweeper("sweeper");
	
	private String pos;
	
	/**
	 * Constructor which initializes the players position in the team.
	 * @param x - String representation of the players position
	 */
	CurlerPosition(String x) {
		pos = x;
	}
	
	/**
	 * Gives the players position
	 * @return - String representation of the players position
	 */
	public String getPos() {
		return pos;
	}
	
	/**
	 * Gives the players position
	 * @return - String representation of the players position
	 */
	public String toString() {
		return pos;
	}

}
