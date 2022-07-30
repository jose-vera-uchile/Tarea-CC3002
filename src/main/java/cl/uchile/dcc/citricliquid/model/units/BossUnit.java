package cl.uchile.dcc.citricliquid.model.units;

public class BossUnit extends AbstractEnemy{

    /**
     * Generic constructor for the Units
     *
     * @param name the character's name.
     * @param hp   the initial (and max) hit points of the character.
     * @param atk  the base damage the character does.
     * @param def  the base defense of the character.
     * @param evd  the base evasion of the character.
     */
    public BossUnit(String name, int hp, int atk, int def, int evd) {
        super(name, hp, atk, def, evd);
    }

    @Override
    public BossUnit copy() {
        return new BossUnit(getName(), getMaxHp(), getAtk(), getDef(), getEvd());
    }
}
