

/**
 * 
 */

/**
 * @author saclauw
 *
 */
public class Car {

	public String make;
	public String model;
	public int year;
	public double price;

	public Car(String make, String model, int year, double price) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
	}
	
	
//		setMake(make);
//		setModel(model);
//		setYear(year);
//		setPrice(price);
//	}

	public Car() {
		make = "Ford";
		model = "Flex";
		year = 2011;
		price = 17000.00;
	}

	
	

	public String getMake(String make) {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel(String model) {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear(int year) {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice(double price) {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {

		
		return String.format("%1$-15s %2$-10s %3$-6d $%4$-,10.2f", make, model, year, price);
	}
	
	
}
