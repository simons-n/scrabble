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

import Scrabble.main.ScrabbleMain;
import Scrabble.view.ScrabbleBoard;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author calw001
 */
public class Game {

    ScrabbleBoard theBoard;
    GameSize gameSize;
    TileBag tileBag;
    ArrayList playerList = new ArrayList();

    public Game(GameSize gameSize, Player creatorOfGame) {
        theBoard = new ScrabbleBoard();
        this.gameSize = gameSize;
        this.tileBag = new TileBag();
        playerList.add(creatorOfGame);
    }

    public int getNumConnectedPlayers() {
        return playerList.size();
    }

    public void playGame() {
    }

    public boolean hasEnoughPlayers() {
        if (playerList.size() == gameSize.getValue()) {
            return true;
        }
        return false;
    }

    public void addPlayer(Player playerToAdd) {
        if (playerList.size() < gameSize.getValue()) {
            playerList.add(playerToAdd);
        } else {
            JOptionPane.showMessageDialog(null,
                                          "This game is full! Start a new game.",
                                          "Game is Full",
                                          JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Game g = new Game(GameSize.TWO_PLAYER, new Player("Caroline"));
        g.addPlayer(new Player("Jenna"));
        String[] a = {""};
        ScrabbleMain.main(a);
    }

}
