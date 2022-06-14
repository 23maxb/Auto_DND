package Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Item
{
    public String name;
    public String description;
    public int value;
    public int weight;
    public String completeID;

    public List<Tag> tags;

    public Item(String name, String description, int value, int weight, Tag... completeID)
    {
        this.name = name;
        this.description = description;
        this.value = value;
        this.weight = weight;
        this.completeID = Arrays.toString(completeID).replace("[", "").replace("]", "").replace(
                ", ", ".").toLowerCase(); //completeID should have
        // path to the item
        // example path: "item.dress.armor.light.studdedleatherarmor"
        // example path: "item.consumable.potion.potionofhealing"
        // example path: "item.weapon.martial_weapon.battleaxe"
    }

    /**
     * Checks through the item path and also the manually added tags to see if they match the tag
     * to check
     *
     * @param tagToCheck The tag to check for a match with.
     * @return true if this item or any of its tags match the given tag.
     */
    public boolean has(Tag tagToCheck)
    {
        return this.completeID.contains(tagToCheck.getTagName()) || tags.contains(tagToCheck);
    }
}
