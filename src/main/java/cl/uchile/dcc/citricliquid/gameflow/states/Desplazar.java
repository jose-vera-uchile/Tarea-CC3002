package cl.uchile.dcc.citricliquid.gameflow.states;

import cl.uchile.dcc.citricliquid.gameflow.Controller;
import cl.uchile.dcc.citricliquid.model.board.InterfacePanel;

import java.util.List;

public class Desplazar extends AbstractState{
    public int movimientosRestantes;

    public Desplazar(Controller controller, int movimientosRestantes) {
        super(controller);
        this.movimientosRestantes = movimientosRestantes;
    }

    public int getMovimientosRestantes(){
        return this.movimientosRestantes;
    }

    public void activateState() {
        if (this.movimientosRestantes > 0) {
            List<InterfacePanel> nextPanel = this.controller.getPlayerPlaying().getCurrentPanel().getNextPanels();
            this.controller.movePlayer(this.controller.getPlayerPlaying(), nextPanel.get(0));
            movimientosRestantes--;
            //Aca debe ir el llamado de si se quiere detener, por ahora no implementare eso sino que el juego funcionara de forma que no te puedas detener a menos que termines de moverte
            this.controller.setState(new Desplazar(this.controller, movimientosRestantes));
        }
        else {
            this.controller.setState(new Detenido(this.controller, true));
        }

    }
}
