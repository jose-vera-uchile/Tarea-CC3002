package cl.uchile.dcc.citricliquid.gameflow.states;

import cl.uchile.dcc.citricliquid.gameflow.Controller;

public class RollDice extends AbstractState {

    public RollDice(Controller controller) {
        super(controller);
    }

    public void nextState(){
        int roll = this.controller.getPlayerPlaying().roll();
        this.controller.setState(new Desplazar(this.controller, roll));
    }
}
