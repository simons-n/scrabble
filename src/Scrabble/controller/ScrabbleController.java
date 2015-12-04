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
import java.awt.Component;
import java.awt.Container;
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
    private JLabel spaceSelected = null;
    private int gridXCoord;
    private int gridYCoord;
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
        this.board = player.getMyBoard();
        this.grid = board.getGrid();
        //this.grid = view.getPlayerBoard().getGrid();
        //this.hand = player.getMyHand();
        this.view.getShuffleBtn().addActionListener(this);
        this.view.getSwapBtn().addActionListener(this);
        this.view.getPlayBtn().addActionListener(this);
        this.view.getPassBtn().addActionListener(this);

        addBoardMouseListeners();
        addHandMouseListeners();
    }

    public void addBoardMouseListeners() {
        // add mouse listeners to board
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                player.getMyBoard().getGrid()[i][j].addMouseListener(this);
            }
        }

    }

    public void addHandMouseListeners() {
        // add mouse listeners to tiles in hand
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
        //this only updates the board not handhandView.addMouseListener();
        // when shuffle is pressed change HandView to HandView(Hand myhand)
        handView.setHand(hand);
        board.setGrid(grid);
        view.setPlayerBoard(board);
        addHandMouseListeners();
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
        System.out.println("mouse event source: " + e);

        // if tile clicked in hand
        for (int i = 0; i < jLabelHand.length; i++) {
            if ((JLabel) e.getSource() == jLabelHand[i]) {
                tileSelected = jLabelHand[i];
                System.out.println(
                        "tile selected " + tileSelected.getToolTipText());
                Container parent = jLabelHand[i].getParent();
                parent.remove(jLabelHand[i]);
                parent.revalidate();
                parent.repaint();
                System.out.println(
                        "parent is: " + parent + "name is: " + parent.getName());

                //handView.setJLabelHand(jLabelHand);
                //handView = view.getHandView();
            }
        }

        // if space clicked on board
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((JLabel) e.getSource() == grid[i][j]) {
                    spaceSelected = player.getMyBoard().getGrid()[i][j];
                    gridXCoord = i;
                    gridYCoord = j;
                    System.out.println("x coord " + gridXCoord);
                    System.out.println("y coord " + gridYCoord);
                    System.out.println(
                            "space selected " + spaceSelected.getToolTipText());
                }
            }
        }

        // add spaceSelected to tileSelected and set tileSelected and spaceSelected back to null
        if (tileSelected != null && spaceSelected != null) {
            System.out.println("trying to place tile on board");
            board.remove(
                    grid[gridXCoord][gridYCoord]);
            grid[gridXCoord][gridYCoord] = tileSelected;

            switch (grid[gridXCoord][gridYCoord].getToolTipText()) {
                case "A":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getaTileImage());
                    board = new Board(handView.getaTileImage(), gridXCoord,
                                      gridYCoord);
                    player.setMyBoard(board);
                    break;
                case "B":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getbTileImage());
                    break;
                case "C":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getcTileImage());
                    break;
                case "D":

                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getdTileImage());
                    break;
                case "E":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.geteTileImage());
                    break;
                case "F":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getfTileImage());
                    break;
                case "G":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getgTileImage());
                    break;
                case "H":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.gethTileImage());
                    break;
                case "I":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getiTileImage());
                    break;
                case "J":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getjTileImage());
                    break;
                case "K":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getkTileImage());
                    break;
                case "L":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getlTileImage());
                    break;
                case "M":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getmTileImage());
                    break;
                case "N":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getnTileImage());
                    break;
                case "O":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getoTileImage());
                    break;
                case "P":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getpTileImage());
                    break;
                case "Q":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getqTileImage());
                    break;
                case "R":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getrTileImage());
                    break;
                case "S":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getsTileImage());
                    break;
                case "T":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.gettTileImage());
                    break;
                case "U":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getuTileImage());
                    break;
                case "V":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getvTileImage());
                    break;
                case "W":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getwTileImage());
                    break;
                case "X":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getxTileImage());
                    break;
                case "Y":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getyTileImage());
                    break;
                case "Z":
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getzTileImage());
                    break;
                default:
                    grid[gridXCoord][gridYCoord] = new JLabel(
                            handView.getBlankTileImage());
                    break;
            }
//            board.add(grid[gridXCoord][gridYCoord]);

            board.setGrid(grid);
            //player.setMyBoard(board);
//            game.setTheBoard(board);
            updateViewFromModel();

            System.out.println("placed(?) tile on board");
            System.out.println(
                    "supposed to be " + grid[gridXCoord][gridYCoord].getToolTipText());
            System.out.println(
                    "actually" + view.getPlayerBoard().getGrid()[gridXCoord][gridYCoord].getToolTipText());

            tileSelected = null;
            spaceSelected = null;
            gridXCoord = 0;
            gridYCoord = 0;

            ((Component) e.getSource()).removeMouseListener(this);
        }

        updateViewFromModel();
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
        //System.out.println("mouse entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("mouse exited");
    }

}
