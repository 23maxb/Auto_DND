package Magic;

import java.util.ArrayList;

public class Spellbook
{
    public Spellbook(ArrayList<Spell> spells, int[] spellSlots)
    {
        this.spellSlots = spellSlots;
        this.spells = spells;
    }

    ArrayList<Spell> spells;
    int[] spellSlots;

    public ArrayList<Spell> getSpells()
    {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells)
    {
        this.spells = spells;
    }

    public void addSpell(Spell spell)
    {
        spells.add(spell);
    }

    public void removeSpell(Spell spell)
    {
        if (spells.contains(spell))
            spells.remove(spell);
        else
            System.out.println("Spell not found.");
    }


}
