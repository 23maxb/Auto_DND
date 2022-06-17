package Classes;

import Dice.Die;
import Interaction.Input;
import Items.Item;

import java.util.ArrayList;
import java.util.List;
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
     * Runs newClass but with parameters given by the user
     *
     * @return the new playerClass
     */
    public static PlayerClass newClass()
    {
        return newClass(Input.prompt("Class name not found! Please enter a valid class name: "),
                Integer.parseInt(Input.prompt("Enter the class level: ")));
    }

    /**
     * Automatically generates a new class based on given parameters.
     *
     * @param className The name of the class.
     * @param level     The level of the class.
     * @return The class.
     */
    public static PlayerClass newClass(String className, int level)
    {
        switch (className)
        {
            case "Barbarian":
                return new Barbarian(level);
            case "Cleric":
                return new Cleric(level);
            case "Druid":
                return new Druid(level);
            case "Fighter":
                return new Fighter(level);
            case "Monk":
                return new Monk(level);
            case "Paladin":
                return new Paladin(level);
            case "Ranger":
                return new Ranger(level);
            case "Rogue":
                return new Rogue(level);
            case "Sorcerer":
                return new Sorcerer(level);
            case "Warlock":
                return new Warlock(level);
            case "Wizard":
                return new Wizard(level);
            default:
                throw new IllegalStateException("Unexpected value: " + className);
        }
    }

    /**
     * Increases the level of the class by 1.
     *
     * @return the new level
     */
    public int levelUp()
    {
        level++;
        checkBonuses();
        return level;
    }

    /**
     * Updates the class's abilities based on its level and subclass.
     */
    public abstract void checkBonuses();

    /**
     * Returns the hit die, which is always 1dx.
     *
     * @return The hit die.
     */
    public abstract Die getHitDie();

    public abstract int getHitDieCount();

    public abstract ArrayList<String> proficientTags(); //TODO: Add proficiency types

    public abstract boolean isProficient(Item item);

    /**
     * Gets the spell book for the class.
     *
     * @return
     */
    public ArrayList<String> getSpellBook()
    {
        return null;
    }

    public abstract List<String> savingThrowProficiencies();

    public abstract ArrayList<String> skillProficiencies();

    /**
     * Gives the proficiency bonus for the class. (based on level)
     *
     * @return the proficiency bonus
     */
    public int proficiencyBonus()
    {
        return 2 + ((level - 1) / 4);
    }

    public abstract Map<String, Double> getVars();

    public abstract ArrayList<String> features();

}
