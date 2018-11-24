package chapter8;
/*Written by Carlos Vazquez
Chapter 8
Programming Challenge 1 
Date: 23 September 2018

This program has a method that accepts a 
String object as an argument and 
displays its contents backward. For 
instance, if the string argument is 
“gravity”, the method should display 
“ytivarg”. Demonstrate the method in 
a program that asks the user to input 
a string, then passes it to the method.

*/
import java.util.Scanner;

public class BackwardString 
{

	   public static void main(String[] args) 
	    {
		    // Declare and define the variable
	        String word = "";
	        
	        // Create a Scanner object for keyboard input.
	        Scanner keyboard = new Scanner(System.in);
	        
	        // As the user to input a word to be spelled backwards.
	        System.out.print("Type a word for the program to spell backwards: ");
	        word = keyboard.nextLine();
	        // Call the method to obtain the typed word backwards.
	        backwardString(word);
	        
			// Close the keyboard to avoid memory leak.
			keyboard.close();
	    }
	   	// The method inputEmployeeData has one string argument. It uses a for loop
	   	// to iterate each character of the word and change its position to enable to
	    // to spell backwards.
	    public static void backwardString(String word)
	    {
	        System.out.print("The backwards spelling of [" + word +
	                "] is : ");
	        // The for loop with initiate from the size of the string
	        // word and decrease in each iteration to enable to spell
	        // the word backwards.
	        for (int count = word.length(); count > 0; count--)
	        {
	            System.out.print(word.charAt(count - 1));
	        }
	        System.out.print("\n");
	    }

}
