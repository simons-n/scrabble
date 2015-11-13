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
 * File: Dictionary
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
 *
 * @author calw001
 */
public class Dictionary {

    private HashMap<Integer, String> dict = new HashMap<Integer, String>();
    private String text;

    public void textToHashMap() throws FileNotFoundException, IOException {
        String line;
        BufferedReader in = new BufferedReader(new FileReader("dictionary.txt"));

        line = in.readLine();
        while (line != null) {
            line = in.readLine();
            dict.put(line.length(), line);
        }
    }

    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();
        dictionary.textToHashMap();
    }

}
