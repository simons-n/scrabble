/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Dec 7, 2015
 * Time: 10:47:12 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: HandTest
 * Description:
 *
 * ****************************************
 */
package Scrabble.model;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author nrs007
 */
public class HandTest {

    private ArrayList<Tile> tilesInHand;
    private Player player;
    private Hand myHand;
    private Game game;
    private GameSize gameSize;

    public HandTest() {
    }

    @Before
    public void setUp() {
        tilesInHand = new ArrayList<Tile>(Arrays.asList(new Tile(Val.T),
                                                        new Tile(Val.U),
                                                        new Tile(Val.R),
                                                        new Tile(Val.T),
                                                        new Tile(Val.L),
                                                        new Tile(Val.E),
                                                        new Tile(Val.S)));
        player = new Player("Nick");

        game = new Game(GameSize.ONE_PLAYER, player);
        player.setGame(game);
        myHand = new Hand(tilesInHand, player);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of containsTile method, of class Hand.
     */
    @Test
    public void testContainsTile() {
        System.out.println("containsTile");
        Tile tile = new Tile(Val.U);
        boolean expResult = true;
        boolean result = myHand.containsTile(tile);
        assertEquals(expResult, result);

    }

    /**
     * Test of addTileFromBoard method, of class Hand.
     */
    @Test
    public void testAddTileFromBoard() {
        System.out.println("addTileFromBoard");
        Tile tile = new Tile(Val.P);
        myHand.addTileFromBoard(tile);
        ArrayList<Tile> expectedHand = new ArrayList<Tile>(Arrays.asList(
                new Tile(Val.T),
                new Tile(Val.U),
                new Tile(Val.R),
                new Tile(Val.T),
                new Tile(Val.L),
                new Tile(Val.E),
                new Tile(Val.S), new Tile(Val.P)));
        ArrayList<Tile> resultHand = myHand.getTilesInHand();
        for (int i = 0; i < resultHand.size(); i++) {
            assertTrue(
                    resultHand.get(i).getLetter() == expectedHand.get(i).getLetter());
        }
    }

    /**
     * Test of addTile method, of class Hand.
     */
    @Test
    public void testAddTile() {
        System.out.println("addTile");
        Tile tile = new Tile(Val.P);
        myHand.addTile(tile);
        ArrayList<Tile> expectedHand = new ArrayList<Tile>(Arrays.asList(
                new Tile(Val.T),
                new Tile(Val.U),
                new Tile(Val.R),
                new Tile(Val.T),
                new Tile(Val.L),
                new Tile(Val.E),
                new Tile(Val.S), new Tile(Val.P)));
        ArrayList<Tile> resultHand = myHand.getTilesInHand();
        for (int i = 0; i < resultHand.size(); i++) {
            assertTrue(
                    resultHand.get(i).getLetter() == expectedHand.get(i).getLetter());
        }
    }

    /**
     * Test of removeTile method, of class Hand.
     */
    @Test
    public void testRemoveTile() {
        System.out.println("removeTile");
        Tile tileToRemove = new Tile(Val.S);
        System.out.println("myhand b4: " + myHand.getTilesInHand());
        myHand.removeTile(tileToRemove);
        ArrayList<Tile> expectedHand = new ArrayList<Tile>(Arrays.asList(
                new Tile(Val.T),
                new Tile(Val.U),
                new Tile(Val.R),
                new Tile(Val.T),
                new Tile(Val.L),
                new Tile(Val.E), new Tile(Val.S)));
        System.out.println("exp size: " + expectedHand.size());

        ArrayList<Tile> resultHand = myHand.getTilesInHand();
        System.out.println("real size: " + resultHand.size());
        System.out.println("handassdf " + resultHand);
        for (int i = 0; i < resultHand.size(); i++) {
            assertTrue(
                    resultHand.get(i).getLetter() == expectedHand.get(i).getLetter());
        }
        fail("no");
    }

    /**
     * Test of switchTiles method, of class Hand.
     */
    @Test
    public void testSwitchTiles() {
        System.out.println("switchTiles");
        Tile myTile = null;
        Tile pickedUpTile = null;

        myHand.switchTiles(myTile, pickedUpTile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffle method, of class Hand.
     */
    @Test
    public void testShuffle() {
        System.out.println("shuffle");

        myHand.shuffle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
