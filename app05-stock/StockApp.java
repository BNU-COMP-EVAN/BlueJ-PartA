
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
    private StockDemo stock;

    private final String AddProduct ="ADD";
    private final String Print = "PRINT";
    private final String RemoveProduct = "REMOVE PRODUCT";
    private final String DeliverProduct = "DELIVER PRODUCT";
    private final String SellProduct = "SELL PRODUCT";
    private final String SearchProduct = "SEARCH PRODUDCT";
    private final String LowInStock = "LOW IN STOCK";
    private final String Restock = "RESTOCK";
    private final String PrintProduct = "PRINT PRODUCT";
    private final String Quit = "QUIT";

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        manager = new StockManager();
    }

    /**
     *  Display a list of menu choices and get the user's
     *  choice.
     */
    public void run()
    {
        printHeading();
        getMenuChoice();
    }

    /**
     *  Display a list of menu choices and get the user's
     *  choice.
     */
    public void getMenuChoice()
    {
        boolean finished = false;

        while(!finished)
        {
            printHeading();
            printMenuChoices();

            String prompt = "\nEnter your choice:";
            String choice = reader.getString(prompt).toLowerCase();
            System.out.println();
            if(choice.startsWith("quit"))
            {
                finished = true;
            }
            else
            {
                executeMenuChoice(choice);
            }
        }
    }

    /**
     *  Allows the user's input
     */
    public void executeMenuChoice(String choice)
    {
        if(choice.startsWith("ADD"))
        {
            addProduct();
        }

        else if(choice.startsWith("PrintProduct"))
        {
            System.out.println("Printing All Products");
            System.out.println("----------\n");

            manager.printAllProducts();
        }
         else if(choice.startsWith("REMOVE"))
         {
             removeProduct();
            }
            else if(choice.startsWith("DELIVER"))
            {
                deliverProduct();
            }
             else if(choice.startsWith("SELL"))
             {
                 sellProduct();
                }
                 else if(choice.startsWith("SEARCH"))
                 {
                     searchProduct();
                    }
                    else if(choice.startsWith("LOWINSTOCK"))
                    {
                        lowStockProduct();
                    }
                    else if(choice.startsWith("RESTOCK"))
                    {
                        restockProduct();
                    }
                
                    
    }

    /**
     *  Allows the user to add product
     */
    private void addProduct()
    {
        System.out.println (" Adding new product\n");

        String prompt = "\n Enter the product code: ";
        int code = reader.getInt(prompt);

        prompt ="\n Enter the product name: ";
        String name = reader.getString(prompt);

        Product product = new Product (code, name);
        manager.addProduct(product);
        manager.deliverProduct(code, 1);
        System.out.println("\n" + product + "has been added");
    }
    
    /**
     * Method to remove product from the user interface
     */
     private void removeProduct()
     {
         System.out.println("\nRemove Product\n");
         
         int id = reader.getInt("Please Enter product ID");
         
         manager.removeProduct(id);
         
        }
        
        /**
     * Method to deliver product from the user interface
     */
     private void deliverProduct()
     {
         int id =reader.getInt("\nPlease enter product ID\n");
         int amount = reader.getInt("\nPlease enter quantity\n");
         
         System.out.println("Delivery of Product");
         manager.deliverProduct(id, amount);
        }
          /**
     * Method to deliver product from the user interface
     */
     private void sellProduct()
     {
         int id =reader.getInt("\nPlease enter product ID\n");
         int amount = reader.getInt("\nPlease enter quantity\n");
         
         System.out.println("Sell Product");
         manager.sellProduct(id, amount);
        }
          /**
     * Method to deliver product from the user interface
     */
     private void searchProduct()
     {
         int id =reader.getInt("\nPlease enter product ID\n");
         System.out.println("The product you search is" + id +"");
    }
          /**
     * Method to deliver product from the user interface
     */
     private void lowStockProduct()
     {
         int id =reader.getInt("\nPlease enter product ID\n");
         manager.lowStockProducts();
    }
          /**
     * Method to deliver product from the user interface
     */
     private void restockProduct()
     {
         int id =reader.getInt("\nPlease enter product ID\n");
         manager.restockLowProduct(id);
    }    
    
          /**
     * Method to deliver product from the user interface
     */
     private void respondToChoice(String choice)
     {
         if(choice.startsWith("AddProducts"))
         {
             manager.addProduct(new Product(101, "Samsung Galaxy S20"));
            }
    }
        
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    ADD :        Add a new product");
        System.out.println("    REMOVE:     Remove an old product");
        System.out.println("    PrintProduct:   Print all products");
        System.out.println("    DELIVER: Deliver specific product"); 
        System.out.println("    SELL Product: Sell a specific product"); 
        System.out.println("    LOWINSTOCK: Print Product that is low in stock");
        System.out.println("    SEARCH: Search for a specific product");
        System.out.println("    RESTOCK: Restock Product");
        System.out.println("    Print: Print a specific product"); 
        System.out.println("    Quit:  Quit the program");
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
