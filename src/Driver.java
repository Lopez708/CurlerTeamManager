import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The driver class creates the gui that the user will be interacting with in order to enter team information
 * @author Juan Lopez
 *
 */
public class Driver extends JFrame {
	CurlerTeam team;
	private final int WIDTH = 340;
	private final int HEIGHT = 430;
	private JLabel topLabel;
	private JPanel topPanel = new JPanel();
	private JLabel picLabel;
	private JLabel country;
	private JTextField countryBox;
	private JLabel fName;
	private JTextField fNameBox;
	private JLabel lName;
	private JTextField lNameBox;
	private JRadioButton thrower;
	private JRadioButton sweeper;
	private JRadioButton skip;
	private JPanel midPanel = new JPanel();
	private JPanel midPanelTop = new JPanel();
	private JPanel midPanelBottom = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private Container contentPane;
	//Radio buttons for the GUI
	private JButton addPlayer;
	private JButton printTeam;
	private JButton newTeam;
	private JButton exit;
	
	private String teamName;
	private String first = "";
	private String last = "";
	private String position = "";
	private String teamFull;

	/**
	 * This is the constructor for the class.  It sets the GUI's layout and adds the panels and buttons onto the content pane.
	 * The constructor also calls the Button Listener classes in order to handle user interaction of buttons and radio buttons.
	 * @throws IOException - Exception thrown when the input .jpg logo cannot be found.
	 */
	public Driver() throws IOException {
		setTitle("Create Curler Team");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		buildTopPanel();
		add(topPanel, BorderLayout.NORTH);
		buildBottomPanel();
		add(bottomPanel, BorderLayout.SOUTH);
		buildMidPanel();
		add(midPanel, BorderLayout.CENTER);
		newTeam.addActionListener(new NewTeamButtonListener());
		addPlayer.addActionListener(new AddPlayerButtonListener());
		exit.addActionListener(new ExitButtonListener());
		printTeam.addActionListener(new PrintTeamButtonListener());
		thrower.addActionListener(new RadioButtonListener());
		sweeper.addActionListener(new RadioButtonListener());
		skip.addActionListener(new RadioButtonListener());
	}
	
