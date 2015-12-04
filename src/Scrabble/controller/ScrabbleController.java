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

import Scrabble.model.Game;
import Scrabble.model.Hand;
import Scrabble.model.Player;
import Scrabble.model.Tile;
import Scrabble.model.TileBag;
import Scrabble.model.Word;
import Scrabble.view.Board;
import Scrabble.view.HandView;
import Scrabble.view.ScrabbleBoard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author jms107
 */
public class ScrabbleController implements ActionListener, MouseListener {
// connects model to view

    private ScrabbleBoard view;
    private Board board;
    private HandView handView;
    private static TileBag tilebag = new TileBag();
    private static Hand hand;
    //private Player player = Game.getCurPlayer();
    private Word word;
    private ArrayList<Tile> tilesInHand = new ArrayList<>();
    private JLabel tileSelected = null;
    //private Player player = new Player("Jenna", 0);
    private Player player;
    private Game game;
    private JLabel[] jLabelHand;
    private JLabel[][] grid;

    public ScrabbleController(ScrabbleBoard view) {
        this.view = view;
        this.player = view.getPlayer();
        this.game = player.getGame();
        this.handView = view.getHandView();
        this.hand = player.getMyHand();
        this.jLabelHand = this.handView.getJLabelHand();
        this.board = view.getMainBoard();
        //this.grid = view.getPlayerBoard().getGrid();
        //this.hand = player.getMyHand();
        this.view.getShuffleBtn().addActionListener(this);
        this.view.getSwapBtn().addActionListener(this);
        this.view.getPlayBtn().addActionListener(this);
        this.view.getPassBtn().addActionListener(this);
        //this.board.getGrid()[0][0].addMouseListener(this);

//        this.board.addMouseListener(this);
//        this.view.addMouseListener(this);
//        this.handView.addMouseListener(this);
//        for (int i = 0; i < 15; i++) {
//            for (int j = 0; j < 15; j++) {
//                this.board.getGrid()[i][j].addMouseListener(this);
//            }
//        }
        for (JLabel tileLabel : this.jLabelHand) {
            tileLabel.addMouseListener(this);
        }
    }

    public void createScrabbleController() {
//        for (JLabel[] row : view.getGrid()) {
//            for (JLabel square : row) {
//               square.addActionListener(this);
//            }
//        }
        for (int i = 0; i < view.getMyGrid().length; i++) {
            for (int j = 0; i < view.getMyGrid()[0].length; j++) {
                view.getMyGrid()[i][j].addMouseListener(
                        (MouseListener) view.getMyGrid()[i][j]);
            }
        }
    }

    public void updateViewFromModel() {
        //if turn ended, check by creating boolean, clear stack
        handView.setHand(hand);
        view.repaint();
        //
        // when pass is pressed change view to next players hand
        // when swap is pressed change HandView to HandView(Hand myhand) *** make the dialog box show up
        // when play is pressed if not valid show error message, if valid update show message of how much they just scored, update total score, show new hand with drawn tiles, change player to next players hand
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getPlayBtn()) //check validity, score word, and end turn
        {
            //word.setTilesInWord(null, null);   Still have to figure out how we are going to figure out what word they made
            word.check();
            word.scoreWord();

        } else if (e.getSource() == view.getSwapBtn()) //pickUp tile from Bag, switch with tile selected, and end turn
        {
            this.hand.createSwap();

            game.setTheBoard(view.getMainBoard());
            game.updatePlayerBoards();

        } else if (e.getSource() == view.getPassBtn()) {
            //change current player to next player, and end turn
            try {

                player.getClientServer().updateServer();
            } catch (IOException ex) {
                Logger.getLogger(ScrabbleController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            }

            game.setTheBoard(view.getMainBoard());
            game.updatePlayerBoards();

        } else if (e.getSource() == view.getShuffleBtn()) {
            System.out.println("tried to shuffle");
            System.out.println("pre-hand: " + hand);
            this.hand.shuffle();
            System.out.println("post-hand: " + hand);

//        } else if (e.getSource() == view.getDirectionsBtn()) {
//            view.getDirectionsPanel().setVisible(true);
//        }
        } else if (e.getSource() == view.getUndoBtn()) {
            //pop the stack to get the tile with it's location
            // add tile back in to hand, to update handview
            //change the location of the tile to a background square **** figure out how to know if it was a TLW etc
            //clear stack when turn is ended
        } else if (tileSelected != null) {
            for (int x = 0; x < 15; x++) {
                for (int y = 0; y < 15; y++) {
                    if (e.getSource() == view.getMyGrid()[x][y]) {
                        view.remove(view.getMyGrid()[x][y]);
                        view.getMyGrid()[x][y] = tileSelected;
                        tileSelected = null;
                    }
                }
            }
        }
        updateViewFromModel();
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("handlist: " + handView);
        System.out.println("mouese event source: " + e);
        for (int i = 0; i < handView.getJLabelHand().length; i++) {
            if ((JLabel) e.getSource() == handView.getJLabelHand()[i]) {
                tileSelected = handView.getJLabelHand()[i];
                System.out.println("tile selected " + tileSelected);
                System.out.println(handView.getJLabelHand()[i]);
                handView.remove(handView.getJLabelHand()[i]);
            }
        }

        if (this.board == null) {
            System.out.println("board null");
        }

        for (int i = 0; i < player.getMyBoard().getGrid().length; i++) {
            for (int j = 0; j < board.getGrid()[0].length; j++) {
                if ((JLabel) e.getSource() == board.getGrid()[i][j]) {
                    System.out.println("xxxx");
                    tileSelected = board.getGrid()[i][j];
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        System.out.println("mouse pressed");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouse exited");
    }

}
