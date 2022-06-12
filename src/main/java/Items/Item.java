package Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item
{
    public String name;
    public String description;
    public int value;
    public int weight;
    public ArrayList<Tag> tags;

    public Item(String name, String description, int value, int weight, Tag... tags)
    {
        this.name = name;
        this.description = description;
        this.value = value;
        this.weight = weight;
        this.tags = new ArrayList<Tag>(Arrays.asList(tags));
    }

    public boolean has(List<Tag> tags)
    {
        for (Tag tag : tags)
        {
            if (!this.tags.contains(tag))
            {
                return false;
            }
        }
    }
}
