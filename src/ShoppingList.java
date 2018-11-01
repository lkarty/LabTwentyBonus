import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShoppingList {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean cont = false;
		double avg = 0;

		ArrayList<String> gItems = new ArrayList<String>(
				Arrays.asList("Bannana", "Apple", "Taco", "Rice", "Ginger",
						"Cat", "Garlic", "Ice"));
		ArrayList<Double> prices = new ArrayList<Double>(
				Arrays.asList(4.44, 3.33, 2.0, 6.66, 69.69, 88.88, 9.99, 1.11));

		ArrayList<String> shopList = new ArrayList<>();
		ArrayList<Double> pricesList = new ArrayList<>();

		/// scanner input example
		System.out.println(getName(scan));


		do {
			System.out.println("\nCurrent Stock");
			System.out.printf("%1$-15s %2$-8s\n", "Item", "Price");
			System.out.printf("=======================\n");
			for (int i = 0; i < gItems.size(); ++i) {
				System.out.printf("%1$-15s %2$-8s\n", gItems.get(i), prices.get(i));
			}

			String inBag = Validator.getString(scan, "\nEnter item name to add to list: \n");

			boolean checkItems = gItems.contains(inBag);
			int listI = gItems.indexOf(inBag);

			if (checkItems == true) {
				System.out.println("Added " + gItems.get(listI) + " to bag for " + "$" + prices.get(listI) + ".");
				// add items and prices via indices
				// try to make it so you can add multiple of item
				shopList.add(gItems.get(listI));
				pricesList.add(prices.get(listI));
			} else {
				System.out.println("Sorry, we do not stock that item. Please try again.");
				continue;
			}


			System.out.println("Would you like to add another item? y/n");
			String choice = scan.nextLine();

			// use validator here?
			if (choice.equalsIgnoreCase("y")) {
				cont = true;
			} else if (choice.equalsIgnoreCase("n")) {

				System.out.println("Thanks for your order! Here's what you got:");

				for (int i = 0; i < shopList.size(); ++i) {
					System.out.printf("\n%1$-15s %2$-8s", shopList.get(i), pricesList.get(i));
				}

				getAverage(prices, avg);

				cont = false;
			}
		} while (cont == true);



	}

	// your method should here
	public static String getName(Scanner scan) {
		System.out.println("Please enter your name:");
		String userName = scan.nextLine();
		return "Welcome " + userName + " to the Super Super Market!";
	}

	public static void getAverage(ArrayList<Double> prices, double avg) {
		avg = 0;
		for (int i = 0; i < prices.size(); ++i) {
			avg += prices.get(i) / prices.size();
		}
		System.out.printf("\nAverage price per item in order was %.2f", avg);
	}

	public static double getHigh(ArrayList<Double> prices) {
		double highPrice = 0;
		for (double price : prices) {
			if (price > highPrice) {
				highPrice = price;
			}
		}
		return highPrice;
	}

	public static double getLow(ArrayList<Double> prices) {
		double lowPrice = Double.MAX_VALUE;
		for (double price : prices) {
			if (price < lowPrice) {
				lowPrice = price;
			}
		}
		return lowPrice;
	}
}
