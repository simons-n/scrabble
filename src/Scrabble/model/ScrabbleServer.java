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
import java.io.IOException;
import java.io.InputStreamReader;
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
    private Game theGame;
    private boolean newGame = true;
    private boolean gameOver = false;
    private ServerSocket srvr;
    private Socket skt;
    private int curPlayers = 0;
    private int maxPlayers;
    private boolean sentGame = false;

    public ScrabbleServer(int gameSize) throws IOException {
        this.maxPlayers = gameSize;

        runServer();
        //createServer();
    }

    public Game createGame(GameSize gameSize, Player creator) {
        this.theGame = new Game(gameSize, creator);
        return this.theGame;
    }

    public Game getTheGame() {
        return theGame;
    }

    public void runServer() throws IOException {
        srvr = new ServerSocket(1025);
        Player updatedPlayer = new Player("null");
        while (true) {
            skt = srvr.accept();

            PrintWriter out;

            if (!sentGame) {
                // send the game to the clients
                out = new PrintWriter(skt.getOutputStream(), true);
                out.print(theGame);
                sentGame = true;
            }

            // update clients
            out = new PrintWriter(skt.getOutputStream(), true);
            out.print(updatedPlayer);
            //out.flush();

            // look for updates FROM clients
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    skt.getInputStream()));
            //System.out.println("b");
            System.out.print("Received string: \n");

            while (!in.ready()) {
            }
            System.out.println(in.readLine() + "\n");
        }
    }

    public void createServer() throws IOException {
        System.out.println("createServer()");
        try {
            System.out.println("in try");
            srvr = new ServerSocket(1025);
            System.out.println("created server socket");
            while (curPlayers < maxPlayers) {
                skt = srvr.accept();
                curPlayers += 1;
                System.out.println("created socket");
            }
            //skt.setKeepAlive(true);
            if (newGame) {
                System.out.println("entered if");
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
        System.out.println("created server");
    }

    public void acceptUpdateFromClient(Player updatedPlayer) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                skt.getInputStream()));
        //System.out.println("b");
        System.out.print("Received string: ");

        while (!in.ready()) {
        }
        System.out.println(in.readLine()); // Read one line and output it

        //System.out.print("'\n");
        //in.close();
        //out.close();
    }

    public void updateClients(Player updatedPlayer) throws IOException {
        PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
        System.out.println("Updating clients..." + '\n');

        updatedPlayer.setName("Jenna 2.0");

        out.print(updatedPlayer);
        out.flush();
    }

    public static void main(String args[]) throws IOException {

        ScrabbleServer ss = new ScrabbleServer(1);

        //ss.createServer();
        ss.runServer();

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
