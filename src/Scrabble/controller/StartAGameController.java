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

import Scrabble.view.StartAGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

/**
 *
 * @author calw001
 */
public class StartAGameController implements ActionListener {

    StartAGame view;
    InetAddress existingIP = null;

    public StartAGameController(StartAGame window) {
        this.view = window;
        view.getJoinExistingGameBtn().addActionListener(this);
        view.getStartNewGameBtn().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getJoinExistingGameBtn()) {
            if (existingIP == null) {
                // create JDialog box saying there are no existing games
            }

            // create client
            // get IP of server
        }
        if (e.getSource() == view.getStartNewGameBtn()) {
            // ask user for name and create player

        }

    }

}
