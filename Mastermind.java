import java.util.ArrayList;
import java.util.Arrays;

public class Mastermind {
	
	ArrayList<ArrayList<Character>> board = new ArrayList<>();;
	ArrayList<ArrayList<Character>> guess_result = new ArrayList<>();;
	char[] answer = new char[4];
	
	public Mastermind() {
		// computer generate a pattern for the human to guess
		ArrayList<Character> choice = new ArrayList<Character>(Arrays.asList('R', 'G', 'B', 'P', 'O', 'Y'));
		for (int i = 0; i < 4; i ++) {
			int random_number = (int) (Math.random() * choice.size());
			char random_color = choice.get(random_number);
			answer[i] = random_color;
			choice.remove(random_number);
			//System.out.println(random_color);
		}
	}
	
	
	
} // end of Mastermind class
