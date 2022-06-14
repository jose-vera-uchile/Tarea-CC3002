package cl.uchile.dcc.citricliquid.model.normas;

import cl.uchile.dcc.citricliquid.model.unidades.Player;

public interface InterfaceNorma {
    /**
     * Checks if the objective to upgrade the norma level were achieved
     * @param player: The player that is going to be checked
     */
    void checkNormaObjective( Player player);
}
