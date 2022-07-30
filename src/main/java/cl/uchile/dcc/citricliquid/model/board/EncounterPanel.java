package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.units.Player;

public class EncounterPanel extends AbstractEnemyPanel{
    /**
     * Constructor for the abstract class, only receives the id
     *
     * @param id : integer to differentiate a panel from another
     */
    public EncounterPanel(int id) {
        super(id);
    }

    /**
     * Starts a fight with a wildUnit. Is currently empty since the battles are not implemented yet.
     */
    @Override
    public void activatedBy(Player player) {

    }
}
