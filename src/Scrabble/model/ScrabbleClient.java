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
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author calw001
 */
public class ScrabbleClient {

    public static void main(String args[]) {
        try {
            InetAddress localaddr = InetAddress.getLocalHost();

            System.out.println("Local IP Address : " + localaddr);
            System.out.println("Local hostname : " + localaddr.getHostName());
            Socket skt = new Socket("134.82.132.209", 1025);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    skt.getInputStream()));
            System.out.print("Received string: ");

            while (!in.ready()) {
            }
            System.out.println(in.readLine()); // Read one line and output it

            System.out.print("'\n");
            //in.close();

            Player nick = new Player("Nick");

            PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
            System.out.print("Sending string: '" + nick + "'\n");
            out.print(nick);
            //out.flush();
            out.close();
            //skt.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.print("Whoops! It didn't work!\n");
        }
    }

}
