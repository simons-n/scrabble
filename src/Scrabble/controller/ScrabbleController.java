/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Caroline Whitman, Jenna Slusar, Nick Simons
 * Date: Nov 8, 2015
 * Time: 4:53:01 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.controller
 * File: ScrabbleController
 * Description: Connects model to view
 *
 * ****************************************
 */
package Scrabble.controller;

import Scrabble.model.Hand;
import Scrabble.model.Player;
import Scrabble.model.Word;
import Scrabble.view.ScrabbleBoard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 *
 * @author jms107
 */
public class ScrabbleController implements ActionListener {
// connects model to view

    private ScrabbleBoard view;
    private Hand hand;
    private Player player;
    private Word word;

    public ScrabbleController(ScrabbleBoard view) {
        this.view = view;

    }

    public void createScrabbleController() {
//        for (JLabel[] row : view.getGrid()) {
//            for (JLabel square : row) {
//               square.addActionListener(this);
//            }
//        }
        for (int i = 0; i < view.getGrid().length; i++) {
            for (int j = 0; i < view.getGrid()[0].length; j++) {
                view.getGrid()[i][j].addMouseListener(
                        (MouseListener) view.getGrid()[i][j]);
            }
        }
    }

    public void updateViewFromModel() {

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getPlayBtn()) //check validity, score word, and end turn
        {
            //word.setTilesInWord(null, null);   Still have to figure out how we are going to figure out what word they made
            word.check();
            word.scoreWord();

        } else if (e.getSource() == view.getSwapBtn()) //pickUp tile from Bag, switch with tile selected, and end turn
        {
            hand.createSwitch();

        } else if (e.getSource() == view.getPassBtn()) //change current player to next player, and end turn
        {
            player.pass();

        } else if (e.getSource() == view.getShuffleBtn()) {
            hand.shuffle();

//        } else if (e.getSource() == view.getDirectionsBtn()) {
//            view.getDirectionsPanel().setVisible(true);
//        }
        }
    }
}
