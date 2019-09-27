package jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AirField {

//	F I E L D S

	private List<Jet> jets = new ArrayList<>();

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

	public void launchMenuSelection(int menuSelection, List<Jet> jets, Scanner keyboard) {
		switch (menuSelection) {
		case 1:
			listFleet(jets);
			break;
		case 2:
			flyFleet(jets);
			break;
		case 3:
			searchFastestJet(jets);
			break;
		case 4:
			searchFurthestRangeJet(jets);
			break;
		case 5:
			loadAllCargoJets(jets);
			break;
		case 6:
			break;
		case 7:
			addJetToFleet(keyboard);
			break;
		case 8:
			removeJetFromFleet(keyboard, jets);
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
			jets.add(new CargoPlane(model, speed, range, price));
			break;
		case 2:
			jets.add(new FighterJet(model, speed, range, price));
			break;
		default:
			System.out.println(jetType + " is an invalid option");
			break;
		}
	}

	public void removeJetFromFleet(Scanner keyboard, List<Jet> jets) {
		System.out.println("Select an index of jet to remove:");
		listFleet(jets);
		try {
			int index = keyboard.nextInt();
			jets.remove(index);
		} catch (InputMismatchException e) {
			System.out.println("Invalid input");
		}
	}

	public List<Jet> getJetsCopy(List<Jet> jets) {
		List<Jet> jetsCopy = new ArrayList<>();
		jetsCopy.addAll(jets);
		return jetsCopy;
	}

	public void listFleet(List<Jet> jets) {

		for (int c = 0; c < jets.size(); c++) {
			System.out.println("Index: " + c + jets.get(c));
		}
	}

	public void flyFleet(List<Jet> jets) {
		for (Jet element : jets) {
			element.fly();
		}
	}

	public void searchFastestJet(List<Jet> jets) {
		String fastestJet = "";
		double fastestSpeed = 0.0;
		for (Jet element : getJets()) {
			if (element != null) {
				if (element.getSpeed() > fastestSpeed) {
					fastestSpeed = element.getSpeed();
					fastestJet = element.toString();
				}
			}
		}
		System.out.println("Fastest Jet: " + fastestJet);
	}

	public void searchFurthestRangeJet(List<Jet> jets) {
		String furthestRangeJet = "";
		int furthestRange = 0;
		for (Jet element : getJets()) {
			if (element != null) {
				if (element.getRange() > furthestRange) {
					furthestRange = element.getRange();
					furthestRangeJet = element.toString();
				}
			}
		}
		System.out.println("Fastest Jet: " + furthestRangeJet);
	}

	public void loadAllCargoJets(List<Jet> jets) {
		for (Jet element : jets) {
			if (element instanceof CargoPlane) {
				CargoPlane cp = (CargoPlane) element;
				System.out.print(element.getModel() + " ");
				cp.loadCargo();
			}
		}
	}

	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}

	public int getJetNumber() {
		return jetNumber;
	}

	public void setJetNumber(int jetNumber) {
		AirField.jetNumber = jetNumber;
	}

	public void readJets(String fileName) {
		List<String> jetsData = new ArrayList<String>();
		FileReader fr = null;
		try {
			fr = new FileReader(fileName);
			String lineOfText;
			BufferedReader br = new BufferedReader(fr);
			while ((lineOfText = br.readLine()) != null) {
				jetsData.add(lineOfText);

				String[] fields = lineOfText.split(", ");

				String classType = fields[0];
				String model = fields[1];
				double speed = Double.parseDouble(fields[2].trim());
				int range = Integer.parseInt(fields[3].trim());
				long price = Long.parseLong(fields[4].trim());
				Jet j;
				switch (classType) {
				case "Fighter":
					j = new FighterJet(model, speed, range, price);
					jets.add(j);
					break;
				case "Cargo":
					j = new CargoPlane(model, speed, range, price);
					jets.add(j);
					break;
				default:
					System.out.println("Invalid class type in text file.");
					break;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
