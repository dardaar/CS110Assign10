/**
 * Class Card contains methods to create a card with a given rank and suit
 * 
 * CS 110
 * @author Benjamin Satterwhite
 * 
 */
public class Card {
	// Public Constants
	public final static int SPADES = 0, CLUBS = 1, HEARTS = 2, DIAMONDS = 3;
	public final static int JACK = 11, QUEEN = 12, KING = 13, ACE = 1;
	public final static String CARD_DOWN = "back.jpg";
	public final static String CLEAR = "clear.jpg";
	// Instance Variables
	private int rank;
	private int suit;

	/**
	 * Constructor
	 * 
	 * @param suit
	 *            the number of the suit
	 * @param rank
	 *            the number of the rank
	 */
	public Card(int rank, int suit) {
		setRank(rank);
		setSuit(suit);
	}

	/**
	 * Constructor
	 * 
	 * @param suit
	 *            the name of the suit
	 * @param rank
	 *            the name of the rank
	 */
	public Card(String rank, String suit) {
		setRank(rank);
		setSuit(suit);
	}

	/**
	 * Constructor
	 * 
	 * @param suit
	 *            the name of the suit
	 * @param rank
	 *            the name of the rank
	 */
	public Card(int rank, String suit) {
		setRank(rank);
		setSuit(suit);
	}

	/**
	 * method getRank
	 * 
	 * @return the number of the rank of the card
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * method setRank with valid input range [1-13]
	 * 
	 * @param rank
	 *            the number of the rank to set the card
	 */
	private void setRank(int rank) {
		final int LOW = 1, HIGH = 13;
		if (rank > LOW && rank <= HIGH)
			this.rank = rank;
		else if (rank <= LOW)
			this.rank = LOW;
		else
			this.rank = HIGH;
	}

	/**
	 * method setRank for Strings
	 * 
	 * @param rank
	 *            the name of the rank to set the card
	 */
	private void setRank(String rank) {
		switch (rank.toUpperCase()) {
		case "ACE":
			setRank(ACE);
			break;
		case "JACK":
			setRank(JACK);
			break;
		case "QUEEN":
			setRank(QUEEN);
			break;
		case "KING":
			setRank(KING);
			break;
		default:
			setRank(1);
			break;
		}
	}

	/**
	 * method getSuit
	 * 
	 * @return the number of the suit of the card
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * method setSuit with valid input range from [0-3]
	 * 
	 * @param suit
	 *            the suit to set the card
	 */
	private void setSuit(int suit) {
		final int LOW = 0, HIGH = 3;
		if (suit > LOW && suit <= HIGH)
			this.suit = suit;
		else if (suit <= LOW)
			this.suit = LOW;
		else
			this.suit = HIGH;
	}

	/**
	 * method setSuit for strings
	 * 
	 * @param suit
	 *            the name of the suit to set the card
	 */
	private void setSuit(String suit) {
		switch (suit.toUpperCase()) {
		case "SPADES":
			setSuit(SPADES);
			break;
		case "CLUBS":
			setSuit(CLUBS);
			break;
		case "HEARTS":
			setSuit(HEARTS);
			break;
		case "DIAMONDS":
			setSuit(DIAMONDS);
			break;
		default:
			setSuit(0);
			break;
		}
	}

	/**
	 * method toString
	 * 
	 * @return String containing rank of suit
	 */
	public String toString() {
		return rankToString() + " of " + suitToString();
	}

	/**
	 * method equals
	 * 
	 * @param otherCard
	 *            the card to compare to
	 * @return true if same rank, false otherwise
	 */
	public boolean equals(Card otherCard) {
		if (this.rank == otherCard.rank)
			return true;
		else
			return false;
	}
	
	/**
	 * method compareTo
	 * 
	 * @param c
	 *            card to compare to
	 * @return 1 if greater, -1 if less, 0 if equal
	 */
	public int compareTo(Card c){
		if(this.getRank() > c.getRank())
			return 1;
		else if (this.getRank() < c.getRank())
			return -1;
		else
			return 0;
	}
	/**
	 * method suitToString
	 * 
	 * @return String containing the name of the suit
	 */
	public String suitToString() {
		if (suit == SPADES)
			return "Spades";
		else if (suit == CLUBS)
			return "Clubs";
		else if (suit == HEARTS)
			return "Hearts";
		else if (suit == DIAMONDS)
			return "Diamonds";
		else
			return String.valueOf(suit);
	}

	/**
	 * method rankToString
	 * 
	 * @return String containing the name of the rank
	 */
	public String rankToString() {
		if (rank == ACE)
			return "Ace";
		else if (rank == JACK)
			return "Jack";
		else if (rank == QUEEN)
			return "Queen";
		else if (rank == KING)
			return "King";
		else
			return String.valueOf(rank);
	}
	/**
	 * method getImageFile
	 * @return file name of the card image
	 */
	public String getImageFile(){
		String s;
		s = rankToString().toLowerCase();
		s+= suitToString().toLowerCase().charAt(0) +".jpg";
		return s;
	}
}
