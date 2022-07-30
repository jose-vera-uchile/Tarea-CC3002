package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.units.Player;

public class DrawPanel extends AbstractPanel{
    /**
     * Constructor for the abstract class, only receives the id
     *
     * @param id : integer to differentiate a panel from another
     */
    public DrawPanel(int id) {
        super(id);
    }

    /**Does nothing since the cards are not implemented yet
     * @param player
     */
    @Override
    public void activatedBy(Player player) {
        // To be Implemented
    }
}
