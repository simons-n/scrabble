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
public class ScrabbleBoard {
    JFrame frame = new JFrame("Scrabble");
    JPanel panel = new JPanel();
    JButton playbtn = new JButton("Play");
    JButton swapbtn = new JButton("Swap");
    JButton passbtn = new JButton("Pass");
    JButton shufflebtn = new JButton("Shuffle");

    public ScrabbleBoard() {
        panel.setLayout(new GridLayout(2, 2, 3, 3));
        panel.add(playbtn);
        panel.add(swapbtn);
        panel.add(passbtn);
        panel.add(shufflebtn);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ScrabbleBoard();
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
