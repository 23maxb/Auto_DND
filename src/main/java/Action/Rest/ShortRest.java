package Action.Rest;

import Action.CastTime;
import Entity.*;

import static Interaction.Input.prompt;

public class ShortRest extends Rest
{
    public ShortRest(String name, String description, CastTime c)
    {
        super(name, description, CastTime.ShortRest);
    }

    @Override
    public void rest(Player player)
    {
        String a =
                prompt(player.getName() + " is attempting a short rest that lasts for " + player.getShortRestDuration() + " hours. Do you want to interrupt the rest? (y/n)");
        if (a.startsWith("y"))
        {
            System.out.println("Rest was interrupted.");
            return;
        }
        System.out.println("Rest successful.");
        player.applyShortRestBonus();
    }

}
