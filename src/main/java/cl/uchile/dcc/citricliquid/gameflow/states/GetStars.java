package cl.uchile.dcc.citricliquid.gameflow.states;

import cl.uchile.dcc.citricliquid.gameflow.Controller;

public class GetStars extends AbstractState{

    public GetStars(Controller controller) {
        super(controller);
    }

    public void activateState(){
        int chapter = this.controller.getChapter();
        this.controller.getPlayerPlaying().increaseStarsBy((int)(chapter/5)+1);
        this.controller.setState(new RollDice(this.controller));
    }
}
