/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Caroline Whitman, Jenna Slusar, Nick Simons
 * Date: Nov 8, 2015
 * Time: 4:46:08 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: Word
 * Description: Represents the word made by the player with the tiles
 *
 * ****************************************
 */
package Scrabble.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jms107
 */
public class Word {
    private List<Tile> tilesInWord = new ArrayList<>();

    public Word(ArrayList tilesInWord) {
        this.tilesInWord = tilesInWord;
    }

    public void setTilesInWord(List<Tile> tilesInWord, Tile placedTile) {
        this.tilesInWord = tilesInWord;
        //add the tiles that are placed from the GUI
    }

    public boolean check() {
        //check if word is in scrabble dictionary
        return true;
    }

}
