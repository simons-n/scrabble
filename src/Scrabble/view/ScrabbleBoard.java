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
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 *
 * @author jms107
 */
public class ScrabbleBoard extends JFrame {
    //JPanel boardPanel = new JPanel();
    JPanel handPanel = new JPanel();
    JLabel handLabel = new JLabel();
    JPanel actionPanel = new JPanel();
    JButton playBtn = new JButton("Play Word");
    JButton swapBtn = new JButton("Swap");
    JButton passBtn = new JButton("Pass");
    JButton shuffleBtn = new JButton("Shuffle");
    JPanel leftPanel = new JPanel();
    JTextArea scoresLabel = new JTextArea(10, 10);
    JTextArea letterDistribLabel = new JTextArea(20, 10);
    JTextArea tileBagLabel = new JTextArea(10, 10);

    Board board;

    public ScrabbleBoard() {
        Border blackBorder = BorderFactory.createLineBorder(
                Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //center panel
        board = new Board();
        //boardPanel.setSize(new Dimension(400, 400));
        //boardPanel.setLayout(new GridLayout(15, 15));
        //boardPanel.setBackground(Color.black);
        //boardPanel.add(grid);

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
        //String size = TileBag.getTileBagSizeStr();
        tileBagLabel.setText("TILES LEFT \n " + "-100-");//size); // get the number of tiles from size of bag using getTileBagSize()
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
        handPanel.setPreferredSize(new Dimension(100, 50));
        handPanel.setLayout(new GridLayout(1, 7));
        //JLabel hand
        handLabel.setPreferredSize(new Dimension(100, 50));
        handLabel.setBackground(Color.cyan);
        handPanel.add(handLabel);

        //put into frame
        add(handPanel, BorderLayout.SOUTH);
        add(leftPanel, BorderLayout.WEST);
        add(actionPanel, BorderLayout.EAST);
        add(board, BorderLayout.CENTER);
        pack();
        //frame.setVisible(true);
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

    public JLabel[][] getGrid() {
        return board.getGrid();
    }

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
