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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
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

    public Hand(ArrayList<Tile> tilesInHand) {
        this.tilesInHand = tilesInHand;
    }

    public Tile getTile(int x) {
        return this.tilesInHand.get(x);
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
        bag.removeTile(pickedUpTile);
        bag.addTile(myTile);
        tilesInHand.remove(myTile);
        tilesInHand.add(pickedUpTile);
    }

    public void shuffle() {
        Collections.shuffle(tilesInHand);
        //randomly change the positions of tiles in array

    }

    public void createSwitch() {
        JDialog dBoxSwitch = new JDialog(view, "Switch");
        JButton switchOKBtn = new JButton();
        dBoxSwitch.setPreferredSize(new Dimension(500, 485));
        JLabel tileToSwitchLabel = new JLabel(
                "Type the letter of the tile you would like to switch: ");
        dBoxSwitch.getContentPane().add(tileToSwitchLabel);
        JTextField tileTextField = new JTextField();
        dBoxSwitch.getContentPane().add(tileTextField);
        switchOKBtn.setText("OK");
        dBoxSwitch.getContentPane().add(switchOKBtn);
        dBoxSwitch.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dBoxSwitch.pack();
        dBoxSwitch.setVisible(true);

        switchOKBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tileStr = tileTextField.getText();
                Tile tile = new Tile(val.valueOf(tileStr));
                Tile newTile = bag.draw();
                switchTiles(tile, newTile);
            }
        });
    }

}
