/**
Written by Carlos Vazquez
Chapter 10
Programming Challenge 1
Date: 7 October 2018
This is a class named TestScores. 
The class constructor accepts an 
array of test scores as its argument. The class 
have a method that returns the average 
of the test scores. If any test score in the 
array is negative or greater than 100, the 
class throws an IllegalArgumentException. 
*/

package chapter10;

public class TestScores
{
	// Declare the variables.
	private double [] testScores; // An array to hold the test scores.
	private double runningTotal; // it keeps the running total of the test scores.
	
	// This constructor takes one
	// argument as an array of the
	// test scores. It runs a for loop
	// to iterate each array element
	// and uses an if-else statement
	// to check if the scores are valid.
	// If the scores are not valid, then
	// it will throw an exception to notify
	// the user. If the scores are valid,
	// then, it will be added to the running total.
	public TestScores(double scr[])
	{
		runningTotal = 0.0;
		
		// For loop to iterate each score from the array.
		for (int count = 0; count < scr.length; count++)
		{
			// Allocate the size of the array.
			testScores = new double[scr.length];
			
			// If the scores are negative or over
			// 100, then throw an exception to let
			// the user know, which element has the
			// wrong score.
			if (scr[count] < 0 || scr[count] > 100)
			{
				throw new IllegalArgumentException("Element: "
						+ count + " Score: " + scr[count]);
			}
			else
				testScores[count] = scr[count];
				runningTotal += testScores[count];
		}
	}
	
	// Accessors
    // This method uses the running total from
	// the constructor and divide it by the size
	// of the array to calculate the average.
	public double getAverage()
	{
		double average = runningTotal / testScores.length;
		
		return average;
	}
	
}
