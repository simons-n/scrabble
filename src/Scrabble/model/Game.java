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

import Scrabble.view.Board;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
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
    private ArrayList<String> wordsPlayed = new ArrayList();

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

    public void addWordToWordsPlayedList(String wordToAdd) {
        wordsPlayed.add(wordToAdd);
    }

    public ArrayList<String> getWordsPlayed() {
        return wordsPlayed;
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

    public int getNumConnectedPlayers() {
        return playerList.size();
    }

    public void playGame() {
    }

    public boolean getHasEnoughPlayers() {
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

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

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

//    public static void main(String[] args) {
//        Game g = new Game(GameSize.TWO_PLAYER, new Player("Caroline"));
//        g.addPlayer(new Player("Jenna"));
//        String[] a = {""};
//        ScrabbleMain.main(a);
//    }
}
