import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
	
	public void check_correct(ArrayList<Character> user_choice) {
		board.add(user_choice);
		ArrayList<Character> result = new ArrayList<>();
		for (int i = 0; i < 4; i ++) {
			char cur = answer[i];
			char cur_answer = '0';
			if (user_choice.get(i) == cur) {
				cur_answer = '2';
			} else {
				for (int j = 0; j < 4; j ++) {
					if (user_choice.get(j) == cur) {
						cur_answer = '1';
						break;
					}
				}
			}
			if (cur_answer != '0') {
				result.add(cur_answer);
			}
		}
		Collections.shuffle(result);
		guess_result.add(result);
		printBoard();
	}
	
	public void printBoard() {
		for (int i = 0; i < board.size(); i ++) {
			for (int j = 0; j < 4; j ++) {
				System.out.print(board.get(i).get(j) + " ");
			}
			System.out.print("   ");
			if (guess_result.size() <= 2) {
				for (int j = 0; j < guess_result.size(); j ++) {
					System.out.print(guess_result.get(i).get(j) + " ");
				}
				System.out.println();
			} else {
				System.out.print(guess_result.get(i).get(0) + " ");
				System.out.println(guess_result.get(i).get(1) + " ");
				System.out.print("                    ");
				for (int j = 2; j < guess_result.size(); j ++) {
					System.out.println(guess_result.get(i).get(j) + " ");
				}
			}
		}		
	}
	
	
} // end of Mastermind class
