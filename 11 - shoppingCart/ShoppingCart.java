package shoppingCart;

/**Written by Carlos Vazquez
Final Project
Date: 18 October 2018
This application works like a shopping cart
system for an online book store. Each line
of the file has the name of the book, and
the book retail's price. The user can select
a title from the list and add it to the shopping
cart. This application has buttons in which the user
can add items, delete items, delete all items, and
the checkout. Upon checkout, the GUI will notify
the user of the total of purchases with tax included
and will printout a receipt with the information
for the customer to maintain a copy.
*/

//imports
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.LinkedHashSet;
import java.util.Set;

public class ShoppingCart extends Application 
{

    // ArrayList to hold info from the file.
    ArrayList<Book> bookList;
    ArrayList<Book> cartList;

    ListView<Book> booksView;
    ListView<Book> cartView;
    
    Label labelSubTotal;
    Label labelTax;
    Label labelTotal;

    double subTotal = 0.0;
    double tax = 0.0;
    double total = 0.0;

    public static void main(String[] args) 
    {
    	// Launch the application.
        launch(args); 
    }

    // This method is the entry point of the application.
    // this method creates the parts of the GUI, such as
    // the buttons, layout and reads the file to collect
    // the list of the books and the prices in the file.
    @Override
    public void start(Stage primaryStage) throws IOException 
    {

        // Build the inventory ArrayLists
        readBookFile();

        // Convert the inventoryTtitles ArrayList to an ObservableList.
        ObservableList<Book> observableList = FXCollections.observableArrayList(bookList);

        // Build the Book ListView
        booksView = new ListView<>(observableList);

        // Build the Shopping Cart ListView
        cartView = new ListView<>();

        // Create the output label for the cart subtotal.
        labelSubTotal = new Label("Sub Total: ");

        // Create the output label for the tax.
        labelTax = new Label("Tax: ");

        // Create the output label for the cart total.
        labelTotal = new Label("Grand Total: ");

        // Add To Cart Button
        Button addToCartButton = new Button("Add To Cart");
        cartList = new ArrayList<>();
        addToCartButton.setOnAction(e -> 
        {

            int index = booksView.getSelectionModel().getSelectedIndex();

            // Get the selected index.
            if (index != -1) 
            {

                Book b = bookList.get(index);

                // Update the cart ArrayLists
                cartList.add(bookList.get(index));

                // Update the cartListView
                cartView.setItems(FXCollections.observableArrayList(cartList));

                // Update the subtotal
                subTotal += b.getPrice();

            }

        });

        // Remove From Cart Button
        Button removeFromCartButton = new Button("Remove From Cart");
        removeFromCartButton.setOnAction(e -> 
        {
            // Get the selected index.
            int index = cartView.getSelectionModel().getSelectedIndex();
            if (index != -1) 
            {
                // Update the subtotal
                subTotal -= cartList.get(index).getPrice();

                // Remove the selected item from the cart ArrayLists
                cartList.remove(index);

                // Update the cartListView
                cartView.setItems(FXCollections.observableArrayList(cartList));

            }

        });

        // Clear Cart Button
        Button clearCartButton = new Button("Clear Cart");
        clearCartButton.setOnAction(e -> 
        {
            // Update the subtotal
            subTotal = 0;
            updateLabels();
            
            // Clear the cart ArrayLists
            cartList.clear();

            // Update the cartList
            cartView.setItems(FXCollections.observableArrayList(cartList));

        });

        // Checkout Button
        Button checkoutButton = new Button("Checkout");
        final double TAX_RATE = 0.07;

        checkoutButton.setOnAction(e -> 
        {

            // Calculate the tax
            tax = subTotal * TAX_RATE;

            // Calculate the total
            total = subTotal + tax;

            updateLabels();

            //setup dates
            String timeStamp = new SimpleDateFormat("MM-DD-YYYY HH:mm:ss").format
            		(Calendar.getInstance().getTime());
            String fntimeStamp = new SimpleDateFormat("MM-DD-YYYY.HH.mm.ss").format
            		(Calendar.getInstance().getTime());

            //create and open receipt file
            String filename = "Receipt-" + fntimeStamp + ".txt";

            try {

                //open file
                PrintWriter receiptFile = new PrintWriter("src/shoppingCart/" + filename);

                //create the receipt
                receiptFile.println("Receipt: "+timeStamp);
                receiptFile.printf("%-25s %-10s %-10s %-10s\n", "Title", "Quantity", "Price", "Total");

                //creating a set to get rid of duplicates
                Set<Book> bookSet = new LinkedHashSet<>(cartList);

                for (Book b : bookSet) 
                {

                    //finding quantity

                    int quantity = findQuantity(b, cartList);
                    receiptFile.println('\n');
                    receiptFile.printf("%-25s %-10d $%-9.2f $%-9.2f\t", b.getTitle(),
                            quantity, b.getPrice(), b.getPrice() * quantity);
                }
                
                receiptFile.println('\n');
                receiptFile.printf("%-25s %-10s %-9.2s $%-9.2f\n", "Total", "", "\t", subTotal);
                receiptFile.println('\n');
                receiptFile.printf("\n%-25s %-10s %-9.2s $%-9.2f\n", "\nTax", "", "\t", tax);
                receiptFile.println('\n');
                receiptFile.printf("\n%-25s %-10s %-9.2s $%-9.2f\n", "\nGrand Total", "", "\t", total);

                //close the file
                receiptFile.close();

            } catch (FileNotFoundException e1) 
            {
                e1.printStackTrace();
                System.out.println("file open error");
            }

        });

        // Create two Hboxes to create and align the buttons.
        HBox hbox1 = new HBox(addToCartButton);
        hbox1.setAlignment(Pos.CENTER);
        HBox hbox2 = new HBox(removeFromCartButton, clearCartButton, checkoutButton);
        hbox2.setSpacing(10);
        hbox2.setAlignment(Pos.CENTER);

        // Label the two lists.
        Label lbl1 = new Label("Available Books");
        Label lbl2 = new Label("Cart");

        // Place the properties into a VBox
        VBox root = new VBox(lbl1, booksView, hbox1, lbl2, cartView, hbox2, labelSubTotal, labelTax, labelTotal);
        
        // Add the main VBox to a scene.
        Scene scene = new Scene(root, 600, 800);
        
        // Set the scene to the stage and display it.       
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    // This method is to display the total labels into the scene
    private void updateLabels() 
    {
        labelSubTotal.setText(String.format("Sub Total: $%.2f", subTotal));
        labelTax.setText(String.format("Tax: $%.2f", tax));
        labelTotal.setText(String.format("Grand Total: $%.2f", total));
    }

    // This method is used to determine the quantity of the books
    // by using an if statement to determine if two titles are the same.
    // If the titles are the same, then, the count will increase by increments
    // of one.
    private int findQuantity(Book b, ArrayList<Book> list) 
    {
        int count = 0;
        
        for (Book book : list) 
        {
            if (book.getTitle().equalsIgnoreCase(b.getTitle())) 
                count++;
        }

      return count;
    }

    // This method is used to open the file to
    // determine the number of titles available
    // in the file and will add it to the array
    // list.
    private void readBookFile() throws IOException 
    {
        bookList = new ArrayList<Book>();
        
        // Open the file.
        File file = new File("src/shoppingCart/BookPrices.txt");
        Scanner inFile = new Scanner(file);

        // Read the file.
        while (inFile.hasNext()) 
        {

            // Read a line.
            String line = inFile.nextLine();

            // Tokenize the line.
            String fields[] = line.split(",");

            Book b = new Book(fields[0].trim(), Double.parseDouble(fields[1].trim()));

            // Add the book info to the ArrayLists.
            bookList.add(b);

        }

        // Close the file.
        inFile.close();
    }

}