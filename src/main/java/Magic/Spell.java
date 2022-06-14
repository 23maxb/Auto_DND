package Magic;

public class Spell
{
    public String name;
    public String description;
    public int level;
    public boolean ritual;
    public int castingTime; // in turns (-1 means bonus action and -2 means reaction and 0 means
    // no casting time)
    public int range; // in feet
    public boolean somatic; //true if the spell requires hand motions
    public boolean material; //true if the spell requires material components
    public boolean verbal; //true if the spell requires the caster to not be silenced
    public boolean instant; //true if the spell is cast instantly (and cant be dispelled)
    public boolean concentration; //true if the spell can be cast while the caster is concentrating

    public enum School // the school of the spell
    {
        Abjuration, Conjuration, Divination, Enchantment, Evocation, Illusion, Necromancy,
        Transmutation
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    /**
     * Creates a new spell.
     *
     * @param name        The name of the spell.
     * @param description The description of the spell.
     * @param level       The level of the spell.
     */
    public Spell(String name, String description, int level)
    {
        this.name = name;
        this.description = description;
        this.level = level;
    }

    public static Spell fetchSpell(String name)
    {
        //TODO fix this
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean isCantrip()
    {
        return level == 0;
    }
}
