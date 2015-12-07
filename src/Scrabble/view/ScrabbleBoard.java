/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Caroline Whitman, Jenna Slusar, Nick Simons
 * Date: Nov 8, 2015
 * Time: 4:50:15 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.view
 * File: ScrabbleBoard
 * Description: Represents the GUI for the Scrabble game
 *
 * ****************************************
 */
package Scrabble.view;

import Scrabble.model.Game;
import Scrabble.model.Hand;
import Scrabble.model.Player;
import Scrabble.model.Stack;
import Scrabble.model.TileBag;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author jms107
 */
public class ScrabbleBoard extends JFrame {
    //private ArrayList<Tile> tilesInBag = new ArrayList<>();
    private TileBag tileBag;// = new TileBag();

    //private final JPanel handPanel = new JPanel();
    //private final JLabel handLabel = new JLabel();
    private final JPanel actionPanel = new JPanel();
    private final JButton playBtn = new JButton("Play Word");
    private final JButton swapBtn = new JButton("Swap");
    private final JButton passBtn = new JButton("Pass");
    private final JButton shuffleBtn = new JButton("Shuffle");

    private final JButton undoBtn = new JButton("Undo");
    private final JPanel leftPanel = new JPanel();
    private final JTextArea scoresLabel = new JTextArea(10, 10);
    private final JTextArea letterDistribLabel = new JTextArea(20, 10);
    private final JTextArea tileBagLabel = new JTextArea(10, 10);
    private Board playerBoard;
    private Board mainBoard;
    private HandView handView;
    private Player player;
    private Game game;
    private Stack undo = new Stack(9);

    public ScrabbleBoard(Player player) {

        this.player = player;
        this.game = player.getGame();
        Border blackBorder = BorderFactory.createLineBorder(
                Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tileBag = game.getTileBag();
        this.playerBoard = player.getMyBoard();

        //center panel
        //Board board = new Board();
        //left panel
        leftPanel.setSize(new Dimension(60, 300));
        leftPanel.setLayout(new GridLayout(2, 1));
        scoresLabel.setText("SCORES \n Player 1: " + player.getTotalScore());// \n Player 2: 0"); // get players scores from scoring method from word class, and get amount of players from JOptionPane
        scoresLabel.setEditable(false);
        scoresLabel.setBorder(blackBorder);
        scoresLabel.setBackground(Color.PINK);
        leftPanel.add(scoresLabel);
        letterDistribLabel.setText(
                "LETTER DISTRIBUTION \n         A:1   N:1 \n         B:3   0:1 \n         C:3   P:3 \n         D:2  Q:10 \n         E:1   R:1 \n         F:4    S:1 \n         G:2   T:1 \n         H:4   U:1 \n         I:1     V:4 \n         J:8    W:4 \n         K:5    X:8 \n         L:1    Y:4 \n         M:3   Z:10 \n         Blank:0");
        letterDistribLabel.setEditable(false);
        letterDistribLabel.setBorder(blackBorder);
        letterDistribLabel.setBackground(Color.ORANGE);
        leftPanel.add(letterDistribLabel);

        //bottom panel -- where tiles are added to hand
        player = game.getCurPlayer();
        Hand myHand = player.getMyHand();
        System.out.println(myHand);
        handView = new HandView(myHand);
        //hand.createNewHand(tileBag);

        //right panel
        actionPanel.setLayout(new GridLayout(8, 1));
        String size = tileBag.getTileBagSizeStr();// try to center letters or bold them
        tileBagLabel.setText("      TILES LEFT \n          " + size); // get the number of tiles from size of bag using getTileBagSize() //should equal 93!! fix
        tileBagLabel.setEditable(false);
        tileBagLabel.setBorder(blackBorder);
        tileBagLabel.setBackground(Color.ORANGE);
        playBtn.setBackground(Color.GREEN);
        actionPanel.add(playBtn);
        swapBtn.setBackground(Color.PINK);
        actionPanel.add(swapBtn);
        passBtn.setBackground(Color.ORANGE);
        actionPanel.add(passBtn);
        shuffleBtn.setBackground(Color.PINK);
        actionPanel.add(shuffleBtn);
        actionPanel.add(undoBtn);
        actionPanel.add(tileBagLabel);

        //put into frame
        add(handView, BorderLayout.SOUTH);
        add(leftPanel, BorderLayout.WEST);
        add(actionPanel, BorderLayout.EAST);
        //add(board, BorderLayout.CENTER);
        add(playerBoard, BorderLayout.CENTER);
        pack();
    }

    public JButton getUndoBtn() {
        return undoBtn;
    }

    public Game getGame() {
        return this.game;
    }

    public void setPlayerBoard(Board board) {
        this.playerBoard = board;
    }

    public void setMyBoard() {
        JLabel[][] newGrid = mainBoard.getGrid();
        playerBoard.setGrid(newGrid);
        add(playerBoard, BorderLayout.CENTER);
    }

    public TileBag getTileBag() {
        return tileBag;
    }

    public Player getPlayer() {
        return player;
    }

    public HandView getHandView() {
        return handView;
    }

    public JButton getPlayBtn() {
        return playBtn;
    }

    public JButton getSwapBtn() {
        return swapBtn;
    }

    public JButton getPassBtn() {
        return passBtn;
    }

    public JButton getShuffleBtn() {
        return shuffleBtn;
    }

    public JLabel[][] getMyGrid() {
        return playerBoard.getGrid();
    }

    public JLabel[][] getMainGrid() {
        return mainBoard.getGrid();
    }

    public Board getMainBoard() {
        return mainBoard;
    }

    //When tile is added to the board, add the tile to the undo stack with its location by using the push function
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                ScrabbleBoard window = new ScrabbleBoard();
//                window.setBackground(Color.BLUE);
//                window.setTitle("Scrabble Game");
//                window.setSize(900, 600);
//                window.setVisible(true);
//
//            }
//        });
    //create GUI
//display scores of all players
//display player's hand
//Play word button
//Pass button (or skip turn)
//Swap Tiles button
//display how many tiles are left in bag
    public Board getPlayerBoard() {
        return playerBoard;
    }
}
