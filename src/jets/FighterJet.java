package jets;

public class FighterJet extends Jet implements CombatReady {

//	C O N S T R U C T O R

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

//	M E T H O D S

	@Override
	public void fight() {
		System.out.println("Pew pew!!");
	}

}
