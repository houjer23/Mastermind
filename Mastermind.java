import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Mastermind class, takes user input and check if they are right or not, also print the board
public class Mastermind {
	
	private ArrayList<ArrayList<Character>> board = new ArrayList<>(); // user input
	private ArrayList<ArrayList<Character>> guess_result = new ArrayList<>(); // how right is the user input
	private char[] answer = new char[4]; // correct answer
	
	public Mastermind() { // constructor
		// computer generate a random pattern for the human to guess
		ArrayList<Character> choice = new ArrayList<Character>(Arrays.asList('R', 'G', 'B', 'P', 'O', 'Y'));
		// four characters
		for (int i = 0; i < 4; i ++) {
			int random_number = (int) (Math.random() * choice.size());
			char random_color = choice.get(random_number);
			answer[i] = random_color;
			choice.remove(random_number);
			//System.out.println(random_color);
		}
	} // end of constructor
	
	public boolean check_correct(ArrayList<Character> user_choice) {
		board.add(user_choice);
		ArrayList<Character> result = new ArrayList<>();
		// 1 represents number in the answer, 2 represents number in the correct position
		int num_got = 0;
		for (int i = 0; i < 4; i ++) {
			char cur = answer[i];
			char cur_answer = '0';
			if (user_choice.get(i) == cur) {
				cur_answer = '2';
				num_got ++;
				
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
		Collections.shuffle(result); // shuffle the result
		guess_result.add(result);
		printBoard(); // call print board method
		if (num_got == 4) {
			return true;
		}
		return false;
	}
	
	public void printBoard() {
		System.out.println();
		//System.out.println(answer[0] + " " + answer[1] + " " + answer[2] + " " + answer[3]);
		//System.out.println(guess_result);
		for (int i = 0; i < board.size(); i ++) {
			for (int j = 0; j < 4; j ++) {
				System.out.print(board.get(i).get(j) + " ");
			}
			System.out.print("   ");
			if (guess_result.get(i).size() <= 2) {
				for (int j = 0; j < guess_result.get(i).size(); j ++) {
					System.out.print(guess_result.get(i).get(j) + " ");
				}
				System.out.println();
			} else {
				System.out.println(guess_result.get(i).get(0) + " " + guess_result.get(i).get(1));
				System.out.print("           ");
				for (int j = 2; j < guess_result.get(i).size(); j ++) {
					System.out.print(guess_result.get(i).get(j) + " ");
				}
				System.out.println();
			}
		}
		System.out.println("\n1 represents there is a number in the answer,");
		System.out.println("2 represents there is a number in the correct position");
		System.out.println();
		
	}
	
	
} // end of Mastermind class
