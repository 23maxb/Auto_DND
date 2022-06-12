package Entity;

import Classes.PlayerClass;
import Items.CoinPurse;
import Items.Item;
import Races.Race;
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


}
