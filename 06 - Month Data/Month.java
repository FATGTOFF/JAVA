package chapter6;
/*
Written by Carlos Vazquez
Chapter 6
Programming Challenge 5
Date: 16 September 2018

Write a class named Month. The class should have an int field 
named monthNumber that holds the number of the month. For example,
January would be 1, February would be 2, and so forth. In 
addition, provide the following methods:
•A no-arg constructor that sets the monthNumber field to 1.
•A constructor that accepts the number of the month as an 
argument. It should set the monthNumber field to the value 
passed as the argument. If a value less than 1 or greater 
than 12 is passed, the constructor should set monthNumber to 1.
•A constructor that accepts the name of the month, such as 
“January” or “February”, as an argument. It should set the 
monthNumber field to the correct corresponding value.
•A setMonthNumber method that accepts an int argument, which 
is assigned to the monthNumber field. If a value less than 1 
or greater than 12 is passed, the method should set monthNumber to 1.
•A getMonthNumber method that returns the value in the monthNumber field.
•A getMonthName method that returns the name of the month. For 
example, if the monthNumber field contains 1, then this method 
should return “January”.
•A toString method that returns the same value as the getMonthName method.
•An equals method that accepts a Month object as an argument. If the 
argument object holds the same data as the calling object, this method 
should return true. Otherwise, it should return false.
•A greaterThan method that accepts a Month object as an argument. If 
the calling object’s monthNumber field is greater than the argument’s 
monthNumber field, this method should return true. Otherwise, it should 
return false.
•A lessThan method that accepts a Month object as an argument. If the 
calling object’s monthNumber field is less than the argument’s monthNumber 
field, this method should return true. Otherwise, it should return false.
 */

public class Month 
{
    private int monthNumber; // Holds the number of the month.
    private String monthName; // Holds the name of the month.
    
    // No-arg Constructor in which define the
    // month number with 1.
    public Month()
    {
        monthNumber = 1;
    }
    
    // Constructor accepts number of the month as argument.
    // It uses the if statement to ensure the input of the user.
    // is validated.
    public Month(int m)
    {
        if (m < 1 || m > 12)
            monthNumber = 1;
        
        else
            monthNumber = m;
    }
    
    // Constructor accepts name of the month as argument.
    public Month(String m)
    {
    	if (m.equalsIgnoreCase("january")) 
    	{
			monthNumber = 1;
		} 
    	else if (m.equalsIgnoreCase("february")) 
		{
			monthNumber = 2;
		} 
    	else if (m.equalsIgnoreCase("march")) 
		{
			monthNumber = 3;
		} 
    	else if (m.equalsIgnoreCase("april")) 
		{
			monthNumber = 4;
		} 
    	else if (m.equalsIgnoreCase("may")) 
		{
			monthNumber = 5;
		} 
    	else if (m.equalsIgnoreCase("june")) 
    	{
			monthNumber = 6;
		} 
    	else if (m.equalsIgnoreCase("july")) 
    	{
			monthNumber = 7;
		} 
    	else if (m.equalsIgnoreCase("august")) 
    	{
			monthNumber = 8;
		} 
    	else if (m.equalsIgnoreCase("september")) 
    	{
			monthNumber = 9;
		} 
    	else if (m.equalsIgnoreCase("october")) 
    	{
			monthNumber = 10;
		} 
    	else if (m.equalsIgnoreCase("november")) 
    	{
			monthNumber = 11;
		} 
    	else if (m.equalsIgnoreCase("december")) 
    	{
			monthNumber = 12;
		} 
    	else 
    	{
			monthNumber = 1;
		}
    }
    
    //Mutators
    /* The method setMonthNumber takes one int argument
     * to hold the number of the month.
     */
    public void setMonthNumber(int m)
    {
        if (m < 1 || m > 12)
            monthNumber = 1;
        
        else
            monthNumber = m;
    }
    
    //Accessors.
    /* The method getMonthNumber returns the
     * integer monthNumber value in the monthNumber field.
     */
    public int getMonthNumber()
    {
        return monthNumber;
    }
    
    /* The method getMonthName uses the switch case
     * to look for the month name based on the user's 
     * input on the number of month and return the
     * string monthName value in the monthName field.
     */
    public String getMonthName()
    {
        switch (monthNumber)
        {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
             case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
             case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;              
             case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
             case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
            	monthName = "Unknown";
        }          
        return monthName;
    }
    
    /* The method toString calls the function
     * getMonthName to obtain the month name and
     * return it as a string. returns the
     */
    public String toString()
    {
        String str = getMonthName();
        
        return str;
    }
    
    /* The method equals compares the object of 
     * the Month to verify is the values are 
     * equals by using the if-statement and returns
     * the boolean value (true) if is equal or (false)
     * if the values are not equal
     */
    public boolean equals(Month object2)
   {
      boolean status;
      
      // Determine whether this object's symbol and
      // monthNumber fields are equal to object2's
      // symbol and monthNumber fields.
      if (monthName.equals(object2.monthName) &&
          monthNumber == object2.monthNumber)
         status = true;  // Yes, the objects are equal.
      else
         status = false; // No, the objects are not equal.
      
      // Return the value in status.
      return status;
   }
    
    /* The method greaterThan compares the object of 
     * the Month to verify that the value is
     * greater than the object value by using 
     * the if-statement and returns
     * the boolean value
     */
   public boolean greaterThan(Month object2)
   {
      boolean status;
      
      if (monthNumber > object2.monthNumber)
         status = true;  // Yes, the calling object is greater than the monthNumber field.
      else
         status = false; // No, the calling object is not greater than the monthNumber field.
      
      // Return the value in status.
      return status;
   }
   
   /* The method lessThan compares the object of 
    * the Month to verify that the value is
    * less than the object value by using 
    * the if-statement and returns
    * the boolean value
    */
   public boolean lessThan(Month object2)
   {
      boolean status;
      
      if (monthNumber < object2.monthNumber)
         status = true;  // Yes, the calling object is greather than the monthNumber field.
      else
         status = false; // No, the calling object is not greather than the monthNumber field.
      
      // Return the value in status.
      return status;
   }
}
