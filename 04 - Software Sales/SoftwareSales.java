package chapter4;
/*Written by Carlos Vazquez
Chapter 4 
Programming Challenge 4
Date: 09 September 2018

The software company sells it's package for $99. The company provides quantity
discounts according to their number of packages.
Below is the discount table:

Quantity 	Discount
10–19		20%
20–49		30%
50–99		40%
100 or more	50%

This class will have the following:
	- Default Constructor
	- Constructor, which takes one argument.
	- Setters:
		- obtain the number of units to sell
		- discount according to the discount table
	- Getters:
		- get the number of units to sell
		- get the discount
		- calculate the total cost
*/

public class SoftwareSales 
{
	//***Private
     private int numUnitSold; //holds the number of unit sold by the company
     private double packagePrice,//holds the package price
                             subTotal,//holds the subtotal.
                             discount,//holds the calculated discount in dollars.
                             total,//holds the total of the sale.
                             discountPercent;//holds the discount based on number of packages.
     
     /* The private method setDiscountPercent does not 
      * take arguments; it uses the if-else 
      * statements to determine the discount 
      * percentage according to the
      * number of unit sold.
      */
     private void setDiscountPercent()
     {
         if (numUnitSold < 10)
             discountPercent = 0.0;
         
         else if (numUnitSold > 9 && numUnitSold < 20)
        	 discountPercent = .20;
         
         else if (numUnitSold > 19 && numUnitSold < 50)
        	 discountPercent = .30;
         
         else if (numUnitSold > 49 && numUnitSold < 100)
        	 discountPercent = .40;
         
          else if (numUnitSold > 99)
        	  discountPercent = .50;
     }
     
     //***Public
     
     /* Default Constructor initializes the variables
      * to their default values and will call the
      * method to obtain the total cost of the sale.
     */
     public SoftwareSales()
     {
         numUnitSold = 0;
         packagePrice = 99;
         discount = 0.0;
         total = 0.0;
         discountPercent = 0.0;
         getCost();
     }
     
     /* The Constructor takes one argument, which is
      * the number of sales the company will make.
      * It initializes the variables
      * to their default values and will call the
      * method to obtain the total cost of the sale.
     */
     public SoftwareSales(int n)
     {
         numUnitSold = n;
         packagePrice = 99;
         subTotal = 0.0;
         discount = 0.0;
         total = 0.0;
         discountPercent = 0.0;
         getCost();
     }
     
     //Mutators.
     /* The method setNumUnitSold takes one int argument
      * to hold the number of unit sold.
      */
     public void setUnitsSold(int n)
     {
         numUnitSold = n;
     }
        
     //Accessors.
     /* The method getNumUnitSold returns the
      * integer numUnitSold value in the numUnitSold field.
      */
     public int getUnitsSold()
     {
         return numUnitSold;
     }
     
     /* The method getDiscount returns the
      * double discount value in the discount field.
      */
     public double getDiscount()
     {
         return discount;
     }
     
     /* The method getCost calls the method
      * to setDiscountPercent to apply the discount. It
      * calculates the subtotal and savings to 
      * get the total.
      */
     public double getCost()
     {
         setDiscountPercent();      
         subTotal = packagePrice * numUnitSold;
         discount = (subTotal * discountPercent);
         total = subTotal - discount;

         return total;
     }
   
}
