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
import java.util.Random;

/**
 *
 * @author jms107
 */
public class TileBag {
    private ArrayList<Tile> tilesInBag = new ArrayList<>();

    public TileBag(ArrayList tilesInBag) {
        this.tilesInBag = tilesInBag;

        // 9 A tiles
        for (int i = 0; i < 9; i++) {
            this.tilesInBag.add(new Tile(Val.A));
        }
        // 2 B tiles
        for (int i = 0; i < 2; i++) {
            this.tilesInBag.add(new Tile(Val.B));
        }
        // 2 C tiles
        for (int i = 0; i < 2; i++) {
            this.tilesInBag.add(new Tile(Val.C));
        }
        // 4 D tiles
        for (int i = 0; i < 4; i++) {
            this.tilesInBag.add(new Tile(Val.D));
        }
        // 12 E tiles
        for (int i = 0; i < 12; i++) {
            this.tilesInBag.add(new Tile(Val.E));
        }
        // 2 F tiles
        for (int i = 0; i < 2; i++) {
            this.tilesInBag.add(new Tile(Val.F));
        }
        // 3 G tiles
        for (int i = 0; i < 3; i++) {
            this.tilesInBag.add(new Tile(Val.G));
        }
        // 2 H tiles
        for (int i = 0; i < 2; i++) {
            this.tilesInBag.add(new Tile(Val.H));
        }
        // 9 I tiles
        for (int i = 0; i < 9; i++) {
            this.tilesInBag.add(new Tile(Val.I));
        }
        // 1 J tile
        this.tilesInBag.add(new Tile(Val.J));
        // 1 K tile
        this.tilesInBag.add(new Tile(Val.K));
        // 4 L tiles
        for (int i = 0; i < 4; i++) {
            this.tilesInBag.add(new Tile(Val.L));
        }
        // 2 M tiles
        for (int i = 0; i < 2; i++) {
            this.tilesInBag.add(new Tile(Val.M));
        }
        // 6 N tiles
        for (int i = 0; i < 6; i++) {
            this.tilesInBag.add(new Tile(Val.N));
        }
        // 8 O tiles
        for (int i = 0; i < 8; i++) {
            this.tilesInBag.add(new Tile(Val.O));
        }
        // 2 P tiles
        for (int i = 0; i < 2; i++) {
            this.tilesInBag.add(new Tile(Val.P));
        }
        // 1 Q tile
        this.tilesInBag.add(new Tile(Val.Q));
        // 6 R tiles
        for (int i = 0; i < 6; i++) {
            this.tilesInBag.add(new Tile(Val.R));
        }
        // 4 S tiles
        for (int i = 0; i < 4; i++) {
            this.tilesInBag.add(new Tile(Val.S));
        }
        // 6 T tiles
        for (int i = 0; i < 6; i++) {
            this.tilesInBag.add(new Tile(Val.T));
        }
        // 4 U tiles
        for (int i = 0; i < 4; i++) {
            this.tilesInBag.add(new Tile(Val.U));
        }
        // 2 V tiles
        for (int i = 0; i < 2; i++) {
            this.tilesInBag.add(new Tile(Val.V));
        }
        // 2 W tiles
        for (int i = 0; i < 2; i++) {
            this.tilesInBag.add(new Tile(Val.W));
        }
        // 1 X tile
        this.tilesInBag.add(new Tile(Val.X));
        // 2 Y tiles
        for (int i = 0; i < 2; i++) {
            this.tilesInBag.add(new Tile(Val.Y));
        }
        // 1 Z tile
        this.tilesInBag.add(new Tile(Val.Z));
        // 2 BlANK tiles
        for (int i = 0; i < 2; i++) {
            this.tilesInBag.add(new Tile(Val.BLANK));
        }

    }

    public int getTileBagSize() {
        return this.tilesInBag.size();
    }

    public void setTilesInBag(ArrayList<Tile> tilesInBag) {
        this.tilesInBag = tilesInBag;

    }

    public void addTile(Tile tile) {
        tilesInBag.add(tile);

    }

    public void removeTile(Tile tile) {
        tilesInBag.remove(tile);

    }

    public Tile draw() {
        Random generator = null;
        int index = generator.nextInt(tilesInBag.size());
        Tile tile = tilesInBag.get(index);
        removeTile(tile);
        return tile;
    }

}
