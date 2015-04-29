import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * War Game GUI Plays war, has pictures CS 110
 * 
 * @author Benjamin
 *
 */
public class WarGUI extends JFrame {
	private War game; // the guts
	private JPanel topPanel, gamePanel, bottomPanel; // break up regions
	private JLabel status; // game status
	private JLabel title; // static title
	private JLabel cpuDeck; // cpu deck
	private JLabel cpuStack; // cpu stack
	private JButton playerDeck; // grid of buttons
	private JLabel playerStack; // player stack
	private JLabel cpuScore; // cpu score
	private JLabel playerScore; // player score

	/**
	 * Constructor
	 */
	public WarGUI() {
		setLayout(new GridLayout(1, 3));
		// create game instance
		game = new War();
		// setup containers and components
		topPanel = new JPanel(new GridLayout(2, 1));
		topPanel.setBackground(Color.green);
		gamePanel = new JPanel();
		bottomPanel = new JPanel(new GridLayout(2, 1));
		bottomPanel.setBackground(Color.green);
		// top
		cpuScore = new JLabel(game.getCPUScore(), SwingConstants.CENTER);
		cpuScore.setFont(new Font("ARIAL", Font.BOLD, 24));
		topPanel.add(cpuScore);

		cpuDeck = new JLabel(new ImageIcon(Card.CARD_DOWN));
		topPanel.add(cpuDeck);
		// game
		title = new JLabel("Ben's War Game\n");
		title.setFont(new Font("HELVETICA", Font.ITALIC, 36));
		gamePanel.add(title);

		cpuStack = new JLabel(new ImageIcon(Card.CLEAR));
		gamePanel.add(cpuStack);
		playerStack = new JLabel(new ImageIcon(Card.CLEAR));
		gamePanel.add(playerStack);

		status = new JLabel("Game in progress");
		status.setFont(new Font("ARIAL", Font.BOLD, 24));
		gamePanel.add(status);
		// bottom
		playerScore = new JLabel(game.getPlayerScore(), SwingConstants.CENTER);
		playerScore.setFont(new Font("ARIAL", Font.BOLD, 24));
		bottomPanel.add(playerScore);
		playerDeck = new JButton(new ImageIcon(Card.CARD_DOWN));
		playerDeck.addActionListener(new ButtonListener());
		bottomPanel.add(playerDeck);

		add(topPanel);
		add(gamePanel);
		add(bottomPanel);
		//updateGame(War.PLAYER);

	}

	/**
	 * Actions on deck click
	 *
	 */
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			game.go();
			int roundWinner;
			roundWinner = game.battle();
			updateGame(roundWinner);
			if (roundWinner > War.WAR_FLAG) {

			}
			game.collectWinnings(roundWinner);

		}
	}

	/**
	 * Update the Decks
	 */
	private void updateDecks() {
		int[] scores = game.getScores();
		if (scores[War.CPU] > 0)
			cpuDeck.setIcon(new ImageIcon(Card.CARD_DOWN));
		else if (scores[War.CPU] <= 0)
			cpuDeck.setIcon(new ImageIcon(Card.CLEAR));

		if (scores[War.PLAYER] > 0)
			playerDeck.setIcon(new ImageIcon(Card.CARD_DOWN));
		else if (scores[War.PLAYER] <= 0)
			playerDeck.setIcon(new ImageIcon(Card.CLEAR));
	}

	/**
	 * Update Stacks and Scores
	 * 
	 * @param roundWinner
	 *            the winner of the round
	 */
	private void updateGame(int roundWinner) {

		// War cards get face down
		if (game.getWarring() == 2) {
			cpuStack.setIcon(new ImageIcon(Card.CARD_DOWN));
			playerStack.setIcon(new ImageIcon(Card.CARD_DOWN));
			game.clearWar();
		} else if (game.getWarring() == 1)
			game.nextDown(); // next one is down, current battle triggered a war
		else {

			cpuStack.setIcon(new ImageIcon(game.getCardImage(War.CPU)));
			playerStack.setIcon(new ImageIcon(game.getCardImage(War.PLAYER)));
		}
		if (roundWinner == War.TIE_FLAG) {
			status.setText("Tie Game!");
			playerDeck.setEnabled(false);
		} else if (roundWinner == War.WAR_FLAG)
			status.setText("War!");
		else if (game.gameWinner() != null) {
			if (game.cpuScore() > game.playerScore())
				status.setText("CPU Wins!");
			else
				status.setText("You Win!");
			playerDeck.setEnabled(false);
		} else {
			if (roundWinner == War.CPU)
				status.setText("CPU " + "wins the round!");
			else
				status.setText("Player " + "wins the round!");

		}
		cpuScore.setText(game.getCPUScore());
		playerScore.setText(game.getPlayerScore());
		updateDecks();
	}

	/**
	 * WarGUI Driver
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new WarGUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.pack();
		// OR
		frame.setSize(1024, 500);
		frame.validate();
		frame.setVisible(true);
	}
}