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
import Scrabble.model.Tile;
import Scrabble.model.TileBag;
import Scrabble.model.Word;
import Scrabble.view.HandView;
import Scrabble.view.ScrabbleBoard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author jms107
 */
public class ScrabbleController implements ActionListener {
// connects model to view

    private ScrabbleBoard view;
    private HandView handview = new HandView();
    private static TileBag tilebag = new TileBag();
    private static Hand hand;
    private Player player;
    private Word word;
    private ArrayList<Tile> tilesInHand = new ArrayList<>();

    public ScrabbleController(ScrabbleBoard view) {
        this.view = view;
        hand = handview.createNewHand(tilebag);
        this.view.getShuffleBtn().addActionListener(this);
        this.view.getSwapBtn().addActionListener(this);
        this.view.getPlayBtn().addActionListener(this);
        this.view.getPassBtn().addActionListener(this);

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
        // when shuffle is pressed change HandView to HandView(Hand myhand)
        // when pass is pressed change view to next players hand
        // when swap is pressed change HandView to HandView(Hand myhand) *** make the dialog box show up
        // when play is pressed if not valid show error message, if valid update show message of how much they just scored, update total score, show new hand with drawn tiles, change player to next players hand

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getPlayBtn()) //check validity, score word, and end turn
        {
            //word.setTilesInWord(null, null);   Still have to figure out how we are going to figure out what word they made
            word.check();
            word.scoreWord();

        } else if (e.getSource() == view.getSwapBtn()) //pickUp tile from Bag, switch with tile selected, and end turn
        {
            this.hand.createSwitch();

        } else if (e.getSource() == view.getPassBtn()) //change current player to next player, and end turn
        {
            player.pass();

        } else if (e.getSource() == view.getShuffleBtn()) {
            System.out.println("tried to shuffle");
            this.hand.shuffle();
            handview.createHand(hand);

//        } else if (e.getSource() == view.getDirectionsBtn()) {
//            view.getDirectionsPanel().setVisible(true);
//        }
        }
        updateViewFromModel();
    }
}
