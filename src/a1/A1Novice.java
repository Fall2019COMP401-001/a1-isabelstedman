package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Second
		int totalNumber = scan.nextInt();
		String [] names = new String[totalNumber];
		double [] totalPrice = new double [totalNumber];
		DecimalFormat numberFormat = new DecimalFormat("#0.00");
		double [][] prices = new double [totalNumber][];
		int [][] quantity = new int [totalNumber][];
		String [][] itemName = new String [totalNumber][];
		double priceTotal = 0.00;
		for (int i = 0; i < totalNumber; i++) {
			String firstName = scan.next();
			String lastName = scan.next();
			int orders = scan.nextInt();
			names[i] = shortName(firstName)+ " " + lastName;
			prices[i] = new double [orders];
			quantity[i] = new int [orders];
			itemName [i] = new String [orders];
			for(int j = 0; j < orders; j++) {
				quantity[i][j] = scan.nextInt();
				itemName[i][j] = scan.next();
				prices[i][j] = scan.nextDouble();
			}
			totalPrice[i] = getTotal(i, quantity, prices);
		}
		for (int i = 0; i < totalNumber; i++) {
			System.out.println(names[i] + ": " + numberFormat.format(totalPrice[i]));
		}
	}
	private static String shortName(String firstName) {
		return firstName.charAt(0) + ".";
	}
	private static double getTotal(int index, int[][] quantity, double[][] prices) {
		double priceTotal = 0.0;
		for (int i = 0; i < quantity[index].length; i++) {
			priceTotal += quantity[index][i] * prices[index][i];
		}
		return priceTotal;
		
	}
}
