package chapter7;
/*
Written by Carlos Vazquez
Chapter 7
Programming Challenge 2
Date: 16 September 2018

This PayRoll class uses the following arrays
•employeeId. An array of seven integers to hold 
employee identification numbers. The array should 
be initialized with the following numbers:    5658845 
4520125 7895122 8777541 8451277 1302850 7580489
•hours. An array of seven integers to hold the 
number of hours worked by each employee
•payRate. An array of seven doubles to hold each 
employee’s hourly pay rate
•wages. An array of seven doubles to hold each 
employee’s gross wages
This class have the following constructors.
	- No arg constructor.
This class have the following mutators.
	- setEmployeeIdAt
	- setHoursAt
	- setPayRateAt
	- setWagesAt
This class have the following accessors.
	- getEmployeeIdAt
	- getHoursAt
	- getPayRateAt
	- getWagesAt
	- getGrossPay
 */
public class PayRoll 
{
	// Constant for the number of employees
    private final int NUM_OF_EMPLOYEES = 7;
    // Array of employee ID numbers
    private int []  employeeId = {5658845, 4520125, 7895122, 8777541, 
    		8451277, 1302850, 7580489};
    // Array to hold hours worked
    private int [] hours = new int[NUM_OF_EMPLOYEES];
	// Array to hold pay rates   
    private double [] payRate = new double[NUM_OF_EMPLOYEES];
	// Array to hold wages earned 
    private double [] wages = new double[NUM_OF_EMPLOYEES];
      
    // No-arg Constructor in which define the
    // variables with 0 by using a for loop.
    public PayRoll()
    {
        //Initialize the arrays to 0 and 0.0 respectively.
        for (int count = 0; count < NUM_OF_EMPLOYEES; count++)
        {
            hours[count] = 0;
            payRate[count] = 0.0;
            wages[count] = 0.0;         
        }
    }

    //Mutators
    /* The method setEmployeeIdAt takes two int arguments
     * to hold the employee id and the index of the array.
     */
    public void setEmployeeIdAt(int id, int elem)
    {
    	employeeId[elem] = id; 
    }
    
    /* The method setHoursAt takes two int arguments
     * to hold the hours and the index of the array.
     */
    public void setHoursAt(int hrs, int elem)
    {
            hours[elem] = hrs;
    }
    
    /* The method setHoursAt takes two arguments. One
     * double, which hold the pay rate and one int, which
     * hold the index of the array.
     */
    public void setPayRateAt(double pr, int elem)
    {
            payRate[elem] = pr;       
    }
    
    /* The method setWagesAt does not take arguments. It
     * uses a for loop to iterate thru the array to compute
     * the wages.
     */
    public void setWagesAt()
    {
         for (int count = 0; count < NUM_OF_EMPLOYEES; count++)
            wages[count] = payRate[count] * hours[count];       
    }
    
    //Accessors.
    /* The method getEmployeeIdAt returns the
     * integer employee id value in the employee id field.
     */
    public int[] getEmployeeIdAt()
    {
        return employeeId;
    }
    
    /* The method getHoursAt returns the
     * integer hours value in the hours field.
     */
    public int[] getHoursAt()
    {
        return hours;
    }
    
    /* The method getPayRateAt returns the
     * double pay rate value in the payrate field.
     */
    public double[] getPayRateAt()
    {
        return payRate;
    }
    
    /* The method getWagesAt returns the
     * double wages value in the wages field.
     */
    public double[] getWagesAt()
    {    
        return wages;
    }
    
    /* The method getGrossPay returns the
     * double gross pay value by using a while loop
     * to iterate thru the array to verify that the 
     * employee id is found. If is found, it computes
     * the gross pay. If is not found, it will let
     * the user know the employee id was not found
     * and the gross pay will be 0 (the default value).
     */
    public double getGrossPay(int emp)
    {
        int index = 0; // Loop control variable.
        int element = -1; // Element the value is found at.
        boolean found = false; // Flag indicating search results.
        double grossPay = 0.0;
        
        // Search the array.
        while (!found && index < employeeId.length)
        {
            // Does this element have the value?
            if (employeeId[index] == emp)
            {
                found = true; // The value is found.
                element = index; // Save the subscript of the value.
            }
            
            // Go to the next element.
            index++;       
        }
        
        // If the employee id is found, compute the gross pay.
        // else, notify the user, the employee was not found and
        // return the default value of gross pay, which is 0.
        if (found)
        {
            wages[element] = payRate[element] * hours[element];
            grossPay = wages[element];
        }
        else
            System.out.println("Employee # " + emp + " was not found. Therefore, ");
        
        return grossPay;
    }
}
