package jets;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AirField {

//	F I E L D S

	private Jet[] jets;

	private static int jetNumber = 0;

//	C O N S T R U C T O R S

	public AirField() {

	}

//	M E T H O D S 

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
		} catch (InputMismatchException e) {
			System.out.println("Input invalid");
		}
		return menuSelection;
	}
	
	public Jet addJetToFleet(Scanner keyboard) {
		Jet output;
		System.out.println("1. Cargo Plane");
		System.out.println("2. Fighter Jet");
		int jetType = keyboard.nextInt();
		System.out.print("Enter model:");
		String model = keyboard.nextLine();
		keyboard.nextLine();
		System.out.print("Enter speed:");
		double speed = keyboard.nextDouble();
		System.out.print("Enter range:");
		int range = keyboard.nextInt();
		System.out.print("Enter price:");
		long price = keyboard.nextLong();
		switch(jetType) {
		case 1:
			output = new CargoPlane(model, speed, range, price);
			break;
		case 2:
			output = new FighterJet(model, speed, range, price);
			break;
		default:
			output = null;
			break;
		}
		return output;
	}

	public Jet[] getJets() {
		return jets;
	}

	public void setJets(Jet[] jets) {
		this.jets = jets;
	}

	public int getJetNumber() {
		return jetNumber;
	}

	public void setJetNumber(int jetNumber) {
		AirField.jetNumber = jetNumber;
	}
}
