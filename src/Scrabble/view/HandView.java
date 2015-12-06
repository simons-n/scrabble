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
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jms107
 */
public class HandView extends javax.swing.JPanel {
    private JLabel[] jLabelHand;
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
    private boolean isDrawing;

    public HandView(Hand myHand) { //use this one to start the game
//        setHand(player.hand);
        //}

//    public Hand createNewHand(TileBag tilebag) {
//        Hand newHand = new Hand(tilesInHand);
//        this.hand = new JLabel[7];
//        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
//        //this.setBackground(java.awt.Color.PINK);
//        javax.swing.border.Border grayBorder = BorderFactory.createLineBorder(
//                java.awt.Color.WHITE);
//        setBorder(grayBorder);
//        for (int x = 0; x < 7; x++) {
//            Tile newTile = tilebag.draw();//get tiles from tile bag
//            newHand.addTileFromBoard(newTile); //addTiles to hand class
//            drawTile(newTile, x);
//        }
//        return newHand;
//    }
        //public Hand setHand(Hand myHand) {  //use this one during the game when updated view
        this.jLabelHand = new JLabel[7];
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        javax.swing.border.Border grayBorder = BorderFactory.createLineBorder(
                java.awt.Color.WHITE);
        setBorder(grayBorder);
        for (int x = 0; x < 7; x++) {
            Tile tile = myHand.getTile(x);
            drawTile(tile, x);
        }
//        createTileListeners();
    }

    public void setHand(Hand myHand) {
        this.isDrawing = false;
        for (int x = 0; x < myHand.getTilesInHand().size(); x++) {
            Tile tile = myHand.getTilesInHand().get(x);
            if (tile == null) {
                tile = tileBag.draw();
                myHand.addTileFromBoard(tile);
            }
            int handLocation = x;
            findTileInHand(tile, x);
        }
    }

    public void setJLabelHand(JLabel[] hand) {
        this.jLabelHand = hand;
    }

    public void drawTile(Tile newTile, int handLocation) {
        this.isDrawing = true;
        findTileInHand(newTile, handLocation);
    }

    public void findTileInHand(Tile tile, int handLocation) {
        switch (tile.getLetter()) {
            case A:
                addATile(this.jLabelHand, handLocation);
                break;
            case B:
                addBTile(this.jLabelHand, handLocation);
                break;
            case C:
                addCTile(this.jLabelHand, handLocation);
                break;
            case D:
                addDTile(this.jLabelHand, handLocation);
                break;
            case E:
                addETile(this.jLabelHand, handLocation);
                break;
            case F:
                addFTile(this.jLabelHand, handLocation);
                break;
            case G:
                addGTile(this.jLabelHand, handLocation);
                break;
            case H:
                addHTile(this.jLabelHand, handLocation);
                break;
            case I:
                addITile(this.jLabelHand, handLocation);
                break;
            case J:
                addJTile(this.jLabelHand, handLocation);
                break;
            case K:
                addKTile(this.jLabelHand, handLocation);
                break;
            case L:
                addLTile(this.jLabelHand, handLocation);
                break;
            case M:
                addMTile(this.jLabelHand, handLocation);
                break;
            case N:
                addNTile(this.jLabelHand, handLocation);
                break;
            case O:
                addOTile(this.jLabelHand, handLocation);
                break;
            case P:
                addPTile(this.jLabelHand, handLocation);
                break;
            case Q:
                addQTile(this.jLabelHand, handLocation);
                break;
            case R:
                addRTile(this.jLabelHand, handLocation);
                break;
            case S:
                addSTile(this.jLabelHand, handLocation);
                break;
            case T:
                addTTile(this.jLabelHand, handLocation);
                break;
            case U:
                addUTile(this.jLabelHand, handLocation);
                break;
            case V:
                addVTile(this.jLabelHand, handLocation);
                break;
            case W:
                addWTile(this.jLabelHand, handLocation);
                break;
            case X:
                addXTile(this.jLabelHand, handLocation);
                break;
            case Y:
                addYTile(this.jLabelHand, handLocation);
                break;
            case Z:
                addZTile(this.jLabelHand, handLocation);
                break;
            default:
                addBlankTile(this.jLabelHand, handLocation);
                break;
        }
    }

