package cl.uchile.dcc.citricliquid.gameflow.states;

import cl.uchile.dcc.citricliquid.gameflow.Controller;

public class AbstractState {
    public Controller controller;

    public AbstractState(Controller controller){
        this.controller = controller;
    }

    public void doAction(){}

    public void activateState(){
    }
}
