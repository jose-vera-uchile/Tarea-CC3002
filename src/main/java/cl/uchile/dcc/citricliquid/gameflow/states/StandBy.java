package cl.uchile.dcc.citricliquid.gameflow.states;

import cl.uchile.dcc.citricliquid.gameflow.Controller;

public class StandBy extends AbstractState{

    public StandBy(Controller controller) {
        super(controller);
    }

    public void activateState(){
        if(this.controller.getPlayerPlaying().getCurrentHp() == 0){
            this.controller.setState(new Recovery(this.controller));
        }
        else {
            this.controller.setState(new GetStars(this.controller));}
    }
}
