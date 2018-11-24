package chapter7;
/*Written by Carlos Vazquez
Chapter 7
Programming Challenge 2 
Date: 16 September 2018
This file is a demonstration of the PayRoll class.
*/
import java.util.Scanner; // Needed for the Scanner class
import java.text.DecimalFormat; // Needed to format decimal values.

public class PayRollDemo 
{
	   public static void main(String[] args) 
	    {
		   		// Create a constant variable with the number of
		   		// elements in the array.
	            final int NUM_OF_EMPLOYEES = 7;
	            int empID = 0; // Variable to obtain the employee id.
	            
	            // Create a Scanner object for keyboard input.	       
	            Scanner keyboard = new Scanner(System.in);
	            
	    		// Create a PayRoll object.	            
	            PayRoll empPay = new PayRoll();
	            
	            // Call the method to input the employee data.
	            inputEmployeeData(keyboard, empPay, NUM_OF_EMPLOYEES);
	            // Compute the wages.
	            empPay.setWagesAt();
	            // Display the pay roll of the employees
	            displayEmployeeWages(empPay, NUM_OF_EMPLOYEES);
	            
	            // Call the method to ask the user to input a single
	            // employee id to obtain their gross pay.
	            displaySingleEmployeeWages(keyboard, empPay, empID);
	            
	    		// Close the keyboard to avoid memory leak.
	    		keyboard.close();	            

	    }
	    
	   	// The method inputEmployeeData has three arguments, a Scanner, a Payroll object
	    // and the constant size of the array. This method uses a for loop to iterate the
	    // array to obtain the hours and payrate of each employee. It uses a while loop
	    // to validate the hours cannot be a negative number and the pay rate must be 6.00
	    // or greater.
	    public static void inputEmployeeData(Scanner keyboard, PayRoll empPay, final int size)
	    {
	    		// Create the local variables.
	            int hours = 0; // Holds the hours of the employee
	            double payRate = 0.0; // Holds the pay rate of the employee.
	            final int minHours = 0; // Constant value to validate the minimum value allowed.
	            final double minPayRate = 6.0; // Constant value to validate the minimum value allowed.
	            
	            // Create DecimalFormat objects for format the dollar value.
	            DecimalFormat dollar = new DecimalFormat("#.00");
	            
	            // A for loop to obtain the hours and pay rate of each employee.
	            for (int count = 0; count < size; count++)
	            {
	                System.out.print("Enter the hours worked by Employee # " + empPay.getEmployeeIdAt()[count] +" : ");
	                hours = keyboard.nextInt();
	                // To validate input.
	                while (hours < minHours)
	                {
	                    System.out.println("ERROR: Your input " + hours + " is incorrect. Try again");
	                    System.out.println("Enter " + minHours + " or greater for hours.");
	                    System.out.print("Enter the hours for Employee # " + empPay.getEmployeeIdAt()[count] +" : ");
	                    hours = keyboard.nextInt();                    
	                }
	                empPay.setHoursAt(hours, count);
	                
	                System.out.print("Enter the hourly pay rate for Employee # " + empPay.getEmployeeIdAt()[count] +" : ");
	                payRate = keyboard.nextDouble();
	                // To validate input.      
	                while (payRate < minPayRate)
	                {
	                    System.out.println("ERROR: Your input " + payRate + " is incorrect. Try again");
	                    System.out.println("Enter " + dollar.format(minPayRate) + " or greater for the hourly pay rate.");
	                    System.out.print("Enter the pay rate for Employee # " + empPay.getEmployeeIdAt()[count] +" : ");
	                    payRate = keyboard.nextDouble();
	                }
	                empPay.setPayRateAt(payRate, count);                          
	            }

	    }
	    
	   	// The method displayEmployeeWages has two arguments, a Payroll object and
	    // the constant size of the array. It uses a for loop to iterate thru the
	    // array to display the employee wages.
	    public static void displayEmployeeWages(PayRoll empPay, final int size)
	    {
	        // Create DecimalFormat objects for dollar amounts.
	        DecimalFormat dollar = new DecimalFormat("#,##0.00");
	        
	         // Display the software sales report.
	        System.out.print("\nPAYROLL DATA\n");
	        System.out.print("============\n");
	        
	        for (int count = 0; count < size; count++)
	        {
	            System.out.println("Employee ID: " + empPay.getEmployeeIdAt()[count]);
	            System.out.println("Gross pay: $" + dollar.format(empPay.getWagesAt()[count]));
	            System.out.println();
	        }
	        
	    }
	    
	   	// The method displaySingleEmployeeWages has three arguments, a Scanner, a Payroll object
	    // and the constant size of the array. It calls the method getGrossPay to search
	    // for the employee according to their id to obtain the gross pay of the single
	    // employee. 
	    public static void displaySingleEmployeeWages(Scanner keyboard, PayRoll empPay, int empID)
	    {
	        
	        // Create DecimalFormat objects for dollar amounts.
	        DecimalFormat dollar = new DecimalFormat("#,##0.00");
	        
            System.out.println("Enter the employee number to obtain the gross pay.");
            System.out.print("Enter the Employee #:" );
            empID = keyboard.nextInt();
            
	        System.out.println("Gross Pay for Employee # " + empID + " is $" 
	                + dollar.format(empPay.getGrossPay(empID)));

	    }

}
