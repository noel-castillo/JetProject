package jets;

import java.util.Scanner;

public class JetsApplication {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		AirField af = new AirField();
		String fileName = "jets.txt";

		af.readJets(fileName);
		int menuSelection;

		do {
			menuSelection = af.displayMenu(keyboard);
			af.launchMenuSelection(menuSelection, af.getJets(), keyboard);

		} while (menuSelection != 9);

		System.out.println("Thanks for playing!");
		keyboard.close();
	}
}
