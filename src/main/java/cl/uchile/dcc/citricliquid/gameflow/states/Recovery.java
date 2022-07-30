package cl.uchile.dcc.citricliquid.gameflow.states;

import cl.uchile.dcc.citricliquid.gameflow.Controller;

public class Recovery extends AbstractState{

    public Recovery(Controller controller) {
        super(controller);
    }

    public void activateState(){
        int roll = this.controller.getPlayerPlaying().roll();
        int chapter = this.controller.getChapter();
        if (roll >= 6-chapter){
            this.controller.setState(new GetStars(this.controller));
        }
        else{
            this.controller.nextPlayer();
            this.controller.setState(new StandBy(this.controller));
        }
    }
}
