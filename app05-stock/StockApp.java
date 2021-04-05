
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Evan Castro
 * @version 01/04/2021
 */
public class StockApp
{

    private InputReader reader;
    private StockManager manager;
    private Product product;
    private StockDemo demo;

    //Constant
    private final String ADD ="ADD";
    private final String PRINT = "PRINT";
    private final String REMOVE = "REMOVE PRODUCT";
    private final String DELIVER = "DELIVER PRODUCT";
    private final String SELL = "SELL PRODUCT";
    private final String SEARCH = "SEARCH PRODUDCT";
    private final String LOWINSTOCK = "LOW IN STOCK";
    private final String RESTOCK = "RESTOCK";
    private final String PRINTPRODUCT = "PRINT PRODUCT";
    private final String QUIT = "QUIT";

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        manager = new StockManager();
        demo = new StockDemo(manager);
    }

    /**
     *  Display a list of menu choices and get the user's
     *  choice.
     */
    public void run()
    {
        boolean finished = false;

        while(!finished)
        {
            printHeading();
            printMenuChoices();

            String prompt = "\nEnter your choice:";
            String choice = reader.getString(" Please enter your choice ");
            choice = choice.toUpperCase();
            System.out.println();
            if(choice.equals("QUIT"))
            {
                finished = true;
                System.out.println(" Thank you for using the app, you are now exiting the program ");
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
        printHeading();
    }

    /**
     *  Allows the user's input
     */
    public void executeMenuChoice(String choice)
    {
        //Gives the user a choice add an item to the product list
        if(choice.equals(ADD))
        {
            String name = reader.getString("Please enter the product NAME you would like to add \n");
            int id = reader.getInt("Please enter the ID of the product you would like to add \n");
            Product product = new Product(id, name);
            manager.addProduct(product);
            System.out.println(product.getName() + ": " + product.getID() + " has been added \n");
            manager.printAllProducts();
        }
        //Gives the user a choice to print all of the items
        else if(choice.startsWith(PRINT))
        {
            System.out.println("Printing All Products");
            System.out.println("----------\n");

            manager.printAllProducts();
        }
        //Gives a user a choice to remove unwanted items
        else if(choice.equals("REMOVE"))
        {            
            manager.printAllProducts();
            String name = reader.getString("Please enter the product NAME you would like to removed \n");
            int id = reader.getInt("Please enter ID of the product you would like to removed \n");
            Product product = new Product(id, name);
            manager.removeProduct(id);
            System.out.println(product.getName() + ": " + product.getID() + " has been removed \n");
            manager.printAllProducts();            
        }
        //Gives user a choice to deliver an item
        else if(choice.equals("DELIVER"))
        {
            String name = reader.getString("Please enter the product NAME you would like to deliver \n");
            int id = reader.getInt("Please enter the ID of the product you would like to deliver \n");
            int amount = reader.getInt("Please enter the AMOUNT of the product you would like to deliver \n");
            Product product = new Product(id, name);
            manager.deliverProduct(id, amount);
            System.out.println(product.getName() + ": " + product.getID() + " has been delivered");
            manager.printAllProducts();
        }
        //Gives user a choice to sell an item
        else if(choice.equals("SELL"))
        {
            String name = reader.getString("Please enter the product NAME you would like to deliver \n");
            int amount = reader.getInt("Please enter the AMOUNT of the product you would like to sell \n");
            int id = reader.getInt("Please enter the ID of the product you would like to sell \n");
            Product product = new Product(id, name);
            manager.sellProduct(id, amount);
            System.out.println(product.getName() + ": " + product.getID() + " has been sold");
        }
        //Gives user a choice to Search for an item using a phrase in the items name
        else if(choice.equals("SEARCH"))
        {
            manager.printAllProducts();
            String targetPhrase = reader.getString("Please enter a phrase to search for a product (case sensitive) \n");
            manager.searchProducts(targetPhrase);
        }
   
        //Gives user a choice to view which product is currently not available and prints out the items that are out of stock
        else if(choice.equals("LOWINSTOCK"))
        {
            if(manager.checkNoProducts()== true)
            {
                System.out.println(" There are no product in the system, Please add a product");
            }
            else
            {
                manager.printLowStock();
            }
        }
        //Gives user a choice to restock items
        else if(choice.equals("RESTOCK"))
        {
            if(manager.checkNoProducts()== true)
            {
                System.out.println("There are no product in the system");
            }
            else
            {
                manager.printLowStock();
                int amount = reader.getInt("Enter the AMOUNT of stock you would like to restock");
                manager.reStockProduct(amount);
                manager.printAllProducts();
            }
        }
        else if(choice.equals("PRINTPRODUCT"))
        {
            if(manager.checkNoProducts()== true)
            {
                System.out.println("There are no product in the system");
            }
            else
            {
                product.printDetails();
            }
        }
    }
      

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    ADD :        Add a new product \n");
        System.out.println("    REMOVE:     Remove an old product\n");
        System.out.println("    PRINTPRODUCT:   Print all products\n");
        System.out.println("    DELIVER: Deliver specific product\n"); 
        System.out.println("    SELL: Sell a specific product\n"); 
        System.out.println("    LOWINSTOCK: Print Product that is low in stock\n");
        System.out.println("    SEARCH: Search for a specific product\n");
        System.out.println("    RESTOCK: Restock Product\n");
        System.out.println("    PRINT: Print a specific product\n"); 
        System.out.println("    QUIT:  Quit the program\n");
        System.out.println();        
    }

    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Evan Castro");
        System.out.println("******************************");
    }
}
