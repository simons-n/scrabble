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

/**
 *
 * @author calw001
 */
public class Tile {

    private Val letter;
    private int score;

    public Tile(Val letter) { //use getOrdinal to get index position of enum
        //use getValue to get the letter
        this.letter = letter;
        this.score = letter.getScore();
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
