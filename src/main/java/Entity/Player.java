package Entity;

import Action.Action;
import Classes.PlayerClass;
import Items.CoinPurse;
import Items.Item;
import Races.Race;
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
    }

    public void generateMaxHP()
    {

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
        for(int i = 0; i  < classes.size(); i++)
        {
            classes.get(i).getHitDie();
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
