package Dice;

public class DiceRoller
{
    public static DiceRoller singleton = new DiceRoller();

    private DiceRoller()
    {
    }

    public static DiceRoller getInstance()
    {
        if (singleton == null)
        {
            singleton = new DiceRoller();
        }
        return singleton;
    }

    public int roll(int numDice, int numSides)
    {
        int total = 0;
        for (int i = 0; i < numDice; i++)
        {
            total += (int) (Math.random() * numSides) + 1;
        }
        return total;
    }

    public int roll(Die d)
    {
        int result = roll(d.getNumDice(), d.getNumSides());
        System.out.println("Rolling " + d + ": " + result);
        return result;
    }

}
