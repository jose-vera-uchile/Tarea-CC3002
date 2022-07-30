package cl.uchile.dcc.citricliquid.gameflow.states;

import cl.uchile.dcc.citricliquid.gameflow.Controller;
import cl.uchile.dcc.citricliquid.model.board.InterfacePanel;

import java.util.List;

public class ActivarPanel extends AbstractState {

    public ActivarPanel(Controller controller) {
        super(controller);
    }

    public void activateState(){
        if( this.controller.getPlayerPlaying().getCurrentPanel().equals(this.controller.getPlayerPlaying().getHomePanel())){
            this.controller.getPlayerPlaying().normaCheck();
            this.controller.nextPlayer();
            this.controller.setState(new StandBy(this.controller));
        }
    }


}