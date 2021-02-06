import java.util.Date;
/**
 * This class represents the tickets that can be purchased from the ticketMachine.
 * It stores the destiantion, cost and date of purchase values.
 *
 * @author Evan Castro
 * @version 05/02/2021
 */
public class Ticket
{
    // Shows the destination of the ticket
    private String destination;
    //Shows the cost of the ticket
    private int cost;
    //String datePurchased
    private Date date;

    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(String destination, int cost)
    {
        this.destination = destination;
        this.cost = cost;
        this.date = new Date();
    }

    /**
     * This method prints out the ticket details
     */
    public void print()
    {
        System.out.println("Destination: "+ destination
            +", Cost: " + cost + ", Date " + date);
    }

    /**
     * This method returns the cost of a ticket
     */    
    public int getCost()
    {
        return cost;
    }

    /**
     * This method returns the destination of a ticket
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * This method prints out the date of when the ticket was purchased
     */
    public Date getDate()
    { 
        return date;
    }

}    
