package chapter2;
/*Written by Carlos Vazquez
Chapter 2 
Programming Challenge 9
Date: 27 August 2018

A car’s miles-per-gallon (MPG) can be calculated with the following formula:
MPG=Milesdriven/Gallonsofgasconsumed

Write a program that asks the user for the number of 
miles driven and the gallons of gas consumed. 
It should calculate the car’s MPG and display 
the result on the screen.
*/

import java.util.Scanner; // Needed for the Scanner class.

public class MilesPerGallon 
{

    public static void main(String[] args) 
    {
    	// Declare the variables.
        double milesDriven; // Number of miles driven.
        double gallonsUsed; // Number of gallons used.
        
        // Create a Scanner object to read input.
        Scanner keyboard = new Scanner(System.in);
        
        // Ask the user to input the number of miles driven.
        System.out.print("Input the number of miles driven: ");
        milesDriven = keyboard.nextDouble();
        
        // Ask the user to input the number of gallons uses.
        System.out.print("Input the number of gallons of gas used: ");
        gallonsUsed = keyboard.nextDouble();
        
        // Declare the variable and define it by computing the miles per gallon.
        double mpg = milesDriven / gallonsUsed;
        
        // Notify the user the number of miles, gallons used and the miles per gallon.
        System.out.print("The number of miles per gallon based on " +
                 milesDriven + " miles driven and " + gallonsUsed + " gallons used " +
                "is " + mpg + " mpg\n");
        
        // Close the keyboard to avoid memory leak.
        keyboard.close();
        
    }
    
}
