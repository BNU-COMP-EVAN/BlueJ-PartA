
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 */
import java.util.Random;
/**
 * @author Evan Casto
 * @version 10/03/2021
 */
public class StockDemo
{

    // The stock manager.
    private StockManager manager;

    private Random randomGenerator;
    
    private Product product;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockManager manager)
    {
        {
            this.manager = manager;
            // Add at least 10 products, they do not have to be mobiles
            // Make sure the ids are sequential numbers;
            manager.addProduct(new Product(102, "Apple iPhone 12"));
            manager.addProduct(new Product(103, "Google Pixel 4A"));
            manager.addProduct(new Product(104, "Apple iPhone 8"));
            manager.addProduct(new Product(105, "Apple iPad Pro"));
            manager.addProduct(new Product(106, "Samsung Flip"));
            manager.addProduct(new Product(107, "OnePlus 8T"));
            manager.addProduct(new Product(108, "Xiaomi MI 10"));
            manager.addProduct(new Product(109, "Samsung Galaxy S21"));
            manager.addProduct(new Product(110, "Apple 12 Pro Max"));
        }
    }

    /**
     * Provide a demonstration of how the StockManager meets all
     * the user requirements by making a delivery of each product 
     * re-stocking it by various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        manager.printAllProducts();
        demoDeliverProducts();
        manager.printAllProducts();        
        demoSellProducts();
        manager.printAllProducts();
    }
    
    /**
     * Runs through the product item using the arrayList
     * Randomly generates stock quantity
     */

    private void demoDeliverProducts()
    {
        printHeading("delivery");
        {
            manager.deliverProduct(103,20);
        }
    }
    
    /**
     * Runs through the items using the arrayList
     * Randomly generates stock quantity 
     */
    private void demoSellProducts()
    {
        printHeading("sell");
        {
            manager.sellProduct(103, 10);
        }
    }

    /**
     * Output formatting
     */
    public void printHeading (String verb)
    {
        System.out.println();
        System.out.println("==================");
        System.out.println("\nProduct Delivered \n " + verb);
        System.out.println("==================");
        System.out.println();
    }
}