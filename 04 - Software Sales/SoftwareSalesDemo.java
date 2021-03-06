package chapter4;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * SoftwareSalesDemo Program
 */

public class SoftwareSalesDemo {
	public static void main(String[] args) {
		int units; // To hold units sold

		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		// Get the units sold.
		System.out.print("Enter the units sold: ");
		units = keyboard.nextInt();

		// Create a SoftwareSales object.
		SoftwareSales sales = new SoftwareSales(units);

		// Display purchase info.
		DecimalFormat dollar = new DecimalFormat("#,##0.00");
		System.out.println("Units sold: " + sales.getUnitsSold());
		System.out.println("Discount: $" + dollar.format(sales.getDiscount()));
		System.out.println("Cost: $" + dollar.format(sales.getCost()));
		
		// Close the keyboard to avoid memory leak.
		keyboard.close();
	}
}
