package Items;

import java.util.ArrayList;
import java.util.Arrays;

public class Tag
{
    public final String tagName;

    /**
     * Creates a new tag with the given name and subtags.
     *
     * @param tagName The name of the tag.
     * @param subtag  The subtags of the tag. (ie if this tag parameter was Armor subtags would
     *                be light armor, medium armor, heavy armor)
     */
    public Tag(String tagName)
    {
        this.tagName = tagName;
    }

    /**
     * Checks this tag and subtags for a match with the given tag.
     *
     * @param nameOfTag The tag to check for a match with.
     * @return true if this tag or any of its subtags match the given tag.
     */
    public boolean has(String nameOfTag)
    {
        return getTagName().contains(nameOfTag);
    }

    public String getTagName()
    {
        return tagName;
    }
}
