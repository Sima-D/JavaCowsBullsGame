package games.cards;

public class Card {
	
	String suit = "";
	String value = "";
	
	Card (String suit, String value){
		this.suit = suit;
		this.value = value;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getValue() {
		return value;
	}
	
	public int convertToInt(String value) {
		int val = 0;
		switch (value) {
		case "1":
			val = Integer.parseInt(value);
			return val;
		case "2":
			val = Integer.parseInt(value);
			return val;
		case "3":
			val = Integer.parseInt(value);
			return val;
		case "4":
			val = Integer.parseInt(value);
			return val;
		case "5":
			val = Integer.parseInt(value);
			return val;
		case "6":
			val = Integer.parseInt(value);
			return val;
		case "7":
			val = Integer.parseInt(value);
			return val;
		case "8":
			val = Integer.parseInt(value);
			return val;
		case "9":
			val = Integer.parseInt(value);
			return val;
		case "Jack":
			val = 10;
			return val;
		case "Queen":
			val = 11;
			return val;
		case "King":
			val = 12;
			return val;
		case "Ace":
			val = 13;
			return val;
		}
	return val;
	}
}
