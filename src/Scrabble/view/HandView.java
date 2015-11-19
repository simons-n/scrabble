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
 * File: HandView
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
public class HandView extends javax.swing.JPanel {
    private JLabel[] hand;
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

    public HandView() {
        for (Tile tile : tileBag) {
            System.out.println("Tile: " + tile);
        }
        this.hand = new JLabel[7];
        this.setLayout(new GridLayout(1, 7));
        this.setBackground(java.awt.Color.PINK);
        javax.swing.border.Border grayBorder = BorderFactory.createLineBorder(
                java.awt.Color.WHITE);
        setBorder(grayBorder);
        for (int x = 0; x < 7; x++) {
            Tile newTile = tileBag.draw();//get tiles from tile bag
            switch (newTile.getLetter()) {
                case A:
                    addATile(this.hand, x);
                    break;
                case B:
                    addBTile(this.hand, x);
                    break;
                case C:
                    addCTile(this.hand, x);
                    break;
                case D:
                    addDTile(this.hand, x);
                    break;
                case E:
                    addETile(this.hand, x);
                    break;
                case F:
                    addFTile(this.hand, x);
                    break;
                case G:
                    addGTile(this.hand, x);
                    break;
                case H:
                    addHTile(this.hand, x);
                    break;
                case I:
                    addITile(this.hand, x);
                    break;
                case J:
                    addJTile(this.hand, x);
                    break;
                case K:
                    addKTile(this.hand, x);
                    break;
                case L:
                    addLTile(this.hand, x);
                    break;
                case M:
                    addMTile(this.hand, x);
                    break;
                case N:
                    addNTile(this.hand, x);
                    break;
                case O:
                    addOTile(this.hand, x);
                    break;
                case P:
                    addPTile(this.hand, x);
                    break;
                case Q:
                    addQTile(this.hand, x);
                    break;
                case R:
                    addRTile(this.hand, x);
                    break;
                case S:
                    addSTile(this.hand, x);
                    break;
                case T:
                    addTTile(this.hand, x);
                    break;
                case U:
                    addUTile(this.hand, x);
                    break;
                case V:
                    addVTile(this.hand, x);
                    break;
                case W:
                    addWTile(this.hand, x);
                    break;
                case X:
                    addXTile(this.hand, x);
                    break;
                case Y:
                    addYTile(this.hand, x);
                    break;
                case Z:
                    addZTile(this.hand, x);
                    break;
                default:
                    addBlankTile(this.hand, x);
                    break;
            }
        }

    }

    public void addATile(JLabel[] hand, int x) {
        hand[x] = new JLabel(aTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addBTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(bTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addCTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(cTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addDTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(dTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addETile(JLabel[] hand, int x) {
        hand[x] = new JLabel(eTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addFTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(fTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addGTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(gTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addHTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(hTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addITile(JLabel[] hand, int x) {
        hand[x] = new JLabel(iTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addJTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(jTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addKTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(kTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addLTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(lTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addMTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(mTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addNTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(nTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addOTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(oTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addPTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(pTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addQTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(qTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addRTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(rTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addSTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(sTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addTTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(tTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addUTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(uTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addVTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(vTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addWTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(wTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addXTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(xTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addYTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(yTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addZTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(zTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

    public void addBlankTile(JLabel[] hand, int x) {
        hand[x] = new JLabel(blankTileImage);
        hand[x].setPreferredSize(new Dimension(30, 30));
        add(hand[x]);
    }

}
