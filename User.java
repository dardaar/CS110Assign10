/**
 * User Class Constains information about a user with a hand and stack
 * 
 * @author Benjamin
 *
 */
public class User {

	private CardPile hand;
	private CardStack stack;
	private int playerNum;

	/**
	 * Constructor
	 * 
	 * @param num
	 *            the player number
	 */
	public User(int num) {
		hand = new CardPile();
		stack = new CardStack();
		playerNum = num;
	}

	/**
	 * Get the users hand
	 * 
	 * @return the users hand
	 */
	public CardPile getHand() {
		return hand;
	}

	/**
	 * Get the users stack
	 * 
	 * @return the users stack
	 */
	public CardStack getStack() {
		return stack;
	}

	/**
	 * Get the player number
	 * 
	 * @return the player number
	 */
	public int getPlayerNum() {
		return playerNum;
	}

	/**
	 * Get the number of cards in the users hand
	 * 
	 * @return the users score
	 */
	public int getScore() {
		return hand.getCount();
	}

	/**
	 * Play a card from the user
	 */
	public void playCard() {
		if (!hand.isEmpty())
			stack.addCard(hand.playCard());
	}

	/**
	 * compare the user's play to another user
	 * 
	 * @param other
	 *            the user to compare to
	 * @return 1 if greater, -1 if less, 0 if equal
	 */
	public int comparePlays(User other) {
		return this.stack.compareTo(other.stack);
	}

	/**
	 * @return The players number
	 */
	public String toString() {
		return "Player " + playerNum;
	}
}
