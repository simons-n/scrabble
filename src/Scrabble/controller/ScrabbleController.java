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

import Scrabble.model.BoardTileLabel;
import Scrabble.model.Game;
import Scrabble.model.Hand;
import Scrabble.model.Player;
import Scrabble.model.Stack;
import Scrabble.model.Tile;
import Scrabble.model.TileBag;
import Scrabble.model.Val;
import Scrabble.model.Word;
import Scrabble.view.Board;
import Scrabble.view.HandView;
import Scrabble.view.ScrabbleBoard;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

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
    private JLabel tileSelected = null;
    private JLabel spaceSelected = null;
    private int gridXCoord;
    private int gridYCoord;
    //private Player player = new Player("Jenna", 0);
    private Player player;
    private Game game;
    private JLabel[] jLabelHand;
    private JLabel[][] grid;
    private Stack undoStack = new Stack(9);

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
        this.view.getUndoBtn().addActionListener(this);

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

        //handView.setJLabelHand(handView.setHand(hand));
        handView.setHand(hand);
//        System.out.println("jlabelhand after updated = " + handView);
        board.setGrid(grid);
        view.setPlayerBoard(board);

        view.repaint();
        addBoardMouseListeners();
        addHandMouseListeners();
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

            //uncomment!!! for two player game!
