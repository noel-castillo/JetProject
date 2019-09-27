package jets;

public class CargoPlane extends Jet implements CargoCarrier {

//	C O N S T R U C T O R

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

//	M E T H O D S

	@Override
	public void loadCargo() {
		System.out.println("Loading cargo");
	}

}
