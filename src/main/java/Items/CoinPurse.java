package Items;

public class CoinPurse
{
    public int copper = 0;
    public int silver = 0;
    public int gold = 0;
    public int platinum = 0;
    public int electrum = 0;
    public int onyx = 0;

    /**
     * Adds a certain amount of copper to the purse.
     *
     * @param amount the amount of copper to add.
     * @return the new amount of copper
     */
    public int addCopper(int amount)
    {
        copper += amount;
        return copper;
    }

    /**
     * Adds a certain amount of silver to the purse.
     *
     * @param amount the amount of silver to add.
     * @return the new amount of silver
     */
    public int addSilver(int amount)
    {
        silver += amount;
        return silver;
    }


    public coinPurse()
    {

    }
}
