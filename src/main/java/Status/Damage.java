package Status;

import Entity.Entity;

public class Damage
{
    public String damage;
    public DamageType damageType;

    public Entity owner;

    public Damage(String damageExpression)
    {
        damage = damageExpression;
        damageType = DamageType.True;
    }

    /**
     * Deals the damage to an entity.
     *
     * @param e the entity to deal damage to
     * @return the damage dealt
     */
    public int dealDamage(Entity e)
    {
        if (e.isAlive() && e.getResistanceMultiplier(damageType) > 0)
        {
            int damageDealt =
                    (int) (e.getResistanceMultiplier(damageType) * Integer.parseInt(damage));
        }
    }
}
