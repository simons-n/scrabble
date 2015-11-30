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

import Scrabble.model.Hand;
import Scrabble.model.Tile;
import Scrabble.model.TileBag;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    private ArrayList<Tile> tilesInHand = new ArrayList<>();
    private TileBag tileBag;

    public HandView() { //use this one to start the game
        setHand(player.hand);
    }

    public Hand createNewHand(TileBag tilebag) {
        Hand newHand = new Hand(tilesInHand);
        this.hand = new JLabel[7];
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        //this.setBackground(java.awt.Color.PINK);
        javax.swing.border.Border grayBorder = BorderFactory.createLineBorder(
                java.awt.Color.WHITE);
        setBorder(grayBorder);
        for (int x = 0; x < 7; x++) {
            Tile newTile = tilebag.draw();//get tiles from tile bag
            newHand.addTileFromBoard(newTile); //addTiles to hand class
            drawTile(newTile, x);
        }
        createTileListeners();
        return newHand;
    }

    public Hand setHand(Hand myHand) {  //use this one during the game when updated view
        this.hand = new JLabel[7];
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        javax.swing.border.Border grayBorder = BorderFactory.createLineBorder(
                java.awt.Color.WHITE);
        setBorder(grayBorder);
        for (int x = 0; x < 7; x++) {
            Tile tile = myHand.getTile(x);
            if (tile == null) {
                tile = tileBag.draw();
                myHand.addTileFromBoard(tile);
            }
            drawTile(tile, x);
        }
        createTileListeners();
        return myHand;
    }

//    public void setHand(Hand myHand) {
//        removeAll();
//        for (int x = 0; x < myHand.getTilesInHand().size(); x++) {
//            Tile tile = myHand.getTilesInHand().get(x);
//            int handLocation = x;
//            switch (tile.getLetter()) {
//                case A:
//                    addATile(this.hand, handLocation);
//                    break;
//                case B:
//                    addBTile(this.hand, handLocation);
//                    break;
//                case C:
//                    addCTile(this.hand, handLocation);
//                    break;
//                case D:
//                    addDTile(this.hand, handLocation);
//                    break;
//                case E:
//                    addETile(this.hand, handLocation);
//                    break;
//                case F:
//                    addFTile(this.hand, handLocation);
//                    break;
//                case G:
//                    addGTile(this.hand, handLocation);
//                    break;
//                case H:
//                    addHTile(this.hand, handLocation);
//                    break;
//                case I:
//                    addITile(this.hand, handLocation);
//                    break;
//                case J:
//                    addJTile(this.hand, handLocation);
//                    break;
//                case K:
//                    addKTile(this.hand, handLocation);
//                    break;
//                case L:
//                    addLTile(this.hand, handLocation);
//                    break;
//                case M:
//                    addMTile(this.hand, handLocation);
//                    break;
//                case N:
//                    addNTile(this.hand, handLocation);
//                    break;
//                case O:
//                    addOTile(this.hand, handLocation);
//                    break;
//                case P:
//                    addPTile(this.hand, handLocation);
//                    break;
//                case Q:
//                    addQTile(this.hand, handLocation);
//                    break;
//                case R:
//                    addRTile(this.hand, handLocation);
//                    break;
//                case S:
//                    addSTile(this.hand, handLocation);
//                    break;
//                case T:
//                    addTTile(this.hand, handLocation);
//                    break;
//                case U:
//                    addUTile(this.hand, handLocation);
//                    break;
//                case V:
//                    addVTile(this.hand, handLocation);
//                    break;
//                case W:
//                    addWTile(this.hand, handLocation);
//                    break;
//                case X:
//                    addXTile(this.hand, handLocation);
//                    break;
//                case Y:
//                    addYTile(this.hand, handLocation);
//                    break;
//                case Z:
//                    addZTile(this.hand, handLocation);
//                    break;
//                default:
//                    addBlankTile(this.hand, handLocation);
//                    break;
//            }
//        }
//    }
    public void drawTile(Tile newTile, int handLocation) {
        switch (newTile.getLetter()) {
            case A:
                addATile(this.hand, handLocation);
                break;
            case B:
                addBTile(this.hand, handLocation);
                break;
            case C:
                addCTile(this.hand, handLocation);
                break;
            case D:
                addDTile(this.hand, handLocation);
                break;
            case E:
                addETile(this.hand, handLocation);
                break;
            case F:
                addFTile(this.hand, handLocation);
                break;
            case G:
                addGTile(this.hand, handLocation);
                break;
            case H:
                addHTile(this.hand, handLocation);
                break;
            case I:
                addITile(this.hand, handLocation);
                break;
            case J:
                addJTile(this.hand, handLocation);
                break;
            case K:
                addKTile(this.hand, handLocation);
                break;
            case L:
                addLTile(this.hand, handLocation);
                break;
            case M:
                addMTile(this.hand, handLocation);
                break;
            case N:
                addNTile(this.hand, handLocation);
                break;
            case O:
                addOTile(this.hand, handLocation);
                break;
            case P:
                addPTile(this.hand, handLocation);
                break;
            case Q:
                addQTile(this.hand, handLocation);
                break;
            case R:
                addRTile(this.hand, handLocation);
                break;
            case S:
                addSTile(this.hand, handLocation);
                break;
            case T:
                addTTile(this.hand, handLocation);
                break;
            case U:
                addUTile(this.hand, handLocation);
                break;
            case V:
                addVTile(this.hand, handLocation);
                break;
            case W:
                addWTile(this.hand, handLocation);
                break;
            case X:
                addXTile(this.hand, handLocation);
                break;
            case Y:
                addYTile(this.hand, handLocation);
                break;
            case Z:
                addZTile(this.hand, handLocation);
                break;
            default:
                addBlankTile(this.hand, handLocation);
                break;
        }
    }

    public void addATile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(aTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addBTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(bTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addCTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(cTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addDTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(dTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addETile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(eTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addFTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(fTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addGTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(gTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addHTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(hTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addITile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(iTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addJTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(jTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addKTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(kTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addLTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(lTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addMTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(mTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addNTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(nTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addOTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(oTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addPTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(pTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addQTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(qTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addRTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(rTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addSTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(sTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addTTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(tTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addUTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(uTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addVTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(vTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addWTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(wTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addXTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(xTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addYTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(yTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addZTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(zTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public void addBlankTile(JLabel[] hand, int handLocation) {
        hand[handLocation] = new JLabel(blankTileImage);
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
    }

    public JLabel[] getHand() {
        return hand;
    }

    public void createTileListeners() {
        for (JLabel tile : hand) {
            tile.addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        }
        System.out.println("created listeners");
    }

}
