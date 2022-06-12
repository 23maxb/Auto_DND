package Classes;

import Dice.Die;
import Items.Item;

import java.util.ArrayList;
import java.util.Map;

public class Ranger extends PlayerClass
{
    public Ranger(int level)
    {
        super("Ranger", level);
    }

    /**
     * Updates the class's abilities based on its level and subclass.
     */
    @Override
    public void checkBonuses()
    {

    }

    @Override
    public Die getHitDie()
    {
        return null;
    }

    @Override
    public int getHitDieCount()
    {
        return 0;
    }

    @Override
    public ArrayList<String> proficientTags()
    {
        return null;
    }

    @Override
    public boolean isProficient(Item item)
    {
        return false;
    }

    @Override
    public ArrayList<String> savingThrowProficiencies()
    {
        return null;
    }

    @Override
    public ArrayList<String> skillProficiencies()
    {
        return null;
    }

    @Override
    public int proficiencyBonus()
    {
        return 0;
    }

    @Override
    public Map<String, Double> getVars()
    {
        return null;
    }

    @Override
    public ArrayList<String> features()
    {
        return null;
    }
}
