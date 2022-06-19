package Status;

import Entity.Player;

import java.util.function.Consumer;

public class Effect
{
    private final Consumer<Player> applyEffect;
    public String name;
    public String description;
    public int duration; //in turns
    public int turnsLeft;
    public Object Source;

    public Effect(String name, String description, int duration, Object Source, Consumer<Player> applyEffect)
    {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.Source = Source;
        this.applyEffect = applyEffect;
    }

    /**
     * Applies an effect to a player.
     *
     * @param player The player to apply the effect to.
     */
    public void apply(Player player)
    {
        applyEffect.accept(player);
    }
}
