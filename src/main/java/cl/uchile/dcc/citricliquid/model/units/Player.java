package cl.uchile.dcc.citricliquid.model.units;

import cl.uchile.dcc.citricliquid.model.normas.InterfaceNorma;
import cl.uchile.dcc.citricliquid.model.normas.StarsNorma;
import cl.uchile.dcc.citricliquid.model.normas.WinsNorma;

/**
 * This class represents a player in the game 99.7% Citric Liquid.
 */
public class Player extends AbstractUnit{
  private int normaLevel;
  private int wins;
  public InterfaceNorma normaGoal;

  /**
   * Constructor for the player, is the same constructor for the Abstract class
   * but this initializes the norma level in 1
   *
   * @param name the character's name.
   * @param hp   the initial (and max) hit points of the character.
   * @param atk  the base damage the character does.
   * @param def  the base defense of the character.
   * @param evd  the base evasion of the character.
   */
  public Player(String name, int hp, int atk, int def, int evd) {
    super(name, hp, atk, def, evd);
    normaLevel=1;
    wins=0;
  }

  /**
   * Returns the current amount of wins
   */
  public int getWins() {
    return wins;
  }

  /**
   * In case of a win in a battle, this method can be used to increase the wins by 1
   */
  public void increaseWins() {
    wins++;
  }

  /**
   * Returns the current norma level.
   */
  public int getNormaLevel() {
    return normaLevel;
  }

  /**
   * Set the player goal to clear the norma
   * @param normaGoal
   */
  public void setNormaGoal(InterfaceNorma normaGoal) {
    this.normaGoal = normaGoal;
  }

  /**
   * Returns the goal to clear the norma
   */
  public InterfaceNorma getNormaGoal() {
    return normaGoal;
  }

  /**
   * Method that Checks the norma objective for this player, using the current set goal
   */
  public void normaCheck(){
    this.getNormaGoal().checkNormaObjective(this);
  }

  /**
   * Performs a norma clear action; the {@code norma} counter increases in 1.
   */
  public void normaClear() {
    normaLevel++;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractUnit)) {
      return false;
    }
    final Player player = (Player) o;
    return getMaxHp() == player.getMaxHp()
            && getAtk() == player.getAtk()
            && getDef() == player.getDef()
            && getEvd() == player.getEvd()
            && getNormaLevel() == player.getNormaLevel()
            && getStars() == player.getStars()
            && getCurrentHp() == player.getCurrentHp()
            && getName().equals(player.getName())
            && getWins() == player.getWins();
  }

  /**
   * Returns a copy of this character.
   */
  public Player copy() {
    return new Player(name, maxHp, atk, def, evd);
  }
}
