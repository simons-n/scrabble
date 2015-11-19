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

import Scrabble.model.Tile;
import Scrabble.model.TileBag;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 *
 * @author jms107
 */
public class ScrabbleBoard extends JFrame {
    private ArrayList<Tile> tilesInBag = new ArrayList<>();
    private TileBag tileBag = new TileBag(tilesInBag);
    //private final JPanel handPanel = new JPanel();
    //private final JLabel handLabel = new JLabel();
    private final JPanel actionPanel = new JPanel();
    private final JButton playBtn = new JButton("Play Word");
    private final JButton swapBtn = new JButton("Swap");
    private final JButton passBtn = new JButton("Pass");
    private final JButton shuffleBtn = new JButton("Shuffle");
    private final JPanel leftPanel = new JPanel();
    private final JTextArea scoresLabel = new JTextArea(10, 10);
    private final JTextArea letterDistribLabel = new JTextArea(20, 10);
    private final JTextArea tileBagLabel = new JTextArea(10, 10);
    //   private Board board;

    public ScrabbleBoard() {
        Border blackBorder = BorderFactory.createLineBorder(
                Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //center panel
        Board board = new Board();

        //left panel
        leftPanel.setSize(new Dimension(60, 300));
        leftPanel.setLayout(new GridLayout(2, 1));
        scoresLabel.setText("SCORES \n Player 1: 0 \n Player 2: 0"); // get players scores from scoring method, and get amount of players from JOptionPane
        scoresLabel.setEditable(false);
        scoresLabel.setBorder(blackBorder);
        scoresLabel.setBackground(Color.PINK);
        leftPanel.add(scoresLabel);
        letterDistribLabel.setText(
                "LETTER DISTRIBUTION \n A:1   N:1 \n B:3   0:1 \n C:3   P:3 \n D:2  Q:10 \n E:1   R:1 \n F:4    S:1 \n G:2   T:1 \n H:4   U:1 \n I:1     V:4 \n J:8    W:4 \n K:5    X:8 \n L:1    Y:4 \n M:3   Z:10 \n Blank:0");
        letterDistribLabel.setEditable(false);
        letterDistribLabel.setBorder(blackBorder);
        letterDistribLabel.setBackground(Color.ORANGE);
        leftPanel.add(letterDistribLabel);

        //right panel
        actionPanel.setLayout(new GridLayout(8, 1));
        String size = tileBag.getTileBagSizeStr();
        tileBagLabel.setText("TILES LEFT \n " + size); // get the number of tiles from size of bag using getTileBagSize()
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
        actionPanel.add(tileBagLabel);

        //bottom panel -- where tiles are added to hand
        Hand hand = new Hand();
//        handPanel.setPreferredSize(new Dimension(100, 50));
//        handPanel.setLayout(new GridLayout(1, 7));
//        //JLabel hand
//        handLabel.setPreferredSize(new Dimension(100, 50));
//        handLabel.setBackground(Color.cyan);
//        handPanel.add(handLabel);

        //put into frame
        add(hand, BorderLayout.SOUTH);
        add(leftPanel, BorderLayout.WEST);
        add(actionPanel, BorderLayout.EAST);
        add(board, BorderLayout.CENTER);
        pack();
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

//    public JLabel[][] getGrid() {
//        return board.getGrid();
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ScrabbleBoard window = new ScrabbleBoard();
                window.setBackground(Color.BLUE);
                window.setTitle("Scrabble Game");
                window.setSize(900, 600);
                window.setVisible(true);
            }
        });
        //create GUI
//display scores of all players
//display player's hand
//Play word button
//Pass button (or skip turn)
//Swap Tiles button
//display how many tiles are left in bag
    }

}
