import java.util.Scanner;
import java.util.ArrayList;

public class Tester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Mastermind m = new Mastermind();
		while (true) {
			ArrayList<Character> user_choice = new ArrayList<>();
			System.out.println("There are 6 colors in total");
			System.out.println("select 4 color of your choice");
			System.out.println("red = R, green = G, blue = B, purple = P, orange = O, yellow = Y");
			System.out.println("input a single character\n");
			
			for (int i = 0; i < 4; i ++) {
				System.out.print((i + 1) + " color: ");
				user_choice.add(sc.next().charAt(0));
			}
			m.check_correct(user_choice);
		}
		
	}
} // end of Tester class