    public void addATile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(aTileImage);
        hand[handLocation].setToolTipText("A");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();

    }

    public void addBTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(bTileImage);
        hand[handLocation].setToolTipText("B");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();

    }

    public void addCTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(cTileImage);
        hand[handLocation].setToolTipText("C");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();

    }

    public void addDTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(dTileImage);
        hand[handLocation].setToolTipText("D");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addETile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(eTileImage);
        hand[handLocation].setToolTipText("E");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();

    }

    public void addFTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(fTileImage);
        hand[handLocation].setToolTipText("F");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addGTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(gTileImage);
        hand[handLocation].setToolTipText("G");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addHTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(hTileImage);
        hand[handLocation].setToolTipText("H");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addITile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(iTileImage);
        hand[handLocation].setToolTipText("I");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addJTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(jTileImage);
        hand[handLocation].setToolTipText("J");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addKTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(kTileImage);
        hand[handLocation].setToolTipText("K");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addLTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(lTileImage);
        hand[handLocation].setToolTipText("L");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addMTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(mTileImage);
        hand[handLocation].setToolTipText("M");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addNTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(nTileImage);
        hand[handLocation].setToolTipText("N");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addOTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(oTileImage);
        hand[handLocation].setToolTipText("O");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addPTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(pTileImage);
        hand[handLocation].setToolTipText("P");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addQTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(qTileImage);
        hand[handLocation].setToolTipText("Q");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addRTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(rTileImage);
        hand[handLocation].setToolTipText("R");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addSTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(sTileImage);
        hand[handLocation].setToolTipText("S");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addTTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(tTileImage);
        hand[handLocation].setToolTipText("T");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addUTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(uTileImage);
        hand[handLocation].setToolTipText("U");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addVTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(vTileImage);
        hand[handLocation].setToolTipText("V");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
//        this.revalidate();
    }

    public void addWTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(wTileImage);
        hand[handLocation].setToolTipText("W");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addXTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(xTileImage);
        hand[handLocation].setToolTipText("X");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addYTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(yTileImage);
        hand[handLocation].setToolTipText("Y");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addZTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(zTileImage);
        hand[handLocation].setToolTipText("Z");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addBlankTile(JLabel[] hand, int handLocation) {
        if (this.isDrawing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(blankTileImage);
        hand[handLocation].setToolTipText("BLANK");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public JLabel[] getJLabelHand() {
        return jLabelHand;
    }

    @Override
    public String toString() {
        String s = "";
        for (Tile tile : tilesInHand) {
            s += tile.toString();
        }
        return s;
    }

//    public void createTileListeners() {
//        for (JLabel tile : jLabelHand) {
//            tile.addMouseListener(new MouseListener() {
//
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                }
//
//                @Override
//                public void mousePressed(MouseEvent e) {
//                }
//
//                @Override
//                public void mouseReleased(MouseEvent e) {
//                }
//
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                }
//            });
//        }
//        //System.out.println("created listeners");
//    }
    public JLabel[] getjLabelHand() {
        return jLabelHand;
    }

    public ImageIcon getaTileImage() {
        return aTileImage;
    }

    public ImageIcon getbTileImage() {
        return bTileImage;
    }

    public ImageIcon getcTileImage() {
        return cTileImage;
    }

    public ImageIcon getdTileImage() {
        return dTileImage;
    }

    public ImageIcon geteTileImage() {
        return eTileImage;
    }

    public ImageIcon getfTileImage() {
        return fTileImage;
    }

    public ImageIcon getgTileImage() {
        return gTileImage;
    }

    public ImageIcon gethTileImage() {
        return hTileImage;
    }

    public ImageIcon getiTileImage() {
        return iTileImage;
    }

    public ImageIcon getjTileImage() {
        return jTileImage;
    }

    public ImageIcon getkTileImage() {
        return kTileImage;
    }

    public ImageIcon getlTileImage() {
        return lTileImage;
    }

    public ImageIcon getmTileImage() {
        return mTileImage;
    }

    public ImageIcon getnTileImage() {
        return nTileImage;
    }

    public ImageIcon getoTileImage() {
        return oTileImage;
    }

    public ImageIcon getpTileImage() {
        return pTileImage;
    }

    public ImageIcon getqTileImage() {
        return qTileImage;
    }

    public ImageIcon getrTileImage() {
        return rTileImage;
    }

    public ImageIcon getsTileImage() {
        return sTileImage;
    }

    public ImageIcon gettTileImage() {
        return tTileImage;
    }

    public ImageIcon getuTileImage() {
        return uTileImage;
    }

    public ImageIcon getvTileImage() {
        return vTileImage;
    }

    public ImageIcon getwTileImage() {
        return wTileImage;
    }

    public ImageIcon getxTileImage() {
        return xTileImage;
    }

    public ImageIcon getyTileImage() {
        return yTileImage;
    }

    public ImageIcon getzTileImage() {
        return zTileImage;
    }

    public ImageIcon getBlankTileImage() {
        return blankTileImage;
    }

    public ArrayList<Tile> getTilesInHand() {
        return tilesInHand;
    }

    public TileBag getTileBag() {
        return tileBag;
    }

    public boolean isIsDrawing() {
        return isDrawing;
    }
}
