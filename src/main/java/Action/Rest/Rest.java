package Action.Rest;

import Action.*;
import Entity.*;

public abstract class Rest extends Action
{

    public Rest(String name, String description, CastTime c)
    {
        super(name, description, c);
    }

    public abstract void rest(Player player);


}
