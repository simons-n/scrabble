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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author jms107
 */
public class Word {

    private ScrabbleDictionary dictionary;
    private ArrayList<Tile> tilesInWord;
    private String word;
    private JLabel[][] grid;
    private Game game;
    private ArrayList<String> boardText;

    private boolean doubleWord = false;
    private boolean tripleWord = false;
    private boolean doubleLetter = false;
    private boolean tripleLetter = false;
    Val val;

    public Word(String word) throws IOException {
        this.word = word;
        dictionary = new ScrabbleDictionary();
    }

    public Word(JLabel[][] grid, Game game, ArrayList<String> boardText) throws IOException {
        this.grid = grid;
        this.word = "";
        this.game = game;
        this.boardText = boardText;
        this.dictionary = new ScrabbleDictionary();
    }

    public Word(ArrayList<Tile> tilesInWord, ScrabbleDictionary dict) {
        this.dictionary = dict;
        this.tilesInWord = tilesInWord;
        this.word = "";
//        for (Tile tile : tilesInWord) {
//            word += tile.getLetter();
//        }

    }

    public Word(String word, ScrabbleDictionary dict) {
        this.dictionary = dict;
        this.word = word;
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

    public int scoreWord(int x, int y) {
        int horizStart = findStartOfWordHorizDir(x, y);
        int horizEnd = findEndOfWordHorizDir(x, y);
        int vertStart = findStartOfWordVertDir(x, y);
        int vertEnd = findEndOfWordVertDir(x, y);

        int totalTurnScore = 0;

        String wordPlayed = "";

        //check if word played is horizontal
        if (vertStart == vertEnd) {

            wordPlayed = getHorizDirWordFromGrid(horizStart, horizEnd, vertStart);
            if (check(wordPlayed) == false) {
                JOptionPane.showMessageDialog(null,
                                              wordPlayed + " is not a valid word! Please try again.");
                return 0;
            }
            totalTurnScore += calculateScore(wordPlayed);

            for (int i = horizStart; i < horizEnd + 1; i++) {

                int start = findStartOfWordVertDir(vertStart, i);
                int end = findEndOfWordVertDir(vertStart, i);
                String crossWord = "";
                crossWord = getVertDirWordFromGrid(start, end, i);

                if (start == end || crossWord.length() == 0) {

                    return totalTurnScore;
                }

                if (check(crossWord) == false) {
                    JOptionPane.showMessageDialog(null,
                                                  crossWord + " is not a valid word! Please try again.");
                    return 0;
                }

                if (!hasBeenPlayed(crossWord)) {

                    totalTurnScore += calculateScore(crossWord);
                }

            }
        } //check if word played is vertical
        else if (horizStart == horizEnd) {

            wordPlayed = getVertDirWordFromGrid(vertStart, vertEnd, horizStart);

            if (!check(wordPlayed)) {
                JOptionPane.showMessageDialog(null,
                                              wordPlayed + " is not a valid word! Please try again.");
                return 0;
            }
            totalTurnScore += calculateScore(wordPlayed);

            for (int j = vertStart; j < vertEnd; j++) {
                int start;
                int end;

                start = findStartOfWordHorizDir(j, horizStart);

                end = findEndOfWordHorizDir(horizStart, j);

                String crossWord = "";
                crossWord = getHorizDirWordFromGrid(start, end, j);

                if (start == end || crossWord.length() == 0) {

                    return totalTurnScore;
                }

                if (!check(crossWord)) {
                    JOptionPane.showMessageDialog(null,
                                                  crossWord + " is not a valid word! Please try again.");
                    return 0;
                }

                if (!hasBeenPlayed(crossWord)) {

                    totalTurnScore += calculateScore(crossWord);
                }
            }
        }
        return totalTurnScore;
    }

    public int calculateScore(String word) {

        int score = 0;

        for (int i = 0; i < word.length(); i++) {
            Val tileVal = val.valueOf(word.substring(i, i + 1));
            score += tileVal.getScore();
        }

//        for (int j = 0; j < bonusType.size(); j++) {
//            if () {
//
//            }
//        }
        return score;
    }

    public String getVertDirWordFromGrid(int xDirStart, int xDirEnd, int y) {
        this.word = "";
        for (int i = xDirStart; i < xDirEnd + 1; i++) {

            this.word += grid[i][y].getToolTipText();
        }

        return this.word.toUpperCase();
    }

    public int findStartOfWordVertDir(int x, int y) {

        while (!boardText.contains(grid[x][y].getToolTipText()) && (x > 0)) {

            x--;
        }
        if (x != 0) {
            return x + 1;
        } else {
            return x;
        }

    }

    public int findEndOfWordVertDir(int x, int y) {

        while ((!boardText.contains(grid[x][y].getToolTipText())) && (x < grid.length - 1)) {

            x++;
        }
        if (x != grid.length - 1) {
            return x - 1;
        } else {
            return x;
        }
    }

    public String getHorizDirWordFromGrid(int yDirStart, int yDirEnd, int x) {
        this.word = "";
        for (int i = yDirStart; i < yDirEnd + 1; i++) {

            this.word += grid[x][i].getToolTipText();
        }

        return this.word.toUpperCase();
    }

    public int findStartOfWordHorizDir(int x, int y) {
        while ((!boardText.contains(grid[x][y].getToolTipText())) && (y > 0)) {
            y--;
        }
        if (y != grid.length - 1) {
            return y + 1;
        } else {
            return y;
        }
    }

    public int findEndOfWordHorizDir(int x, int y) {
        while ((!boardText.contains(grid[x][y].getToolTipText())) && (y < grid.length - 1)) {
            y++;
        }
        if (y != grid.length - 1) {
            return y - 1;
        } else {
            return y;
        }
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

    public boolean check(String word) {
        return dictionary.containsKey(word);
    }

    public boolean hasBeenPlayed(String word) {
        if (game.getWordsPlayed().indexOf(word) > 0) {
            return true;
        }
        return false;
    }

//    public int scoreWord() {
//        int score = 0;
//        for (int i = 0; i < tilesInWord.size(); i++) {
//            score += tilesInWord.get(i).getScore();
//        }
//        return score;
//    }
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

    public String getWord() {
        return word;
    }

    // checking if scoreWord() works
//    public static void main(String args[]) throws IOException {
//        ArrayList<Tile> list = new ArrayList<>();
//        list.add(new Tile(Val.C));
//        list.add(new Tile(Val.A));
//        list.add(new Tile(Val.T));
//        System.out.println(list);
//
//        ScrabbleDictionary dict = new ScrabbleDictionary();
//        Word w = new Word("NO", dict);
//        w.check();
//        System.out.println(w.check());
//        System.out.println("word " + w);
////        System.out.println(w.scoreWord());
//    }
}
