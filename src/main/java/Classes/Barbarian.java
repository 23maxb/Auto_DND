package Classes;

import Action.Action;
import Dice.Die;
import Items.Item;
import Stats.Skill;
import Stats.Stat;
import Status.Effect;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static Interaction.Input.promptOptions;

import Action.*;

public class Barbarian extends PlayerClass
{

    public Barbarian(int level)
    {
        super("Barbarian", level);
        skillProficiencies = null;
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
        return IntStream.range(0, item.tags.size()).anyMatch(i -> proficientTags().contains(item.tags.get(i)));//TODO fix this error
    }

    @Override
    public List<Stat> savingThrowProficiencies()
    {
        return Stream.of(Stat.Strength, Stat.Constitution).collect(Collectors.toList());
    }

    private List<Skill> skillProficiencies;

    /**
     * Gets the skill proficiencies for the class. If none are selected, it will ask the user for
     * input.
     *
     * @return the list of skill proficiencies.
     */
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
        skillProficiencies =
                Arrays.stream(promptOptions(2, choices)).map(String::trim).map(Skill::valueOf).collect(Collectors.toList());
        return skillProficiencies();
    }

    private Map<String, Double> classVars;

    /**
     * Gets the class's variables.
     *
     * @return the class's variables.
     */
    @Override
    public Map<String, Double> getVars()
    {
        if (classVars != null)
            return classVars;
        setDefaultVars(level);
        return getVars();
    }

    /**
     * Returns a list of actions that the class can perform.
     *
     * @return the list of actions a class can perform
     */
    @Override
    public ArrayList<Action> actions()
    {
        ArrayList<Action> a = new ArrayList<>();
        a.add(new Action("Rage", "In battle, you fight with primal ferocity. On your turn,\n" +
                "you can enter a rage as a bonus action.\n" +
                "While raging, you gain the following benefits if you\n" +
                "aren't wearing heavy armor:\n" +
                "You have advantage on Strength checks and Strength\n" +
                "saving throws.\n" +
                "When you make a melee weapon attack using\n" +
                "Strength, you gain a bonus to the damage roll that\n" +
                "increases as you gain levels as a barbarian, as shown\n" +
                "in the Rage Damage column of the Barbarian table.\n" +
                "You have resistance to bludgeoning, piercing, and\n" +
                "slashing damage.\n" +
                "If you are able to cast spells, you can't cast them or\n" +
                "concentrate on them while raging.\n" +
                "Your rage lasts for 1 minute. It ends early if you are\n" +
                "knocked unconscious or if your turn ends and you\n" +
                "haven't attacked a hostile creature since your last turn\n" +
                "or taken damage since then. You can also end your rage\n" +
                "on your turn as a bonus action.\n" +
                "Once you have raged the number of times shown\n" +
                "for your barbarian level in the Rages column of the\n" +
                "Barbarian table, you must finish a long rest before you\n" +
                "can rage again. \n", CastTime.Bonus, new Effect()));
        a.add();

        return a;
    }

    /**
     * Returns a list of effects that the class provides temporarily.
     *
     * @return the list of effects a class provides
     */
    @Override
    public ArrayList<Effect> effects()
    {
        return null;
    }

    @Override
    public void setDefaultVars(int level)
    {
        resetRage();

    }

    public void resetRage()
    {
        if (level < 3)
            classVars.put("rages", 2.0);
        else if (level < 5)
            classVars.put("rages", 3.0);
        else if (level < 12)
            classVars.put("rages", 4.0);
        else if (level < 17)
            classVars.put("rages", 5.0);
        else if (level < 20)
            classVars.put("rages", 6.0);
        else
            classVars.put("rages", Double.MAX_VALUE);

        if (level < 9)
            classVars.put("rage damage", 2.0);
        else if (level < 17)
            classVars.put("rage damage", 3.0);
        else
            classVars.put("rage damage", 4.0);
    }

    /**
     * Updates internal variables whenever a sunrise occurs.
     */
    @Override
    public void sunrise()
    {

    }

    /**
     * Updates internal variables whenever a short rest occurs.
     */
    @Override
    public void shortRest()
    {

    }

    /**
     * Updates internal variables whenever a long rest occurs.
     */
    @Override
    public void longRest()
    {
        resetRage();
    }


}
