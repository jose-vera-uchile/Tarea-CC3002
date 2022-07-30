package cl.uchile.dcc.citricliquid.model.controller;

import cl.uchile.dcc.citricliquid.gameflow.Controller;
import cl.uchile.dcc.citricliquid.gameflow.states.AbstractState;
import cl.uchile.dcc.citricliquid.gameflow.states.Recovery;
import cl.uchile.dcc.citricliquid.gameflow.states.RollDice;
import cl.uchile.dcc.citricliquid.model.board.*;
import cl.uchile.dcc.citricliquid.model.units.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

class ControllerTests {
    private Player suguri;
    private Player pedro;
    private Player juan;
    private Player diego;
    private Controller controller;
    private InterfacePanel homePanel;
    private InterfacePanel neutralPanel;
    private InterfacePanel bonusPanel;
    private InterfacePanel dropPanel;
    private AbstractEnemyPanel encounterPanel;
    private AbstractEnemyPanel bossPanel;
    private InterfacePanel drawPanel;
    private ArrayList<Player> listaDeJugadores = new ArrayList<Player>();
    private ArrayList<InterfacePanel> board = new ArrayList<InterfacePanel>();



    @BeforeEach
    public void setUp(){
        homePanel = new HomePanel(0);
        neutralPanel = new NeutralPanel(1);
        homePanel.addNextPanel(neutralPanel);
        bonusPanel = new BonusPanel(2);
        neutralPanel.addNextPanel(bonusPanel);
        dropPanel = new DropPanel(3);
        bonusPanel.addNextPanel(dropPanel);
        encounterPanel = new EncounterPanel(4);
        dropPanel.addNextPanel(encounterPanel);
        bossPanel = new BossPanel(5);
        encounterPanel.addNextPanel(bossPanel);
        drawPanel = new DrawPanel(6);
        bossPanel.addNextPanel(drawPanel);
        drawPanel.addNextPanel(homePanel);
        suguri = new Player("Suguri", 4, 1, 0, 2, homePanel);
        pedro = new Player("Pedro", 4, 1, 0, 2, homePanel);
        juan = new Player("Juan", 4, 1, 0, 2, homePanel);
        diego = new Player("Diego", 4, 1, 0, 2, homePanel);
        listaDeJugadores.add(suguri);
        listaDeJugadores.add(pedro);
        listaDeJugadores.add(juan);
        listaDeJugadores.add(diego);
        board.add(homePanel);
        board.add(neutralPanel);
        board.add(bonusPanel);
        board.add(dropPanel);
        board.add(encounterPanel);
        board.add(bossPanel);
        board.add(drawPanel);
        controller = new Controller(listaDeJugadores, board);
    }

    @Test
    public void controllerTest(){
        AbstractState standBy = controller.getState();
        Assertions.assertEquals(standBy, controller.getState());
        controller.getState().activateState();
        AbstractState newState = controller.getState();
        Assertions.assertEquals(newState, controller.getState());
        Assertions.assertEquals(suguri, controller.getPlayerPlaying());
        Assertions.assertEquals(1,controller.getChapter());
        controller.nextPlayer();
        Assertions.assertEquals(pedro, controller.getPlayerPlaying());
        Assertions.assertEquals(1,controller.getChapter());
        controller.nextPlayer();
        controller.nextPlayer();
        controller.nextPlayer();
        Assertions.assertEquals(suguri, controller.getPlayerPlaying());
        Assertions.assertEquals(2,controller.getChapter());
        Assertions.assertEquals(listaDeJugadores, controller.getPlayerList());
        Assertions.assertEquals(homePanel, suguri.getCurrentPanel());
        controller.movePlayer(controller.getPlayerPlaying(), controller.getPlayerPlaying().getCurrentPanel().getNextPanels().get(0));
        Assertions.assertEquals(neutralPanel, suguri.getCurrentPanel());
    }

    @Test
    public void standByStateTest(){
        AbstractState startingStandByState = this.controller.getState();
        this.controller.getState().activateState();
        Assertions.assertNotEquals(startingStandByState, this.controller.getState());
        this.controller.setState(startingStandByState);
        this.controller.getPlayerPlaying().setCurrentHp(0);
        this.controller.getState().activateState();
        Assertions.assertNotEquals(startingStandByState, this.controller.getState());
    }

    @RepeatedTest(100)
    public void recoveryStateConsistencyTest(){
        AbstractState recovery = new Recovery(controller);
        this.controller.setState(recovery);

        final long testSeed = new Random().nextLong();
        controller.getPlayerPlaying().setSeed(testSeed);
        controller.getState().activateState();

        Assertions.assertTrue(controller.getState() != recovery,
                "El controlador no cambio de estado" + System.lineSeparator()
                        + "Test failed with random seed: " + testSeed);
    }

    @RepeatedTest(100)
    public void rollDiceStateTest(){
        AbstractState rollDice = new RollDice(controller);
        this.controller.setState(rollDice);

        final long testSeed = new Random().nextLong();
        controller.getPlayerPlaying().setSeed(testSeed);
        controller.getState().activateState();

        Assertions.assertTrue(controller.getState() != rollDice,
                "El controlador no cambio de estado" + System.lineSeparator()
                        + "Test failed with random seed: " + testSeed);

    }
}
