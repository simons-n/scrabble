/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Nov 20, 2015
 * Time: 10:30:23 AM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: Game
 * Description:
 *
 * ****************************************
 */
package Scrabble.model;

import Scrabble.view.ScrabbleBoard;

/**
 *
 * @author calw001
 */
public class Game {

    ScrabbleBoard theBoard;
    GameSize gameSize;
    TileBag tileBag;

    public Game(GameSize gameSize) {
        theBoard = new ScrabbleBoard();
        this.gameSize = gameSize;
        this.tileBag = new TileBag();
    }

}
