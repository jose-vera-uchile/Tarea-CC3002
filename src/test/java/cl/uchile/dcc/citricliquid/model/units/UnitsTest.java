package cl.uchile.dcc.citricliquid.model.units;

import cl.uchile.dcc.citricliquid.model.normas.InterfaceNorma;
import cl.uchile.dcc.citricliquid.model.normas.StarsNorma;
import cl.uchile.dcc.citricliquid.model.normas.WinsNorma;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

class UnitsTest {
    private final static String PLAYER_NAME = "Suguri";
    private Player suguri;
    public InterfaceNorma WinsNorma = new WinsNorma();
    public StarsNorma starsNorma = new StarsNorma();

    private final static String WILD_NAME = "Chicken";
    private WildUnit chicken;

    private final static String BOSS_NAME = "Store Manager";
    private BossUnit storeManager;

    @BeforeEach
    void setUp() {
        suguri = new Player(PLAYER_NAME, 4, 1, 0, 2);
        chicken = new WildUnit(WILD_NAME, 3, 1, 1, 1);
        storeManager = new BossUnit(BOSS_NAME, 8, 3, 2, -1);
    }

    @Test
    public void constructorTest() {
        final var expectedSuguri = new Player(PLAYER_NAME, 4, 1, 0, 2);
        Assertions.assertEquals(expectedSuguri, suguri);
    }

    @Test
    public void getStatsTest() {
        Assertions.assertEquals("Suguri",suguri.getName());
        Assertions.assertEquals(1, suguri.getAtk());
        Assertions.assertEquals(0, suguri.getDef());
        Assertions.assertEquals(2, suguri.getEvd());
    }

    @Test
    public void testStars() {
        Assertions.assertEquals(suguri.getStars(), 0);
        suguri.increaseStarsBy(5);
        Assertions.assertEquals(suguri.getStars(),5);
        suguri.reduceStarsBy(2);
        Assertions.assertEquals(suguri.getStars(),3);
    }

    @Test
    public void testHp() {
        Assertions.assertEquals(suguri.getMaxHp(), 4);
        Assertions.assertEquals(suguri.getCurrentHp(), 4);
        suguri.setCurrentHp(-1);
        Assertions.assertEquals(suguri.getCurrentHp(),0);
        suguri.setCurrentHp(5);
        Assertions.assertNotEquals(suguri.getCurrentHp(), 5);
        Assertions.assertEquals(suguri.getCurrentHp(), 4);
    }

    @Test
    public void testEquals() {
        Assertions.assertTrue(suguri.equals(suguri));
        final var o = new Object();
        Assertions.assertFalse(suguri.equals(o));
        final var expectedSuguri = new Player(PLAYER_NAME, 4, 1, 0, 2);
        Assertions.assertTrue(suguri.equals(expectedSuguri));

        Assertions.assertTrue(chicken.equals(chicken));
        Assertions.assertFalse(chicken.equals(o));
        final var expectedChicken = new WildUnit(WILD_NAME, 3, 1, 1, 1);
        Assertions.assertTrue(chicken.equals(expectedChicken));
    }

    @Test
    public void testWins() {
        Assertions.assertEquals(0, suguri.getWins());
        suguri.increaseWins();
        Assertions.assertEquals(1, suguri.getWins());
    }

    @Test
    public void normaTest() {

        Assertions.assertEquals(1, suguri.getNormaLevel());
        suguri.setNormaGoal(starsNorma);
        Assertions.assertEquals(starsNorma, suguri.getNormaGoal());
        // We test that it doesn't increase without the goal met
        suguri.normaCheck();
        Assertions.assertEquals(1, suguri.getNormaLevel());
        // We match the goal and check that it increase
        suguri.increaseStarsBy(10);
        suguri.normaCheck();
        Assertions.assertEquals(2, suguri.getNormaLevel());
        // Now we try with the other type of objective
        suguri.setNormaGoal(WinsNorma);
        // We increase the wins by 4 and check that it works
        suguri.increaseWins();
        suguri.increaseWins();
        suguri.increaseWins();
        suguri.increaseWins();

        suguri.normaCheck();
        Assertions.assertEquals(3, suguri.getNormaLevel());
    }

    @Test
    public void copyTest() {
        Player expectedSuguri = new Player(PLAYER_NAME, 4, 1, 0, 2);
        Player actualSuguri = suguri.copy();
        // Checks that the copied player have the same parameters as the original
        Assertions.assertEquals(expectedSuguri, actualSuguri);
        // Checks that the copied player doesn't reference the same object
        Assertions.assertNotSame(expectedSuguri, actualSuguri);

        WildUnit expectedChicken = new WildUnit(WILD_NAME, 3, 1, 1, 1);
        WildUnit actualChicken = chicken.copy();
        // Checks that the copied player have the same parameters as the original
        Assertions.assertEquals(expectedChicken, actualChicken);
        // Checks that the copied player doesn't reference the same object
        Assertions.assertNotSame(expectedChicken, actualChicken);

        BossUnit expectedStoreManager = new BossUnit(BOSS_NAME, 8, 3, 2, -1);
        BossUnit actualStoreManager = storeManager.copy();
        // Checks that the copied player have the same parameters as the original
        Assertions.assertEquals(expectedStoreManager, actualStoreManager);
        // Checks that the copied player doesn't reference the same object
        Assertions.assertNotSame(expectedStoreManager, actualStoreManager);

    }

    @RepeatedTest(100)
    public void normaClearConsistencyTest() {
        final long testSeed = new Random().nextLong();
        // We're gonna test for 0 to 5 norma clears
        final int iterations = Math.abs(new Random(testSeed).nextInt(6));
        final int expectedNorma = suguri.getNormaLevel() + iterations;
        for (int it = 0; it < iterations; it++) {
            suguri.normaClear();
        }
        Assertions.assertEquals(expectedNorma, suguri.getNormaLevel(),
                "Test failed with random seed: " + testSeed);
    }

    @RepeatedTest(100)
    public void rollConsistencyTest() {
        final long testSeed = new Random().nextLong();
        suguri.setSeed(testSeed);
        final int roll = suguri.roll();
        Assertions.assertTrue(roll >= 1 && roll <= 6,
                roll + "is not in [1, 6]" + System.lineSeparator()
                        + "Test failed with random seed: " + testSeed);
    }
}