package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.units.Player;

public class HomePanel extends AbstractPanel{
    /**
     * Constructor for the abstract class, only receives the id
     *
     * @param id : integer to differentiate a panel from another
     */
    public HomePanel(int id) {
        super(id);
    }

    /**
     * Restores the CurrentHp in +1
     * @param player
     */
    @Override
    public void activatedBy(Player player) {
        player.setCurrentHp(player.getCurrentHp() + 1);
    }
}
