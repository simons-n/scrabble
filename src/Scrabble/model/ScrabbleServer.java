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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
    private transient Game theGame;
    private boolean newGame = true;
    private boolean gameOver = false;
    private ServerSocket srvr;
    private Socket skt;
    private int curPlayers = 0;
    private int maxPlayers;
    private boolean sentGame = false;
    private transient ObjectOutputStream oos;
    private transient ObjectInputStream ois;
    private transient OutputStream os;

    public ScrabbleServer(GameSize gameSize) throws IOException, ClassNotFoundException {
        this.maxPlayers = gameSize.getValue();
        createGame(gameSize);
        runServer();
        //createServer();
    }

    public ScrabbleServer() {
        createGame(GameSize.ONE_PLAYER);
    }

//    public Game createGame(GameSize gameSize, Player creator) {
//        this.theGame = new Game(gameSize, creator);
//        return this.theGame;
//    }
    public void createGame(GameSize gameSize) {
        this.theGame = new Game(gameSize, new Player("caroline"));

    }

    public Game getTheGame() {
        return this.theGame;
    }

    public void runServer() throws IOException, ClassNotFoundException {
        srvr = new ServerSocket(1025);
//        while (true) {
//            skt = srvr.accept();
//
//            if (sentGame == false) {
//                // send the game to the clients
//                os = skt.getOutputStream();
//                oos = new ObjectOutputStream(os);
//                System.out.println(
//                        "this is the game in scrabbleserver: " + getTheGame());
//                oos.writeObject(getTheGame());
//
//                sentGame = true;
//            }
        skt = srvr.accept();
        while (sentGame == false) {
            os = skt.getOutputStream();
            oos = new ObjectOutputStream(os);
            System.out.println(
                    "this is the game in scrabbleserver: " + getTheGame());
            oos.writeObject(getTheGame());
            sentGame = true;
        }
        updateClients(acceptUpdateFromClient());

    }

    public Game acceptUpdateFromClient() throws IOException, ClassNotFoundException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(
//                skt.getInputStream()));

        System.out.println("entered acceputupdatefromclient");
        System.out.println(
                "skt inputstream = " + skt.getInputStream().available());
        ois = new ObjectInputStream(skt.getInputStream());
        System.out.println("ois contents: " + ois.available());
        //System.out.println("b");
//        System.out.print("Received string: ");

//        while (!in.ready()) {
//        }
//        System.out.println(in.readLine()); // Read one line and output it
        Game updatedGame = (Game) ois.readObject();
        //ois.close();
        //System.out.print("'\n");
        //in.close();
        //out.close();

        //System.out.println(updatedGame.getGameOwner());
        System.out.println("accepted update");

        return updatedGame;
    }

    public void updateClients(Game updatedGame) throws IOException {

        os = skt.getOutputStream();
        oos = new ObjectOutputStream(os);
        oos.writeObject(updatedGame);

        System.out.println("sent game update");
        //oos.flush();
//        PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
//        System.out.println("Updating clients..." + '\n');
//
//        updatedPlayer.setName("Jenna 2.0");
//
//        out.print(updatedPlayer);
//        out.flush();
    }

//    public static void main(String args[]) throws IOException, ClassNotFoundException {
//
//        ScrabbleServer ss = new ScrabbleServer(1);
//        ss.createGame(GameSize.TWO_PLAYER);
//
//        //ss.createServer();
//        ss.runServer();
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

//}
