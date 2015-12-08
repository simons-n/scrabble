/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Jenna Slusar, Caroline Whitman, Nick Simons
 * Date: Nov 18, 2015
 * Time: 10:16:20 AM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.view
 * File: HandView
 * Description: Creates the players hand that they see in the GUI
 *
 * ****************************************
 */
package Scrabble.view;

import Scrabble.model.Hand;
import Scrabble.model.Tile;
import Scrabble.model.TileBag;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jms107
 */
public class HandView extends javax.swing.JPanel {

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

    private JLabel[] jLabelHand;
    private TileBag tileBag;
    private boolean isDrawing;
    private Hand playerHand;
    private boolean isTurnOver = false;

    public HandView(Hand myHand) {
        this.playerHand = myHand;
        this.jLabelHand = new JLabel[7];
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        javax.swing.border.Border grayBorder = BorderFactory.createLineBorder(
                java.awt.Color.WHITE);
        setBorder(grayBorder);
        for (int x = 0; x < 7; x++) {
            Tile tile = myHand.getTile(x);
            drawTile(tile, x);
        }
    }

    /**
     * This method is called to update the GUI after the first hand is created,
     * which is why isDrawing is false.
     *
     * @param myHand
     * @param isUndo
     * @return
     */
    public JLabel[] setHand(Hand myHand, boolean isUndo) {
        this.playerHand = myHand;
        this.isDrawing = false;
        if (isUndo == true) {
            return setHandAfterUndo(myHand);
        }
        JLabel[] handToAddTo = null;
        for (int x = 0; x < myHand.getTilesInHand().size(); x++) {
            Tile tile = myHand.getTilesInHand().get(x);
            if (isTurnOver == true) {
                if (tile == null) {
                    tile = tileBag.draw();
                    myHand.addTileFromBoard(tile);

                }
                //with this uncommented, remove works but shuffle doesn't
                findTileInHand(jLabelHand, tile, x, false);
            }

            findTileInHand(jLabelHand, tile, x, false);
        }
        return jLabelHand;
    }

    /**
     * This method is called after the undo button is pressed, it adds JLabel
     * tiles to the new JLabel hand while isUndooing is true, so no JLabels are
     * removed
     *
     * @param myHand
     * @return
     */
    public JLabel[] setHandAfterUndo(Hand myHand) {
        JLabel[] newLabelHand = new JLabel[myHand.getHandSize()];
        for (int x = 0; x < myHand.getTilesInHand().size(); x++) {
            Tile tile = myHand.getTilesInHand().get(x);
            findTileInHand(newLabelHand, tile, x, true);
        }
        jLabelHand = newLabelHand;
        return jLabelHand;
    }

    public void setJLabelHand(JLabel[] hand) {
        this.jLabelHand = hand;
    }

    /**
     * This method is called to create the new hand, which is why isDrawing is
     * true because it is drawing new JLabels
     *
     * @param newTile
     * @param handLocation
     */
    public void drawTile(Tile newTile, int handLocation) {
        this.isDrawing = true;
        findTileInHand(jLabelHand, newTile, handLocation, false);
    }

    /**
     * This method chooses which tile JLabel is to be added to the JLabel hand
     * by using a switch
     *
     * @param handToAddTo
     * @param tile
     * @param handLocation
     * @param isUndoing
     */
    public void findTileInHand(JLabel[] handToAddTo, Tile tile, int handLocation,
                               boolean isUndoing) {

        switch (tile.getLetter()) {
            case A:
                addATile(handToAddTo, handLocation, isUndoing);
                break;
            case B:
                addBTile(handToAddTo, handLocation, isUndoing);
                break;
            case C:
                addCTile(handToAddTo, handLocation, isUndoing);
                break;
            case D:
                addDTile(handToAddTo, handLocation, isUndoing);
                break;
            case E:
                addETile(handToAddTo, handLocation, isUndoing);
                break;
            case F:
                addFTile(handToAddTo, handLocation, isUndoing);
                break;
            case G:
                addGTile(handToAddTo, handLocation, isUndoing);
                break;
            case H:
                addHTile(handToAddTo, handLocation, isUndoing);
                break;
            case I:
                addITile(handToAddTo, handLocation, isUndoing);
                break;
            case J:
                addJTile(handToAddTo, handLocation, isUndoing);
                break;
            case K:
                addKTile(handToAddTo, handLocation, isUndoing);
                break;
            case L:
                addLTile(handToAddTo, handLocation, isUndoing);
                break;
            case M:
                addMTile(handToAddTo, handLocation, isUndoing);
                break;
            case N:
                addNTile(handToAddTo, handLocation, isUndoing);
                break;
            case O:
                addOTile(handToAddTo, handLocation, isUndoing);
                break;
            case P:
                addPTile(handToAddTo, handLocation, isUndoing);
                break;
            case Q:
                addQTile(handToAddTo, handLocation, isUndoing);
                break;
            case R:
                addRTile(handToAddTo, handLocation, isUndoing);
                break;
            case S:
                addSTile(handToAddTo, handLocation, isUndoing);
                break;
            case T:
                addTTile(handToAddTo, handLocation, isUndoing);
                break;
            case U:
                addUTile(handToAddTo, handLocation, isUndoing);
                break;
            case V:
                addVTile(handToAddTo, handLocation, isUndoing);
                break;
            case W:
                addWTile(handToAddTo, handLocation, isUndoing);
                break;
            case X:
                addXTile(handToAddTo, handLocation, isUndoing);
                break;
            case Y:
                addYTile(handToAddTo, handLocation, isUndoing);
                break;
            case Z:
                addZTile(handToAddTo, handLocation, isUndoing);
                break;
            default:
                addBlankTile(handToAddTo, handLocation, isUndoing);
                break;
        }
    }

