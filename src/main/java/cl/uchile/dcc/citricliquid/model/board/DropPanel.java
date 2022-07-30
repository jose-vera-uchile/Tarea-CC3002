package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.units.Player;

public class DropPanel extends AbstractPanel{

    /**
     * Constructor for the abstract class, only receives the id
     *
     * @param id : integer to differentiate a panel from another
     */
    public DropPanel(int id) {
        super(id);
    }

    /**
     * Reduces the amount of stars that a player has. This amount is defined by a roll of a D6 dice
     * multiplied with the players norma level
     * @param player
     */
    @Override
    public void activatedBy(Player player) {
        player.reduceStarsBy(player.roll() * player.getNormaLevel());
    }
}
