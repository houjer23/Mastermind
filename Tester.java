/**
* This class gather user input and run Mastermind
*
* @author Jerry Hou
* @since 1.0
*/

// import all the necessary classes
import java.util.Scanner;
import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) { // start of public static void main
		Scanner sc = new Scanner(System.in); // Scanner class
		Mastermind m = new Mastermind(); // constructor for Mastermind
		while (true) { // start of while loop
			// gathers user input
			ArrayList<Character> user_choice = new ArrayList<>();
			System.out.println("\nThere are 6 colors in total");
			System.out.println("select 4 color of your choice");
			System.out.println("red = R, green = G, blue = B, purple = P, orange = O, yellow = Y");
			System.out.println("Example Input Format: R G B P");
			System.out.print("Your input: ");
			
			for (int i = 0; i < 4; i ++) {
				user_choice.add(sc.next().charAt(0));
			}
			// pass the user input to the Mastermind class
			// Mastermind will check if the user input are right and print the board
			if (m.check_correct(user_choice)) {
				/* 
				 * if the user gets the correct answer
				 * stop the game
				 */
				break;
			}
		} // end of while loop
	} // end of public static void main
} // end of Tester class
