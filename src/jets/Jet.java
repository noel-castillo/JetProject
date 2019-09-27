package jets;

public abstract class Jet {

//	F I E L D S 

	private String model;

	private double speed;

	private int range;

	private long price;

	private int jetID;

//	C O N S T R U C T O R S

	public Jet(String model, double speed, int range, long price, int jetID) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.jetID = jetID;
	}

//	M E T H O D S 

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getJetID() {
		return jetID;
	}

	public void setJetID(int jetID) {
		this.jetID = jetID;
	}

	public void fly() {
		System.out.println(toString() + "\n is taking flight!");
	}

	public double getSpeedInMach() {
		return this.getSpeed() / 767.269;
	}

	@Override
	public String toString() {
		return "Jet Model: " + model + ", Speed: " + speed + ", Range: " + range + ", Price: " + price + "]";
	}

}
