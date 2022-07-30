package cl.uchile.dcc.citricliquid.gameflow;

import cl.uchile.dcc.citricliquid.gameflow.states.AbstractState;
import cl.uchile.dcc.citricliquid.gameflow.states.StandBy;
import cl.uchile.dcc.citricliquid.model.board.InterfacePanel;
import cl.uchile.dcc.citricliquid.model.units.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public ArrayList<Player> playerList;
    public ArrayList<InterfacePanel> board;
    public int currentPlayer;
    public int chapter;
    public AbstractState state;



    public Controller(ArrayList<Player> playerList, ArrayList<InterfacePanel> board){
        this.playerList = playerList;
        this.board = board;
        this.currentPlayer = 0;
        this.chapter = 1;
        this.state = new StandBy(this);
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void movePlayer(Player player, InterfacePanel panel){
        player.setCurrentPanel(panel);
    }

    public int getChapter(){
        return this.chapter;
    }

    public Player getPlayerPlaying() {
        return this.playerList.get(currentPlayer);
    }

    public void nextPlayer(){
        if (this.currentPlayer == 3){
            this.currentPlayer = 0;
            this.chapter++;
        }
        else{ this.currentPlayer++;}
    }

    public AbstractState getState(){
        return state;
    }

    public void setState(AbstractState state) {
        this.state = state;
    }
}
