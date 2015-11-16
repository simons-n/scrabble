/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Nov 11, 2015
 * Time: 9:07:10 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: ScrabbleServer
 * Description:
 *
 * ****************************************
 */
package Scrabble.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author calw001
 */
public class ScrabbleServer {

    public static void main(String args[]) {
        Player me = new Player("Caroline");
        try {
            ServerSocket srvr = new ServerSocket(1025);
            Socket skt = srvr.accept();
            System.out.print("Server has connected!\n");
            PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
            System.out.print("Sending string: '" + me + "'\n");
            out.print(me);
            out.close();
            //skt.close();
            //srvr.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    skt.getInputStream()));
            System.out.print("Received string: ");

            while (!in.ready()) {
            }
            System.out.println(in.readLine()); // Read one line and output it

            System.out.print("'\n");
            in.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.print("Whoops! It didn't work!\n");
        }
    }

}
