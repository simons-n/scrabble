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

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jms107
 */
public class Word {

    private ScrabbleDictionary dictionary;
    private ArrayList<Tile> tilesInWord;
    private String word;

    public Word(ArrayList<Tile> tilesInWord, ScrabbleDictionary dict) {
        this.dictionary = dict;
        this.tilesInWord = tilesInWord;
        this.word = "";
        for (Tile tile : tilesInWord) {
            word += tile.getLetter();
        }

    }

    public void clearTilesInWord() {
        //clear the list when turn is ended
        this.tilesInWord.clear();
    }

    public void removeTileInWord() {
        //use this when a tile is placed on the board then taken off the board in same turn

    }

    public void setTilesInWord(ArrayList<Tile> tilesInWord, Tile placedTile) {
        this.tilesInWord = tilesInWord;
        //when a tile is placed onto the board add it to the tilesInWord

    }

    /**
     * https://docs.oracle.com/javase/tutorial/networking/urls/connecting.html
     *
     * @return
     */
    public boolean check() {
        //check if word is in scrabble dictionary
        return dictionary.containsKey(word);
    }

    public int scoreWord() {
        int score = 0;
        for (int i = 0; i < tilesInWord.size(); i++) {
            score += tilesInWord.get(i).getScore();
        }
        return score;
    }

    public ArrayList<Tile> getTilesInWord() {
        return tilesInWord;
    }

    public String toString() {
        String s = "";
        for (Tile tile : getTilesInWord()) {
            s += tile.getLetter();
        }
        return s;
    }

    // checking if scoreWord() works
    public static void main(String args[]) throws IOException {
        ArrayList<Tile> list = new ArrayList<>();
        list.add(new Tile(Val.C));
        list.add(new Tile(Val.A));
        list.add(new Tile(Val.T));
        System.out.println(list);

        ScrabbleDictionary dict = new ScrabbleDictionary();
        Word w = new Word(list, dict);
        w.check();
        System.out.println("word " + w);
        System.out.println(w.scoreWord());
    }

}
