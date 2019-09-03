package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int storeItems = scan.nextInt();
		String [] foodName = new String[storeItems];
		double[] foodPrices = new double[storeItems];
		for(int i = 0; i < storeItems; i++) {
			foodName[i] = scan.next();
			foodPrices[i] = scan.nextDouble();
		}
		int totalCustomers = scan.nextInt();
		int [][] totalQuantity = new int [totalCustomers][];
		String [][] orders = new String [totalCustomers][];
		String [] firstNames = new String [totalCustomers];
		String [] lastNames = new String [totalCustomers];
		int otherItems = 0;
		for (int i = 0; i < totalCustomers; i++) {
			firstNames[i] = scan.next();
			lastNames[i] = scan.next();
			otherItems = scan.nextInt();
			totalQuantity[i] = new int[otherItems];
			orders[i] = new String [otherItems];
			for(int j = 0; j < otherItems; j++) {
				totalQuantity[i][j] = scan.nextInt();
				orders[i][j] = scan.next();
			}
		}
		double[] orderPrice = new double[totalCustomers];
		for (int i = 0; i < totalCustomers; i++) {
			orderPrice[i] = totalPaid(totalQuantity[i], orders[i], foodPrices, foodName);
		}
		double biggest = largestIndex(orderPrice);
		double smallest = smallestReturn(orderPrice);
		String biggestName = firstNames[largestIndex(orderPrice)]+ " " + lastNames[largestIndex(orderPrice)];
		String smallestName = firstNames[smallestIndex(orderPrice)]+ " " + lastNames[smallestIndex(orderPrice)];
		double average = getAverage(orderPrice);
		DecimalFormat numberFormat = new DecimalFormat("#0.00");
		System.out.println("Biggest: "+ biggestName + " (" + numberFormat.format(biggest) + ")");
		System.out.println("Smallest: "+ smallestName + " (" + numberFormat.format(smallest)+ ")");
		System.out.println("Average: " + numberFormat.format(average));
		// Your code follows here.
		
	}
	private static int indexReturn (String lookup, String[] foodList) {
		for (int i = 0; i < foodList.length; i++) { 
			if(foodList[i].contentEquals(lookup)) {
				return i;
			}
		}
		return foodList.length + 1;
	}
	private static double totalPaid (int[] quantity, String[] foods, double[] prices, String[] items) {
		double totalPaid = 0;
		for (int i = 0; i < quantity.length; i++) {
			totalPaid =  totalPaid + quantity[i] * prices[indexReturn(foods[i], items)];
		}
		return totalPaid;
	}
	private static double smallestReturn (double[] prices) {
		double smallest = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < smallest) {
				smallest = prices[i];
			}
		}
		return smallest;
	}
	private static int largestIndex (double[] prices) {
		double biggest = prices[0];
		int biggestIndex = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] > biggest) {
				biggest = prices[i];
				biggestIndex = i;
			}
		}
		return biggestIndex;
	}
	private static int smallestIndex (double[] prices) {
		double smallest = prices[0];
		int smallestIndex = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < smallest) {
				smallest = prices[i];
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}
	private static int getAverage (double[] prices) {
		double total = 0.0;
		for (int i = 0; i < prices.length; i++) {
			total += prices[i];
		}
		return (int) (total/prices.length);
	}
}

		

