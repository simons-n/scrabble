/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Nov 17, 2015
 * Time: 6:22:47 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.controller
 * File: StartAGameController
 * Description:
 *
 * ****************************************
 */
package Scrabble.controller;

import Scrabble.main.ScrabbleMain;
import Scrabble.model.Game;
import Scrabble.model.GameSize;
import Scrabble.model.Player;
import Scrabble.model.ScrabbleClient;
import Scrabble.model.ScrabbleServer;
import Scrabble.view.StartBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author calw001
 */
public class StartBoxController implements ActionListener {

    StartBox view;
    InetAddress existingIP = null;
    ScrabbleServer scrabbleServer;
    Game theGame;

    public StartBoxController(StartBox window) {
        this.view = window;
        view.getJoinExistingGameBtn().addActionListener(this);
        view.getStartNewGameBtn().addActionListener(this);
        view.getIPAddressBtn().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getJoinExistingGameBtn()) {
//            if (existingIP == null) {
//                JOptionPane.showMessageDialog(null,
//                                              "No existing games. Start your own!");
//                // create JDialog box saying there are no existing games
//
//            } else {
            String iPOfExistingGame = JOptionPane.showInputDialog(null,
                                                                  "IP address of the game you'd like to join",
                                                                  "Join Game",
                                                                  JOptionPane.WARNING_MESSAGE);
            try {
                ScrabbleClient client = new ScrabbleClient(iPOfExistingGame);
                System.out.println("created client");
                this.theGame = client.getTheGame();
                System.out.println("got the game");

                String name = JOptionPane.showInputDialog(null,
                                                          "What's your name?",
                                                          "Enter Name",
                                                          JOptionPane.WARNING_MESSAGE);
                Player newPlayer = new Player(name, scrabbleServer);
                theGame.addPlayer(newPlayer);
                System.out.println("Added player: " + newPlayer);
                if (theGame.hasEnoughPlayers()) {
                    System.out.println("starting game");
                    ScrabbleMain startScrabbleGame = new ScrabbleMain();
                    // start the Scrabble game!
                }
            } catch (IOException ex) {
                Logger.getLogger(StartBoxController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StartBoxController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            }

            //}
        }
        if (e.getSource() == view.getStartNewGameBtn()) {
            // ask for name and create a player

            String name = JOptionPane.showInputDialog(null, "What's your name?",
                                                      "Enter Name",
                                                      JOptionPane.WARNING_MESSAGE);

            String[] numPlayers = {"1", "2", "3", "4"};
            String n = (String) JOptionPane.showInputDialog(null,
                                                            "How many players would you like in this game?",
                                                            "Number of Players",
                                                            JOptionPane.QUESTION_MESSAGE,
                                                            null,
                                                            numPlayers,
                                                            numPlayers[0]);

            // number of players to wait
            int size = Integer.valueOf(n);
            System.out.println("size " + size);

            try {
                existingIP = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                Logger.getLogger(StartBoxController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            }

            //set default to two-player
            GameSize gameSize = GameSize.TWO_PLAYER;

            if (size == 1) {
                gameSize = GameSize.ONE_PLAYER;
            } else if (size == 3) {
                gameSize = GameSize.THREE_PLAYER;
            } else if (size == 4) {
                gameSize = GameSize.FOUR_PLAYER;
            }

            try {
                System.out.println("x");
                if (gameSize.getValue() != 1) {
                    scrabbleServer = new ScrabbleServer(gameSize.getValue());
                } else {
                    // create a dummy server so I can get the Game
                    scrabbleServer = new ScrabbleServer();
                }
                System.out.println("a");
            } catch (IOException ex) {
                Logger.getLogger(StartBoxController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            }
            System.out.println("finished creating server");

            Player gameCreator = new Player(name,
                                            scrabbleServer);

            //this.theGame = scrabbleServer.createGame(gameSize, gameCreator);
            this.theGame = new Game(gameSize, gameCreator);

            System.out.println(theGame.getNumConnectedPlayers());
            System.out.println(gameSize.getValue());

            if (theGame.hasEnoughPlayers()) {
                System.out.println("hopefully Scrabble window pops up");
                String[] a = {""};
                ScrabbleMain.main(a);
                // start the Scrabble game!
            }

            System.out.println("Game Creator: " + gameCreator);
        }
        if (e.getSource() == view.getIPAddressBtn()) {
            System.out.println("ip address button pressed");

            InetAddress localaddr;
            try {
                localaddr = InetAddress.getLocalHost();
                System.out.println(localaddr);
                JOptionPane.showMessageDialog(null,
                                              "This computer's IP address: " + "\n" + localaddr);
            } catch (UnknownHostException ex) {
                Logger.getLogger(StartBoxController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            }

        }

    }

}
