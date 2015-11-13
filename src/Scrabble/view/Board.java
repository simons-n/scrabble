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
    private JLabel blankBoardSquare;
    private JLabel doubleLetterScoreSquare;
    private JLabel doubleWordScoreSquare;
    private JLabel tripleLetterScoreSquare;
    private JLabel tripleWordScoreSquare;
    private JLabel starCenterSquare;

    public Board() {
        this.grid = new JLabel[15][15];
        setLayout(new GridLayout(15, 15));
        javax.swing.border.Border grayBorder = BorderFactory.createLineBorder(
                Color.WHITE);
        setBorder(grayBorder);
        blankBoardSquare.setIcon(new javax.swing.ImageIcon(
                getClass().getResources(
                        "/csci205FinalProject/src/Scrabble/view/BackgroundSquare.png")));
        for (int x = 0; x < 15; x++) {
            for (int y = 0; x < 15; y++) {
                if ((x == 0 & y == 0) || (x == 0 & y == 14) || (x == 14 & y == 0) || (x == 14 & y == 14) || (x == 14 & y == 7) || (x == 7 & y == 14) || (x == 0 & y == 7) || (x == 7 & y == 7)) {
                    addTWS(this.grid, x, y);
                } else if ((x == 7 & y == 7)) {
                    addStar(this.grid, x, y);
                } else if ((x != 0 & x != 14) & (y != 0 & y != 14) & y == x) {

                }

                this.grid[x][y] = blankBoardSquare;
                this.grid[x][y].setBorder(BorderFactory.createLineBorder(
                        Color.WHITE));
                add(this.grid[x][y]);
            }
        }
    }

    public void addTWS(JLabel[][] grid, int x, int y) {
        tripleWordScoreSquare.setIcon(new javax.swing.ImageIcon(
                getClass().getResources(
                        "/csci205FinalProject/src/Scrabble/view/tws.png")));
        grid[x][y] = tripleWordScoreSquare;

    }

    public void addTLS(JLabel[][] grid, int x, int y) {
        tripleLetterScoreSquare.setIcon(new javax.swing.ImageIcon(
                getClass().getResources(
                        "/csci205FinalProject/src/Scrabble/view/tls.png")));
        grid[x][y] = tripleLetterScoreSquare;
    }

    public void addDWS(JLabel[][] grid, int x, int y) {
        doubleWordScoreSquare.setIcon(new javax.swing.ImageIcon(
                getClass().getResources(
                        "/csci205FinalProject/src/Scrabble/view/dws.png")));
        grid[x][y] = doubleWordScoreSquare;
    }

    public void addDLS(JLabel[][] grid, int x, int y) {
        doubleLetterScoreSquare.setIcon(new javax.swing.ImageIcon(
                getClass().getResources(
                        "/csci205FinalProject/src/Scrabble/view/dls.png")));
        grid[x][y] = doubleLetterScoreSquare;
    }

    public void addStar(JLabel[][] grid, int x, int y) {
        starCenterSquare.setIcon(new javax.swing.ImageIcon(
                getClass().getResources(
                        "/csci205FinalProject/src/Scrabble/view/centerStar.png")));
        grid[x][y] = doubleLetterScoreSquare;
    }

}
