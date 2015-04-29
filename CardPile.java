/**
 * CardPile contains info about a queue of cards CS110
 * 
 * @author Benjamin Satterwhite
 * 
 */
public class CardPile extends QueueReferenceBased {
	private int count; // num cards in pile

	/**
	 * Constructor
	 */
	public CardPile() {
		super();
		count = 0;
	}

	/**
	 * add a card to the pile
	 * 
	 * @param c
	 *            card to add
	 */
	public void addCard(Card c) {
		count++;
		enqueue(c);
	}

	/**
	 * remove a card
	 */
	public Card dequeue() {
		count--;
		return (Card) super.dequeue();
	}

	/**
	 * add a stack of cards
	 * 
	 * @param cardStack
	 *            the stack to add
	 */
	public void addStack(CardStack cardStack) {
		while (!cardStack.isEmpty()) {
			Card c = (Card) cardStack.pop();
			this.addCard(c);
		}
	}

	/**
	 * add a pile of cards
	 * 
	 * @param cardPile
	 *            the pile to add
	 */
	public void addPile(CardPile cardPile) {
		while (!cardPile.isEmpty()) {
			Card c = (Card) cardPile.dequeue();
			this.addCard(c);
		}
	}

	/**
	 * method compareTo
	 * 
	 * @param cardPile
	 *            the pile to compare to
	 * @return 1 if greater, -1 if less, 0 if equal
	 */
	public int compareTo(CardPile cardPile) {
		Card c1 = (Card) this.peek();
		Card c2 = (Card) cardPile.peek();
		return c1.compareTo(c2);
	}

	/**
	 * remove and return a card
	 * 
	 * @return the top of the pile
	 */
	public Card playCard() {
		return (Card) this.dequeue();
	}

	/**
	 * get the number of cards in the pile
	 * 
	 * @return the number of cards in the pile
	 */
	public int getCount() {
		return count;
	}
}
