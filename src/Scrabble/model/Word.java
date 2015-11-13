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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 *
 * @author jms107
 */
public class Word {
    private ArrayList<Tile> tilesInWord = new ArrayList<>();

    public Word(ArrayList tilesInWord) {
        this.tilesInWord = tilesInWord;
    }

    public void setTilesInWord(ArrayList<Tile> tilesInWord, Tile placedTile) {
        this.tilesInWord = tilesInWord;
        //add the tiles that are placed from the GUI
    }

    /**
     * https://docs.oracle.com/javase/tutorial/networking/urls/connecting.html
     *
     * @return
     */
    public boolean check() {
        //check if word is in scrabble dictionary
        try {
            URL scrabbleDict = new URL(
                    "http://www.hasbro.com/scrabble-2/en_US/search.cfm");
            URLConnection scrabbleDictConnection = scrabbleDict.openConnection();
            scrabbleDictConnection.connect();

            System.out.println("connected");
        } catch (MalformedURLException e) {
            // URL failed
        } catch (IOException e) {
            // openConnection() failed
        }
        return true;
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
    public static void main(String args[]) {
        ArrayList<Tile> list = new ArrayList<>();
        list.add(new Tile(Val.C));
        list.add(new Tile(Val.A));
        list.add(new Tile(Val.T));
        System.out.println(list);

        Word w = new Word(list);
        w.check();
        System.out.println("word " + w);
        System.out.println(w.scoreWord());
    }

}
