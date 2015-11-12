/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Nov 11, 2015
 * Time: 9:09:49 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: ScrabbleClient
 * Description:
 *
 * ****************************************
 */
package Scrabble.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author calw001
 */
public class ScrabbleClient {

    public static void main(String args[]) {
        try {
            Socket skt = new Socket("bucknell.edu", 1234);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    skt.getInputStream()));
            System.out.print("Received string: ");

            while (!in.ready()) {
            }
            System.out.println(in.readLine()); // Read one line and output it

            System.out.print("'\n");
            in.close();
        } catch (Exception e) {
            System.out.print("Whoops! It didn't work!\n");
        }
    }

}
