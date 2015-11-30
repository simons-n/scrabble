/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Nov 20, 2015
 * Time: 10:35:00 AM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: GameSize
 * Description:
 *
 * ****************************************
 */
package Scrabble.model;

/**
 *
 * @author calw001
 */
public enum GameSize {
    ONE_PLAYER(1), TWO_PLAYER(2), THREE_PLAYER(3), FOUR_PLAYER(4);

    private int value;

    private GameSize() {

    }

    private GameSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
