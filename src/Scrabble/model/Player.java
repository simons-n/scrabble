/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Caroline Whitman, Jenna Slusar, Nick Simons
 * Date: Nov 8, 2015
 * Time: 4:06:51 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: Player
 * Description: The actor playing the Scrabble game, and holds all the functions a player can do
 *
 * ****************************************
 */
package Scrabble.model;

import Scrabble.view.ScrabbleBoard;
import java.util.ArrayList;

/**
 *
 * @author jms107
 */
public class Player {
    private String name;
    private int totalScore = 0;
    private Hand myHand;
    // tileBag object will be same for all players
    private TileBag tileBag;
    private boolean skipTurn = false;
    private ArrayList<Tile> discardPile;
    private ScrabbleBoard currBoard;
    private ScrabbleServer scrabbleServer;

    // in action performed, when pass button is pressed, change this back to false
    private boolean hasPassed = true;

    // this is used in the server to see if the player is still in a game, or if someone has won
    boolean inGame = false;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, ScrabbleServer server) {
        this.name = name;
        //this.inGame = true;
        this.scrabbleServer = server;
    }

    // instantiating a player without a hand already created
    public Player(String name, int totalScore) {
        this.name = name;
        this.totalScore = totalScore;
        this.myHand = new Hand(newHand());
    }

//    public Player(String name, int totalScore, Hand myHand) {
//        this.name = name;
//        this.totalScore = totalScore;
//        this.myHand = myHand;
//    }
    public void setSkipTurn() {
        this.skipTurn = !skipTurn;
    }

    public String getName() {
        return name;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public Hand getMyHand() {
        return myHand;
    }

    public boolean isSkipTurn() {
        return skipTurn;
    }

    public ArrayList<Tile> newHand() {
        ArrayList<Tile> hand = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            Tile tile = tileBag.draw();
            hand.add(tile);
        }
        return hand;
    }

    public void updateHand(Hand myHand) {
        this.myHand = myHand;
    }

    public void playWord(Word word) {
        if (word.check()) {
            this.totalScore += word.scoreWord();
        }

    }

//    public Hand getHandView() {
//        return HandView.setHand(myHand);
//    }
    public void setName(String newName) {
        this.name = newName;
    }

    public void pass() {
        // This will pass the turn to the next player in the network, somehow
    }

    public void switchTilesInHand() {
        setSkipTurn();
        for (Tile tile : discardPile) {
            myHand.addTileFromBag(tileBag);
        }
        for (Tile tile : discardPile) {
            tileBag.addTile(tile);
        }
    }

    public void shuffleTiles() {

    }
    //rearrange tiles will be handled in GUI

    public boolean isInGame() {
        return inGame;
    }

    public boolean hasPassed() {
        return hasPassed;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
