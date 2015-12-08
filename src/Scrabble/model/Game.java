 /* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Jenna Slusar, Caroline Whitman, and Nick Simons
 * Date: Nov 20, 2015
 * Time: 10:30:23 AM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: Game
 * Description: This class connects all of the model classes and is created in startbox.
 * ****************************************
 */
package Scrabble.model;

import Scrabble.view.Board;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Only one Game class is made, but it connects all of the other model classes
 *
 * @author calw001
 */
public class Game implements Serializable {

    Board mainBoard = new Board();
    GameSize gameSize;
    transient TileBag tileBag = new TileBag();
    ArrayList<Player> playerList = new ArrayList();
    Player curPlayer;
    transient Player gameOwner;

    //make game take no parameters
    //create an addPlayer class to add player to the game once it is already created
    public Game(GameSize gameSize) {
        //this.mainBoard = new ScrabbleBoard(this);
        this.gameSize = gameSize;
        setTheBoard(mainBoard);
    }

    public Game(GameSize gameSize, Player gameOwner) {
        this.gameSize = gameSize;
        this.gameOwner = gameOwner;
    }

    public void setTheBoard(Board board) {
        this.mainBoard = board;
    }

    public void setCurPlayer(Player playah) {
        curPlayer = playah;
    }

    public GameSize getGameSize() {
        return gameSize;
    }

    public Player getGameOwner() {
        return gameOwner;
    }

    /**
     * Returns the size of the list of players, to get the number of players
     * connected
     *
     * @return playerList.size()
     */
    public int getNumConnectedPlayers() {
        return playerList.size();
    }

    /**
     * Checks if the number of players equals the correct size of the game.
     *
     * @return true, if they're equal, else false
     */
    public boolean getHasEnoughPlayers() {
        if (playerList.size() == gameSize.getValue()) {
            return true;
        }
        return false;
    }

    /**
     * Adds players to the player list, unless the game is already full.
     *
     * @param playerToAdd
     */
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

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    /**
     * Sets each player's board in the player list to the mainBoard.
     */
    public void updatePlayerBoards() {
        for (Player player : playerList) {
            player.setMyBoard(mainBoard);
        }
    }

    public Board getTheBoard() {
        return mainBoard;
    }

    public TileBag getTileBag() {
        return tileBag;
    }

    public Game getGame() {
        return this;
    }
}
