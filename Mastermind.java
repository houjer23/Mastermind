/**
* This class takes user input and check if they are right or not, also print the board
*
* @author Jerry Hou
* @return if the game is finished or not
* @since 1.0
*/

// import needed classes
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Mastermind class, takes user input and check if they are right or not, also print the board
public class Mastermind {
	
	private ArrayList<ArrayList<Character>> board = new ArrayList<>(); // user input
	private ArrayList<ArrayList<Character>> guess_result = new ArrayList<>(); // how right is the user input
	private char[] answer = new char[4]; // correct answer
	private int guess_time = 0; // how many time the user guessed
	
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
	
	public boolean check_correct(ArrayList<Character> user_choice) { // check how many user guesses are correct
		guess_time ++;
		board.add(user_choice);
		ArrayList<Character> result = new ArrayList<>();
		// 1 represents a number is in the answer, 2 represents there is a number in the correct position
		int num_got = 0;
		for (int i = 0; i < 4; i ++) { // loop through 4 numbers
			char cur = answer[i];
			char cur_answer = '0';
			if (user_choice.get(i) == cur) { // if there is a number in the correct position
				cur_answer = '2';
				num_got ++;
				
			} else {
				for (int j = 0; j < 4; j ++) { // if a number is in the answer
					if (user_choice.get(j) == cur) {
						cur_answer = '1';
						break;
					}
				}
			}
			if (cur_answer != '0') {
				result.add(cur_answer); // add to how the user did
			}
		}
		Collections.shuffle(result); // shuffle the result
		guess_result.add(result);
		printBoard(); // call print board method
		if (num_got == 4) { // if all the inputs are correct, stops
			System.out.println("\nYou finished in " + guess_time + " times");
			System.out.println("You Win!!!");
			return true;
		}
		if (guess_time == 12) {
			System.out.println("\nYou have guessed 12 times");
			System.out.println("You Lost!!!");
			System.out.print("Answer: ");
			for (int j = 0; j < 4; j ++) {
				System.out.print(answer[j] + " ");
			}
			return true;
		}
		return false;
	} // end of check_correct method
	
	public void printBoard() { // print board method: prints the board
		System.out.println("\nTHE BOARD");
		//System.out.println(answer[0] + " " + answer[1] + " " + answer[2] + " " + answer[3]);
		//System.out.println(guess_result);
		for (int i = 0; i < board.size(); i ++) { // track all the turns
			System.out.print("--------------------\n ");
			for (int j = 0; j < 4; j ++) { // prints the user input
				System.out.print(board.get(i).get(j) + " ");
			}
			System.out.print("  |  ");
			if (guess_result.get(i).size() <= 2) { // if the the result is less than or equal to 2, print only one line
				for (int j = 0; j < guess_result.get(i).size(); j ++) {
					System.out.print(guess_result.get(i).get(j) + " ");
				}
				System.out.println("");
			} else { // if the the result is more than 2, print two lines
				System.out.println(guess_result.get(i).get(0) + " " + guess_result.get(i).get(1)); // first line
				System.out.print("           |  ");
				for (int j = 2; j < guess_result.get(i).size(); j ++) { // second line
					System.out.print(guess_result.get(i).get(j) + " ");
				}
				System.out.println("");
			}
		} // end of the for loop looping through all the turns
		System.out.println("--------------------");
		System.out.println("\n1 represents a color in the answer but not in the correct location");
		System.out.println("2 represents there is a color in the correct position");
		System.out.println();
		
	} // end of print board method
	
	
} // end of Mastermind class