//            game.setTheBoard(view.getMainBoard());
//            game.updatePlayerBoards();
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
            //pop the stack to get the tile with tile location in grid
            if (undoStack.isEmpty() == false) {
                System.out.println("Hand before undo: " + hand);
                Tile tile = undoStack.pop();
                int x = tile.getX();
                int y = tile.getY();

                JPanel panel = (JPanel) board.getComponent(
                        y + x * 15);
                JLabel boardLabel = (JLabel) panel.getComponent(0);
                panel.remove(boardLabel);
                JLabel newLabel = new JLabel(board.getLabel(x, y));
                panel.add(newLabel);
                view.getMyGrid()[x][y].addMouseListener(this);
                board.revalidate();

                // add tile back in to hand, to update handview
                this.hand.addTileFromBoard(tile);
                handView.revalidate();

                System.out.println("Hand after undo: " + hand);
                //change the location of the tile to a background square **** figure out how to know if it was a TLW etc
                //clear stack when turn is ended
            } else {
                JOptionPane.showMessageDialog(view,
                                              "You do not have any moves to Undo, you must make a move now.",
                                              "Error",
                                              DISPOSE_ON_CLOSE);
            }
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
        //System.out.println("handlist: " + handView);
        //System.out.println("mouse event source: " + e);

        // if tile clicked in hand
        for (int i = 0; i < jLabelHand.length; i++) {
            if ((JLabel) e.getSource() == jLabelHand[i]) {
                tileSelected = jLabelHand[i];
                System.out.println(
                        "tile selected " + tileSelected.getToolTipText());
                System.out.println("index of tile: " + i);
                System.out.println();
                System.out.println("pre-handsize: " + hand.getHandSize());
                System.out.println(
                        "pre-jlabelhandsize: " + handView.getJLabelHand().length);
                System.out.println("pre-hand: " + hand);
                System.out.println("pre-jLabelHand: " + handView);
                System.out.println();

                int indexNewHand = 0;
                JLabel[] newJLabelHand = new JLabel[jLabelHand.length - 1];
                for (int a = 0; a < jLabelHand.length; a++) {
                    if (jLabelHand[a] != tileSelected) {
                        newJLabelHand[indexNewHand] = jLabelHand[a];
                        indexNewHand += 1;
                    }
                }
                handView.remove(jLabelHand[i]);

                handView.setJLabelHand(newJLabelHand);
                jLabelHand = newJLabelHand;

                //jLabelHand = handView.getJLabelHand();
                hand.removeTile(hand.getTile(i));
                handView.revalidate();
                handView.repaint();

                System.out.println("post-handsize: " + hand.getHandSize());
                System.out.println(
                        "post-jlabelhandsize: " + handView.getJLabelHand().length);
                System.out.println("post-hand: " + hand);
                System.out.println("post-jLabelHand: " + handView);
                break;
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
//                    System.out.println("x coord " + gridXCoord);
//                    System.out.println("y coord " + gridYCoord);
//                    System.out.println(
//                            "space selected " + spaceSelected.getToolTipText());
                }
            }
        }

        // add spaceSelected to tileSelected and set tileSelected and spaceSelected back to null
        if (tileSelected != null && spaceSelected != null) {
            System.out.println("trying to place tile on board");
            board.remove(
                    grid[gridXCoord][gridYCoord]);
            grid[gridXCoord][gridYCoord] = tileSelected;
//
            switch (tileSelected.getToolTipText()) {
                case "A":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getaTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("A");
                    Tile tileA = new Tile(Val.A, gridXCoord, gridYCoord);
                    undoStack.push(tileA);

                    break;
                case "B":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getbTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("B");
                    Tile tileB = new Tile(Val.B, gridXCoord, gridYCoord);
                    undoStack.push(tileB);
                    break;
                case "C":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getcTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("C");
                    Tile tileC = new Tile(Val.C, gridXCoord, gridYCoord);
                    undoStack.push(tileC);
                    break;
                case "D":

                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getdTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("D");
                    Tile tileD = new Tile(Val.D, gridXCoord, gridYCoord);
                    undoStack.push(tileD);
                    break;
                case "E":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.geteTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("E");
                    Tile tileE = new Tile(Val.E, gridXCoord, gridYCoord);
                    undoStack.push(tileE);
                    break;
                case "F":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getfTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("F");
                    Tile tileF = new Tile(Val.F, gridXCoord, gridYCoord);
                    undoStack.push(tileF);
                    break;
                case "G":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getgTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("G");
                    Tile tileG = new Tile(Val.G, gridXCoord, gridYCoord);
                    undoStack.push(tileG);
                    break;
                case "H":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.gethTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("H");
                    Tile tileH = new Tile(Val.H, gridXCoord, gridYCoord);
                    undoStack.push(tileH);
                    break;
                case "I":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getiTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("I");
                    Tile tileI = new Tile(Val.I, gridXCoord, gridYCoord);
                    undoStack.push(tileI);
                    break;
                case "J":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getjTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("J");
                    Tile tileJ = new Tile(Val.J, gridXCoord, gridYCoord);
                    undoStack.push(tileJ);
                    break;
                case "K":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getkTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("K");
                    Tile tileK = new Tile(Val.K, gridXCoord, gridYCoord);
                    undoStack.push(tileK);
                    break;
                case "L":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getlTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("L");
                    Tile tileL = new Tile(Val.L, gridXCoord, gridYCoord);
                    undoStack.push(tileL);
                    break;
                case "M":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getmTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("M");
                    Tile tileM = new Tile(Val.M, gridXCoord, gridYCoord);
                    undoStack.push(tileM);
                    break;
                case "N":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getnTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("N");
                    Tile tileN = new Tile(Val.N, gridXCoord, gridYCoord);
                    undoStack.push(tileN);
                    break;
                case "O":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getoTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("O");
                    Tile tileO = new Tile(Val.O, gridXCoord, gridYCoord);
                    undoStack.push(tileO);
                    break;
                case "P":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getpTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("P");
                    Tile tileP = new Tile(Val.P, gridXCoord, gridYCoord);
                    undoStack.push(tileP);
                    break;
                case "Q":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getqTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("Q");
                    Tile tileQ = new Tile(Val.Q, gridXCoord, gridYCoord);
                    undoStack.push(tileQ);
                    break;
                case "R":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getrTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("R");
                    Tile tileR = new Tile(Val.R, gridXCoord, gridYCoord);
                    undoStack.push(tileR);
                    break;
                case "S":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getsTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("S");
                    Tile tileS = new Tile(Val.S, gridXCoord, gridYCoord);
                    undoStack.push(tileS);
                    break;
                case "T":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.gettTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("T");
                    Tile tileT = new Tile(Val.T, gridXCoord, gridYCoord);
                    undoStack.push(tileT);
                    break;
                case "U":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getuTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("U");
                    Tile tileU = new Tile(Val.U, gridXCoord, gridYCoord);
                    undoStack.push(tileU);
                    break;
                case "V":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getvTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("V");
                    Tile tileV = new Tile(Val.V, gridXCoord, gridYCoord);
                    undoStack.push(tileV);
                    break;
                case "W":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getwTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("W");
                    Tile tileW = new Tile(Val.W, gridXCoord, gridYCoord);
                    undoStack.push(tileW);
                    break;
                case "X":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getxTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("X");
                    Tile tileX = new Tile(Val.X, gridXCoord, gridYCoord);
                    undoStack.push(tileX);
                    break;
                case "Y":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getyTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("Y");
                    Tile tileY = new Tile(Val.Y, gridXCoord, gridYCoord);
                    undoStack.push(tileY);
                    break;
                case "Z":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getzTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("Z");
                    Tile tileZ = new Tile(Val.Z, gridXCoord, gridYCoord);
                    undoStack.push(tileZ);
                    break;
                default:
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getBlankTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("Blank");
                    Tile tile = new Tile(Val.BLANK, gridXCoord, gridYCoord);
                    undoStack.push(tile);
                    break;
            }
            //http://stackoverflow.com/questions/2561690/placing-component-on-glass-pane/2562685#2562685
            JPanel panel = (JPanel) board.getComponent(
                    gridYCoord + gridXCoord * 15);
            JLabel boardLabel = (JLabel) panel.getComponent(0);
            panel.remove(boardLabel);
            panel.add(grid[gridXCoord][gridYCoord]);

            board.revalidate();
            board.repaint();
            //board.add(panel);

            //board.setGrid(grid);
            //player.setMyBoard(board);
//            game.setTheBoard(board);
            //updateViewFromModel();
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

        System.out.println();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println();
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
