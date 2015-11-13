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

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author jms107
 */
public class ScrabbleBoard extends JFrame {
    JPanel boardPanel = new JPanel();
    JPanel handPanel = new JPanel();
    JPanel resultsPanel = new JPanel();
    JButton playbtn = new JButton("Play");
    JButton swapbtn = new JButton("Swap");
    JButton passbtn = new JButton("Pass");
    JButton shufflebtn = new JButton("Shuffle");

    public ScrabbleBoard() {
        boardPanel.setLayout(new GridLayout(15, 15));
        boardPanel.add(playbtn);
        boardPanel.add(swapbtn);
        boardPanel.add(passbtn);
        boardPanel.add(shufflebtn);
        //frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ScrabbleBoard window = new ScrabbleBoard();
                window.setTitle("Scrabble Game");
                window.setSize(800, 500);
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
