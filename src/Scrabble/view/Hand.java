/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Nov 18, 2015
 * Time: 10:16:20 AM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.view
 * File: Hand
 * Description:
 *
 * ****************************************
 */
package Scrabble.view;

import Scrabble.model.Tile;
import Scrabble.model.TileBag;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jms107
 */
public class Hand extends javax.swing.JPanel {
    private JLabel[][] hand;
    private ImageIcon aTileImage = new ImageIcon("Images/aTile.png");
    private ImageIcon bTileImage = new ImageIcon("Images/bTile.png");
    private ImageIcon cTileImage = new ImageIcon("Images/cTile.png");
    private ImageIcon dTileImage = new ImageIcon("Images/dTile.png");
    private ImageIcon eTileImage = new ImageIcon("Images/eTile.png");
    private ImageIcon fTileImage = new ImageIcon("Images/fTile.png");
    private ImageIcon gTileImage = new ImageIcon("Images/gTile.png");
    private ImageIcon hTileImage = new ImageIcon("Images/hTile.png");
    private ImageIcon iTileImage = new ImageIcon("Images/iTile.png");
    private ImageIcon jTileImage = new ImageIcon("Images/jTile.png");
    private ImageIcon kTileImage = new ImageIcon("Images/kTile.png");
    private ImageIcon lTileImage = new ImageIcon("Images/lTile.png");
    private ImageIcon mTileImage = new ImageIcon("Images/mTile.png");
    private ImageIcon nTileImage = new ImageIcon("Images/nTile.png");
    private ImageIcon oTileImage = new ImageIcon("Images/oTile.png");
    private ImageIcon pTileImage = new ImageIcon("Images/pTile.png");
    private ImageIcon qTileImage = new ImageIcon("Images/qTile.png");
    private ImageIcon rTileImage = new ImageIcon("Images/rTile.png");
    private ImageIcon sTileImage = new ImageIcon("Images/sTile.png");
    private ImageIcon tTileImage = new ImageIcon("Images/tTile.png");
    private ImageIcon uTileImage = new ImageIcon("Images/uTile.png");
    private ImageIcon vTileImage = new ImageIcon("Images/vTile.png");
    private ImageIcon wTileImage = new ImageIcon("Images/wTile.png");
    private ImageIcon xTileImage = new ImageIcon("Images/xTile.png");
    private ImageIcon yTileImage = new ImageIcon("Images/yTile.png");
    private ImageIcon zTileImage = new ImageIcon("Images/zTile.png");
    private ImageIcon blankTileImage = new ImageIcon("Images/blankTile.png");

    private ArrayList<Tile> tilesInBag = new ArrayList<>();
    TileBag tileBag = new TileBag(tilesInBag);

    public Hand() {
        this.hand = new JLabel[7][1];
        this.setLayout(new GridLayout(7, 1));
        this.setBackground(java.awt.Color.PINK);
        javax.swing.border.Border grayBorder = BorderFactory.createLineBorder(
                java.awt.Color.WHITE);
        setBorder(grayBorder);
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 1; y++) {
                Tile newTile = tileBag.draw();//get tiles from tile bag
                if (newTile.getLetter() ==) {
                    addATile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.B) {
                    addBTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.C) {
                    addCTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.D) {
                    addDTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.E) {
                    addETile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.F) {
                    addFTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.G) {
                    addGTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.H) {
                    addHTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.I) {
                    addITile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.J) {
                    addJTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.K) {
                    addKTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.L) {
                    addLTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.M) {
                    addMTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.N) {
                    addNTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.O) {
                    addOTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.P) {
                    addPTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.Q) {
                    addQTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.R) {
                    addRTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.S) {
                    addSTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.T) {
                    addTTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.U) {
                    addUTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.V) {
                    addVTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.W) {
                    addWTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.X) {
                    addXTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.Y) {
                    addYTile(this.hand, x, y);
                } else if (newTile.getLetter() == Val.Z) {
                    addZTile(this.hand, x, y);
                } else {
                    addBlankTile(this.hand, x, y);
                }
            }
        }

    }

    public void addATile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(aTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addBTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(bTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addCTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(cTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addDTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(dTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addETile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(eTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addFTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(fTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addGTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(gTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addHTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(hTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addITile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(iTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addJTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(jTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addKTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(kTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addLTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(lTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addMTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(mTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addNTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(nTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addOTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(oTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addPTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(pTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addQTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(qTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addRTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(rTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addSTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(sTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addTTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(tTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addUTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(uTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addVTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(vTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addWTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(wTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addXTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(xTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addYTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(yTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addZTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(zTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

    public void addBlankTile(JLabel[][] hand, int x, int y) {
        hand[x][y] = new JLabel(blankTileImage);
        hand[x][y].setPreferredSize(new Dimension(30, 30));
        add(hand[x][y]);
    }

}
