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

import Scrabble.model.Player;
import Scrabble.model.ScrabbleClient;
import Scrabble.model.ScrabbleServer;
import Scrabble.view.StartBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
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

            try {
                scrabbleServer = new ScrabbleServer();
            } catch (IOException ex) {
                Logger.getLogger(StartBoxController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            }
            Player p1 = new Player(name, scrabbleServer);
            System.out.println(p1);
        }

    }

}
