package jets;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AirField {

//	F I E L D S

	private Jet[] jets;

//	C O N S T R U C T O R S

//	M E T H O D S 

	public Jet[] getJets() {
		return jets;
	}

	public void setJets(Jet[] jets) {
		this.jets = jets;
	}

	public int displayMenu(Scanner keyboard) {
		int menuSelection = 0;
		System.out.println("Air Field Menu:");
		System.out.println("1. List Fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all Cargo Jets");
		System.out.println("6. Dogfight!");
		System.out.println("7. Add a jet to Fleet");
		System.out.println("8. Remove a jet from Fleet");
		System.out.println("9. Quit");
		try {
		menuSelection = keyboard.nextInt();
		} catch(InputMismatchException e){
			System.out.println("Input invalid");
		}
		return menuSelection;
	}

}
