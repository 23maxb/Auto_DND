package Items;

/**
 * Handles the coin purse.
 *
 * @author Max Blennemann
 * @version 1.0
 */
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

    /**
     * Adds a certain amount of gold to the purse.
     *
     * @param amount the amount of gold to add.
     * @return the new amount of gold
     */
    public int addGold(int amount)
    {
        gold += amount;
        return gold;
    }

    /**
     * Adds a certain amount of platinum to the purse.
     *
     * @param amount the amount of platinum to add.
     * @return the new amount of platinum
     */
    public int addPlatinum(int amount)
    {
        platinum += amount;
        return platinum;
    }

    /**
     * Adds a certain amount of electrum to the purse.
     *
     * @param amount the amount of electrum to add.
     * @return the new amount of electrum
     */
    public int addElectrum(int amount)
    {
        electrum += amount;
        return electrum;
    }

    /**
     * Adds a certain amount of onyx to the purse.
     *
     * @param amount the amount of onyx to add.
     * @return the new amount of onyx
     */
    public int addOnyx(int amount)
    {
        onyx += amount;
        return onyx;
    }

    public CoinPurse(int copper)
    {
        this.copper = copper;
        collapseCurrency();
    }

    /**
     * Automatically collapses currency into precious metal currencies. (no electrum)
     */
    public void collapseCurrency()
    {
        while (copper > 10)
        {
            copper -= 10;
            silver += 1;
        }
        while (silver > 10)
        {
            silver -= 10;
            gold += 1;
        }
        while (gold > 10)
        {
            gold -= 10;
            platinum += 1;
        }
    }

    /**
     * Returns the amount of each currency in the purse.
     */
    @Override
    public String toString()
    {
        return "Copper: " + copper + "\nSilver: " + silver + "\nGold: " + gold + "\nPlatinum: " + platinum + "\nElectrum: " + electrum + "\nOnyx: " + onyx;
    }

    /**
     * The value of the entire purse in copper.
     *
     * @return The value of the entire purse in copper
     */
    public int inCopper()
    {
        return copper + (silver * 10) + ((gold + (50 * onyx)) * 100) + (platinum * 1000) + (electrum * 50);
    }

    /**
     * The value of the entire purse in silver.
     *
     * @return The value of the entire purse in silver
     */
    public double inSilver()
    {
        return (double) inCopper() / 10;
    }

    /**
     * The value of the entire purse in gold.
     *
     * @return The value of the entire purse in gold
     */
    public double inGold()
    {
        return (double) inCopper() / 100;
    }

    /**
     * The value of the entire purse in platinum.
     *
     * @return The value of the entire purse in platinum
     */
    public double inPlatinum()
    {
        return (double) inCopper() / 1000;
    }

    /**
     * The value of the entire purse in electrum.
     *
     * @return The value of the entire purse in electrum
     */
    public double inElectrum()
    {
        return (double) inCopper() / 50;
    }

    /**
     * The value of the entire purse in onyx.
     *
     * @return The value of the entire purse in onyx
     */
    public double inOnyx()
    {
        return (double) inCopper() / 500;
    }
}
