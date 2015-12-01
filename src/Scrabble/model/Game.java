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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author calw001
 */
public class Game {

    ScrabbleBoard theBoard;
    GameSize gameSize;
    TileBag tileBag = new TileBag();
    ArrayList playerList = new ArrayList();
    Player curPlayer;

    //make game take no parameters
    //create an addPlayer class to add player to the game once it is already created
    public Game(GameSize gameSize) {
        this.theBoard = new ScrabbleBoard(this);
        this.gameSize = gameSize;
    }

    public void setTheBoard(ScrabbleBoard board) {
        this.theBoard = board;
        this.tileBag = theBoard.getTileBag();
    }

    public void setCurPlayer(Player playah) {
        curPlayer = playah;
    }

    public GameSize getGameSize() {
        return gameSize;
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

    public Player getCurPlayer() {

        return curPlayer;
    }

    public ArrayList getPlayerList() {
        return playerList;
    }

    public ScrabbleBoard getTheBoard() {
        return theBoard;
    }

    public TileBag getTileBag() {
        return tileBag;
    }

    public Game getGame() {
        return this;
    }

//    public static void main(String[] args) {
//        Game g = new Game(GameSize.TWO_PLAYER, new Player("Caroline"));
//        g.addPlayer(new Player("Jenna"));
//        String[] a = {""};
//        ScrabbleMain.main(a);
//    }
}
