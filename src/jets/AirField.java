package jets;

import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class AirField {

//	F I E L D S

	private Collection<Jet> jets = new HashSet<>();

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

	public void launchMenuSelection(int menuSelection, Collection<Jet> jets, Scanner keyboard) {
		switch (menuSelection) {
		case 1:
			listFleet(jets);
			break;
		case 2:
			flyFleet(jets);
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			addJetToFleet(keyboard);
			break;
		case 8:
			break;
		case 9:
			System.out.println("Exiting the program");
			break;
		default:
			System.out.println("Invalid menu option");
			break;
		}
	}

	public void addJetToFleet(Scanner keyboard) {
		String model = "";
		double speed = 0.0;
		int range = 0, jetType = 0;
		long price = 0;
		System.out.println("1. Cargo Plane");
		System.out.println("2. Fighter Jet");
		try {
			jetType = keyboard.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
		System.out.print("Enter model:");
		try {
			keyboard.nextLine();
			model = keyboard.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
		System.out.print("Enter speed:");
		try {
			speed = keyboard.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
		System.out.print("Enter range:");
		try {
			range = keyboard.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
		System.out.print("Enter price:");
		try {

			price = keyboard.nextLong();
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
		switch (jetType) {
		case 1:
			jets.add(new CargoPlane(model, speed, range, price, getJetNumber()));
			setJetNumber(getJetNumber() + 1);
			break;
		case 2:
			jets.add(new FighterJet(model, speed, range, price, getJetNumber()));
			setJetNumber(getJetNumber() + 1);
			break;
		default:
			System.out.println(jetType + " is an invalid option");
			break;
		}
	}

	public Collection<Jet> getJetsCopy(Collection<Jet> jets) {
		Collection<Jet> jetsCopy = new HashSet<>();
		jetsCopy.addAll(jets);
		return jetsCopy;
	}

	public void listFleet(Collection<Jet> jets) {
		Iterator<Jet> it = jets.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void flyFleet(Collection<Jet> jets) {
		for (Jet element : jets) {
			element.fly();
		}
	}

	public Collection<Jet> getJets() {
		return jets;
	}

	public void setJets(Collection<Jet> jets) {
		this.jets = jets;
	}

	public int getJetNumber() {
		return jetNumber;
	}

	public void setJetNumber(int jetNumber) {
		AirField.jetNumber = jetNumber;
	}
}
