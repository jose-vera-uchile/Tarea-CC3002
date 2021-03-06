package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.unidades.Player;

public class EncounterPanel extends AbstractPanel{
    /**
     * Constructor for the abstract class, only receives the id
     *
     * @param id : integer to differentiate a panel from another
     */
    protected EncounterPanel(int id) {
        super(id);
    }

    /**
     * Starts a fight with a wildUnit. Is currently empty since the battles are not implemented yet.
     */
    @Override
    public void activatedBy(Player player) {

    }
}
