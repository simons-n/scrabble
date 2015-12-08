/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Jenna Slusar, Nick Simons, Caroline Whitman
 * Date: Nov 18, 2015
 * Time: 8:23:32 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: Val
 * Description: An enumerated data type for the different tile values
 *
 * ****************************************
 */
package Scrabble.model;

/**
 *
 * @author Nick and Caroline
 */
public enum Val {
    A(1), B(3), C(3), D(2), E(1), F(4), G(2), H(4), I(1), J(8), K(5), L(1), M(3), N(
            1), O(1), P(3), Q(10), R(1), S(1), T(1), U(1), V(4), W(4), X(8), Y(4), Z(
                    10), BLANK(0);

    private int score;

    /**
     * Sets the score of each tile to the correct score
     *
     * @param score, an int of the score of the tile
     */
    Val(int score) {
        this.score = score;
    }

    /**
     * returns the score of the tile
     *
     * @return int, the score
     */
    int getScore() {
        return this.score;
    }
}
