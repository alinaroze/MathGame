import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MathGame {

	int r1, r2, score;

	public static void main(String[] args) {

		System.out
				.print("Hey there! Welcome to the MATHGAME.\n"
						+ "The object of this game is you have two random numbers.\n"
						+ "After that, you have 3 moves to use to +,-,*, or / , and either 1, 2, or 3 with the 1st number \n" + 
						"to get as close as possible to the 2nd number.\n\n");

		System.out
				.println("This game has 10 levels and in order to win you need to beat all 10.\n"
						+ "Any time you score gets over 20 you will lose.\n\n"
						+ "GOOD LUCK!! :)");
		MathGame game = new MathGame();
		game.run();

	}

	private int choose1() {

		Random generator = new Random();
		r1 = generator.nextInt(100);

		return r1;

	}

	private int choose2() {
		Random generator = new Random();
		r2 = generator.nextInt(100 - r1);

		return r2;
	}

	private int num() {
		int num;
		Scanner input = new Scanner(System.in);

		do {
			try {

				num = input.nextInt();

			} catch (InputMismatchException e) {
				return num();

			}// end catch

		} while (num < 1 || num > 3);
		return num;

	}

	private void level() {

		int tryCount = 1;
		do{
			
			System.out.println("This is try "+tryCount);

			System.out.println("Would you like to use 1, 2, or 3?");
			int num = num();

			System.out.println("What operation would you like?");
			Scanner input = new Scanner(System.in);
			String op = input.next();

			if (op.equals("*")) {
				r1 = r1 * num;
			} else if (op.equals("+")) {
				r1 = r1 + num;
			} else if (op.equals("-")) {
				r1 = r1 - num;
			} else if (op.equals("/")) {
				r1 = r1 / num;
			} else {
				System.out.println("That is not a valid input.\n"
						+ "Please try again:");
				level();

			}

			System.out.println("You just finished try " + tryCount);
			System.out.println("Your current chosen value is " + r1
					+ "\n\n");
			
			
			tryCount++;
		}while((tryCount < 4) && (r1 != r2) );

	}

	private void replay() {

		Scanner input = new Scanner(System.in);

		String ans = input.next();
		if (ans.equalsIgnoreCase("yes")) {
			run();

		}
		if (ans.equalsIgnoreCase("no")) {

		} else {
			System.out
					.println("I am sorry, I do not understand what you are saying.\n"
							+ "Please re-enter your response: ");
			replay();
		}

	}

	private void run() {

		int level = 1;

		while (level < 11) {
			System.out.println("Welcome to level " + level);

			choose1();
			choose2();
			System.out.println("Your first number is " + choose1()+ "\n"+
					"Your second number is "+choose2());
			level();

			score = r1 - r2;
			System.out.println("Your score is: " + Math.abs(score));

			if (Math.abs(score) > 20) {
				System.out.println("I am sorry, you lost the game!\n"
						+ "Would you like to try again?");
				replay();
			} else {
				System.out.println("Congrats! You just finished level " + level
						+ "\n\n");
			}

			level++;
		}

		System.out.println("You won the MATHGAME!!\n"
				+ "Would you like to try again?");
		replay();
	}
}
