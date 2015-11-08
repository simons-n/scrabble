/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Caroline Whitman, Jenna Slusar, Nick Simons
 * Date: Nov 8, 2015
 * Time: 4:33:34 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: TileBag
 * Description: Represents the bags filled with all the tiles you will eventually play
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
public class TileBag {
    private List<Tile> tilesInBag = new ArrayList<>(100);

    public TileBag(ArrayList tilesInBag) {
        this.tilesInBag = tilesInBag;
    }

    public void setTilesInBag(List<Tile> tilesInBag) {
        this.tilesInBag = tilesInBag;
        //add initial tiles to bag 100 of them
    }

    public void addTile(Tile tile) {
        tilesInBag.add(tile);

    }

    public void removeTile(Tile tile) {
        tilesInBag.remove(tile);

    }

}
