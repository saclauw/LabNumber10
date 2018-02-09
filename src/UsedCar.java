
public class UsedCar extends Car {

	private double mileage = 0.0;
	
	public UsedCar() {
		
	}

public UsedCar(String make, String model, int year, double price, double mileage) {
		super(make, model, year, price);
		this.mileage = mileage;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	@Override
	public String toString() {

		return String.format("%1$-15s %2$-10s %3$-6d $%04$-,10.2f (used) %5$-10.2fmiles", make, model, year, price, mileage);
	}
	
	
}