/*********************
 * Homework #3 
 * Due Date: 2/24/2019
 * Name: Nick Kenworthy (Worked by myself)
 * Github URL: https://github.com/nkenworthy98/CPSC224_01_nkenworthy98
 ********************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class tictactoe
{
	public int turn = 0;
	private JTextField playerField;

	private JFrame frame = new JFrame("Tic-Tac-Toe");
	private JPanel player1Panel;
	private JPanel player2Panel;
	private JPanel topPanel;
	private JPanel buttonsPanel;
	private JPanel gameButtonsPanel;
	private boolean[] clickedArray = new boolean[9]; // array to check if a button has been clicked already
	private char[] charArray = new char[9]; // array to keep track X's and O's. Used to check for win

	private JTextField p1NameField;
	public String player1Name;
	private JTextField p1WinsField;
	private JTextField p1LossesField;
	public int player1Wins = 0;
	public int player1Losses = 0;
	private JLabel nameLabel1 = new JLabel("Name: ");
	private JLabel winsLabel1 = new JLabel("Wins: ");
	private JLabel lossesLabel1 = new JLabel("Losses: ");

	private JTextField p2NameField;
	public String player2Name;
	private JTextField p2WinsField;
	private JTextField p2LossesField;
	public int player2Wins = 0;
	public int player2Losses = 0;
	private JLabel nameLabel2 = new JLabel("Name: ");
	private JLabel winsLabel2 = new JLabel("Wins: ");
	private JLabel lossesLabel2 = new JLabel("Losses: ");

	private JButton topLeft = new JButton("");
	private JButton topMiddle = new JButton("");
	private JButton topRight = new JButton("");
	private JButton middleLeft = new JButton("");
	private JButton middleMiddle = new JButton("");
	private JButton middleRight = new JButton("");
	private JButton bottomLeft = new JButton("");
	private JButton bottomMiddle = new JButton("");
	private JButton bottomRight = new JButton("");
	private JButton newGameButton = new JButton("New Game");
	private JButton resetButton = new JButton("Reset");
	private JButton exitButton = new JButton("Exit");

	public tictactoe()
	{
		//Specify an action for the close button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// sets the size of the frame
		frame.setSize(500,500);

		// gets the names of the players through an input dialog
		getPlayersNames();

		// builds the various panels for the GUI
		buildPlayer1Panel();
		buildPlayer2Panel();
		buildTopPanel();
		buildButtonsPanel();
		buildGameButtonsPanel();

		// adds the various panels to the frame
		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(buttonsPanel, BorderLayout.CENTER);
		frame.add(gameButtonsPanel, BorderLayout.SOUTH);

		frame.pack();
		frame.setVisible(true);
	}

	public void getPlayersNames()
	{
		player1Name = JOptionPane.showInputDialog(null, "Player 1, enter in your name");
		player2Name = JOptionPane.showInputDialog(null, "Player 2, enter in your name");
		
		// random number to determine which player will go first
		Random rand = new Random();
		turn = rand.nextInt(2);
		if (turn == 0)
		{
			JOptionPane.showMessageDialog(null, player1Name + "  will go first");
		}
		else 
		{
			JOptionPane.showMessageDialog(null, player2Name + "  will go first");
			turn = 1;  // changes the turn counter to make sure player 2 goes first
		}
	}

	// builds the player 1's panel. Has name, wins, and losses
	private void buildPlayer1Panel()
	{
		JPanel namePanel = new JPanel();
		JPanel winsPanel = new JPanel();
		JPanel lossesPanel = new JPanel();

		p1NameField = new JTextField(player1Name, 8);
		p1NameField.setEditable(false);
		p1WinsField = new JTextField(Integer.toString(player1Wins), 8);
		p1WinsField.setEditable(false);
		p1LossesField = new JTextField(Integer.toString(player1Losses), 8);
		p1LossesField.setEditable(false);

		namePanel.add(nameLabel1);
		namePanel.add(p1NameField);
		winsPanel.add(winsLabel1);
		winsPanel.add(p1WinsField);
		lossesPanel.add(lossesLabel1);
		lossesPanel.add(p1LossesField);

		JPanel groupingPanel = new JPanel();
		player1Panel = new JPanel();

		groupingPanel.add(namePanel);
		groupingPanel.add(winsPanel);
		groupingPanel.add(lossesPanel);

		groupingPanel.setBorder(BorderFactory.createTitledBorder("Player 1 (X):"));
		groupingPanel.setLayout(new GridLayout(3,2));

		player1Panel.add(groupingPanel, BorderLayout.CENTER);
		player1Panel.setLayout(new GridLayout());

		frame.pack();
	}

	// builds the player 2's panel. Has name, wins, and losses
	private void buildPlayer2Panel()
	{
		JPanel namePanel = new JPanel();
		JPanel winsPanel = new JPanel();
		JPanel lossesPanel = new JPanel();

		p2NameField = new JTextField(player2Name, 8);
		p2NameField.setEditable(false);
		p2WinsField = new JTextField(Integer.toString(player2Wins), 8);
		p2WinsField.setEditable(false);
		p2LossesField = new JTextField(Integer.toString(player2Losses), 8);
		p2LossesField.setEditable(false);

		namePanel.add(nameLabel2);
		namePanel.add(p2NameField);
		winsPanel.add(winsLabel2);
		winsPanel.add(p2WinsField);
		lossesPanel.add(lossesLabel2);
		lossesPanel.add(p2LossesField);

		JPanel groupingPanel = new JPanel();
		player2Panel = new JPanel();

		groupingPanel.add(namePanel);
		groupingPanel.add(winsPanel);
		groupingPanel.add(lossesPanel);

		groupingPanel.setBorder(BorderFactory.createTitledBorder("Player 2 (O):"));
		groupingPanel.setLayout(new GridLayout(3,2));

		player2Panel.add(groupingPanel, BorderLayout.CENTER);
		player2Panel.setLayout(new GridLayout());

		frame.pack();
	}

	// this combines player 1 and player 2 panels
	private void buildTopPanel()
	{
		topPanel = new JPanel();

		topPanel.add(player1Panel);
		topPanel.add(player2Panel);

		topPanel.setLayout(new GridLayout(1,2));
		frame.pack();
	}

	// makes the 9 buttons for the game of tic-tac-toe
	private void buildButtonsPanel()
	{
		buttonsPanel = new JPanel();

		topLeft.addActionListener(new topLeftButtonListener());
		topMiddle.addActionListener(new topMiddleButtonListener());
		topRight.addActionListener(new topRightButtonListener());
		middleLeft.addActionListener(new middleLeftButtonListener());
		middleMiddle.addActionListener(new middleMiddleButtonListener());
		middleRight.addActionListener(new middleRightButtonListener());
		bottomLeft.addActionListener(new bottomLeftButtonListener());
		bottomMiddle.addActionListener(new bottomMiddleButtonListener());
		bottomRight.addActionListener(new bottomRightButtonListener());

		buttonsPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		buttonsPanel.add(topLeft);
		buttonsPanel.add(topMiddle);
		buttonsPanel.add(topRight);
		buttonsPanel.add(middleLeft);
		buttonsPanel.add(middleMiddle);
		buttonsPanel.add(middleRight);
		buttonsPanel.add(bottomLeft);
		buttonsPanel.add(bottomMiddle);
		buttonsPanel.add(bottomRight);

		buttonsPanel.setLayout(new GridLayout(3,3));
		frame.pack();
	}

	private class topLeftButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (turn % 2 == 0 && !clickedArray[0])
			{
				topLeft.setText("X");
				topLeft.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[0] = true;
				charArray[0] = 'X';
				checkWin();
				playerField.setText(player2Name + "'s turn");
				turn++;
			}
			else if (turn % 2 != 0 && !clickedArray[0]) 
			{
				topLeft.setText("O");
				topLeft.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[0] = true;
				charArray[0] = 'O';
				checkWin();
				playerField.setText(player1Name + "'s turn");
				turn++;
			}
		}
	}

	private class topMiddleButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (turn % 2 == 0 && !clickedArray[1])
			{
				topMiddle.setText("X");
				topMiddle.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[1] = true;
				charArray[1] = 'X';
				checkWin();
				playerField.setText(player2Name + "'s turn");
				turn++;
			}
			else if (turn % 2 != 0 && !clickedArray[1]) 
			{
				topMiddle.setText("O");
				topMiddle.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[1] = true;
				charArray[1] = 'O';
				checkWin();
				playerField.setText(player1Name + "'s turn");
				turn++;
			}
		}
	}

	private class topRightButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (turn % 2 == 0 && !clickedArray[2])
			{
				topRight.setText("X");
				topRight.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[2] = true;
				charArray[2] = 'X';
				checkWin();
				playerField.setText(player2Name + "'s turn");
				turn++;
			}
			else if (turn % 2 != 0 && !clickedArray[2]) 
			{
				topRight.setText("O");
				topRight.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[2] = true;
				charArray[2] = 'O';
				checkWin();
				playerField.setText(player1Name + "'s turn");
				turn++;
			}
		}
	}

	private class middleLeftButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (turn % 2 == 0 && !clickedArray[3])
			{
				middleLeft.setText("X");
				middleLeft.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[3] = true;
				charArray[3] = 'X';
				checkWin();
				playerField.setText(player2Name + "'s turn");
				turn++;
			}
			else if (turn % 2 != 0 && !clickedArray[3]) 
			{
				middleLeft.setText("O");
				middleLeft.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[3] = true;
				charArray[3] = 'O';
				checkWin();
				playerField.setText(player1Name + "'s turn");
				turn++;
			}
		}
	}

	private class middleMiddleButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (turn % 2 == 0 && !clickedArray[4])
			{
				middleMiddle.setText("X");
				middleMiddle.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[4] = true;
				charArray[4] = 'X';
				checkWin();
				playerField.setText(player2Name + "'s turn");
				turn++;
			}
			else if (turn % 2 != 0 && !clickedArray[4]) 
			{
				middleMiddle.setText("O");
				middleMiddle.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[4] = true;
				charArray[4] = 'O';
				checkWin();
				playerField.setText(player1Name + "'s turn");
				turn++;
			}
		}
	}

	private class middleRightButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (turn % 2 == 0 && !clickedArray[5])
			{
				middleRight.setText("X");
				middleRight.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[5] = true;
				charArray[5] = 'X';
				checkWin();
				playerField.setText(player2Name + "'s turn");
				turn++;
			}
			else if (turn % 2 != 0 && !clickedArray[5]) 
			{
				middleRight.setText("O");
				middleRight.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[5] = true;
				charArray[5] = 'O';
				checkWin();
				playerField.setText(player1Name + "'s turn");
				turn++;
			}
		}
	}

	private class bottomLeftButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (turn % 2 == 0 && !clickedArray[6])
			{
				bottomLeft.setText("X");
				bottomLeft.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[6] = true;
				charArray[6] = 'X';
				checkWin();
				playerField.setText(player2Name + "'s turn");
				turn++;
			}
			else if (turn % 2 != 0 && !clickedArray[6]) 
			{
				bottomLeft.setText("O");
				bottomLeft.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[6] = true;
				charArray[6] = 'O';
				checkWin();
				playerField.setText(player1Name + "'s turn");
				turn++;
			}
		}
	}

	private class bottomMiddleButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (turn % 2 == 0 && !clickedArray[7])
			{
				bottomMiddle.setText("X");
				bottomMiddle.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[7] = true;
				charArray[7] = 'X';
				checkWin();
				playerField.setText(player2Name + "'s turn");
				turn++;
			}
			else if (turn % 2 != 0 && !clickedArray[7]) 
			{
				bottomMiddle.setText("O");
				bottomMiddle.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[7] = true;
				charArray[7] = 'O';
				checkWin();
				playerField.setText(player1Name + "'s turn");
				turn++;
			}
		}
	}

	private class bottomRightButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (turn % 2 == 0 && !clickedArray[8])
			{
				bottomRight.setText("X");
				bottomRight.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[8] = true;
				charArray[8] = 'X';
				checkWin();
				playerField.setText(player2Name + "'s turn");
				turn++;
			}
			else if (turn % 2 != 0 && !clickedArray[8]) 
			{
				bottomRight.setText("O");
				bottomRight.setFont(new Font("SansSerif", Font.BOLD, 24));
				clickedArray[8] = true;
				charArray[8] = 'O';
				checkWin();
				playerField.setText(player1Name + "'s turn");
				turn++;
			}
		}
	}

	private void buildGameButtonsPanel()
	{
		String currentPlayer = "";
		if (turn % 2 == 0)
			currentPlayer = player1Name;
		else
			currentPlayer = player2Name;

		playerField = new JTextField(currentPlayer + "'s turn");
		playerField.setEditable(false);
		gameButtonsPanel = new JPanel();
		JPanel buttons = new JPanel();
		JPanel playerTurn = new JPanel();

		playerTurn.add(playerField);

		newGameButton.addActionListener(new NewGameButtonListener()); // starts new game when button is clicked 
		resetButton.addActionListener(new ResetButtonListener()); // resets program when reset button is clicked
		exitButton.addActionListener(new ExitButtonListener()); // exits program when exit button is clicked

		buttons.add(newGameButton);
		buttons.add(resetButton);
		buttons.add(exitButton);

		gameButtonsPanel.add(buttons);
		gameButtonsPanel.add(playerField);
		gameButtonsPanel.setLayout(new GridLayout(2, 1));
		frame.pack();
	}

	// starts new game. resets names and wins/losses
	private class NewGameButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(null, "A new game will begin. Both names and all wins/losses will be reset");
			getPlayersNames();
			p1NameField.setText(player1Name);
			p2NameField.setText(player2Name);
			player1Wins = 0;
			player1Losses = 0;
			player2Wins = 0;
			player2Losses = 0;
			p1WinsField.setText(Integer.toString(player1Wins));
			p1LossesField.setText(Integer.toString(player1Losses));
			p2WinsField.setText(Integer.toString(player2Wins));
			p2LossesField.setText(Integer.toString(player2Losses));
			performReset();
		}
	}

	// resets the current board
	private class ResetButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			performReset();
		}
	}

	private void performReset()
	{
		//resets the text on the buttons
		topLeft.setText("");
		topMiddle.setText("");
		topRight.setText("");
		middleLeft.setText("");
		middleMiddle.setText("");
		middleRight.setText("");
		bottomLeft.setText("");
		bottomMiddle.setText("");
		bottomRight.setText("");

		// reinitializes the arrays to what they would be in the beginning
		for (int i = 0; i < 9; i++)
		{
			clickedArray = new boolean[9];
			charArray = new char[9];
		}
	}


	// exits the game
	private class ExitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	// checks all possible layouts to determine whether or not a game has been won
	private void checkWin()
	{
		if ((charArray[0] == 'X' && charArray[0] == charArray[1] && charArray[1] == charArray[2]) || // checks horizontal top row
		    (charArray[3] == 'X' && charArray[3] == charArray[4] && charArray[4] == charArray[5]) || // checks horizontal middle row
		    (charArray[6] == 'X' && charArray[6] == charArray[7] && charArray[5] == charArray[8]) || // checks horizontal bottom row
		    (charArray[0] == 'X' && charArray[0] == charArray[3] && charArray[3] == charArray[6]) || // checks vertical left column
		    (charArray[1] == 'X' && charArray[1] == charArray[4] && charArray[4] == charArray[7]) || // checks vertical middle column
		    (charArray[2] == 'X' && charArray[2] == charArray[5] && charArray[5] == charArray[8]) || // checks vertical right column
		    (charArray[0] == 'X' && charArray[0] == charArray[4] && charArray[4] == charArray[8]) || // checks diagonal topleft to bottomright
		    (charArray[6] == 'X' && charArray[6] == charArray[4] && charArray[4] == charArray[2]))   // checks diagonal bottomleft to topright
		{
			JOptionPane.showMessageDialog(null, "Player 1 has won.");
			player1Wins++;
			player2Losses++;
			p1WinsField.setText(Integer.toString(player1Wins));
			p2LossesField.setText(Integer.toString(player2Losses));
			performReset();
		}

		if ((charArray[0] == 'O' && charArray[0] == charArray[1] && charArray[1] == charArray[2]) || // checks horizontal top row
		    (charArray[3] == 'O' && charArray[3] == charArray[4] && charArray[4] == charArray[5]) || // checks horizontal middle row
		    (charArray[6] == 'O' && charArray[6] == charArray[7] && charArray[5] == charArray[8]) || // checks horizontal bottom row
		    (charArray[0] == 'O' && charArray[0] == charArray[3] && charArray[3] == charArray[6]) || // checks vertical left column
		    (charArray[1] == 'O' && charArray[1] == charArray[4] && charArray[4] == charArray[7]) || // checks vertical middle column
		    (charArray[2] == 'O' && charArray[2] == charArray[5] && charArray[5] == charArray[8]) || // checks vertical right column
		    (charArray[0] == 'O' && charArray[0] == charArray[4] && charArray[4] == charArray[8]) || // checks diagonal topleft to bottomright
		    (charArray[6] == 'O' && charArray[6] == charArray[4] && charArray[4] == charArray[2]))   // checks diagonal bottomleft to topright
		{
			JOptionPane.showMessageDialog(null, "Player 2 has won.");
			player2Wins++;
			player1Losses++;
			p2WinsField.setText(Integer.toString(player2Wins));
			p1LossesField.setText(Integer.toString(player1Losses));
			performReset();
		}
	}

	public static void main(String[] args)
	{
		new tictactoe();
	}
}
