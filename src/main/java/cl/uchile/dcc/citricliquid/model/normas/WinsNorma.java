package cl.uchile.dcc.citricliquid.model.normas;

import cl.uchile.dcc.citricliquid.model.units.Player;
import java.util.List;


/**
 * This class contains the method to get the normaClear with wins
 */
public class WinsNorma implements InterfaceNorma {
    @Override
    public void checkNormaObjective(Player player) {
        List<Integer> winsList = List.of(0, 2, 5, 9, 14);
        int currentWins = player.getWins();
        int winsNeeded = winsList.get(player.getNormaLevel() - 1);
        if (currentWins >= winsNeeded){
            player.normaClear();
        }
    }
}
