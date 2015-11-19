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
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jms107
 */
public class Board extends javax.swing.JPanel {
    private JLabel[][] grid;

    private ImageIcon backgroundImage = new ImageIcon(
            "Images/BackgroundSquare.png");
    private ImageIcon tripleLetterImage = new ImageIcon("Images/tls.png");
    private ImageIcon doubleLetterImage = new ImageIcon("Images/dls.png");
    private ImageIcon tripleWordImage = new ImageIcon("Images/tws.png");
    private ImageIcon doubleWordImage = new ImageIcon("Images/dws.png");
    private ImageIcon starImage = new ImageIcon("Images/centerStar.png");

    public Board() {

        this.grid = new JLabel[15][15];
        this.setLayout(new GridLayout(15, 15));

        this.setBackground(Color.WHITE);
        javax.swing.border.Border grayBorder = BorderFactory.createLineBorder(
                Color.WHITE);
        setBorder(grayBorder);

        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                if ((x == 0 & y == 0) || (x == 0 & y == 14) || (x == 14 & y == 0) || (x == 14 & y == 14) || (x == 14 & y == 7) || (x == 7 & y == 14) || (x == 0 & y == 7) || (x == 7 & y == 0)) {
                    addTWS(this.grid, x, y);
                } else if (x == 7 & y == 7) {
                    addStar(this.grid, x, y);
                } else if (((x != 0 & x != 14) & (y != 0 & y != 14) & (x != 7 & y != 7) & (x != 6 & y != 6) & (x != 8 & y != 8) & (x != 5 & y != 5) & (x != 9 & y != 9) & y == x) || (x == 13 & y == 1) || (x == 12 & y == 2) || (x == 11 & y == 3) || (x == 10 & y == 4) || (y == 13 & x == 1) || (y == 12 & x == 2) || (y == 11 & x == 3) || (y == 10 & x == 4)) {
                    addDWS(this.grid, x, y);
                } else if ((x == 6 & y == 6) || (x == 8 & y == 8) || (x == 6 & y == 8) || (x == 8 & y == 6) || (x == 0 & y == 3) || (x == 0 & y == 11) || (x == 11 & y == 0) || (x == 3 & y == 0) || (x == 14 & y == 3) || (x == 14 & y == 11) || (x == 11 & y == 14) || (x == 3 & y == 14) || (x == 6 & y == 2) || (x == 7 & y == 3) || (x == 8 & y == 2) || (x == 12 & y == 6) || (x == 12 & y == 8) || (x == 11 & y == 7) || (y == 6 & x == 2) || (y == 7 & x == 3) || (y == 8 & x == 2) || (y == 12 & x == 6) || (y == 12 & x == 8) || (y == 11 & x == 7)) {
                    addDLS(this.grid, x, y);

                } else if ((x == 5 & y == 5) || (x == 9 & y == 9) || (x == 5 & y == 9) || (x == 9 & y == 5) || (x == 1 & y == 5) || (x == 1 & y == 9) || (x == 13 & y == 5) || (x == 13 & y == 9) || (y == 1 & x == 5) || (y == 1 & x == 9) || (y == 13 & x == 5) || (y == 13 & x == 9)) {
                    addTLS(this.grid, x, y);

                } else {

                    this.grid[x][y] = new JLabel(backgroundImage);
                    this.grid[x][y].setPreferredSize(new Dimension(30, 30));
                    this.grid[x][y].setBorder(BorderFactory.createLineBorder(
                            Color.WHITE));
                    add(this.grid[x][y]);
                }

            }
        }
    }

    public void addTWS(JLabel[][] grid, int x, int y) {
        grid[x][y] = new JLabel(tripleWordImage);
        grid[x][y].setPreferredSize(new Dimension(30, 30));
        grid[x][y].setBorder(BorderFactory.createLineBorder(
                Color.WHITE));
        add(grid[x][y]);

    }

    public void addTLS(JLabel[][] grid, int x, int y) {
        grid[x][y] = new JLabel(tripleLetterImage);
        grid[x][y].setPreferredSize(new Dimension(30, 30));
        grid[x][y].setBorder(BorderFactory.createLineBorder(
                Color.WHITE));
        add(grid[x][y]);
    }

    public void addDWS(JLabel[][] grid, int x, int y) {
        grid[x][y] = new JLabel(doubleWordImage);
        grid[x][y].setPreferredSize(new Dimension(30, 30));
        grid[x][y].setBorder(BorderFactory.createLineBorder(
                Color.WHITE));
        add(grid[x][y]);
    }

    public void addDLS(JLabel[][] grid, int x, int y) {
        grid[x][y] = new JLabel(doubleLetterImage);
        grid[x][y].setPreferredSize(new Dimension(30, 30));
        grid[x][y].setBorder(BorderFactory.createLineBorder(
                Color.WHITE));
        add(grid[x][y]);
    }

    public void addStar(JLabel[][] grid, int x, int y) {
        grid[x][y] = new JLabel(starImage);
        grid[x][y].setPreferredSize(new Dimension(30, 30));
        grid[x][y].setBorder(BorderFactory.createLineBorder(
                Color.WHITE));
        add(grid[x][y]);
    }

    public JLabel[][] getGrid() {
        return grid;
    }

}
