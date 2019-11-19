package oop_basics;

public class Game {
	
	private final int LENGTH = 4;
	int[] comp_arr = new int[LENGTH];
	private int numOfBulls = 0, numOfHits = 0;
	
	int[] createRandom() {
		
		final int LOWER_RANGE = 0, UPPER_RANGE = 9;
		int num = 0, i = 0;

		while (i < comp_arr.length) {
			int flag = 0;
			num = (int)Math.round((Math.random()* (UPPER_RANGE - LOWER_RANGE) + LOWER_RANGE));
			for (int j = 0; j < i; ++j) {
				if (comp_arr[j] == num) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				comp_arr[i] = num;
				++i;
			}
		}
		return comp_arr;
	}
	
	private int[] strToArray(String numStr) {
		int[] user_arr = new int[LENGTH];
		if (isValidLength(numStr) && isNumeric(numStr)) {
			int num = (int)Integer.parseInt(numStr); 
			int right_digit = 0, i = user_arr.length-1;
			while(num != 0) {
				right_digit = num % 10;
				user_arr[i] = right_digit;
				num = (int)num/10;
				--i;
			}
		}
		return user_arr;
	}
	
	public boolean isNumeric(String numStr) {
		char[] user_arr = numStr.toCharArray();
		for (int i = 0; i < user_arr.length; ++i) {
			if (!(user_arr[i] >= '0' && user_arr[i] <= '9')) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isValidLength(String numStr) {
		return (numStr.length() == LENGTH);
	}	
	
	public boolean isDistinctNum(String numStr) {
		int[] user_arr = new int[LENGTH];
		if (isValidLength(numStr) && !numStr.equals("0000")) {
			user_arr = strToArray(numStr); 
			for (int i = 0; i < user_arr.length; ++i) {
				for (int j = i + 1; j < user_arr.length; ++j) {
					if (user_arr[i] == user_arr[j] && i != j) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean gameOver() {
		return (numOfBulls == LENGTH);
	}
	
	public boolean gameExit(String exitStr) {
		return (exitStr.equalsIgnoreCase("exit"));
	}
	public int getBulls() {
		return numOfBulls;
	}
	
	public int getHits() {
		return numOfHits;
	}
	
	public void updateBulls(String numStr) {
		int[] user_arr = new int[LENGTH];
		user_arr = strToArray(numStr); 
		int bulls_counter = 0;
		
		for (int i = 0; i < comp_arr.length; ++i) { 
				if (comp_arr[i] == user_arr[i]) {
					++bulls_counter;
				}
		}
		numOfBulls = bulls_counter;
	}
	
	public void updateHits(String numStr) {
		int[] user_arr = new int[LENGTH];
		user_arr = strToArray(numStr); 
		int hits_counter = 0;	
		
		for (int i = 0; i < comp_arr.length; ++i) {
			for (int j = 0; j < user_arr.length; ++j) {
				if (comp_arr[i] == user_arr[j] && i != j) {
					++hits_counter;
				}
			}
		}
		numOfHits = hits_counter;
	}
}
