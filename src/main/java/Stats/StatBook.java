package Stats;

import java.util.Map;

public class StatBook
{
    public Map<Stat, Integer> stats;
    public Map<Skill, Boolean> skillProficiencies;
    public Map<Stat, Boolean> savingThrowProficiencies;
    public Map<Skill, Integer> skillValues;

    public int statModifier(Stat stat)
    {
        return intToModifier(stats.get(stat));
    }

    public static int intToModifier(int value)
    {
        return (value - 10) / 2;
    }
}
