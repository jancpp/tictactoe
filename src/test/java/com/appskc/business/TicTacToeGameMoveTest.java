package com.appskc.business;

import org.junit.*;
import org.junit.rules.TestName;

import com.appskc.business.TicTacToeGameMove;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * JUnit Demo
 * use assertEquals, assertTrue (with and without message
 */
public class TicTacToeGameMoveTest {

    private TicTacToeGameMove move;
    private final int id = 3;
    private final int x = 1;
    private final int y = 1;
    private final char player = 'X';

    // https://github.com/junit-team/junit4/wiki/rules (JUnit interceptors)
    @Rule
    public final TestName name = new TestName();

    @BeforeClass
    public static void beforeClass() {
        // called once on class initialization time
    }

    @AfterClass
    public static void afterClass() {
        // called once after all methods are executed
    }

    @Before
    public void before() {
        // called before each method execution
        // init a move
    	move = new TicTacToeGameMove(id, player, x, y);

    }

    @After
    public void after() {
        // called after each method execution
    	move = null;
    }

    // check id is set after instantiation
    @Test
    public void whenInstantiated_ThenIdIsSet() {
    	assertEquals("Asserting that id is set in constructor", id, move.getId());
    }

    // check x is set after instantiation
    @Test
    public void whenInstantiated_ThenXIsSet() {
    	assertEquals("Asserting that X is set after move", x, move.getX());
    }

    // check y is set after instantiation
    @Test
    public void whenInstantiated_ThenYIsSet() {
    	assertEquals("Asserting that Y is set after move", y, move.getY());
    }

    // check player is set after instantiation
    @Test
    public void whenInstantiated_ThenPlayerIsSet() {
    	assertEquals("Asserting that player is set in constructor", player, move.getPlayer());
    }

    // check allowedChars are O and X after instantiation
    @Test
    public void whenInstantiated_ThenAllowedCharsAreOandX() {
    	List<Character> expectedCharacters = Arrays.asList('X');
    	assertTrue(move.getAllowedChars().containsAll(expectedCharacters));
    	assertEquals(2, move.getAllowedChars().size());
    }

    // check Rule TestName.getMethodName
    @Test
    public void whenGetMethodNameOfTestNameRuleInvoked_ThenReturnNameOfThisTest() {
    	assertEquals("whenGetMethodNameOfTestNameRuleInvoked_ThenReturnNameOfThisTest", name.getMethodName());
    }

}