package Classes;

import Dice.Die;
import Items.Item;

import java.util.ArrayList;
import java.util.Map;

public abstract class PlayerClass
{
    public int level;
    public String className;

    public PlayerClass(String className, int level)
    {
        this.className = className;
        this.level = level;
    }

    /**
     * Increases the level of the class by 1.
     *
     * @return the new level
     */
    public int levelUp()
    {
        level++;
        return level;
    }

    public abstract int getMaxHP();

    public abstract Die getHitDie();

    public abstract int getHitDieCount();

    public abstract ArrayList<String> proficientTags(); //TODO: Add proficiency types

    public abstract boolean isProficient(Item item);

    public abstract ArrayList<String> savingThrowProficiencies();

    public abstract int proficiencyBonus();

    public abstract Map<String, Double> getVars();

    public abstract ArrayList<String> features();


}
