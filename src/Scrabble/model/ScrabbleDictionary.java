/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Jenna Slusar, Nick Simons, Caroline Whitman
 * Date: Nov 13, 2015
 * Time: 10:35:51 AM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: ScrabbleDictionary
 * Description: Creates and holds the Scrabble dictionary
 *
 * ****************************************
 */
package Scrabble.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Our scrabble dictionary was found on www.github.com
 *
 * @see
 * <a href = "https://raw.githubusercontent.com/jonbcard/scrabble-bot/master/src/dictionary.txt">
 * https://raw.githubusercontent.com/jonbcard/scrabble-bot/master/src/dictionary.txt</a>
 * @author Caroline and Nick
 */
public class ScrabbleDictionary extends HashMap {

    /**
     * Creates a Scrabble Dictionary object by reading in the file and putting
     * it into a hash map
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public ScrabbleDictionary() throws FileNotFoundException, IOException {
        String line;
        BufferedReader in = new BufferedReader(new FileReader("dictionary.txt"));

        line = in.readLine();
        while (line != null) {
            this.put(line, line.length());
            line = in.readLine();
        }
    }

}
