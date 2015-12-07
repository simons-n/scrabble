/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Dec 6, 2015
 * Time: 8:03:23 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: BoardTileLabel
 * Description:
 *
 * ****************************************
 */
package Scrabble.model;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
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
