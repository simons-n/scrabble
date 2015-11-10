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
import java.util.Random;

/**
 *
 * @author jms107
 */
public class TileBag {
    private List<Tile> tilesInBag = new ArrayList<>();

    public TileBag(ArrayList tilesInBag) {
        this.tilesInBag = tilesInBag;
        this.tilesInBag.add(new Tile(Val.A)); //*9
        this.tilesInBag.add(new Tile(Val.A));
        this.tilesInBag.add(new Tile(Val.A));
        this.tilesInBag.add(new Tile(Val.A));
        this.tilesInBag.add(new Tile(Val.A));
        this.tilesInBag.add(new Tile(Val.A));
        this.tilesInBag.add(new Tile(Val.A));
        this.tilesInBag.add(new Tile(Val.A));
        this.tilesInBag.add(new Tile(Val.A));
        this.tilesInBag.add(new Tile(Val.B)); //*2
        this.tilesInBag.add(new Tile(Val.B));
        this.tilesInBag.add(new Tile(Val.C)); //*2
        this.tilesInBag.add(new Tile(Val.C));
        this.tilesInBag.add(new Tile(Val.D)); //*4
        this.tilesInBag.add(new Tile(Val.D));
        this.tilesInBag.add(new Tile(Val.D));
        this.tilesInBag.add(new Tile(Val.D));
        this.tilesInBag.add(new Tile(Val.E)); //*12
        this.tilesInBag.add(new Tile(Val.E));
        this.tilesInBag.add(new Tile(Val.E));
        this.tilesInBag.add(new Tile(Val.E));
        this.tilesInBag.add(new Tile(Val.E));
        this.tilesInBag.add(new Tile(Val.E));
        this.tilesInBag.add(new Tile(Val.E));
        this.tilesInBag.add(new Tile(Val.E));
        this.tilesInBag.add(new Tile(Val.E));
        this.tilesInBag.add(new Tile(Val.E));
        this.tilesInBag.add(new Tile(Val.E));
        this.tilesInBag.add(new Tile(Val.E));
        this.tilesInBag.add(new Tile(Val.F)); //*2
        this.tilesInBag.add(new Tile(Val.F));
        this.tilesInBag.add(new Tile(Val.G)); //*3
        this.tilesInBag.add(new Tile(Val.G));
        this.tilesInBag.add(new Tile(Val.G));
        this.tilesInBag.add(new Tile(Val.H)); //*2
        this.tilesInBag.add(new Tile(Val.H));
        this.tilesInBag.add(new Tile(Val.I)); //*9
        this.tilesInBag.add(new Tile(Val.I));
        this.tilesInBag.add(new Tile(Val.I));
        this.tilesInBag.add(new Tile(Val.I));
        this.tilesInBag.add(new Tile(Val.I));
        this.tilesInBag.add(new Tile(Val.I));
        this.tilesInBag.add(new Tile(Val.I));
        this.tilesInBag.add(new Tile(Val.I));
        this.tilesInBag.add(new Tile(Val.I));
        this.tilesInBag.add(new Tile(Val.J)); //*1
        this.tilesInBag.add(new Tile(Val.K)); //*1
        this.tilesInBag.add(new Tile(Val.L)); //*4
        this.tilesInBag.add(new Tile(Val.L));
        this.tilesInBag.add(new Tile(Val.L));
        this.tilesInBag.add(new Tile(Val.L));
        this.tilesInBag.add(new Tile(Val.M)); //*2
        this.tilesInBag.add(new Tile(Val.M));
        this.tilesInBag.add(new Tile(Val.N)); //*6
        this.tilesInBag.add(new Tile(Val.N));
        this.tilesInBag.add(new Tile(Val.N));
        this.tilesInBag.add(new Tile(Val.N));
        this.tilesInBag.add(new Tile(Val.N));
        this.tilesInBag.add(new Tile(Val.N));
        this.tilesInBag.add(new Tile(Val.O)); //*8
        this.tilesInBag.add(new Tile(Val.O));
        this.tilesInBag.add(new Tile(Val.O));
        this.tilesInBag.add(new Tile(Val.O));
        this.tilesInBag.add(new Tile(Val.O));
        this.tilesInBag.add(new Tile(Val.O));
        this.tilesInBag.add(new Tile(Val.O));
        this.tilesInBag.add(new Tile(Val.O));
        this.tilesInBag.add(new Tile(Val.P)); //*2
        this.tilesInBag.add(new Tile(Val.P));
        this.tilesInBag.add(new Tile(Val.Q)); //*1
        this.tilesInBag.add(new Tile(Val.R)); //*6
        this.tilesInBag.add(new Tile(Val.R));
        this.tilesInBag.add(new Tile(Val.R));
        this.tilesInBag.add(new Tile(Val.R));
        this.tilesInBag.add(new Tile(Val.R));
        this.tilesInBag.add(new Tile(Val.R));
        this.tilesInBag.add(new Tile(Val.S)); //*4
        this.tilesInBag.add(new Tile(Val.S));
        this.tilesInBag.add(new Tile(Val.S));
        this.tilesInBag.add(new Tile(Val.S));
        this.tilesInBag.add(new Tile(Val.T)); //*6
        this.tilesInBag.add(new Tile(Val.T));
        this.tilesInBag.add(new Tile(Val.T));
        this.tilesInBag.add(new Tile(Val.T));
        this.tilesInBag.add(new Tile(Val.T));
        this.tilesInBag.add(new Tile(Val.T));
        this.tilesInBag.add(new Tile(Val.U)); //*4
        this.tilesInBag.add(new Tile(Val.U));
        this.tilesInBag.add(new Tile(Val.U));
        this.tilesInBag.add(new Tile(Val.U));
        this.tilesInBag.add(new Tile(Val.V)); //*2
        this.tilesInBag.add(new Tile(Val.V));
        this.tilesInBag.add(new Tile(Val.W)); //*2
        this.tilesInBag.add(new Tile(Val.W));
        this.tilesInBag.add(new Tile(Val.X)); //*1
        this.tilesInBag.add(new Tile(Val.Y)); //*2
        this.tilesInBag.add(new Tile(Val.Y));
        this.tilesInBag.add(new Tile(Val.Z)); //*1
        this.tilesInBag.add(new Tile(Val.BLANK));//*2
        this.tilesInBag.add(new Tile(Val.BLANK));
    }

    public void setTilesInBag(List<Tile> tilesInBag) {
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
