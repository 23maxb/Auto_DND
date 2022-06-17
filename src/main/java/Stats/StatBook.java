package Stats;

import java.util.Map;

public class StatBook
{
    public Map<Stat, Integer> stats;
    public Map<Skill, Boolean> skillProficiencies;
    public Map<Stat, Boolean> savingThrowProficiencies;
    public Map<Skill, Integer> skillValuesWithoutProficiency;

    /**
     * Creates a new StatBook with completely empty stats.
     */
    public StatBook()
    {
        stats = new java.util.HashMap<>();
        skillProficiencies = new java.util.HashMap<>();
        savingThrowProficiencies = new java.util.HashMap<>();
        skillValuesWithoutProficiency = new java.util.HashMap<>();
    }

    /**
     * Creates a new StatBook with the given parameters.
     *
     * @param stats                    The stats of the player.
     * @param skillProficiencies       The skill proficiencies of the player.
     * @param savingThrowProficiencies The saving throw proficiencies of the player.
     * @param skillValues              The skill values of the player.
     */
    public StatBook(Map<Stat, Integer> stats, Map<Skill, Boolean> skillProficiencies, Map<Stat,
            Boolean> savingThrowProficiencies, Map<Skill, Integer> skillValues)
    {
        this.stats = stats;
        this.skillProficiencies = skillProficiencies;
        this.savingThrowProficiencies = savingThrowProficiencies;
        this.skillValuesWithoutProficiency = skillValues;
    }

    public int statModifier(Stat stat)
    {
        return intToModifier(stats.get(stat));
    }

    public static int intToModifier(int value)
    {
        return (value - 10) / 2;
    }
}
