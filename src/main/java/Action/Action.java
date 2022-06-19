package Action;

import Status.Effect;

public class Action
{
    public CastTime castTime;
    public String name;
    public String description;
    public Effect grantedEffect;

    public Action(String name, String description, CastTime c)
    {
        this.name = name;
        this.description = description;
        castTime = c;
    }

    public Action(String name, String description, CastTime c, Effect grantedEffect)
    {
        this.name = name;
        this.description = description;
        castTime = c;
        this.grantedEffect = grantedEffect;
    }

}
