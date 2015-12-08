/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Caroline Whitman, Jenna Slusar, Nick Simons
 * Date: Nov 8, 2015
 * Time: 3:47:49 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: Tile
 * Description: Represents a tile in the scrabble game
 *
 * ****************************************
 */
package Scrabble.model;

import java.io.Serializable;

/**
 * Tiles for the Scrabble Game
 *
 * @author calw001
 */
public class Tile implements Serializable {

    private Val letter;
    private int score;
    private int x;
    private int y;

    /**
     * Creates a Tile object given a letter
     *
     * @param letter, the Val of the tile to create
     */
    public Tile(Val letter) { //use getOrdinal to get index position of enum
        //use getValue to get the letter
        this.letter = letter;
        this.score = letter.getScore();
    }

    /**
     * Creates a Tile object given a letter and x and y coordinates.
     *
     * @param letter, the Val of the tile to create
     * @param x, an xCoord
     * @param y, a yCoord
     */
    public Tile(Val letter, int x, int y) {
        this.letter = letter;
        this.score = letter.getScore();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getScore() {
        return this.score;
    }

    public Val getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return this.letter + "(" + this.score + ")";
    }

}
