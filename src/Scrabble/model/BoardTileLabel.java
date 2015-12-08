/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Carloine Whitman, Jenna Slusar, and Nick Simons
 * Date: Dec 6, 2015
 * Time: 8:03:23 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: BoardTileLabel
 * Description: This class is used in scoring words, so that only new words placed on the board are scored
 *
 * ****************************************
 */
package Scrabble.model;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * This class still creates the JLabel of the tile on the board, but adds a
 * isNew boolean to that JLabel. When tiles are played during the turn isNew is
 * set to true, but once the turn is over they are all changed to false when
 * setIsNew is called.
 *
 * @author nrs007
 */
public class BoardTileLabel extends JLabel {
    private boolean isNew;

    public BoardTileLabel(Icon image) {
        super(image);
        this.isNew = true;
    }

    public void setIsNew() {
        if (isNew == true) {
            isNew = false;
        }
    }

    public boolean getIsNew() {
        return isNew;
    }
}
