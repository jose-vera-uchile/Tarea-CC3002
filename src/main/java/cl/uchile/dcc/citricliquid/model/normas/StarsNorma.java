package cl.uchile.dcc.citricliquid.model.normas;

import cl.uchile.dcc.citricliquid.model.units.Player;
import java.util.List;

/**
 * This class contains the method to get the normaClear with stars
 */
public class StarsNorma implements InterfaceNorma {
    @Override
    public void checkNormaObjective(Player player) {
        List<Integer> starsList = List.of(10, 30, 70, 120, 200);
        int currentStars = player.getStars();
        int starsNeeded = starsList.get(player.getNormaLevel() - 1);
        if (currentStars >= starsNeeded){
            player.normaClear();
        }
    }
}
