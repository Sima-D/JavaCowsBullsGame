package games.cards;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class DeckOfCards {

	Card my_card;
	List<Card> cardsArrList = new ArrayList<Card>();
	final int SIZE = 52;
	private final int TOP = 0;
	
	DeckOfCards(String[] suites, String[] values){
		init(suites, values);
	}

	private void shuffle(List<Card> cardsArrList) {
		System.out.printf("\n\nAfter the Shuffle: \n\n");
		Collections.shuffle(cardsArrList);
		printList(cardsArrList);
	}
	
	private void init(String[] suites, String[] values) {
		for(int i = 0; i < suites.length; ++i) {
			for (int j = 0; j < values.length; ++j) {
				my_card = new Card(suites[i],values[j]);
				cardsArrList.add(my_card);
			}
		}
		System.out.printf("\nBefore the Shuffle: \n\n");
		printList(cardsArrList);
	}
	
	public void printList(List<Card> cardsArrList) {
		for (Card c: cardsArrList) {
			System.out.print(c.getSuit() + " of " + c.getValue() + "\n");
		}
	}  
	
	/* returns card object from the top of the deck */
	public Card dealOne() {
		return cardsArrList.remove(TOP);
	}
	
	public int getDeckSize() {
		return cardsArrList.size();
	}
	
	public void newGame() {
		shuffle(cardsArrList);
	}
}
