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
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class ScrabbleController implements ActionListener, MouseListener {
// connects model to view
    private ScrabbleBoard view;
    private Board board;
    private HandView handView;
    private static TileBag tilebag;
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
    private int score = 0;
    private JLabel[] jLabelHand;
    private JLabel[][] grid;
    private JPanel[][] squares;
    private boolean canPlayWord = true;
    private Val val;
    private int turnCounter = 1;
    private ArrayList<String> boardText = new ArrayList<>(Arrays.asList(
            "Double Word", "Double Letter", "Star", "Square", "Triple Word",
            "Triple Letter"));
    private Stack undoStack = new Stack(9);
    private int mostRecentScore = 0;
    private ArrayList<String> bonusType;
    private ArrayList<String> letterForBonus;
    private boolean isUndoing = false;

    public ScrabbleController(ScrabbleBoard view) throws IOException {
        this.view = view;
        this.player = view.getPlayer();
        this.game = player.getGame();
        this.handView = view.getHandView();
        this.hand = player.getMyHand();
        this.jLabelHand = this.handView.getJLabelHand();
        this.board = player.getMyBoard();
        this.grid = board.getGrid();
        tilebag = game.getTileBag();

        word = new Word(grid, game, boardText);
        this.squares = board.getSquares();
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
        handView.setHand(hand, isUndoing);
//        System.out.println("jlabelhand after updated = " + handView);
        isUndoing = false;
        jLabelHand = handView.getJLabelHand();
        //handView.setIsUndoing(isUndoing);
        board.setGrid(grid);

        handView.repaint();
        handView.revalidate();
        view.setPlayerBoard(board);

        view.repaint();
        //addBoardMouseListeners();
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
            if (gridXCoord > 0 && gridYCoord > 0) {
                score = word.scoreWord(gridXCoord, gridYCoord);
            }

            //word.setTilesInWord(null, null);   Still have to figure out how we are going to figure out what word they made
            if (canPlayWord == false) {
                JOptionPane.showMessageDialog(view,
                                              "The first word you play has to have a tile on the center star, rearrange your word by pressing the undo button.",
                                              "Error", DISPOSE_ON_CLOSE);
            } else {
                int newScore = player.getTotalScore() + score;
                player.setTotalScore(newScore);
                view.refreshScoresLabel();
                undoStack = new Stack(9);

                //turnCounter++;
            }

        } else if (e.getSource() == view.getSwapBtn()) //pickUp tile from Bag, switch with tile selected, and end turn
        {
            this.hand.createSwap();

            //uncomment!!! for two player game!
//            game.setTheBoard(view.getMainBoard());
//            game.updatePlayerBoards();
        } else if (e.getSource() == view.getPassBtn()) {
            System.out.println("Player passed their turn");

            int tilesDrawn = 0;
            for (JLabel jLabelTile : handView.getJLabelHand()) {
                handView.remove(jLabelTile);
            }

            while (hand.getHandSize() < 7) {

                tilesDrawn++;
                Tile tile = tilebag.draw();
                hand.addTile(tile);

            }

            handView.setHand(hand, true);

            //handView.drawAtEndOfTurn(hand);
            //jLabelHand = handView.getJLabelHand()
            handView.revalidate();
            view.refreshTileBagLabel(tilebag);

            view.repaint();
            view.revalidate();

            score = 0;
            gridXCoord = -1;
            gridYCoord = -1;
            turnCounter++;

//            bonusType.clear();
//            letterForBonus.clear();
            //change current player to next player, and end turn
//            try {
//
//                player.getClientServer().updateServer();
//            } catch (IOException ex) {
//                Logger.getLogger(ScrabbleController.class.getName()).log(
//                        Level.SEVERE,
//                        null,
//                        ex);
//            }
//
//            game.setTheBoard(view.getMainBoard());
//            game.updatePlayerBoards();
        } else if (e.getSource()
                   == view.getShuffleBtn()) {

            this.hand.shuffle();

//        } else if (e.getSource() == view.getDirectionsBtn()) {
//            view.getDirectionsPanel().setVisible(true);
//        }
        } else if (e.getSource()
                   == view.getUndoBtn()) {

            //pop the stack to get the tile with tile location in grid
            if (undoStack.isEmpty() == false) { //add the check to see if it was blank is true
                this.isUndoing = true;

                Tile tile = undoStack.pop();
                int x = tile.getX();
                int y = tile.getY();

                JPanel panel = (JPanel) board.getComponent(
                        y + x * 15);
                JLabel boardLabel = (JLabel) panel.getComponent(0);
                panel.remove(boardLabel);
                JLabel newLabel = new JLabel(board.getLabel(x, y));
                if (board.getLabel(x, y) == board.getTripleWordImage()) {
                    newLabel.setToolTipText("Triple Word");
                } else if (board.getLabel(x, y) == board.getTripleLetterImage()) {
                    newLabel.setToolTipText("Triple Letter");

                } else if (board.getLabel(x, y) == board.getDoubleWordImage()) {
                    newLabel.setToolTipText("Double Word");
                } else if (board.getLabel(x, y) == board.getDoubleLetterImage()) {
                    newLabel.setToolTipText("Double Letter");
                } else if (board.getLabel(x, y) == board.getStarImage()) {
                    newLabel.setToolTipText("Star");

                } else if (board.getLabel(x, y) == board.getBackgroundImage()) {
                    newLabel.setToolTipText("Square");
                }

                squares[x][y] = panel;
                grid[x][y] = newLabel;
                panel.add(newLabel);

                //view.getMyGrid()[x][y].addMouseListener(this);
                addBoardMouseListeners();
                board.revalidate();

                Tile blankTile = new Tile(val.BLANK);

                for (JLabel jLabelTile : handView.getJLabelHand()) {
                    handView.remove(jLabelTile);
                }
                this.hand.addTileFromBoard(tile);

                handView.revalidate();

                // add tile back in to hand, to update handview
                //this.hand.addTileFromBoard(blankTile);
//                handView.revalidate();
            } else if (undoStack.isEmpty() == false) {
                this.isUndoing = true;

                Tile tile = undoStack.pop();
                int x = tile.getX();
                int y = tile.getY();

                JPanel panel = (JPanel) board.getComponent(
                        y + x * 15);
                JLabel boardLabel = (JLabel) panel.getComponent(0);
                panel.remove(boardLabel);
                grid[x][y] = new JLabel(board.getLabel(x, y));
                panel.add(grid[x][y]);
                addBoardMouseListeners();

                JLabel newLabel = new JLabel(board.getLabel(x, y));
                if (board.getLabel(x, y) == board.getTripleWordImage()) {
                    newLabel.setToolTipText("Triple Word");
                } else if (board.getLabel(x, y) == board.getTripleLetterImage()) {
                    newLabel.setToolTipText("Triple Letter");

                } else if (board.getLabel(x, y) == board.getDoubleWordImage()) {
                    newLabel.setToolTipText("Double Word");
                } else if (board.getLabel(x, y) == board.getDoubleLetterImage()) {
                    newLabel.setToolTipText("Double Letter");
                } else if (board.getLabel(x, y) == board.getStarImage()) {
                    newLabel.setToolTipText("Star");

                } else if (board.getLabel(x, y) == board.getBackgroundImage()) {
                    newLabel.setToolTipText("Square");
                }

                squares[x][y] = panel;
                grid[x][y] = newLabel;
                panel.add(newLabel);

                //view.getMyGrid()[x][y].addMouseListener(this);
                addBoardMouseListeners();
                board.revalidate();

                // add tile back in to hand, to update handview
                for (JLabel jLabelTile : handView.getJLabelHand()) {
                    handView.remove(jLabelTile);
                }
                this.hand.addTileFromBoard(tile);

                handView.revalidate();

                //change the location of the tile to a background square **** figure out how to know if it was a TLW etc
                //clear stack when turn is ended
            } else {
                JOptionPane.showMessageDialog(view,
                                              "You do not have any moves to Undo, you must make a move now.",
                                              "Error",
                                              DISPOSE_ON_CLOSE);
            }

        } else if (tileSelected
                   != null) {
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

    /**
     * @see
     * <a href = "http://stackoverflow.com/questions/2561690/placing-component-on-glass-pane/2562685#2562685">
     * http://stackoverflow.com/questions/2561690/placing-component-on-glass-pane/2562685#2562685</a>
     * @param e
     */
    public void mouseClicked(MouseEvent e) {
        //System.out.println("handlist: " + handView);
        //System.out.println("mouse event source: " + e);

        // if tile clicked in hand
        for (int i = 0; i < jLabelHand.length; i++) {
            if ((JLabel) e.getSource() == jLabelHand[i]) {

                if (jLabelHand[i].getToolTipText() == "BLANK") {
                    Tile newTile = view.createBlankTile();
                    Tile tile = this.hand.getTile(i);
                    this.hand.switchTiles(tile, newTile);
                    handView.setHand(hand, false);
                    view.repaint();
                }

                tileSelected = jLabelHand[i];

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

                break;

            }
        }

        // if space clicked on board
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((JLabel) e.getSource() == grid[i][j]) {
                    spaceSelected = player.getMyBoard().getGrid()[i][j];
                    gridXCoord = i;
                    gridYCoord = j;

                }
            }
        }

        // add spaceSelected to tileSelected and set tileSelected and spaceSelected back to null
        if (tileSelected != null && spaceSelected != null && boardText.contains(
                spaceSelected.getToolTipText())) {
            board.remove(
                    grid[gridXCoord][gridYCoord]);
            grid[gridXCoord][gridYCoord] = tileSelected;
//
            switch (tileSelected.getToolTipText()) {
                case "A":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getaTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("A");
                    Tile tileA = new Tile(Val.A, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileA);

                    break;
                case "B":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getbTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("B");
                    Tile tileB = new Tile(Val.B, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileB);
                    break;
                case "C":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getcTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("C");
                    Tile tileC = new Tile(Val.C, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileC);
                    break;
                case "D":

                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getdTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("D");
                    Tile tileD = new Tile(Val.D, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileD);
                    break;
                case "E":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.geteTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("E");
                    Tile tileE = new Tile(Val.E, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileE);
                    break;
                case "F":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getfTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("F");
                    Tile tileF = new Tile(Val.F, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileF);
                    break;
                case "G":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getgTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("G");
                    Tile tileG = new Tile(Val.G, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileG);
                    break;
                case "H":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.gethTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("H");
                    Tile tileH = new Tile(Val.H, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileH);
                    break;
                case "I":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getiTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("I");
                    Tile tileI = new Tile(Val.I, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileI);
                    break;
                case "J":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getjTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("J");
                    Tile tileJ = new Tile(Val.J, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileJ);
                    break;
                case "K":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getkTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("K");
                    Tile tileK = new Tile(Val.K, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileK);
                    break;
                case "L":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getlTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("L");
                    Tile tileL = new Tile(Val.L, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileL);
                    break;
                case "M":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getmTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("M");
                    Tile tileM = new Tile(Val.M, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileM);
                    break;
                case "N":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getnTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("N");
                    Tile tileN = new Tile(Val.N, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileN);
                    break;
                case "O":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getoTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("O");
                    Tile tileO = new Tile(Val.O, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileO);
                    break;
                case "P":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getpTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("P");
                    Tile tileP = new Tile(Val.P, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileP);
                    break;
                case "Q":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getqTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("Q");
                    Tile tileQ = new Tile(Val.Q, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileQ);
                    break;
                case "R":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getrTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("R");
                    Tile tileR = new Tile(Val.R, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileR);
                    break;
                case "S":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getsTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("S");
                    Tile tileS = new Tile(Val.S, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileS);
                    break;
                case "T":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.gettTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("T");
                    Tile tileT = new Tile(Val.T, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileT);
                    break;
                case "U":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getuTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("U");
                    Tile tileU = new Tile(Val.U, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileU);
                    break;
                case "V":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getvTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("V");
                    Tile tileV = new Tile(Val.V, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileV);
                    break;
                case "W":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getwTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("W");
                    Tile tileW = new Tile(Val.W, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileW);
                    break;
                case "X":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getxTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("X");
                    Tile tileX = new Tile(Val.X, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileX);
                    break;
                case "Y":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getyTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("Y");
                    Tile tileY = new Tile(Val.Y, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileY);
                    break;
                case "Z":
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getzTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText("Z");
                    Tile tileZ = new Tile(Val.Z, gridXCoord,
                                          gridYCoord);
                    undoStack.push(tileZ);
                    break;
                default:
                    grid[gridXCoord][gridYCoord] = new BoardTileLabel(
                            handView.getBlankTileImage());
                    grid[gridXCoord][gridYCoord].setToolTipText(
                            "Blank");
                    Tile tile = new Tile(Val.BLANK, gridXCoord,
                                         gridYCoord);
                    undoStack.push(tile);
                    break;
            }
            // see javadoc for source
            JPanel panel = (JPanel) board.getComponent(
                    gridYCoord + gridXCoord * 15);
            JLabel boardLabel = (JLabel) panel.getComponent(0);
            panel.remove(boardLabel);
            panel.add(grid[gridXCoord][gridYCoord]);

            board.revalidate();
            board.repaint();
            canPlayWord();

            tileSelected = null;
            spaceSelected = null;

            ((Component) e.getSource()).removeMouseListener(this);
        }

        updateViewFromModel();
    }

    public ArrayList<String> getBonusType() {
        return bonusType;
    }

    public ArrayList<String> getLetterForBonus() {
        return letterForBonus;
    }

    public ArrayList<String> getBoardText() {
        return boardText;
    }

    public JLabel[][] getGrid() {
        return grid;
    }

    public void canPlayWord() {
        if (gridXCoord != 7 && gridYCoord != 7 && turnCounter == 1) {
            canPlayWord = false;
        } else {
            canPlayWord = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
