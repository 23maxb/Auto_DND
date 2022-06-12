package Classes;

import Dice.Die;

import java.util.ArrayList;

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

    public abstract ArrayList<String> getProficiencies(); //TODO: Add proficiency types



}
