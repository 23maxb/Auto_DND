package Entity;

import Items.Item;
import Races.Race;
import Status.Effect;

import java.util.ArrayList;

public class NPC extends Entity
{
    /**
     * Creates a new Entity
     *
     * @param name      Name
     * @param race      Race
     * @param effects   List of status effects
     * @param inventory inventory
     */
    public NPC(String name, Race race, ArrayList<Effect> effects, ArrayList<Item> inventory)
    {
        super(name, race, effects, inventory);
    }
}
