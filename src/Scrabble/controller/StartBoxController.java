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

    public StartBoxController(StartBox window) {
        this.view = window;
        view.getJoinExistingGameBtn().addActionListener(this);
        view.getStartNewGameBtn().addActionListener(this);
        view.getIPAddressBtn().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getJoinExistingGameBtn()) {
            if (existingIP == null) {
                JOptionPane.showMessageDialog(null,
                                              "No existing games. Start your own!");
                // create JDialog box saying there are no existing games

            } else {
                String iPOfExistingGame = JOptionPane.showInputDialog(null,
                                                                      "IP address of the game you'd like to join",
                                                                      "Join Game",
                                                                      JOptionPane.WARNING_MESSAGE);
                try {
                    ScrabbleClient client = new ScrabbleClient(iPOfExistingGame);
                } catch (IOException ex) {
                    Logger.getLogger(StartBoxController.class.getName()).log(
                            Level.SEVERE,
                            null,
                            ex);
                }
                String name = JOptionPane.showInputDialog(null,
                                                          "What's your name?",
                                                          "Enter Name",
                                                          JOptionPane.WARNING_MESSAGE);
                Player p2 = new Player(name, scrabbleServer);
            }

        }
        if (e.getSource() == view.getStartNewGameBtn()) {
            // ask for name and create a player

            String name = JOptionPane.showInputDialog(null, "What's your name?",
                                                      "Enter Name",
                                                      JOptionPane.WARNING_MESSAGE);

            String[] numPlayers = {"2", "3", "4"};
            String n = (String) JOptionPane.showInputDialog(null,
                                                            "How many players would you like in this game?",
                                                            "Number of Players",
                                                            JOptionPane.QUESTION_MESSAGE,
                                                            null,
                                                            numPlayers,
                                                            numPlayers[0]);

            // number of players to wait
            int size = Integer.valueOf(n);
            // sets default game to a two-player game
            GameSize gameSize = GameSize.TWO_PLAYER;

            if (size == 3) {
                gameSize = GameSize.THREE_PLAYER;
            }
            if (size == 4) {
                gameSize = GameSize.FOUR_PLAYER;
            }

            try {
                scrabbleServer = new ScrabbleServer();
            } catch (IOException ex) {
                Logger.getLogger(StartBoxController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            }

            Game theGame = new Game(gameSize);
            Player p1 = new Player(name,
                                   scrabbleServer
            );
            System.out.println(p1);
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
