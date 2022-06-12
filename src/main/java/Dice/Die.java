package Dice;

public class Die
{

    private final int numSides;
    private final int numDice;

    public Die(int count, int Sides)
    {
        this.numSides = Sides;
        this.numDice = count;
    }

    public Die(String dieID)
    {
        this(Integer.parseInt(dieID.split("d")[1]), Integer.parseInt(dieID.split("d")[0]));
    }

    public int roll()
    {
        return DiceRoller.getInstance().roll(this);
    }

    public int getNumSides()
    {
        return numSides;
    }

    public int getNumDice()
    {
        return numDice;
    }

    public String toString()
    {
        return numDice + "d" + numSides;
    }
}