	/**
	 * The method buildTopPanel initializes the top panel label and adds the logo.
	 * @throws IOException - Exception thrown when the input .jpg logo cannot be found.
	 */
	private void buildTopPanel() throws IOException {
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 12));
		topLabel = new JLabel("  Curling Teams");
		BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\J\\Desktop\\School\\eclipse\\projects\\CurlerTeams\\src\\logo.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		topPanel.add(picLabel);
		topPanel.add(topLabel);
		
	}
	
	/**
	 * The method buildMidPanel initializes the middle panel labels, text fieds and radiobuttons. There are also two panels initialized and added to the content pane.
	 */
	private void buildMidPanel() {
		midPanel.setLayout(new BorderLayout());
		midPanelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 12, 14));
		midPanelBottom.setBorder(BorderFactory.createTitledBorder("Position"));
		midPanelBottom.setPreferredSize(new Dimension(0, 70));
		country = new JLabel("    Country: ");
		countryBox = new JTextField(15);
		countryBox.setEditable(false);
		fName = new JLabel("           First Name:");
		fNameBox = new JTextField(10);
		lName = new JLabel("    Last Name: ");
		lNameBox = new JTextField(14);
		thrower = new JRadioButton ("Thrower");
		sweeper = new JRadioButton ("Sweeper");
		skip = new JRadioButton ("Skip");
		midPanel.add(midPanelTop, BorderLayout.CENTER);
		midPanelTop.add(country, BorderLayout.CENTER);
		midPanelTop.add(countryBox, BorderLayout.CENTER);
		midPanelTop.add(fName, BorderLayout.CENTER);
		midPanelTop.add(fNameBox, BorderLayout.CENTER);
		midPanelTop.add(lName, BorderLayout.CENTER);
		midPanelTop.add(lNameBox, BorderLayout.CENTER);
		midPanel.add(midPanelBottom, BorderLayout.SOUTH);
		midPanelBottom.add(thrower);
		midPanelBottom.add(sweeper);
		midPanelBottom.add(skip);
	}
	
	/**
	 * The method buildBottomPanel initializes the 4 buttons needed for the bottom panel and sets the panel on the southern part of the content pane.
	 */
	private void buildBottomPanel() {
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.setPreferredSize(new Dimension(0, 65));
		addPlayer = new JButton("Add Player");
		printTeam = new JButton("Print Team");
		newTeam = new JButton("New Team");
		exit = new JButton("Exit");
		bottomPanel.add(addPlayer);
		bottomPanel.add(printTeam);
		bottomPanel.add(newTeam);
		bottomPanel.add(exit);
		
	}
		
		/**
		 * The purpose of the class NewTeamButtonListener is to handle the interaction of the user with the new team button.
		 *
		 */
		private class NewTeamButtonListener implements ActionListener {
			
			/**
			 * actionPerformed handles the logic and action of the NewTeam button.  A new CurlerTeam is initialized and the user is prompted for the teams name
			 */
			public void actionPerformed(ActionEvent e) {
				
				teamName = JOptionPane.showInputDialog(contentPane, "What country does this team play for?", "Team Name", JOptionPane.PLAIN_MESSAGE);
				countryBox.setText(teamName);
				team = new CurlerTeam(teamName);
			}
		}
		
		/**
		 * The purpose of the class AddPlayerButtonListener is to handle the interaction of the user with the Add Player button.
		 *
		 */
		private class AddPlayerButtonListener implements ActionListener {
			
			/**
			 * actionPerformed handles the logic and action of the add player button.  It checks to make sure the appropriate number of players positions have been added.  Prompts the user
			 * if there is an error in adding the player.
			 */
			public void actionPerformed(ActionEvent e) {
				
				if (CurlerTeam.numSweepers == 2 && position.equals("sweeper")) {
					JOptionPane.showMessageDialog(contentPane, "There are already 2 sweepers on this team \nPlayer not added", "Team Roster", JOptionPane.PLAIN_MESSAGE);
				} else if (CurlerTeam.numSkip == 1 && position.equals("skip")) {
					JOptionPane.showMessageDialog(contentPane, "There is already a skip on this team \nPlayer not added", "Team Roster", JOptionPane.PLAIN_MESSAGE);
				} else if (CurlerTeam.numThrowers == 1 && position.equals("thrower")) {
					JOptionPane.showMessageDialog(contentPane, "There is already a thrower on this team \nPlayer not added", "Team Roster", JOptionPane.PLAIN_MESSAGE);
				}
				
				first = fNameBox.getText();
				last = lNameBox.getText();
				team.addPlayer(first, last, position);
			}
		}
		
		/**
		 * The purpose of the class PrintTeamButtonListener is to handle the interaction of the user with the print team button.
		 *
		 */
		private class PrintTeamButtonListener implements ActionListener {
			
			/**
			 * actionPerformed handles the logic and action of the users interaction with the print team button.  Displays a window with the current team name and roster.
			 */
			public void actionPerformed(ActionEvent e) {
				teamFull = "";
				teamFull = team.printTeam();
				
				JOptionPane.showMessageDialog(contentPane, teamFull, "Team Roster", JOptionPane.PLAIN_MESSAGE);
			}
		}
		/**
		 * The purpose of the class ExitButtonListener is to handle the interaction of the user with the exit button.
		 *
		 */
		private class ExitButtonListener implements ActionListener {
			
			/**
			 * actionPerformed handles the logic and action of the users interaction with the exit button.  Terminates the application
			 */
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		}
		
		/**
		 * The purpose of the class RadioButtonListener is to handle the interaction of the user with the GUI's position radio buttons.
		 *
		 */
		private class RadioButtonListener implements ActionListener {
			
			/**
			 * actionPerformed handles the logic and action of the users interaction with the radio buttons.  It allows only one of the radio buttons to be selected at a time.
			 */
			public void actionPerformed(ActionEvent e) {
				
				String radioAction = e.getActionCommand();
				
				if (radioAction.equals("Thrower")) {
					position = "thrower";
					sweeper.setSelected(false);
					skip.setSelected(false);
				} else if (radioAction.equals("Sweeper")) {
					position = "sweeper";
					thrower.setSelected(false);
					skip.setSelected(false);
				} else if (radioAction.equals("Skip")){
					position = "skip";
					thrower.setSelected(false);
					sweeper.setSelected(false);
				}
			}
		}

	public static void main(String[] args) throws IOException {
		Driver gui = new Driver();
		gui.setVisible(true);
	}
}
