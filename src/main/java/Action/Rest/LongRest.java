package Action.Rest;

import Action.CastTime;
import Entity.*;

import static Interaction.Input.prompt;

public class LongRest extends Rest
{
    public LongRest(String name, String description)
    {
        super(name, description, CastTime.LongRest);
    }

    @Override
    public void rest(Player player)
    {
        String a =
                prompt(player.getName() + " is attempting a long rest that lasts for " + player.getLongRestDuration() + " hours. Do you want to interrupt the rest? (y/n)");
        if (a.startsWith("y"))
        {
            System.out.println("Rest was interrupted.");
            return;
        }
        System.out.println("Rest successful.");
        player.applyLongRestBonus();
    }
}
