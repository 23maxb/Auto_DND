package Items;

import java.util.ArrayList;
import java.util.Arrays;

public class Tag
{
    public final String tagName;
    public final ArrayList<Tag> subtags;

    /**
     * Creates a new tag with the given name and subtags.
     *
     * @param tagName The name of the tag.
     * @param subtag The subtags of the tag. (ie if this tag parameter was Armor subtags would be light armor, medium armor, heavy armor)
     */
    public Tag(String tagName, Tag... subtag)
    {
        this.tagName = tagName;
        this.subtags = new ArrayList<>(Arrays.asList(subtag));
    }

    /**
     * Checks this tag and subtags for a match with the given tag.
     *
     * @param tag The tag to check for.
     * @return true if this tag or any of its subtags match the given tag.
     */
    public boolean has(Tag tag)
    {
        if (getTagName().equals(tag.getTagName()))
            return true;
        for (Tag subtag : subtags)
        {
            if (subtag.getTagName().compareTo((tag).getTagName()) == 0)
                return true;
            else if (subtag.has(tag))
                return true;
        }
        return false;
    }

    public String getTagName()
    {
        return tagName;
    }

    public ArrayList<Tag> getSubtags()
    {
        return subtags;
    }
}
