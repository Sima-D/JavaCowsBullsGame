package games.cards;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class Game_main {

	public static void main(String[] args) {
		
		final int MIN = 5000, MAX = 10000;
		int cardsPerPlayer = 5, numOfPlayers = 4;
		int money = (int)Math.round((Math.random() * (MAX - MIN) + MIN));
		String name = "";
		
		Player[] playersArr = new Player[numOfPlayers];
		
		for (int i = 0; i < playersArr.length; ++i) {
			name = JOptionPane.showInputDialog("Please enter your name: ");
			playersArr[i] = new Player(name, money, cardsPerPlayer);
		}
		
		CardGame war_game = new CardGame(cardsPerPlayer, playersArr); //shuffles the cards and divides cards for each player
		
		int currRoundNumber = 1, totalAmount = 0, winnerIndex = 0;
		List<Card> cardsArrList = new ArrayList<Card>();
		List<Integer> valuesArrList = new ArrayList<Integer>();
				
		while(currRoundNumber <= 5) {
			
			int amountForRound = 100 * currRoundNumber;
			System.out.printf("ROUND NUMBER %d.\n", currRoundNumber);
			
			for (int i = 0; i < playersArr.length; ++i) {
				playersArr[i].reduceAmount(amountForRound);
				cardsArrList.add(playersArr[i].getCard());
				System.out.printf("The player %s throw the card: %s of %s.\n", playersArr[i].getPlayerName(), cardsArrList.get(i).getSuit(), cardsArrList.get(i).getValue());
			}
			
			for (int i = 0; i < cardsArrList.size(); ++i) {
					String strValue = cardsArrList.get(i).getValue();
					int intValue = cardsArrList.get(i).convertToInt(strValue);
					valuesArrList.add(intValue);
			}
			
			totalAmount = amountForRound * numOfPlayers;
			// In my implementation - if there are cards with same max value - will return the FIRST card in the list
			int maxVal = Collections.max(valuesArrList); 
			winnerIndex = valuesArrList.indexOf(maxVal);
			playersArr[winnerIndex].addAmount(totalAmount);
			System.out.printf("\nThe cards thrown in this round: \n");
			printList(cardsArrList);
			System.out.printf("\nThe winner in the current round is: %s", playersArr[winnerIndex].getPlayerName());
			cardsArrList.clear();
			valuesArrList.clear();
			++currRoundNumber;
			System.out.print("\n----------------------------------NEXT ROUND----------------------------------\n");
		}
		
		System.out.print("\n--------------------------------GAME RESULTS----------------------------------\n");
		for (int i = 0; i < playersArr.length; ++i) {
			System.out.printf("Name: %s, amount of money: %d.\n", playersArr[i].getPlayerName(),playersArr[i].money);
		}

		System.exit(0);
	}

	private static void printList(List<Card> cardsArrList) {
			for (Card c: cardsArrList) {
				System.out.print(c.getSuit() + " of " + c.getValue() + "\n");
			}
	}
}
