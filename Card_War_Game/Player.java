package games.cards;
import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String name = "";
	public int money = 0;
	public int numOfCards = 0;
	private final int TOP = 0;
	List <Card> playerArrList = new ArrayList<Card>();
	
	Player(String name, int money, int numOfCards){
		this.name = name;
		this.money = money;
		this.numOfCards = numOfCards;
	}
	
	// receives new set of cards for the Player 
	public void setHand(List<Card> handArrList) {
		playerArrList.addAll(handArrList);
	}
	
	public Card getCard() {
		return playerArrList.remove(TOP);
	}
	
	public void addCard(Card new_card) {
		playerArrList.add(new_card);
	}
	
	public void reduceAmount(int amount) {
		money -= amount;
	}
	
	public void addAmount(int amount) {
		money += amount;
	}
	
	public void getPlayerInfo() {
		System.out.printf("The name of player is: %s, the amount of money is: %d, the cards are: \n", name, money);
		for(Card c: playerArrList) {
			System.out.print(c.getSuit() + " of " + c.getValue() + "\n");
		}	
	}
	
	public String getPlayerName() {
		return name;
	}
}
