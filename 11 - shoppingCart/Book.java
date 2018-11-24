package shoppingCart;

/**Written by Carlos Vazquez
Final Project
Date: 18 October 2018
This class contains the variables
to retrieve the file of the list
of books.
*/

public class Book 
{
	// Declare the variables to hold the title and the price.
    private String title;
    private double price;

    // This constructor has two arguments,
    // which would obtain the title of the book
    // and their prices.
    public Book(String title, double price) 
    {
        this.title = title;
        this.price = price;
    }
    
    // This method returns the title obtained from the list of books
    public String getTitle() 
    {
        return title;
    }

    // This method sets the title from the books.
    public void setTitle(String title) 
    {
        this.title = title;
    }

    // This method is used to get the price of the books.
    public double getPrice() 
    {
        return price;
    }

    // This method set the price from the list of the books.
    public void setPrice(double price) 
    {
        this.price = price;
    }

    @Override
    // This method convert the title and the price to string
    public String toString() 
    {
        return title + " ($" + price + ")";
    }

}