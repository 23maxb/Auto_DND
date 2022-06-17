package Action;

public class Action
{
    public enum CastTime
    {
        Instant,
        Bonus,
        Reaction,
        ShortRest,
        LongRest,
        Turn
    }
    public CastTime castTime;
    public String name;
    public String description;
    public Action(String name, String description, CastTime c)
    {
        this.name = name;
        this.description = description;
        castTime = c;

    }

}
