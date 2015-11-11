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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jms107
 */
public class Hand {
    private List<Tile> tilesInHand = new ArrayList<>(7);

    public Hand(ArrayList tilesInHand) {
        this.tilesInHand = tilesInHand;
    }

    public void addTileFromBag(TileBag bag) {
        Tile tile;
        tile = bag.draw();
        this.tilesInHand.add(tile);
    }

    public void addTileFromBoard(Tile tile) {
        this.tilesInHand.add(tile);
    }

    public void removeTile(Tile tile) {
        this.tilesInHand.remove(tile);
    }

    public void switchTiles(Tile myTile, Tile pickedUpTile) {
        //TileBag.removeTile(pickedUpTile);
        //TileBag.addTile(myTile);
        tilesInHand.remove(myTile);
        tilesInHand.add(pickedUpTile);
    }

    public void shuffle() {
        //randomly change the positions of tiles in array

    }

}
