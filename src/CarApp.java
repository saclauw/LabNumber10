import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Steven Clauw
 * LabNumber10
 * 
 */
public class CarApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int i = 0;
		int year = 2011;
		int userChoice = 0;
		int numOfCars = 0;
		int endApp = 0;
		double price = 17000.00;
		double mileage = 0.0;
		String make = "Ford";
		String model = "Flex";
		String usedQuestion = " ";
		String buyCar = " ";
		String cont = "y";
		boolean isUsed = false;
		ArrayList<Car> carLot = new ArrayList<Car>();
		UsedCar usedCar = new UsedCar(make, model, year, price, mileage);
		Car car = new Car(make, model, year, price);

		// Starting inventory carLot created and added to ArrayList
		Car car1 = new Car("Ford", "F-150", 2018, 35000.00);
		carLot.add(0, car1);
		UsedCar usedCar2 = new UsedCar("Ford", "Aerovan", 1997, 250.00, 212345.76);
		carLot.add(1, usedCar2);
		Car car3 = new Car("Ford", "Transit", 2017, 28000.00);
		carLot.add(2, car3);
		Car car4 = new Car("Ford", "Fiesta", 2018, 12000.00);
		carLot.add(3, car4);
		UsedCar usedCar5 = new UsedCar("Ford", "GT", 2006, 350000.00, 208.01);
		carLot.add(4, usedCar5);
		UsedCar usedCar6 = new UsedCar("Ford", "Explorer", 2015, 25000.00, 20000.00);
		carLot.add(5, usedCar6);

		// Console begin point
		System.out.println("Welcome to the Grand Circus Motors admin console!");

		
		while (cont == "y") {
			try {
				// prompt the user for how many cars they want to enter
				numOfCars = Validator.getInt(scan, "Please enter how many cars you want to enter: ", 0, 100);

				// if user enters an int larger than 0, and less than 100, they will be prompted
				// to enter input to create more
				// cars to add to the carLot
				if (numOfCars > 0) {
					for (i = 0; i < numOfCars; i++) {
						make = Validator.getString(scan, "What kind of make is the car?: ");
						model = Validator.getString(scan, "What kind of model is the car?: ");
						year = Validator.getInt(scan, "What year is the car?: ", 1870, 2030);
						price = Validator.getDouble(scan, "What price is the car?: ");
						usedQuestion = Validator.getString(scan, "Is the car used? (y/n): ");
						if (usedQuestion.equalsIgnoreCase("y")) {
							isUsed = true;
							mileage = Validator.getDouble(scan, "What is the mileage?: ");
							car = new UsedCar(make, model, year, price, mileage);
						} else {

							car = new Car(make, model, year, price);
						} // end inner if/else
						carLot.add(car);
					} // end for
				} // end if

				// After input of new cars inventory will be updated then display on the
				// console.
				System.out.println("...");
				System.out.println("Current Inventory: ");

				for (i = 0; i < carLot.size(); i++) {
					System.out.println((i + 1) + ". " + carLot.get(i).toString());
				} // end for loop
				endApp = (i + 1);
				System.out.println(endApp + ". Quit");

				// The user will be prompted to enter which car they want
				userChoice = Validator.getInt(scan, "\nWhich car would you like?", 1, (carLot.size() + 1));
				userChoice = userChoice - 1;
				// userChoice is then put through if/else to determine if car is new or used,
				// then the car is displayed accordingly
				if (carLot.get(userChoice) == usedCar) {
					System.out.println(((UsedCar) carLot.get(userChoice)).toString());
				} else {
					System.out.println(carLot.get(userChoice).toString());
				} // end else
					// the user is asked if they would like to purchase the car, if "Y" the car is
					// removed from the arrayList
				buyCar = Validator.getString(scan, "Would you like to buy this car? (y/n) ");
				if (buyCar.equalsIgnoreCase("y")) {
					System.out.println("Excellent! Our finance department will be in touch shortly.\n");
					carLot.remove(userChoice);
					for (i = 0; i < carLot.size(); i++) {
						System.out.println((i + 1) + ". " + carLot.get(i).toString());
						// continue;
					} // end for loop
					endApp = (i + 1);
					System.out.println(endApp + ". Quit");
				} // end if
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Have a great day!");
				break;
			} // end catch
			cont = "y";
		} // end while
		scan.close();
	} // end main
} // end class body
