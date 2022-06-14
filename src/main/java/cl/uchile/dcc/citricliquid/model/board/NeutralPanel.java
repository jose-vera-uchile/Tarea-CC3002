package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.unidades.Player;

public class NeutralPanel extends AbstractPanel{
    /**
     * Constructor for the abstract class, only receives the id
     *
     * @param id : integer to differentiate a panel from another
     */
    protected NeutralPanel(int id) {
        super(id);
    }

    /**
     * Since is a neutral panel, does nothing
     */
    @Override
    public void activatedBy(Player player) {
        //empty method
    }
}
