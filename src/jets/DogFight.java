package jets;

import java.util.List;
import java.util.Scanner;

public class DogFight {

//	F I E L D S 
	private int p1;

	private int p2;

//	C O N S T R U C T O R 

	public DogFight() {

	}

//	M E T H O D S 

	public void constructDogFight(List<Jet> jets, Scanner keyboard) {
		System.out.println("Player 1 select your Combat Ready Jet:");
		for (int c = 0; c < jets.size(); c++) {
			if (jets.get(c) instanceof CombatReady) {
				System.out.println("Index: " + c + " " + jets.get(c).getModel());
			}
		}
		p1 = keyboard.nextInt();
		System.out.println("Player 2 select your Combat Ready Jet:");
		for (int c = 0; c < jets.size(); c++) {
			if (jets.get(c) instanceof CombatReady) {
				System.out.println("Index: " + c + " " + jets.get(c).getModel());
			}
		}
		p2 = keyboard.nextInt();

		double winner = Math.random();
		if (winner > 0.50) {
			System.out.println("Player 1's " + jets.get(p1).getModel() + " decimated Player 2's "
					+ jets.get(p2).getModel() + " in a savage dog fight!");
		} else {
			System.out.println("Player 2's " + jets.get(p2).getModel() + " decimated Player 1's "
					+ jets.get(p1).getModel() + " in a savage dog fight!");
		}

	}

}
