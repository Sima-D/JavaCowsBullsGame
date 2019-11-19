package games.cards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardGame extends DeckOfCards{
	
	static String[] suites = {"SPADES", "HEARTS", "DIAMONDS", "CLUBS"};
	static String[] values = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "Jack", "Queen", "King", "Ace"};
	List<Card> handArrList = new ArrayList<Card>();
	final int NUM_OF_PLAYERS = 4;
	int cardsPerPlayer = 0;
	
	CardGame(int numOfCards, Player[] playersArr){
		super(suites, values);
		cardsPerPlayer = numOfCards;
		newGame(playersArr);
	}
	
	public void newGame(Player[] playersArr) {
		System.out.printf("\n\nAfter the Shuffle: \n\n");
		Collections.shuffle(cardsArrList);
		printList(cardsArrList);
		
		// divides 5 cards for each player 
		for (int i = 0; i < playersArr.length; ++i) {
			for (int j = 0; j < cardsPerPlayer; ++j) {
				handArrList.add(dealOne()); //Takes 5 card objects from the top of the Deck and adds it to the handArrList
			}
			System.out.print("-----------------------------------------------------------------------------------\n");
			playersArr[i].setHand(handArrList);
			handArrList.clear();
			playersArr[i].getPlayerInfo();
			System.out.printf("The deck size is now: %d. The player holds %d cards.\n", getDeckSize(), cardsPerPlayer);
			System.out.print("-----------------------------------------------------------------------------------\n");
		}
	}
}
