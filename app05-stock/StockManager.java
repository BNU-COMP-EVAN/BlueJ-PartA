import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (Evan Castro) 
 * @version (10/03/2021)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void deliverProduct(int id, int amount)
    {
        Product product = findProduct(id);
        //if product is not equal to null, increase the quantity.
        if(product != null)
        {
            product.increaseQuantity(amount); 
            System.out.println(" Product Deliveries : " + product);
        }
        else 
        {
            System.out.println("Error, Product not found");
        }
    }
    

    /**
     * Method to locate product by its ID
     */
    public Product findProduct(int id)
    { //for every product in the stock collection, do an action.
        for(Product product : stock)
        {
            if(id == product.getID())
            {
                return product;
            }
        }
        return null;
    }

    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id, int amount)
    {
        Product product = findProduct(id);
        // if product is not equal to null
        if(product != null)
        {
            System.out.println(" Selling: " + id +  ","
                + " quantity: " + amount);
            product.sellQuantity(amount);
        }
        else
        {
            System.out.println(" Product not found ");
        }
    }

    /** 
     * Shows the details of the found product
     */
    public void printDetails(int id)
    {
        Product product = findProduct(id);
        //if product is not equal to null
        if(product != null)
        {
            System.out.println(" Available Stock : " + product.getQuantity());
            System.out.println(product);
        }
        else 
        { 
            System.out.println(" Error! Product not found ");
        }
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        return 0;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int id)
    {
        Product product = findProduct(id);
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }

    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void printAllProducts()
    {
        printHeading();
        for(Product product : stock)
        {
            System.out.println(product);
        }
        System.out.println();
    }

    /**
     * If the product exist that matches the id 
     * method to remove product from the stock list
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);

        if(product == null)
        {
            System.out.println(" Product ID " + id +
                " Error, ID NOT FOUND ");
        }
        else 
            stock.remove(product);
        System.out.println("\n Product ID " + id + " Removed\n ");
    }

    /**
     * Method to rename product
     */
    public void renameProduct(int id, String newName)
    {

        Product product = findProduct(id);

        if(product == null)
        {
            System.out.println( "Product id " + id + " not found ");
        }
        else 
        {
            System.out.println(product);
            product.setName(newName);
            System.out.println("**NEW_NAME***");
            System.out.println (product);
        }
    }

    /**
     * Print out products that are low in stock
     */
    public ArrayList<Product> printLowStockProducts(int minimum)
    {
        ArrayList<Product> lowStock = new ArrayList<Product>();
        int count = 0;

        System.out.println(" List of all out of stock products ");
        System.out.println();

        for(Product product : stock)
        {
            if(product.getQuantity() <= minimum)
            {
                count++;
                lowStock.add(product);
                System.out.println(product);
            }
        }

        System.out.println();
        System.out.println("There were " + count + 
            "stock products with less than " + minimum + " items ");

        return lowStock;
    }

    /**
     * Print out products that are low in stock
     */
    public void lowStockProducts()
    {

        System.out.println(" List of all out of stock products ");
        System.out.println();

        for(Product product : stock)
        {
            if(product.getQuantity() >=1 && product.getQuantity() <= 10)
            {
                System.out.println(product.toString());
            }
        }
    }

    /**
     *  Increases the quantity of lowstock products
     */
    public void restockLowProduct(int amount)
    {

        for(Product product : stock)
        {
            if(product.getQuantity() >=1 && product.getQuantity()<= 10)
            {
                if(amount >= 1 && amount <= 11)
                {
                    product.increaseQuantity(amount);
                    System.out.println(product.getName() + " item restocked "
                    + amount + " quantity " + "\n" + product.toString());
                }
                else 
                {
                    System.out.println(" Enter number a number between 1 to 11"); 
                }
            }
        }
    }

    /**
     * Print out the stock list
     * 
     *
     */
    public void printHeading()
    {
        System.out.println();
        System.out.println("Evan's Stock List");
        System.out.println("====================");
        System.out.println();
    }
}