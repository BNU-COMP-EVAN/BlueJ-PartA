
/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been inserted.
 * The Ticket Machine will print data such as destination, price and date.
 * 
 * @author Evan Castro
 * @version 05/02/2021
 */
public class TicketMachine
{
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //price of each ticket
    private int price;
    //Shows the ticket to aylesbury
    private static final Ticket AYLESBURY_TICKET = new Ticket("Aylesbury", 220);
    //Shows the ticket to amersham
    private static final Ticket AMERSHAM_TICKET = new Ticket("Amersham", 300);
    //Shows the ticket to highWycombe
    private static final Ticket HIGHWYCOMBE_TICKET = new Ticket("HighWycombe",330);
    //ticket selector 
    private Ticket selectedTicket;
    //Insert coin
    private Coin coin;

    /**
     * Create a machine that issues tickets of the given price.
     */

    public TicketMachine()
    {
        balance = 0;
        total = 0;
        //this.price = cost;
    }

    /**
     * Display available destination for the TicketMachine
     */
    public void displayDestination()
    {
        System.out.println("Choose from the following destination");
        AYLESBURY_TICKET.print();
        AMERSHAM_TICKET.print();
        HIGHWYCOMBE_TICKET.print();

    }

    /**
     * Select the Aylesbury ticket
     */
    public void selectAylesburyTicket()
    {
        selectedTicket = AYLESBURY_TICKET;
        System.out.println ("You have selected the Aylesbury Ticket");
    }

    /**
     * Select the Amersham ticket
     */
    public void selectAmershamTicket()
    {
        selectedTicket = AMERSHAM_TICKET;
        System.out.println ("You have selected the Amersham Ticket");
    }

    /**
     * Select HighWycombe ticket
     */
    public void selectHighWycombeticket()
    {
        selectedTicket = HIGHWYCOMBE_TICKET;
        System.out.println ("You have selected the High Wycombe Ticket");
    }

    /**
     * Print the current balance
     */
    public void printbalance()
    {
        System.out.println("Your balance is " + getbalance());
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getbalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) 
        {
            balance = balance + amount;
        }
        else 
        {
            System.out.println("Use a positive amount rather than: " +
                amount);
        }
    }

    /**
     * Insert Twenty pence coin
     */
    public void inserttwentypence (Coin coin)
    {
        if(coin.getValue()== 20)
        {
            balance = balance + 20;
            System.out.println("You have inserted Twenty Pence coin");
            printbalance();

        }
        else
        {
            System.out.println("Please insert a twenty pence coin");

        }
    }

    /**
     * Insert the Ten pence coin
     */
    public void inserttenpence (Coin coin)
    {
        if(coin.getValue()== 10)
        {
            balance = balance + 10;
            System.out.println("You have inserted Ten Pence coin");
            printbalance();

        }
        else
        {
            System.out.println("Please insert a Ten pence coin");

        }
    }

    /**
     * Insert One Pound Coin
     */
    public void insertonepound (Coin coin)
    {
        if(coin.getValue()== 100)
        {
            balance = balance + 100;
            System.out.println("You have inserted a One Pound coin");
            printbalance();

        }
        else
        {
            System.out.println("Please insert a One pound coin");

        }
    }

    /**
     * Insert Two pounds coin
     */
    public void inserttwopounds (Coin coin)
    {
        if(coin.getValue()== 200)
        {
            balance = balance + 200;
            System.out.println("You have inserted Two Pounds coin");
            printbalance();

        }
        else
        {
            System.out.println("Please insert a Two pounds coin");

        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        //if(balance >= price)
        if(balance >= selectedTicket.getCost()) 
        {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            selectedTicket.print();
            //System,out.println("selectedTicket.getDate"());
            //System.out.println("# Ticket" + "selectedTicket.getDestination());
            //System.out.println("# " + selectedTicket.getCost() +"cents");
            System.out.println("##################");
            System.out.println();

            // totel = total + cost;
            total = total + selectedTicket.getCost();
            // balance = balance - cost
            balance = balance - selectedTicket.getCost();
            printbalance();
        }
        else 
        {
            System.out.println("You must insert at least: " +
                (selectedTicket.getCost() - balance) + " more cents.");

        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public void refundbalance()
    {
        System.out.println(" Amount refunded " + balance);
        balance = 0;

    }
}
