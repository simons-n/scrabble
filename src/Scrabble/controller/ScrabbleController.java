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

import Scrabble.view.ScrabbleBoard;
import java.awt.event.ActionEvent;

/**
 *
 * @author jms107
 */
public class ScrabbleController {
// connects model to view

    private ScrabbleBoard view;

    public ScrabbleController(ScrabbleBoard view) {
        this.view = view;
    }

    public void updateViewFromModel() {

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getPlayBtn()) //check validity, score word, and end turn
        {

        } else if (e.getSource() == view.getDirectionsBtn()) {
            view.getDirectionsPanel().setVisible(true);
        } else if (e.getSource() == view.getSwapBtn()) //pickUp tile from Bag, switch with tile selected, and end turn
        {

        } else if (e.getSource() == view.getPassBtn()) //change current player to next player, and end turn
        {

        }
    }
}
