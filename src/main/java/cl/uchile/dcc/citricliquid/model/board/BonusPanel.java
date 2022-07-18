package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.units.Player;

public class BonusPanel extends AbstractPanel{

    /**
     * Constructor for the abstract class, only receives the id
     *
     * @param id : integer to differentiate a panel from another
     */
    protected BonusPanel(int id) {
        super(id);
    }

    /**
     * Increases the amount of stars of a player. The amount is determined by a roll multiplied by the min
     * between the player's norma level and 3.
     * @param player
     */
    @Override
    public void activatedBy(Player player) {
        player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(), 3));
    }
}
