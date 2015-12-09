/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Dec 8, 2015
 * Time: 7:49:07 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: TileBagTest
 * Description:
 *
 * ****************************************
 */
package Scrabble.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author nrs007
 */
public class TileBagTest {

    public TileBagTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTileBagSize method, of class TileBag.
     */
    @Test
    public void testGetTileBagSize() {
        System.out.println("getTileBagSize");
        TileBag instance = new TileBag();
        int expResult = 0;
        int result = instance.getTileBagSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTileBagSizeStr method, of class TileBag.
     */
    @Test
    public void testGetTileBagSizeStr() {
        System.out.println("getTileBagSizeStr");
        TileBag instance = new TileBag();
        String expResult = "";
        String result = instance.getTileBagSizeStr();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTile method, of class TileBag.
     */
    @Test
    public void testAddTile() {
        System.out.println("addTile");
        Tile tile = null;
        TileBag instance = new TileBag();
        instance.addTile(tile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTile method, of class TileBag.
     */
    @Test
    public void testRemoveTile() {
        System.out.println("removeTile");
        Tile tile = null;
        TileBag instance = new TileBag();
        instance.removeTile(tile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of draw method, of class TileBag.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        TileBag instance = new TileBag();
        Tile expResult = null;
        Tile result = instance.draw();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
