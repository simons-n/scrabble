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
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jms107
 */
public class Board extends javax.swing.JPanel {
    private JLabel[][] grid;

    private JLabel doubleLetterScoreSquare = new JLabel();
    private JLabel doubleWordScoreSquare = new JLabel();
    private JLabel tripleLetterScoreSquare = new JLabel();
    private JLabel tripleWordScoreSquare = new JLabel();
    private JLabel starCenterSquare = new JLabel();
    private ImageIcon backgroundImage = new ImageIcon(
            "Images/rsz_backgroundsquare.png");
    private JLabel blankBoardSquare = new JLabel(backgroundImage);
    private ImageIcon tripleLetterImage = new ImageIcon("Images/tls.png");
    private ImageIcon doubleLetterImage = new ImageIcon("Images/dls.png");
    private ImageIcon tripleWordImage = new ImageIcon("Images/tws.png");
    private ImageIcon doubleWordImage = new ImageIcon("Images/dws.png");
    private ImageIcon starImage = new ImageIcon("Images/centerStar.png");

    public Board() {

        this.grid = new JLabel[15][15];
        this.setLayout(new GridLayout(15, 15));
        this.setBackground(Color.gray);
        this.setSize(new Dimension(10, 10));
        this.add(blankBoardSquare);
        this.add(blankBoardSquare);
//        JFrame board = new JFrame();
//        board.setLayout(new GridLayout(15, 15));
//        board.add(blankBoardSquare);
//        board.pack();
//        board.setVisible(true);

//        for (int m = 0; m < 15; m++) {
//            for (int n = 0; n < 15; n++) {
//                this.grid[m][n] = blankBoardSquare;
//                add(this.grid[m][n]);
//            }
//        }
//        javax.swing.border.Border grayBorder = BorderFactory.createLineBorder(
//                Color.WHITE);
//        setBorder(grayBorder);
//        blankBoardSquare = new JLabel(backgroundImage);
//        for (int x = 0; x < 15; x++) {
//            for (int y = 0; y < 15; y++) {
//                if ((x == 0 & y == 0) || (x == 0 & y == 14) || (x == 14 & y == 0) || (x == 14 & y == 14) || (x == 14 & y == 7) || (x == 7 & y == 14) || (x == 0 & y == 7) || (x == 7 & y == 7)) {
//                    addTWS(this.grid, x, y);
//                } else if ((x == 7 & y == 7)) {
//                    addStar(this.grid, x, y);
//                } else if ((x != 0 & x != 14) & (y != 0 & y != 14) & y == x) {
//                    addDWS(this.grid, x, y);
//
//                } else {
//
//                    this.grid[x][y] = blankBoardSquare;
//                    this.grid[x][y].setBorder(BorderFactory.createLineBorder(
//                            Color.WHITE));
//                    add(this.grid[x][y]);
//                }
//            }
//        }
    }

    public void addTWS(JLabel[][] grid, int x, int y) {
        tripleWordScoreSquare.setIcon(tripleWordImage);
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
