package chapter5;
/*Written by Carlos Vazquez
Chapter 5
Programming Challenge 5 
Date: 09 September 2018

This program calculates the occupancy rate for each 
floor of a hotel. The program asks the number of floors 
the hotel has. A loop iterate once for each floor. 
During each iteration, the loop ask the user for the 
number of rooms on the floor, and how many of them 
are occupied. After all the iterations, the program 
display the number of rooms the hotel has, the number 
that are occupied, the number that are vacant, and the 
occupancy rate for the hotel.
Input Validation: Do not accept a value less than 1 for 
the number of floors. Do not accept a number less than 10 
for the number of rooms on a floor.
*/
import java.text.DecimalFormat;
import java.util.Scanner;// Needed for the Scanner class

public class HotelOccupancy 
{

	public static void main(String[] args) 
    {
		//Declare and define the variables
        int numOfFloors = 0;
        int numOfRooms = 0;
        int roomsAccumulator = 0;
        int numOfRoomsOccupied = 0;
        int roomsOccupiedAccumulator = 0;
        int numOfRoomsVacant = 0;
        double occupancyRate = 0.0;
        final int min_num_floors_const = 1;
        final int min_num_rooms_const = 10;
        
        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);
        
        // Create DecimalFormat objects for percentages.
        DecimalFormat percent = new DecimalFormat("#.0############# %");
        
        // Ask the user the number of floors in the hotel.
        System.out.println("Welcome to Hotel Occupancy Program");
        System.out.print("How many number of floors the hotel have?: ");
        numOfFloors = keyboard.nextInt();
        
        // Use the while loop to validate the number of floors is not less than one.
        while (numOfFloors < min_num_floors_const)
        {
        	// Notify the user of the wrong input and ask the user to try again.
            System.out.println("Your input " + numOfFloors + " is not valid.");
            System.out.print("Enter " + min_num_floors_const + " or more: ");
            numOfFloors = keyboard.nextInt();
        }
        
        // Use the for loop to let the user to input
        // the number of rooms per floor.
        for (int count = 0; count < numOfFloors; count++)
        {
            System.out.print("How many number of rooms floor # " + (count + 1) + " has?: ");
            numOfRooms = keyboard.nextInt();
            
            // Use the while loop to validate the number of rooms is not less than ten.
            while (numOfRooms < min_num_rooms_const)
            {
            	// Notify the user of the wrong input and ask the user to try again.
                System.out.println("Your input " + numOfRooms + " is not valid. Try again");
                System.out.print("Enter " + min_num_rooms_const + " or more: ");
                numOfRooms = keyboard.nextInt();
            }
            
            // Keep a counter to keep track of the number of rooms per floor.
            roomsAccumulator += numOfRooms;
           
            // Ask the user the number of rooms per floor in the hotel.
            System.out.print("How many rooms on floor # " + (count + 1) + " are occupied?: ");
            numOfRoomsOccupied = keyboard.nextInt();
            
            // Use the while loop to validate the user do not input a 
            // negative number of the number of rooms occupied do not
            // exceed the number of rooms on the floor.
            while (numOfRoomsOccupied < 0 || numOfRoomsOccupied > numOfRooms)
            {
                System.out.println("Your input " + numOfRoomsOccupied + " is not valid. Try again");
                System.out.println("Ensure your selection is not a negative number");
                System.out.println("or higher than " + numOfRooms + " number of rooms");
                System.out.print("How many rooms on floor # " + (count + 1) + " are occupied?: ");
                numOfRoomsOccupied = keyboard.nextInt();
            }
            // Keep a accumulator to keep track of the number of rooms occupied per floor.
            roomsOccupiedAccumulator += numOfRoomsOccupied;
            
        }
         // Determine the number of rooms vacant by subtracting
         // the accumulator of occupied rooms from the counter of rooms.
         numOfRoomsVacant = roomsAccumulator - roomsOccupiedAccumulator;
         
         // Use the cast operator to convert the integer into
         // a double to provide the rate of occupancy in the hotel.
         occupancyRate = (double)roomsOccupiedAccumulator / roomsAccumulator;
         
        // Display the hotel occupancy report.
        System.out.print("\nHotel Occupancy Report\n");
        System.out.print("---------------------------------------------\n");
        System.out.println("Total number of rooms: " + roomsAccumulator);
        System.out.println("Total number of occupied rooms: " + roomsOccupiedAccumulator);
        System.out.println("Total number of vacant rooms: " + numOfRoomsVacant);
        System.out.println("The occupancy rate is: " + percent.format(occupancyRate));
        
        // Close the keyboard to avoid memory leak.
        keyboard.close();
    }

}
