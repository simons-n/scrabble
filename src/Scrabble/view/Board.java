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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jms107
 */
public class Board extends javax.swing.JPanel {
    private JLabel[][] grid;
    private JLabel blankBoardSquare;
    private JLabel doubleLetterScoreSquare;
    private JLabel doubleWordScoreSquare;
    private JLabel tripleLetterScoreSquare;
    private JLabel tripleWordScoreSquare;
    private JLabel starCenterSquare;
    private ImageIcon backgroundImage = new ImageIcon("BackgroundSquare.png");
    private ImageIcon tripleLetterImage = new ImageIcon("tls.png");
    private ImageIcon doubleLetterImage = new ImageIcon("dls.png");
    private ImageIcon trippleWordImage = new ImageIcon("tws.png");
    private ImageIcon doubleWordImage = new ImageIcon("dws.png");
    private ImageIcon starImage = new ImageIcon("centerStar.png");

    public Board() {

        this.grid = new JLabel[15][15];

        javax.swing.border.Border grayBorder = BorderFactory.createLineBorder(
                Color.WHITE);
        setBorder(grayBorder);
        blankBoardSquare = new JLabel(backgroundImage);
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
//                if ((x == 0 & y == 0) || (x == 0 & y == 14) || (x == 14 & y == 0) || (x == 14 & y == 14) || (x == 14 & y == 7) || (x == 7 & y == 14) || (x == 0 & y == 7) || (x == 7 & y == 7)) {
//                    addTWS(this.grid, x, y);
//                } else if ((x == 7 & y == 7)) {
//                    addStar(this.grid, x, y);
//                } else if ((x != 0 & x != 14) & (y != 0 & y != 14) & y == x) {
//                    addDWS(this.grid,x,y);
//
//                }

                this.grid[x][y] = blankBoardSquare;
                this.grid[x][y].setBorder(BorderFactory.createLineBorder(
                        Color.WHITE));
                add(this.grid[x][y]);
            }
        }
    }

    public void addTWS(JLabel[][] grid, int x, int y) {
        tripleWordScoreSquare.setIcon(trippleWordImage);
        grid[x][y] = tripleWordScoreSquare;

    }

    public void addTLS(JLabel[][] grid, int x, int y) {
        tripleLetterScoreSquare.setIcon(tripleLetterImage);
        grid[x][y] = tripleLetterScoreSquare;
    }

    public void addDWS(JLabel[][] grid, int x, int y) {
        doubleWordScoreSquare.setIcon(doubleWordImage);
        grid[x][y] = doubleWordScoreSquare;
    }

    public void addDLS(JLabel[][] grid, int x, int y) {
        doubleLetterScoreSquare.setIcon(doubleLetterImage);
        grid[x][y] = doubleLetterScoreSquare;
    }

    public void addStar(JLabel[][] grid, int x, int y) {
        starCenterSquare.setIcon(starImage);
        grid[x][y] = doubleLetterScoreSquare;
    }

}
