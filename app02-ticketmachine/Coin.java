
/**
 * Enumeration class Coin -
 * Holds the value of the prices to different destination
 *
 * @author Evan Castro
 * @version 06/02/2021
 */
public enum Coin
{
    P10 (10),

    P20 (20),

    P100 (100),

    P200 (200);

    private final int value;

    private Coin(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
