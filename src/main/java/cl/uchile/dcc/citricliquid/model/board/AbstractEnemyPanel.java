package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.units.AbstractEnemy;

import java.util.ArrayList;

public abstract class AbstractEnemyPanel extends AbstractPanel {
    private final ArrayList<AbstractEnemy> enemyInPanel;
    /**
     * Constructor for the abstract class, only receives the id
     *
     * @param id : integer to differentiate a panel from another
     */
    protected AbstractEnemyPanel(int id) {
        super(id);
        this.enemyInPanel = new ArrayList<AbstractEnemy>();
    }

    public void addEnemy(AbstractEnemy enemy) {
        if (enemyInPanel.size() == 0 ) {
            enemyInPanel.add(enemy);
        }
    }

    public void removeEnemy(AbstractEnemy enemy) {
        enemyInPanel.remove(enemy);
    }

    public boolean hasEnemyInPanel(){
        if(enemyInPanel.size()>0){
            return true;
        }
        else {
            return false;}
    }
}
