/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Nov 13, 2015
 * Time: 10:35:51 AM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: ScrabbleDictionary
 * Description:
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
 * <https://raw.githubusercontent.com/jonbcard/scrabble-bot/master/src/dictionary.txt>
 * @author Caroline and Nick
 */
public class ScrabbleDictionary extends HashMap {

    public ScrabbleDictionary() throws FileNotFoundException, IOException {
        String line;
        BufferedReader in = new BufferedReader(new FileReader("dictionary.txt"));

        line = in.readLine();
        while (line != null) {
            this.put(line, line.length());
            line = in.readLine();
        }
    }

//    public static void main(String[] args) throws IOException {
//        ScrabbleDictionary dictionary = new ScrabbleDictionary();
//    }
}
