import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnit test program to test the Data Manager CurlerTeam.
 * The following classes must be defined and implemented:
 * CurlerPosition - enumeration
 * CurlerPlayer - data element
 * CurlerTeam - data manager
 * @author Professor Monshi
 *
 */
public class CurlerTeamTester {

	/**  A CurlerTeam object reference used for testing */
	CurlerTeam team;
	
	@Before
	/** This method is run before each individual test
	 *   Creates an object of CurlerTeam and adds three
	 *   CurlerPlayers to the CurlerTeam
	 */
	public void setUp() throws Exception {
		team = new CurlerTeam("Sweden");
		team.addPlayer("John", "Smith","thrower");
		team.addPlayer("Bob", "Brown", "sweeper");
		team.addPlayer("Harold", "Jones", "skip");
	}

	@After
	/** This method is run after each individual test
	 *   It sets the team reference to null so the garbage
	 *   collector can reclaim the memory used for the
	 *   CurlerTeam object
	 * @throws Exception
	 */
	public void tearDown() throws Exception {
		team = null;
	}

	@Test
	/**
	 * Test to 
	 * 1.  check if the number of players is originally 3
	 * 2.  Add another player, and check if number of players is 4
	 * 
	 */
	public void testGetNumPlayers() {
		assertEquals(3,CurlerTeam.getNumPlayers());
		team.addPlayer("George", "Jungle", "sweeper");
		assertEquals(4, CurlerTeam.getNumPlayers());
	}

	@Test
	/**
	 * Test to
	 * 1.  add a new player as a skip
	 *     check if recognizes there is already a skip on the team
	 * 2.  add a new player as a thrower
	 *     check if recognizes there is already a skip on the team
	 * 3.  add new player as a sweeper - player is added
	 */
	public void testAddPlayer() {
		String result;
		result = team.addPlayer("Benny", "Jets", "skip");
		assertEquals("There is already a skip on this team\nPlayer not added", result);
		result = team.addPlayer("Benny","Jets", "thrower");
		assertEquals("There is already a thrower on this team\nPlayer not added", result);
		result = team.addPlayer("Benny","Jets", "sweeper");
		assertEquals(null, result);
		assertEquals(4,CurlerTeam.getNumPlayers());
	}

	@Test
	/**
	 * Test to:
	 * 1.  Check if the country name is on the first line
	 * 2.  Check if Harold is on the forth line
	 */
	public void testPrintTeam() {
		String result = team.printTeam();
		Scanner team = new Scanner(result);
		assertEquals("Sweden",team.nextLine()); //Sweden
		//extract three team players
		team.nextLine();  //John Smith     Position guard
		team.nextLine();  //Bob Brown     Position forward
		assertEquals("Harold",team.next()); //Harold
	}
}