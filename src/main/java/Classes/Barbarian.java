package Classes;

import Dice.Die;
import Items.Item;
import Stats.Skill;
import Stats.Stat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    /**
     * Returns the hit die, which is a d12 for barbarians.
     * This will always be 1dx.
     *
     * @return The hit die.
     */
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

    /**
     * Returns true if the proficiency tags that the class grants includes any tag the item has.
     *
     * @param item the item to check
     * @return true if the user would be proficient
     * otherwise false
     */
    @Override
    public boolean isProficient(Item item)
    {
        return IntStream.range(0, item.tags.size()).anyMatch(i -> proficientTags().contains(item.tags.get(i)));
    }

    @Override
    public List<Stat> savingThrowProficiencies()
    {
        return Stream.of(Stat.Strength, Stat.Constitution).collect(Collectors.toList());
    }

    private ArrayList<Skill> skillProficiencies;

    @Override
    public List<Skill> skillProficiencies()
    {
        if (skillProficiencies != null)
            return skillProficiencies;
        System.out.println("Your class selection allows you to choose two skills to be proficient" +
                " in.");
        System.out.println("Choose two skills to be proficient in:");
        String[] choices = {"Animal Handling", "Athletics", "Intimidation", "Nature", "Perception"
                , "Survival"};
        return Arrays.stream(promptOptions(2, choices)).map(String::trim).map(Skill::valueOf).collect(Collectors.toList());
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
