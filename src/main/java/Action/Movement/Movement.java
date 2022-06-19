package Action.Movement;

import Action.Action;

public class Movement extends Action
{
    public int distance; //in feet
    public Movement(String name, String description)
    {
        super(name, description, CastTime.Turn);
    }
}
