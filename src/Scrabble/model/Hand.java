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

    public Hand(ArrayList<Tile> tilesInHand, Player player) {
        this.tilesInHand = tilesInHand;
        this.game = player.getGame();
        this.bag = this.game.getTileBag();
    }

    public Tile getTile(int x) {
        return this.tilesInHand.get(x);
    }

    public void addTileFromBoard(Tile tile) {
        this.tilesInHand.add(tile);
    }

    public void removeTile(Tile tile) {
        this.tilesInHand.remove(tile);
    }

    public void switchTiles(Tile myTile, Tile pickedUpTile) {
        bag.removeTile(pickedUpTile);
        bag.addTile(myTile);
        tilesInHand.remove(myTile);
        tilesInHand.add(pickedUpTile);
    }

    public void shuffle() {
        System.out.println("it shuffled the list");
        Collections.shuffle(tilesInHand);

        //randomly change the positions of tiles in array
    }

    public void createSwap() {
        System.out.println("tried to create switch");

        String tileStr = JOptionPane.showInputDialog(view,
                                                     "Type the letter of the tile you would like to swap: ",
                                                     "Swap",
                                                     DISPOSE_ON_CLOSE);
        Tile tile = new Tile(val.valueOf(tileStr));
        Tile newTile = bag.draw();
        JOptionPane.showInternalMessageDialog(view, "New Tile",
                                              newTile.toString(),
                                              DISPOSE_ON_CLOSE);
        switchTiles(tile, newTile);
    }

    public ArrayList<Tile> getTilesInHand() {
        return tilesInHand;
    }

    @Override
    public String toString() {
        String s = "";
        for (Tile tile : this.tilesInHand) {
            s += tile.getLetter();
        }
        return s;
    }

}
