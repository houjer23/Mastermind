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
		// direction for the game...
		System.out.println("\nWelcome to Mastermind!");
		System.out.println("The computer will randomly generate one combanation of six numbers without repeating colors.");
		System.out.println("You have to guess that combanation.");
		System.out.println("After your each guess,");
		System.out.println("you will get a hint of how many of your inputs are in the right location");
		System.out.println("and how many of them are not in the right location but in the answer.");
		System.out.println("With these clues, you can get the answer without taking forever.");
		System.out.println("ENJOY YOUR GAME\n");
		System.out.print("Hit return to continue ");
		sc.nextLine();
		Mastermind m = new Mastermind(); // constructor for Mastermind
		System.out.println("\nComputer have randomly generated one combanation of six numbers without repeating colors.");
		System.out.println("Now, it is your turn to guess the combanation\n");
		System.out.print("Hit return to continue ");
		sc.nextLine();
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
