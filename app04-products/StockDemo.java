
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
    public static final int FIRST_ID = 101;

    // The stock manager.
    private StockManager manager;

    private Random randomGenerator;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockManager manager)
    {
        //rename product based on ID
        int id = FIRST_ID;
        for(id = 101; id < 110; id++);
        {
            this.manager = manager;
            randomGenerator = new Random();

            // Add at least 10 products, they do not have to be mobiles
            // Make sure the ids are sequential numbers
            manager.addProduct(new Product(101, "Samsung Galaxy S20"));
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

    private void demoDeliverProducts()
    {
        printHeading("delivery");

        int amount = 0;
        for(int id = 101; id <= 110; id++)
        {
            int quantity = randomGenerator.nextInt(7) + 1;
            manager.deliverProduct(id, amount);
            amount++;
        }
    }

    private void demoSellProducts()
    {
        printHeading("sell");
        int amount= 0;
        for(int id = 101; id <= 110; id++)
        {
            int quantity = randomGenerator.nextInt(7) + 1;
            manager.sellProduct(id, amount);
            amount++;
            System.out.println();
        }
    }

    /**
     * output formatting
     */
    public void printHeading (String verb)
    {
        System.out.println();
        System.out.println("==================");
        System.out.println("\nProduct Delivered \n " + verb);
        System.out.println("==================");
        System.out.println();
    }

    /**
     * Print all product that has no quantity
     * 
     *
     */
    public void removeProduct (int id)
    {
        manager.printAllProducts();
        manager.removeProduct(id);
        manager.printAllProducts();
    }
}