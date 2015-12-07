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
 * Description: Represents the tiles that are in your hand to play
 *
 * ****************************************
 */
package Scrabble.model;

import Scrabble.view.ScrabbleBoard;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
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

    public boolean containsTile(Tile tile) {
        boolean contains = false;
        for (int x = 0; x < tilesInHand.size(); x++) {
            if (tilesInHand.get(x).getLetter() == tile.getLetter()) {
                contains = true;
            }
        }
        return contains;
    }

    public void addTileFromBoard(Tile tile) {
        this.tilesInHand.add(tile);
    }

    public void addTile(Tile tile) {
        this.tilesInHand.add(tile);
    }

    public void removeTile(Tile tileToRemove) {
        ArrayList<Tile> newTiles = new ArrayList<Tile>(tilesInHand.size() - 1);
        for (int i = 0; i < tilesInHand.size(); i++) {
            if (tilesInHand.get(i) != tileToRemove) {
                newTiles.add(tilesInHand.get(i));
            }
        }
//        int index = tilesInHand.indexOf(tile);
//        ArrayList<Tile> newTiles = new ArrayList<Tile>(tilesInHand.size());
//
//        for (int i = 0; i < tilesInHand.size(); i++) {
////            System.out.println("index is " + i);
////            System.out.println("tilesInHand is " + tilesInHand.size());
//            if (i != index) {
//                newTiles.add(tilesInHand.get(i));
//            }
//
//        }
        this.tilesInHand = newTiles;

//        this.tilesInHand.remove(tile);
//        setTilesInHand();
        //this.tilesInHand.set(tilesInHand.size()-1, null);
    }

    public void setTilesInHand() {
//        System.out.println("//////");
//        System.out.println("handSize = " + getHandSize());
//        for (int x = 0; x < tilesInHand.size() - 1; x++) {
//            System.out.println("hand[" + x + "] = " + tilesInHand.get(x));
//        }
        ArrayList<Tile> newTiles = new ArrayList<Tile>(tilesInHand.size() - 1);
        for (int i = 0; i < tilesInHand.size() - 2; i++) {
            newTiles.add(tilesInHand.get(i));
        }
        tilesInHand = newTiles;
    }

    public void switchTiles(Tile myTile, Tile pickedUpTile) {
        System.out.println("Pre-hand :" + tilesInHand);

        for (int x = 0; x < tilesInHand.size(); x++) {
            if (tilesInHand.get(x).getLetter() == myTile.getLetter()) {
                System.out.println("x is: " + x);
                index = x;
            }
        }
        System.out.println("The index of your tile is: " + index);
        tilesInHand.remove(index);
        tilesInHand.add(index, pickedUpTile);
        System.out.println("Post-hand: " + tilesInHand);
        bag.removeTile(pickedUpTile);
        bag.addTile(myTile);
    }

    public void shuffle() {
        System.out.println("it shuffled the list");
        Collections.shuffle(tilesInHand);

        //randomly change the positions of tiles in array
    }

    public void createSwap() {
        System.out.println("tried to create switch");

        String tileStr = JOptionPane.showInputDialog(view,
                                                     "Type the letter of the tile you would like to swap (or blank for a blank tile): ",
                                                     "Swap",
                                                     DISPOSE_ON_CLOSE);
        if (tileStr == null) {
            //do nothing
        } else {
            String upCaseStr = tileStr.toUpperCase();
            System.out.println("tile str : " + upCaseStr);
            try {
                Val tileValue = val.valueOf(upCaseStr);
                Tile tile = new Tile(tileValue);
                boolean contains = containsTile(tile);
                if (contains == true) {
                    System.out.println("went through if statement");
                    System.out.println(
                            "The tile they want to switch is: " + tile);
                    Tile newTile = bag.draw();
                    System.out.println("The new tile from bag is: " + newTile);
                    JOptionPane.showMessageDialog(view,
                                                  "Your new tile is:   " + newTile.toString(),
                                                  "New Tile",
                                                  DISPOSE_ON_CLOSE);
                    switchTiles(tile, newTile);
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
//        for (Tile tile : this.tilesInHand) {
//            if (tile == null) {
//                s += "null";
//            } else {
//                s += tile.getLetter();
//            }
//        }
        for (int i = 0; i < tilesInHand.size(); i++) {
            if (Tile.class.isInstance(this.tilesInHand.get(i))) {
                s += this.tilesInHand.get(i).getLetter();
            }
        }
        return s;
    }

}
