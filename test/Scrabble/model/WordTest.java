/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Dec 8, 2015
 * Time: 7:50:14 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: WordTest
 * Description:
 *
 * ****************************************
 */
package Scrabble.model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author nrs007
 */
public class WordTest {

    public WordTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of clearTilesInWord method, of class Word.
     */
    @Test
    public void testClearTilesInWord() {
        System.out.println("clearTilesInWord");
        Word instance = null;
        instance.clearTilesInWord();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTileInWord method, of class Word.
     */
    @Test
    public void testRemoveTileInWord() {
        System.out.println("removeTileInWord");
        Word instance = null;
        instance.removeTileInWord();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTilesInWord method, of class Word.
     */
    @Test
    public void testSetTilesInWord() {
        System.out.println("setTilesInWord");
        ArrayList<Tile> tilesInWord = null;
        Tile placedTile = null;
        Word instance = null;
        instance.setTilesInWord(tilesInWord, placedTile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scoreWord method, of class Word.
     */
    @Test
    public void testScoreWord() {
        System.out.println("scoreWord");
        int x = 0;
        int y = 0;
        Word instance = null;
        int expResult = 0;
        int result = instance.scoreWord(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateScore method, of class Word.
     */
    @Test
    public void testCalculateScore() {
        System.out.println("calculateScore");
        String word = "";
        Word instance = null;
        int expResult = 0;
        int result = instance.calculateScore(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVertDirWordFromGrid method, of class Word.
     */
    @Test
    public void testGetVertDirWordFromGrid() {
        System.out.println("getVertDirWordFromGrid");
        int xDirStart = 0;
        int xDirEnd = 0;
        int y = 0;
        Word instance = null;
        String expResult = "";
        String result = instance.getVertDirWordFromGrid(xDirStart, xDirEnd, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findStartOfWordVertDir method, of class Word.
     */
    @Test
    public void testFindStartOfWordVertDir() {
        System.out.println("findStartOfWordVertDir");
        int x = 0;
        int y = 0;
        Word instance = null;
        int expResult = 0;
        int result = instance.findStartOfWordVertDir(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEndOfWordVertDir method, of class Word.
     */
    @Test
    public void testFindEndOfWordVertDir() {
        System.out.println("findEndOfWordVertDir");
        int x = 0;
        int y = 0;
        Word instance = null;
        int expResult = 0;
        int result = instance.findEndOfWordVertDir(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHorizDirWordFromGrid method, of class Word.
     */
    @Test
    public void testGetHorizDirWordFromGrid() {
        System.out.println("getHorizDirWordFromGrid");
        int yDirStart = 0;
        int yDirEnd = 0;
        int x = 0;
        Word instance = null;
        String expResult = "";
        String result = instance.getHorizDirWordFromGrid(yDirStart, yDirEnd, x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findStartOfWordHorizDir method, of class Word.
     */
    @Test
    public void testFindStartOfWordHorizDir() {
        System.out.println("findStartOfWordHorizDir");
        int x = 0;
        int y = 0;
        Word instance = null;
        int expResult = 0;
        int result = instance.findStartOfWordHorizDir(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findEndOfWordHorizDir method, of class Word.
     */
    @Test
    public void testFindEndOfWordHorizDir() {
        System.out.println("findEndOfWordHorizDir");
        int x = 0;
        int y = 0;
        Word instance = null;
        int expResult = 0;
        int result = instance.findEndOfWordHorizDir(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of check method, of class Word.
     */
    @Test
    public void testCheck_0args() {
        System.out.println("check");
        Word instance = null;
        boolean expResult = false;
        boolean result = instance.check();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of check method, of class Word.
     */
    @Test
    public void testCheck_String() {
        System.out.println("check");
        String word = "";
        Word instance = null;
        boolean expResult = false;
        boolean result = instance.check(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkHasBeenPlayed method, of class Word.
     */
    @Test
    public void testHasBeenPlayed() {
        System.out.println("hasBeenPlayed");
        String word = "";
        Word instance = null;
        boolean expResult = false;
        boolean result = instance.checkHasBeenPlayed(word);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTilesInWord method, of class Word.
     */
    @Test
    public void testGetTilesInWord() {
        System.out.println("getTilesInWord");
        Word instance = null;
        ArrayList<Tile> expResult = null;
        ArrayList<Tile> result = instance.getTilesInWord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Word.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Word instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWord method, of class Word.
     */
    @Test
    public void testGetWord() {
        System.out.println("getWord");
        Word instance = null;
        String expResult = "";
        String result = instance.getWord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
