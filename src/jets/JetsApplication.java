package jets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class JetsApplication {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		JetsApplication app = new JetsApplication();
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
	
	public List<Set<String>> parseJets(Collection<String> jets) {
		List<Set<String>> result = new ArrayList<>();

		for (int i = 0; i < 26; i++) {
			result.add(new TreeSet<>());
		}

		for (String name : jets) {
			int index = name.charAt(0) % 65;
			result.get(index).add(name);
		}

		return result;
	}
	
}
