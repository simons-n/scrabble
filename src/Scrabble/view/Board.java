/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Nov 12, 2015
 * Time: 8:26:43 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.view
 * File: Board
 * Description:
 *
 * ****************************************
 */
package Scrabble.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author jms107
 */
public class Board extends javax.swing.JPanel {
    private JLabel[][] grid;

    public Board() {
        this.grid = new JLabel[15][15];
        setLayout(new GridLayout(15, 15));
        javax.swing.border.Border grayBorder = BorderFactory.createLineBorder(
                Color.GRAY);
        setBorder(grayBorder);
        for (int x = 0; x < 15; x++) {
            for (int y = 0; x < 15; y++) {
                this.grid[x][y] = new JLabel();
                this.grid[x][y].setBackground(Color.WHITE);
                this.grid[x][y].setBorder(BorderFactory.createLineBorder(
                        Color.GRAY));
                add(this.grid[x][y]);
            }
        }
    }

}
