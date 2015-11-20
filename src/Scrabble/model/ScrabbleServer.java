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

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author calw001
 */
public class ScrabbleServer {

    /**
     * http://www.cise.ufl.edu/~amyles/tutorials/tcpchat/
     *
     * @param args
     */
    private boolean newGame = true;
    private boolean gameOver = false;
    private ServerSocket srvr;
    private Socket skt;

    public ScrabbleServer() throws IOException {
        createServer();
    }

    public void createServer() throws IOException {
        try {
            srvr = new ServerSocket(1025);
            skt = srvr.accept();
            skt.setKeepAlive(true);
            if (newGame) {
                System.out.print("Server has connected!\n");
                String message = "Game starting!";
                PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
                System.out.print("Sending string: '" + message + "'\n");
                out.print(message + '\n');
                out.flush();
                //out.close();
                //skt.close();
                //srvr.close();
                newGame = false;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.print("Whoops! It didn't work!\n");
        }
    }

    public void updateClients(Player updatedPlayer) throws IOException {
        PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
        System.out.println("Updating clients..." + '\n');
        out.print(updatedPlayer);
        out.flush();
    }

    public static void main(String args[]) throws IOException {

        ScrabbleServer ss = new ScrabbleServer();

        ss.createServer();

//        ScrabbleBoard currBoard = new ScrabbleBoard();
//        boolean gameOver = false;
//        boolean newGame = true;
//        try {
//            ServerSocket srvr = new ServerSocket(1025);
//            Socket skt = srvr.accept();
//            skt.setKeepAlive(true);
//
//            Player me = new Player("Caroline", ss);
//
//            if (newGame) {
//
//                System.out.print("Server has connected!\n");
//
//                String message = "Game starting!";
//                PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
//                System.out.print("Sending string: '" + message + "'\n");
//                out.print(message + '\n');
//                out.flush();
//                //out.close();
//                //skt.close();
//                //srvr.close();
//                newGame = false;
//            }
//
//            while (!gameOver) {
//                //System.out.println("a");
//
//                BufferedReader in = new BufferedReader(new InputStreamReader(
//                        skt.getInputStream()));
//                //System.out.println("b");
//                System.out.print("Received string: ");
//
//                while (!in.ready()) {
//                }
//                System.out.println(in.readLine()); // Read one line and output it
//
//                //System.out.print("'\n");
//                //in.close();
//                //out.close();
//                gameOver = true;
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//            System.out.print("Whoops! It didn't work!\n");
//        }
    }

}
