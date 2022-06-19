package Entity;

import Action.Action;
import Classes.PlayerClass;
import Items.CoinPurse;
import Items.Item;
import Races.Race;
import Stats.Skill;
import Stats.Stat;
import Stats.StatBook;
import Status.Effect;

import java.util.ArrayList;

/**
 * The Player class is a subclass of the Entity class.
 * It encompasses a player's attributes.
 *
 * @author Max Blennemann
 */
public class Player extends Entity
{
    public ArrayList<PlayerClass> classes;
    public int maxHP;
    public int currentHP;
    public int armorClass;
    public int speed;
    public int initiative;
    public int proficiencyBonus;
    public int xp;
    public ArrayList<Action> actions;
    public StatBook stats;


    public Player(String name, CoinPurse coins, PlayerClass theClass, Race race,
                  ArrayList<Effect> effects, ArrayList<Item> inventory)
    {
        super(name, race, effects, inventory);
        classes = new ArrayList<PlayerClass>();
        classes.add(theClass);
        stats = new StatBook();
    }

    public int generateMaxHP()
    {
        int newMax = 0;
        for (PlayerClass aClass : classes)
        {
            int currentTotal = 0;
            for (int i = 0; i < aClass.getHitDieCount(); i++)
                currentTotal += aClass.getHitDie().roll() + stats.statModifier(Stat.Constitution);
            if (currentTotal > newMax)
                newMax = currentTotal;
        }
        return newMax;
    }

    @Override
    public void processBonuses() //TODO Implement these
    {
        super.processRaceBonus();
        super.processEquipedBonus();
        super.processEffectBonus();
        super.processInventoryBonus();
        this.processClassBonus();
    }

    public void processClassBonus()
    {
        maxHP = generateMaxHP();

        //Processing saving throw proficiencies
        for (PlayerClass aClass : classes)
            for (int i = 0; i < aClass.savingThrowProficiencies().size(); i++)
                stats.savingThrowProficiencies.put(aClass.savingThrowProficiencies().get(i), true);

        //Processing skill proficiencies
        for (PlayerClass aClass : classes)
            for (int i = 0; i < aClass.skillProficiencies().size(); i++)
                stats.skillProficiencies.put(aClass.skillProficiencies().get(i), true);

        //Processing features
        for (PlayerClass aClass : classes)
        {
            aClass.getFeatures();
            proficiencyBonus = aClass.proficiencyBonus();
        }
    }


    public void applyShortRestBonus()
    {

    }

    public void applyLongRestBonus()
    {
    }

    public int getLongRestDuration()
    {

    }
}
