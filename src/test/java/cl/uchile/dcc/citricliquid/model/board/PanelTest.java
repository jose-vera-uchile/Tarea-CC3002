package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.units.AbstractEnemy;
import cl.uchile.dcc.citricliquid.model.units.Player;
import cl.uchile.dcc.citricliquid.model.units.WildUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PanelTest {
    private final static String PLAYER_NAME = "Suguri";
    private Player suguri;
    private InterfacePanel homePanel;
    private InterfacePanel neutralPanel;
    private InterfacePanel bonusPanel;
    private InterfacePanel dropPanel;
    private AbstractEnemyPanel encounterPanel;
    private AbstractEnemyPanel bossPanel;
    private InterfacePanel drawPanel;

    @BeforeEach
    public void setUp(){
        suguri = new Player(PLAYER_NAME, 4, 1, 0, 2, homePanel);
        suguri.increaseStarsBy(10);
        homePanel = new HomePanel(0);
        neutralPanel = new NeutralPanel(1);
        bonusPanel = new BonusPanel(2);
        dropPanel = new DropPanel(3);
        encounterPanel = new EncounterPanel(4);
        bossPanel = new BossPanel(5);
        drawPanel = new DrawPanel(6);
    }

    @Test
    public void getIdTest() {
        Assertions.assertEquals(0,homePanel.getId());
    }

    @Test
    public void nextPanelsTest() {
        var list = new ArrayList<InterfacePanel>();
        Assertions.assertEquals(list, homePanel.getNextPanels());
        list.add(neutralPanel);
        list.add(bonusPanel);
        homePanel.addNextPanel(neutralPanel);
        homePanel.addNextPanel(bonusPanel);
        Assertions.assertEquals(list,homePanel.getNextPanels());
    }

    @Test
    public void playersInPanelTest() {
        var list = new ArrayList<Player>();
        Assertions.assertEquals(list, homePanel.getPlayersInPanel());
        Assertions.assertFalse(homePanel.hasPlayersInPanel());
        list.add(suguri);
        homePanel.addPlayer(suguri);
        Assertions.assertTrue(homePanel.hasPlayersInPanel());
        Assertions.assertEquals(list, homePanel.getPlayersInPanel());
        list.remove(suguri);
        homePanel.removePlayer(suguri);
        Assertions.assertEquals(list, homePanel.getPlayersInPanel());
    }

    @Test
    public void equalsTest() {
        var otherHomePanel = new HomePanel(0);
        Assertions.assertTrue(otherHomePanel.equals(homePanel));
        Assertions.assertFalse(otherHomePanel.equals(bonusPanel));
    }

    @Test
    public void homePanelTest() {
        suguri.setCurrentHp(3);
        Assertions.assertEquals(3, suguri.getCurrentHp());
        homePanel.activatedBy(suguri);
        Assertions.assertEquals(4, suguri.getCurrentHp());
        homePanel.activatedBy(suguri);
        Assertions.assertEquals(4, suguri.getCurrentHp());
    }

    @Test
    public void enemyPanelsTest(){
        AbstractEnemy chicken = new WildUnit("Chicken", 3, 1, 1, 1);
        Assertions.assertFalse(encounterPanel.hasEnemyInPanel());
        encounterPanel.addEnemy(chicken);
        Assertions.assertTrue(encounterPanel.hasEnemyInPanel());
        encounterPanel.removeEnemy(chicken);
        Assertions.assertFalse(encounterPanel.hasEnemyInPanel());

    }

    @RepeatedTest(100)
    public void bonusPanelConsistencyTest() {
        final long testSeed = new Random().nextLong();
        int expectedStars = 10;
        assertEquals(expectedStars, suguri.getStars());
        final var testRandom = new Random(testSeed);
        suguri.setSeed(testSeed);
        for (int normaLvl = 1; normaLvl <= 6; normaLvl++) {
            final int roll = testRandom.nextInt(6) + 1;
            bonusPanel.activatedBy(suguri);
            expectedStars += roll * Math.min(3, normaLvl);
            assertEquals(expectedStars, suguri.getStars(),
                    "Test failed with seed: " + testSeed);
            suguri.normaClear();
        }
    }

    @RepeatedTest(100)
    public void dropPanelConsistencyTest() {
        final long testSeed = new Random().nextLong();
        final var testRandom = new Random(testSeed);
        var stars = 10;
        suguri.setSeed(testSeed);
        for (int normaLvl = 1; normaLvl <= 6; normaLvl++) {
            final int roll = testRandom.nextInt(6) + 1;
            dropPanel.activatedBy(suguri);
            stars = Math.max(stars - roll * normaLvl, 0);
            assertEquals(stars, suguri.getStars(),
                    "Test failed with seed: " + testSeed);
            suguri.normaClear();
        }
    }
}