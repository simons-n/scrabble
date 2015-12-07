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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jms107
 */
public class Board extends javax.swing.JPanel {
    private JLabel[][] grid;
    private JPanel[][] squares;

    private ImageIcon backgroundImage = new ImageIcon(
            "Images/BackgroundSquare.png");
    private ImageIcon tripleLetterImage = new ImageIcon("Images/tls.png");
    private ImageIcon doubleLetterImage = new ImageIcon("Images/dls.png");
    private ImageIcon tripleWordImage = new ImageIcon("Images/tws.png");

    private ImageIcon doubleWordImage = new ImageIcon("Images/dws.png");
    private ImageIcon starImage = new ImageIcon("Images/centerStar.png");

    public Board() {

        this.grid = new JLabel[15][15];
        this.squares = new JPanel[15][15];
        this.setLayout(new GridLayout(15, 15));
        //this.setLayout(null);

        this.setBackground(Color.WHITE);
        javax.swing.border.Border grayBorder = BorderFactory.createLineBorder(
                Color.WHITE);
        setBorder(grayBorder);

        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                JPanel panel = new JPanel();
                panel.setBackground(Color.WHITE);
                JLabel label = new JLabel(getLabel(x, y));
                if (getLabel(x, y) == tripleWordImage) {
                    label.setToolTipText("Triple Word");
                } else if (getLabel(x, y) == tripleLetterImage) {
                    label.setToolTipText("Triple Letter");

                } else if (getLabel(x, y) == doubleWordImage) {
                    label.setToolTipText("Double Word");
                } else if (getLabel(x, y) == doubleLetterImage) {
                    label.setToolTipText("Double Letter");
                } else if (getLabel(x, y) == starImage) {
                    label.setToolTipText("Star");

                } else if (getLabel(x, y) == backgroundImage) {
                    label.setToolTipText("Square");
                }
                //panel.setPreferredSize(new Dimension(32, 50));
                panel.setBorder(grayBorder);
                panel.add(label);
                squares[x][y] = panel;
                grid[x][y] = label;
                add(panel);

            }
        }
    }

    public ImageIcon getLabel(int x, int y) {
        ImageIcon boardLabel = null;
        if ((x == 0 & y == 0) || (x == 0 & y == 14) || (x == 14 & y == 0) || (x == 14 & y == 14) || (x == 14 & y == 7) || (x == 7 & y == 14) || (x == 0 & y == 7) || (x == 7 & y == 0)) {
            boardLabel = tripleWordImage;
        } else if (x == 7 & y == 7) {
            boardLabel = starImage;
        } else if (((x != 0 & x != 14) & (y != 0 & y != 14) & (x != 7 & y != 7) & (x != 6 & y != 6) & (x != 8 & y != 8) & (x != 5 & y != 5) & (x != 9 & y != 9) & y == x) || (x == 13 & y == 1) || (x == 12 & y == 2) || (x == 11 & y == 3) || (x == 10 & y == 4) || (y == 13 & x == 1) || (y == 12 & x == 2) || (y == 11 & x == 3) || (y == 10 & x == 4)) {
            boardLabel = doubleWordImage;
        } else if ((x == 6 & y == 6) || (x == 8 & y == 8) || (x == 6 & y == 8) || (x == 8 & y == 6) || (x == 0 & y == 3) || (x == 0 & y == 11) || (x == 11 & y == 0) || (x == 3 & y == 0) || (x == 14 & y == 3) || (x == 14 & y == 11) || (x == 11 & y == 14) || (x == 3 & y == 14) || (x == 6 & y == 2) || (x == 7 & y == 3) || (x == 8 & y == 2) || (x == 12 & y == 6) || (x == 12 & y == 8) || (x == 11 & y == 7) || (y == 6 & x == 2) || (y == 7 & x == 3) || (y == 8 & x == 2) || (y == 12 & x == 6) || (y == 12 & x == 8) || (y == 11 & x == 7)) {
            boardLabel = doubleLetterImage;

        } else if ((x == 5 & y == 5) || (x == 9 & y == 9) || (x == 5 & y == 9) || (x == 9 & y == 5) || (x == 1 & y == 5) || (x == 1 & y == 9) || (x == 13 & y == 5) || (x == 13 & y == 9) || (y == 1 & x == 5) || (y == 1 & x == 9) || (y == 13 & x == 5) || (y == 13 & x == 9)) {
            boardLabel = tripleLetterImage;

        } else {

            boardLabel = backgroundImage;
        }
        return boardLabel;

    }

    public JLabel[][] getGrid() {
        return grid;
    }

    public void setGrid(JLabel[][] grid) {
        this.grid = grid;
    }

    public ImageIcon getBackgroundImage() {
        return backgroundImage;
    }

    public ImageIcon getTripleLetterImage() {
        return tripleLetterImage;
    }

    public ImageIcon getDoubleLetterImage() {
        return doubleLetterImage;
    }

    public ImageIcon getTripleWordImage() {
        return tripleWordImage;
    }

    public ImageIcon getDoubleWordImage() {
        return doubleWordImage;
    }

    public ImageIcon getStarImage() {
        return starImage;
    }

    public JPanel[][] getSquares() {
        return squares;
    }

}
