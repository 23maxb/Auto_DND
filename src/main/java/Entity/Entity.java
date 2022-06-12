package Entity;

import Items.Item;
import Races.Race;
import Status.Effect;

import java.util.ArrayList;
import java.util.Map;

public class Entity
{
    private String name;
    private Race race;
    private boolean alive;
    private ArrayList<Effect> effects; //String is damage type and Integer is the multiplier
    private ArrayList<Item> inventory;

    /**
     * Creates a new Entity
     *
     * @param name      Name
     * @param race      Race
     * @param effects   List of status effects
     * @param inventory inventory
     */
    public Entity(String name, Race race, ArrayList<Effect> effects,
                  ArrayList<Item> inventory)
    {
        this.name = name;
        this.race = race;
        this.alive = true;
        this.effects = effects;
        this.inventory = inventory;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Race getRace()
    {
        return race;
    }

    public boolean isAlive()
    {
        return alive;
    }

    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }

    public void die()
    {
        setAlive(false);
    }

    public void resurrect()
    {
        setAlive(true);
    }

    public void addEffect(Effect effect)
    {
        effects.add(effect);
    }

    public ArrayList<Effect> getEffects()
    {
        return effects;
    }

    public void setEffects(ArrayList<Effect> effects)
    {
        this.effects = effects;
    }

    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory)
    {
        this.inventory = inventory;
    }
}
