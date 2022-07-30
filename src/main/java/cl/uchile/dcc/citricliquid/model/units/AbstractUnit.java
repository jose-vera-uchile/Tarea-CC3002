package cl.uchile.dcc.citricliquid.model.units;

import java.util.Random;

public abstract class AbstractUnit implements InterfaceUnit {
    private final Random random;
    protected final String name;
    protected final int maxHp;
    protected final int atk;
    protected final int def;
    protected final int evd;
    private int stars;
    private int currentHp;

    /**
     * Generic constructor for the Units
     *
     * @param name
     *     the character's name.
     * @param hp
     *     the initial (and max) hit points of the character.
     * @param atk
     *     the base damage the character does.
     * @param def
     *     the base defense of the character.
     * @param evd
     *     the base evasion of the character.
     */
    public AbstractUnit(final String name, final int hp, final int atk, final int def, final int evd) {
        this.name = name;
        this.maxHp = currentHp = hp;
        this.atk = atk;
        this.def = def;
        this.evd = evd;
        random = new Random();
    }

    /**
     * Returns the character's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the character's max hit points.
     */
    public int getMaxHp() {
        return maxHp;
    }

    /**
     * Returns the current character's attack points.
     */
    public int getAtk() {
        return atk;
    }

    /**
     * Returns the current character's defense points.
     */
    public int getDef() {
        return def;
    }

    /**
     * Returns the current character's evasion points.
     */
    public int getEvd() {
        return evd;
    }

    /**
     * Returns this player's star count.
     */
    public int getStars() {
        return stars;
    }

    /**
     * Returns the current hit points of the character.
     */
    public int getCurrentHp() {
        return currentHp;
    }

    /**
     * Increases this player's star count by an amount.
     */
    public void increaseStarsBy(final int amount) {
        stars += amount;
    }

    /**
     * Reduces this player's star count by a given amount.
     *
     * <p>The star count will must always be greater or equal to 0
     */
    public void reduceStarsBy(final int amount) {
        stars = Math.max(0, stars - amount);
    }

    /**
     * Sets the seed for this player's random number generator.
     *
     * <p>The random number generator is used for taking non-deterministic decisions, this method is
     * declared to avoid non-deterministic behaviour while testing the code.
     */
    public void setSeed(final long seed) {
        random.setSeed(seed);
    }

    /**
     * Sets the current character's hit points.
     *
     * <p>The character's hit points have a constraint to always be between 0 and maxHP, both
     * inclusive.
     */
    public void setCurrentHp(final int newHp) {
        this.currentHp = Math.max(Math.min(newHp, maxHp), 0);
    }

    /**
     * Returns a uniformly distributed random value in [1, 6].
     */
    public int roll() {
        return random.nextInt(6) + 1;
    }

    /*
     * Returns the value for the attack
     */
    public int attacks() {
        return this.roll()+atk;
    }

    /*
     * Receives a unit, and it uses the formula to determine
     * how many hp are going to be deducted from the current hp
     */
    public void defends(AbstractUnit unit) {
        this.setCurrentHp(this.currentHp - Math.max(1, unit.attacks() - (this.roll() - this.def)));
    }

    /*
     * Receives a unit, it calculates the value of the evasion of the player, then
     * calculates the value of the unit attack. Finally compares them and if the
     * evasion is equal or less than the attack, then it deducts the value of the attack
     * from the currenHp of the player
     */
    public void dodges(AbstractUnit unit) {
        var evasion = this.roll() + evd;
        var unitAttack = unit.attacks();
        if (unitAttack >= evasion) {
            this.setCurrentHp(this.currentHp -  unitAttack);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractUnit player)) {
            return false;
        }
        player = (AbstractUnit) o;

        return getMaxHp() == player.getMaxHp()
                && getAtk() == player.getAtk()
                && getDef() == player.getDef()
                && getEvd() == player.getEvd()
                && getStars() == player.getStars()
                && getCurrentHp() == player.getCurrentHp()
                && getName().equals(player.getName());
    }

    public abstract InterfaceUnit copy();

}