    /**
     * each add a tile method removes the JLabel from the hand at the location
     * param given, if it is not undoing(the undo button pressed) and not
     * drawing(creating the first hand). Then changes the JLabel to a new JLabel
     * of the specific tile and adds it to the hand, which updates the GUI
     *
     * We realize that this could be refactored more because its the same code
     * over and over again, we would have refactored it if we had time
     *
     * @param hand
     * @param handLocation
     * @param isUndoing
     */
    public void addATile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(aTileImage);
        hand[handLocation].setToolTipText("A");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();

    }

    public void addBTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(bTileImage);
        hand[handLocation].setToolTipText("B");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();

    }

    public void addCTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(cTileImage);
        hand[handLocation].setToolTipText("C");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();

    }

    public void addDTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(dTileImage);
        hand[handLocation].setToolTipText("D");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addETile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(eTileImage);
        hand[handLocation].setToolTipText("E");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();

    }

    public void addFTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(fTileImage);
        hand[handLocation].setToolTipText("F");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addGTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(gTileImage);
        hand[handLocation].setToolTipText("G");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addHTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(hTileImage);
        hand[handLocation].setToolTipText("H");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addITile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(iTileImage);
        hand[handLocation].setToolTipText("I");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addJTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(jTileImage);
        hand[handLocation].setToolTipText("J");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addKTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(kTileImage);
        hand[handLocation].setToolTipText("K");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addLTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(lTileImage);
        hand[handLocation].setToolTipText("L");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addMTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(mTileImage);
        hand[handLocation].setToolTipText("M");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addNTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(nTileImage);
        hand[handLocation].setToolTipText("N");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addOTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(oTileImage);
        hand[handLocation].setToolTipText("O");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addPTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(pTileImage);
        hand[handLocation].setToolTipText("P");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addQTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(qTileImage);
        hand[handLocation].setToolTipText("Q");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addRTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(rTileImage);
        hand[handLocation].setToolTipText("R");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addSTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(sTileImage);
        hand[handLocation].setToolTipText("S");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addTTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(tTileImage);
        hand[handLocation].setToolTipText("T");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addUTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(uTileImage);
        hand[handLocation].setToolTipText("U");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addVTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(vTileImage);
        hand[handLocation].setToolTipText("V");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addWTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(wTileImage);
        hand[handLocation].setToolTipText("W");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addXTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(xTileImage);
        hand[handLocation].setToolTipText("X");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addYTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(yTileImage);
        hand[handLocation].setToolTipText("Y");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addZTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
            this.remove(hand[handLocation]);
        }
        hand[handLocation] = new JLabel(zTileImage);
        hand[handLocation].setToolTipText("Z");
        hand[handLocation].setPreferredSize(new Dimension(30, 30));
        add(hand[handLocation]);
        this.revalidate();
    }

    public void addBlankTile(JLabel[] hand, int handLocation, boolean isUndoing) {
        if (this.isDrawing == false && isUndoing == false) {
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
        for (JLabel tile : jLabelHand) {
            if (tile != null) {
                s += tile.getToolTipText();
            }
        }
        return s;
    }

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

    public TileBag getTileBag() {
        return tileBag;
    }

    public boolean getIsDrawing() {
        return isDrawing;
    }
}
