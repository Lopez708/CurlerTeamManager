/**
 * The CurlerPlayer class manages the attributes of each curler player.
 * @author Juan Lopez
 */
public class CurlerPlayer {

	private String firstName;
	private String lastName;
	private String pos;
	CurlerPosition position;
	
	/**
	 * This constructor initializes the first, last and postion of the player.
	 * @param x - String representing the players first name
	 * @param y - String representing the players last name
	 * @param z - CurlerPosition variable typer representing the players position
	 */
	public CurlerPlayer(String x, String y, CurlerPosition z) {
		firstName = x;
		lastName = y;
		position = z;
	}
	
	/**
	 * Gives the players position on the team
	 * @return - String representation of the players position
	 */
	public String getPosition() {
		return position.getPos();
	}
	
	/**
	 * Gives the players complete name
	 * @return - String representation of the players first and last name
	 */
	public String getName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * Converts the CurlerPlayer instance to a string variable
	 * @return - String representation of the players first name, last name and position.
	 */
	public String toString() {
		return "[" + firstName + " " + lastName + " " + position.getPos() + "]";
	}
}
