/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Caroline Whitman, Jenna Slusar, Nick Simons
 * Date: Nov 8, 2015
 * Time: 4:16:24 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: Hand
 * Description: Represents the tiles that are in your hand to play.
 * ****************************************
 */
package Scrabble.model;

import Scrabble.view.ScrabbleBoard;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 * Hand is an arrayList of seven tiles
 *
 * @author jms107
 */
public class Hand {
    private ArrayList<Tile> tilesInHand;
    private ScrabbleBoard view;
    private TileBag bag;
    private Val val;
    private Game game;
    private int index;
    private boolean isUndoing; //is the boolean to get the undo button to work, by not removing the JLabel when added back into the hand

    public Hand(ArrayList<Tile> tilesInHand, Player player) {
        this.tilesInHand = tilesInHand;
        this.game = player.getGame();
        this.bag = this.game.getTileBag();
    }

    public Tile getTile(int x) {
        return this.tilesInHand.get(x);
    }

    public int getHandSize() {
        return this.tilesInHand.size();
    }

    public boolean getIsUndoing() {
        return this.isUndoing;
    }

    /**
     * Checks to see if the tiles in the hand contains the param
     *
     * @param tile
     * @return contains
     */
    public boolean containsTile(Tile tile) {
        boolean contains = false;
        for (int x = 0; x < tilesInHand.size(); x++) {
            if (tilesInHand.get(x).getLetter() == tile.getLetter()) {
                contains = true;
            }
        }
        return contains;
    }

    /**
     * This method is used in undo because in order to add the tile back to the
     * hand you have to make the size of the hand bigger because when the tile
     * was removed from the hand originally the hand size was decreased by 1.
     *
     * @param tile
     */
    public void addTileFromBoard(Tile tile) {
        ArrayList<Tile> biggerHand = new ArrayList<Tile>(tilesInHand.size() + 1);
        for (int i = 0; i < tilesInHand.size(); i++) {
            biggerHand.add(tilesInHand.get(i));
        }
        biggerHand.add(tile);
        this.tilesInHand = biggerHand;
    }

    /**
     * Adds a tile to the list of tiles in tilesInHand
     *
     * @param tile
     */
    public void addTile(Tile tile) {
        this.tilesInHand.add(tile);
    }

    /**
     * This changes the list of tiles by removing the param from the list. This
     * is called when the tile is clicked to be placed on the board.
     *
     * @param tileToRemove
     */
    public void removeTile(Tile tileToRemove) {
        ArrayList<Tile> newTiles = new ArrayList<Tile>(tilesInHand.size() - 1);//creates a sammler list to be used to place all the tiles from the old hand minus the one removed into
        for (int i = 0; i < tilesInHand.size(); i++) {
            if (tilesInHand.get(i) != tileToRemove) {
                newTiles.add(tilesInHand.get(i));
            }
        }
        this.tilesInHand = newTiles;
    }

    public void setTilesInHand() {
        ArrayList<Tile> newTiles = new ArrayList<Tile>(tilesInHand.size() - 1);
        for (int i = 0; i < tilesInHand.size() - 2; i++) {
            newTiles.add(tilesInHand.get(i));
        }
        tilesInHand = newTiles;
    }

    /**
     * This method is called when the swap button is pressed. It gets the index
     * in the hand of which tile in the hand needs to be swapped. Removes that
     * tile from the hand and adds the picked up tile in its place. Also adds
     * the tile from the hand to the tile bag and removes the picked up tile
     * from the tile bag.
     *
     * @param myTile
     * @param pickedUpTile
     */
    public void switchTiles(Tile myTile, Tile pickedUpTile) {

        for (int x = 0; x < tilesInHand.size(); x++) {
            if (tilesInHand.get(x).getLetter() == myTile.getLetter()) {
                index = x;
            }
        }
        tilesInHand.remove(index);
        tilesInHand.add(index, pickedUpTile);
        bag.removeTile(pickedUpTile);
        bag.addTile(myTile);
    }

    /**
     * Shuffles the tiles in the list using the Collections API
     */
    public void shuffle() {
        Collections.shuffle(tilesInHand);

        //randomly change the positions of tiles in array
    }

    /**
     * Used when the swap button is pressed in the GUI. Prompts the user for a
     * tile that is a tile and in their hand that they would like to swap, and
     * swaps it with a random tile from the tile bag.
     */
    public void createSwap() {

        String tileStr = JOptionPane.showInputDialog(view,
                                                     "Type the letter of the tile you would like to swap (or blank for a blank tile): ",
                                                     "Swap",
                                                     DISPOSE_ON_CLOSE);
        if (tileStr == null) {
            //do nothing, when cancel button is pressed
        } else {
            String upCaseStr = tileStr.toUpperCase(); //you can input lower case or upper case
            try {
                Val tileValue = val.valueOf(upCaseStr); // checks if string is a tile value
                Tile tile = new Tile(tileValue);
                boolean contains = containsTile(tile);  //checks if actually have tile in hand
                if (contains == true) {
                    Tile newTile = bag.draw(); //gets a random tile from the tile bag
                    JOptionPane.showMessageDialog(view,
                                                  "Your new tile is:   " + newTile.toString(),
                                                  "New Tile",
                                                  DISPOSE_ON_CLOSE);
                    switchTiles(tile, newTile); //switches tiles in hand
                } else {
                    JOptionPane.showMessageDialog(view,
                                                  "You do not have a " + tile.toString() + " tile in your hand to swap. You have to choose a tile in your hand.",
                                                  "Error", DISPOSE_ON_CLOSE);
                    createSwap();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(view,
                                              tileStr + " is an illegal input, you need to only type the letter of a tile.",
                                              "Error", DISPOSE_ON_CLOSE);
                createSwap();

            }

        }

    }

    public ArrayList<Tile> getTilesInHand() {
        return tilesInHand;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < tilesInHand.size(); i++) {
            if (Tile.class.isInstance(this.tilesInHand.get(i))) {
                s += this.tilesInHand.get(i).getLetter();
            }
        }
        return s;
    }

}
