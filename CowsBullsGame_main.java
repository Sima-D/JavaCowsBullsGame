package oop_basics;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class CowsBullsGame_main {

	public static void main(String[] args) {
		
		Game my_game = new Game();
		JOptionPane.showMessageDialog(null, Arrays.toString(my_game.createRandom()), "COMPUTER CHOICE", JOptionPane.INFORMATION_MESSAGE);
		int count_tries = 0;
		String exitStr = "";
		
		do {
			String numStr = JOptionPane.showInputDialog("Please enter a 4-digit number, each digit between 0 and 9: ");
			
			if (!my_game.isValidLength(numStr) && my_game.isNumeric(numStr)) {
				JOptionPane.showMessageDialog(null, "The number should contain 4 digits!", "Error", JOptionPane.ERROR_MESSAGE);
				exitStr = JOptionPane.showInputDialog("To EXIT the game before it's end, enter \"Exit\" ");
			}			
			else if (!my_game.isDistinctNum(numStr) && my_game.isNumeric(numStr)) {
				JOptionPane.showMessageDialog(null, "The number should contain only unique digits!", "Error", JOptionPane.ERROR_MESSAGE);
				exitStr = JOptionPane.showInputDialog("To EXIT the game before it's end, enter \"Exit\" ");
			}
			else if(!my_game.isNumeric(numStr)) {
				JOptionPane.showMessageDialog(null, "The number should contain only digits!", "Error", JOptionPane.ERROR_MESSAGE);
				exitStr = JOptionPane.showInputDialog("To EXIT the game before it's end, enter \"Exit\" ");
			}
			else
			{
				my_game.updateBulls(numStr);
				my_game.updateHits(numStr);
				System.out.printf("Try number %d: %s, results: Bulls = %d, Hits = %d.\n", ++count_tries, numStr, my_game.getBulls(), my_game.getHits());
			}
			
		} while (!my_game.gameOver() && !my_game.gameExit(exitStr));
		
		if (my_game.gameExit(exitStr)) {
			JOptionPane.showMessageDialog(null, "You exited the game! Buy buy!", "GAME EXIT", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			System.out.printf("You Won! Number of tries till the full guess was: %d", count_tries);
		}
		
		System.exit(0); 
	}
}
