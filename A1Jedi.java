package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int itemTotal = scan.nextInt();
		String[] foodItems = new String[itemTotal];
		double[] foodPrice = new double[itemTotal];
		for(int i = 0; i < itemTotal; i++) {
			foodItems[i] = scan.next();
			foodPrice[i] = scan.nextDouble();
		}
		int totalNumber = scan.nextInt();
		int [][] totalQuantity = new int[totalNumber][];
		String[][] orders = new String [totalNumber][];
		String [] firstNames = new String [totalNumber];
		String [] lastNames = new String [totalNumber];
		int otherItems = 0;
		for (int i = 0; i < totalNumber; i++) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			otherItems = scan.nextInt();
			totalQuantity[i] = new int [otherItems];
			orders[i] = new String [otherItems];
			for (int j = 0; j < otherItems; j++) {
				totalQuantity[i][j] = scan.nextInt();
				orders[i][j] = scan.next();
				
			}
		}
		int [] purchaserCounts = new int[itemTotal];
		int [] boughtItem = new int[itemTotal];
		for (int x = 0; x < itemTotal; x++) {
			purchaserCounts[x] = purchasers(foodItems[x], orders);
		}
		for (int x = 0; x < itemTotal; x++) {
			boughtItem[x] = totalPurchasedCount(foodItems[x], orders, totalQuantity);
		}
		for (int x = 0; x < itemTotal; x++) {
			if (purchaserCounts[x] > 0) {
				System.out.println(purchaserCounts[x]+ " customers bought " + boughtItem[x] + " " + foodItems[x]);
			} else {
				System.out.println("No customers bought " + foodItems[x]);
			}
		}
	}
	private static int totalPurchasedCount(String item, String[][] orders, int[][] quantity) {
		int totalPurchased = 0;
		for (int i = 0; i < orders.length; i++) {
			totalPurchased += individualCount (item, orders[i], quantity[i]);
		}
		return totalPurchased;
	}
	private static int purchasers(String item, String[][] orders) {
		int totalBought = 0;
		for (int i = 0; i < orders.length; i++) {
			if (purchased(item, orders[i])) {
				totalBought++;
			}
		}
		return totalBought;
	}
	private static boolean purchased(String item, String[] orders) {
		for (int j = 0; j < orders.length; j++) {
			if (orders[j].equals(item)) {
				return true;
			}
		}
		return false;
	}
	private static int individualCount (String item, String[] order, int [] quantity) {
		int bought = 0;
		for (int i = 0; i < order.length; i++) {
			if (order[i].equals(item)) {
				bought += quantity[i];
			}
		}
		return bought;
	}
}
