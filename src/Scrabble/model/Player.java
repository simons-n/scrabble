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

/**
 *
 * @author jms107
 */
public class Player {
    private String name;
    private int totalScore = 0;
    private Hand myHand;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int totalScore, Hand myHand) {
        this.name = name;
        this.totalScore = totalScore;
        this.myHand = myHand;
    }

    public void setMyHand(Hand myHand) {
        this.myHand = myHand;
    }

    public void playWord() {

    }

    public void pass() {

    }

    public void newHand() {

    }

    public void siwtchTilesInHand() {

    }

    public void shuffleTiles() {

    }
    //rearrange tiles will be handled in GUI

    @Override
    public String toString() {
        return this.name;
    }

}
