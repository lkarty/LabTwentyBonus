import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ShoppingList {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean stop = false;

		ArrayList<String> gItems = new ArrayList<String>(
				Arrays.asList("Bannana", "Apple", "Taco", "Rice", "Ginger",
						"Cat", "Garlic", "Ice"));
		ArrayList<Double> prices = new ArrayList<Double>(
				Arrays.asList(4.44, 3.33, 2.0, 6.66, 69.69, 88.88, 9.99, 1.11));

		LinkedList<String> shopList = new LinkedList<>();
		LinkedList<Double> costList = new LinkedList<>();

		/// scanner input example

		for (int i = 0; i < gItems.size(); i++) {
			System.out.printf("%-10.10s  %-10.10s%n", gItems.get(i), prices.get(i));
		}

		while (stop == false) {

			String inBag = Validator.getString(scan, "Enter item name to add to list: \n");

			boolean checkItems = gItems.contains(inBag);

			System.out.println("Bag: " + gItems.indexOf(inBag));


			System.out.println("Number?  " + gItems.indexOf(inBag));
			int listI = gItems.indexOf(inBag);
			System.out.println("MagicNumber: " + listI);


			// add items and prices via indices
			// shopList.add(inBag);
			// shopList.add(gItems.get(index-1));

			System.out.println("Shopping List: " + shopList);

		}

	}

	// your method should here
	public static ArrayList<String> getName(ArrayList<String> gItems) {

		return gItems;
	}

}
