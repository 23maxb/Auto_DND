package Classes;

import Dice.Die;
import Items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static Interaction.Input.promptOptions;

public class Barbarian extends PlayerClass
{

    public Barbarian(int level)
    {
        super("Barbarian", level);
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
        return new Die(1, 12);
    }

    @Override
    public int getHitDieCount()
    {
        return level;
    }

    @Override
    public ArrayList<String> proficientTags()
    {
        return new ArrayList<>(Arrays.asList("light armor", "medium armor", "heavy armor",
                "shields", "simple weapons", "martial weapons")).stream().map(el -> el.replaceAll(" ", "_")
                .toLowerCase()).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    @Override
    public boolean isProficient(Item item)
    {
        proficientTags();
    }

    @Override
    public ArrayList<String> savingThrowProficiencies()
    {
        ArrayList<String> savingThrowProficiencies = new ArrayList<String>();
        savingThrowProficiencies.add("Strength");
        savingThrowProficiencies.add("Constitution");
        return savingThrowProficiencies;
    }

    private ArrayList<String> skillProficiencies;

    @Override
    public ArrayList<String> skillProficiencies()
    {
        if (skillProficiencies != null)
            return skillProficiencies;
        ArrayList<String> skillProficiencies = new ArrayList<String>();
        System.out.println("Your class selection allows you to choose two skills to be proficient" +
                " in.");
        System.out.println("Choose two skills to be proficient in:");
        String[] choices = {"Animal Handling", "Athletics", "Intimidation", "Nature", "Perception"
                , "Survival"};

        skillProficiencies =
                Arrays.stream(promptOptions(2, choices)).map(String::trim).collect(ArrayList::new
                        , java.util.ArrayList::add, java.util.ArrayList::addAll);
        return skillProficiencies;
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
