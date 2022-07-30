package cl.uchile.dcc.citricliquid.gameflow.states;

import cl.uchile.dcc.citricliquid.gameflow.Controller;
import cl.uchile.dcc.citricliquid.model.board.InterfacePanel;

public class Detenido extends AbstractState{
    public boolean iniciarBatalla;
    public Detenido(Controller controller, boolean iniciarBatalla) {
        super(controller);
        this.iniciarBatalla = iniciarBatalla;
    }

    public void activateState(){
        InterfacePanel currentPanel = this.controller.getPlayerPlaying().getCurrentPanel();
        if (currentPanel.getPlayersInPanel().size() > 0 && iniciarBatalla){
            int enemies = currentPanel.getPlayersInPanel().size();
            this.controller.setState(new iniciarBatalla(this.controller, enemies));
        }
        else{
            this.controller.setState(new ActivarPanel(this.controller));
        }
    }
}
