package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.unidades.Player;
import java.util.List;
import java.util.Set;

public interface InterfacePanel {

    int getId();

    Set<InterfacePanel> getNextPanels();

    void addNextPanel(InterfacePanel nPanel);

    List<Player> getPlayersInPanel();

    void addPlayer(Player player);

    void removePlayer(Player player);

    void activatedBy(final Player player);

}
