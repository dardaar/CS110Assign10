/**
 * CardStack is a stack of cards CS 110
 * 
 * @author Benjamin
 *
 */
public class CardStack extends StackReferenceBased {
	/**
	 * Constructor
	 */
	public CardStack() {
		super();
	}

	/**
	 * CompareTo
	 * 
	 * @param cardStack
	 *            the stack to compare to
	 * @return 1 if greater, -1 if less, 0 if equal
	 */
	public int compareTo(CardStack cardStack) {
		Card c1 = (Card) this.peek();
		Card c2 = (Card) cardStack.peek();
		return c1.compareTo(c2);
	}

	/**
	 * Add a card to the stack
	 * 
	 * @param c
	 *            the card to add
	 */
	public void addCard(Card c) {
		push(c);
	}

}
