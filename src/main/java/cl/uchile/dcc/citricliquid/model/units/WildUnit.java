package cl.uchile.dcc.citricliquid.model.units;

public class WildUnit extends AbstractEnemy{
    /**
     * Generic constructor for the Units
     *
     * @param name the character's name.
     * @param hp   the initial (and max) hit points of the character.
     * @param atk  the base damage the character does.
     * @param def  the base defense of the character.
     * @param evd  the base evasion of the character.
     */
    public WildUnit(String name, int hp, int atk, int def, int evd) {
        super(name, hp, atk, def, evd);
    }

    @Override
    public WildUnit copy() {
        return new WildUnit(name, maxHp, atk, def, evd);
    }
}
