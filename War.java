/**
 * War Game class CS 110 Methods to play War
 * 
 * @author Benjamin
 *
 */
public class War {

	public static final int NUM_PLAYERS = 2;
	public static final int WAR_FLAG = -1;
	public static final int TIE_FLAG = -2;
	public static final int PLAYER = 0;
	public static final int CPU = 1;
	private int warring; // war counter. on a war, one is face down, two resets

	private User[] users = new User[NUM_PLAYERS]; // array of players

	/**
	 * Constructor
	 */
	public War() {
		warring = 0;
		Deck deck = new Deck();
		for (int i = 0; i < NUM_PLAYERS; i++) {
			users[i] = new User(i + 1);
		}
		deck.shuffle();
		while (!deck.isEmpty()) {
			for (int i = 0; i < NUM_PLAYERS; i++) {
				users[i].getHand().addCard(deck.dealCard());
			}
		}
	}

	/**
	 * Play a card from each user
	 * 
	 * @return null if no winner or the winner
	 */
	public User go() {
		User winner = gameWinner();
		for (int i = 0; i < NUM_PLAYERS && winner == null; i++) {
			users[i].playCard();
		}

		return gameWinner();
	}

	/**
	 * Battle the two users stack
	 * 
	 * @return the round winner
	 */
	public int battle() {

		// find a winner
		int roundWinner = 0;
		for (int i = 1; i < NUM_PLAYERS; i++) {
			if (users[i].comparePlays(users[roundWinner]) > 0) {
				roundWinner = i;
			}
		}
		// Check for wars
		for (int i = 1; i < NUM_PLAYERS; i++) {
			if (users[i].comparePlays(users[roundWinner]) == 0
					&& users[i] != users[roundWinner]) {
				roundWinner = WAR_FLAG;
				warring++; // hack for not thinking ahead...
			}
		}
		return roundWinner;

	}

	/**
	 * Collect every pile to the winner
	 * 
	 * @param winner
	 *            the round winner
	 */

	public void collectWinnings(int winner) {

		if (winner != War.WAR_FLAG && winner != War.TIE_FLAG) {
			CardPile winnings = new CardPile();
			for (int i = 0; i < NUM_PLAYERS; i++) {
				winnings.addStack(users[i].getStack());
			}
			users[winner].getHand().addPile(winnings);
		}
	}

	/**
	 * Check if anyone has one
	 * 
	 * @return the winner
	 */
	public User gameWinner() {
		User winner = null;
		for (int i = 0; i < NUM_PLAYERS; i++) {
			if (users[i].getScore() == Deck.CARDS_IN_DECK)
				winner = users[i];

		}
		return winner;
	}

	/**
	 * Grab an array of scores
	 * 
	 * @return the array of scores
	 */
	public int[] getScores() {
		int[] scores = new int[NUM_PLAYERS];
		for (int i = 0; i < NUM_PLAYERS; i++) {
			scores[i] = users[i].getScore();
		}
		return scores;
	}

	/*
	 * public boolean newRound() { return users[CPU].getStack().isEmpty() &&
	 * users[PLAYER].getStack().isEmpty(); }
	 */
	/**
	 * @return the cpu score
	 */
	public int cpuScore() {
		return users[CPU].getScore();
	}

	/**
	 * @return the player score
	 */
	public int playerScore() {
		return users[PLAYER].getScore();
	}

	/**
	 * reset the war counter
	 */
	public void clearWar() {
		warring = 0;
	}

	/**
	 * @return formatted cpu score
	 */
	public String getCPUScore() {
		return "CPU Score: " + users[CPU].getScore();
	}

	/**
	 * @return warring counter
	 */
	public int getWarring() {
		return warring;
	}

	/**
	 * Next card will be face down
	 */
	public void nextDown() {
		warring = 2;
	}

	/**
	 * @return formatted player score
	 */
	public String getPlayerScore() {
		return "PLAYER Score: " + users[PLAYER].getScore();
	}

	/**
	 * @return array of users
	 */
	public User[] getUsers() {
		return users;
	}

	/**
	 * @param user
	 *            the user whose stack to check
	 * @return the image of the top of the stack
	 */
	public String getCardImage(int user) {
		if (!users[user].getStack().isEmpty())
			return ((Card) users[user].getStack().peek()).getImageFile();
		else
			return Card.CLEAR;

	}
}
