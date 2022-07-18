package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.units.Player;

public class BossPanel extends AbstractPanel{
    /**
     * Constructor for the abstract class, only receives the id
     *
     * @param id : integer to differentiate a panel from another
     */
    protected BossPanel(int id) {
        super(id);
    }

    /**
     * Starts a fight with a boss. Is currently empty since the battles are not implemented yet.
     * @param player
     */
    @Override
    public void activatedBy(Player player) {

    }
}
