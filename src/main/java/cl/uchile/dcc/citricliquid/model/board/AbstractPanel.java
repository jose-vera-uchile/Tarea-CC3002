package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.unidades.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractPanel implements InterfacePanel{
    private final int id;
    private final Set<InterfacePanel> nextPanels;
    private final List<Player> playersInPanel;

    /**
     * Constructor for the abstract class, only receives the id
     * @param id: integer to differentiate a panel from another
     */
    protected AbstractPanel(int id) {
        this.id = id;
        this.nextPanels = new HashSet<InterfacePanel>();
        this.playersInPanel = new ArrayList<Player>();
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @return next panels set
     */
    public Set<InterfacePanel> getNextPanels() {
        return nextPanels;
    }

    /**
     * Adds a panel to the nextPanels set
     * @param panel
     */
    public void addNextPanel(InterfacePanel panel) {
        if (this.getId()!=panel.getId()) {
            nextPanels.add(panel);
        }
    }

    /**
     * @return List of players currently in the panel.
     */
    public List<Player> getPlayersInPanel() {
        return playersInPanel;
    }

    /**
     * Adds a player to the playersInPanel List
     * @param player
     */
    public void addPlayer(Player player) {
        playersInPanel.add(player);
    }

    /**
     * Removes a player from the playersInPanel List
     * @param player
     */
    public void removePlayer(Player player) {
        playersInPanel.remove(player);
    }

    /**
     * Checks to see if there is any player in the panel.
     * @return
     */
    public boolean hasPlayersInPanel(){
        if(playersInPanel.size()>1){
            return true;
        }
        else {
            return false;}
    }

    /**
     * Method to compare two panels, they are equals only if their id is the same
     * @param panel
     * @return
     */
    public boolean equals (@NotNull InterfacePanel panel){
        if(this.getId()==panel.getId()){
            return true;
        }
        else {
            return false;}
    }

    public abstract void activatedBy(final Player player);
}
