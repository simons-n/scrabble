/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Dec 3, 2015
 * Time: 4:50:49 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: Stack
 * Description: Creates a stack array of tile objects.
 * ****************************************
 */
package Scrabble.model;

/**
 * Creates a stack array of tile objects. Used for the undo button
 *
 * This code was based off of information found at tutorialspoint.com
 *
 * @see
 * <http://www.tutorialspoint.com/javaexamples/data_stack.htm>
 *
 * @author jms107
 */
public class Stack {
    private int maxSize;
    private Tile[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new Tile[maxSize];
        top = -1;
    }

    public void push(Tile tile) {
        stackArray[++top] = tile;
    }

    public Tile pop() {
        return stackArray[top--];
    }

    public Tile peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);

    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

}
