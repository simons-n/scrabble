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
public class TileBag extends ArrayList<Tile> {

    public TileBag() {

        // 9 A tiles
        for (int i = 0; i < 9; i++) {
            this.add(new Tile(Val.A));
        }
        // 2 B tiles
        for (int i = 0; i < 2; i++) {
            this.add(new Tile(Val.B));
        }
        // 2 C tiles
        for (int i = 0; i < 2; i++) {
            this.add(new Tile(Val.C));
        }
        // 4 D tiles
        for (int i = 0; i < 4; i++) {
            this.add(new Tile(Val.D));
        }
        // 12 E tiles
        for (int i = 0; i < 12; i++) {
            this.add(new Tile(Val.E));
        }
        // 2 F tiles
        for (int i = 0; i < 2; i++) {
            this.add(new Tile(Val.F));
        }
        // 3 G tiles
        for (int i = 0; i < 3; i++) {
            this.add(new Tile(Val.G));
        }
        // 2 H tiles
        for (int i = 0; i < 2; i++) {
            this.add(new Tile(Val.H));
        }
        // 9 I tiles
        for (int i = 0; i < 9; i++) {
            this.add(new Tile(Val.I));
        }
        // 1 J tile
        this.add(new Tile(Val.J));
        // 1 K tile
        this.add(new Tile(Val.K));
        // 4 L tiles
        for (int i = 0; i < 4; i++) {
            this.add(new Tile(Val.L));
        }
        // 2 M tiles
        for (int i = 0; i < 2; i++) {
            this.add(new Tile(Val.M));
        }
        // 6 N tiles
        for (int i = 0; i < 6; i++) {
            this.add(new Tile(Val.N));
        }
        // 8 O tiles
        for (int i = 0; i < 8; i++) {
            this.add(new Tile(Val.O));
        }
        // 2 P tiles
        for (int i = 0; i < 2; i++) {
            this.add(new Tile(Val.P));
        }
        // 1 Q tile
        this.add(new Tile(Val.Q));
        // 6 R tiles
        for (int i = 0; i < 6; i++) {
            this.add(new Tile(Val.R));
        }
        // 4 S tiles
        for (int i = 0; i < 4; i++) {
            this.add(new Tile(Val.S));
        }
        // 6 T tiles
        for (int i = 0; i < 6; i++) {
            this.add(new Tile(Val.T));
        }
        // 4 U tiles
        for (int i = 0; i < 4; i++) {
            this.add(new Tile(Val.U));
        }
        // 2 V tiles
        for (int i = 0; i < 2; i++) {
            this.add(new Tile(Val.V));
        }
        // 2 W tiles
        for (int i = 0; i < 2; i++) {
            this.add(new Tile(Val.W));
        }
        // 1 X tile
        this.add(new Tile(Val.X));
        // 2 Y tiles
        for (int i = 0; i < 2; i++) {
            this.add(new Tile(Val.Y));
        }
        // 1 Z tile
        this.add(new Tile(Val.Z));
        // 2 BlANK tiles
        for (int i = 0; i < 2; i++) {
            this.add(new Tile(Val.BLANK));
        }

    }

    public int getTileBagSize() {
        return this.size();
    }

    public String getTileBagSizeStr() {
        int size = getTileBagSize();
        String sizeStr = "-" + size + "-";
        return sizeStr;
    }

//    public void setTilesInBag(ArrayList<Tile> tilesInBag) {
//        this.tilesInBag = tilesInBag;
//
//    }
    public void addTile(Tile tile) {
        this.add(tile);

    }

    public void removeTile(Tile tile) {
        this.remove(tile);

    }

    public Tile draw() {
        Random generator = new Random();
        int index = generator.nextInt(this.size());
        Tile tile = this.get(index);
        removeTile(tile);
        return tile;
    }

    public static void main(String[] args) {
        TileBag tb = new TileBag();
        System.out.println(tb.size());
    }

}
