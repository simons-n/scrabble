/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Jenna Slusar, Nick Simons, Caroline Whitman
 * Date: Nov 11, 2015
 * Time: 9:09:49 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.model
 * File: ScrabbleClient
 * Description: creates a client to allow for networking
 *
 * ****************************************
 */
package Scrabble.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creates a client for the Scrabble game
 *
 * @author calw001
 */
public class ScrabbleClient {

    private Socket skt;
    private transient Game theGame;
    private boolean gameReceived = false;
    private boolean clientCreated = false;
    private transient OutputStream os;
    private transient ObjectOutputStream oos;
    private transient ObjectInputStream ois;

    /**
     * Create a ScrabbleClient object and given an ipAddress, connect to the
     * server
     *
     * @param ipAddress, a String
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ScrabbleClient(String ipAddress) throws IOException, ClassNotFoundException {
        connectToServer(ipAddress);
        //runClient();
    }

    public Game getTheGame() {
        return this.theGame;
    }

    /**
     * Connects the client to the server socket.
     *
     * @param ipAddress, a String
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void connectToServer(String ipAddress) throws IOException, ClassNotFoundException {
        //while (true) {
        if (clientCreated == false) {
            skt = new Socket(ipAddress, 1025);
            System.out.println(
                    "created socket waiting to transfer game info");
            clientCreated = true;
        }

        acceptInfoFromServer();

        // accept the game from the server
        //acceptInfoFromServer();
        //System.out.println("client socket created");
        //}
    }

    /**
     * Keeps the client server running throughout the game, constantly trying to
     * update the server and accept information from the server.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void runClient() throws IOException, ClassNotFoundException {
        while (true) {
            updateServer();
            acceptInfoFromServer();
        }
    }

    /**
     * Updates the server--sends the modified gameObject to the server.
     *
     * @throws IOException
     */
    public void updateServer() throws IOException {

        os = skt.getOutputStream();
        oos = new ObjectOutputStream(os);
        oos.writeObject(theGame);

        System.out.println("wrote theGame");

    }

    /**
     * Accepts a game object from the server to update the player board
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void acceptInfoFromServer() throws IOException, ClassNotFoundException {
        ois = new ObjectInputStream(skt.getInputStream());
        System.out.println(
                "Bytes available in input stream in client: " + ois.available());
        this.theGame = (Game) ois.readObject();

        System.out.println("accepted game from server");
    }

    /**
     * Tests the ScrabbleClient by trying to connect to the server
     *
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {

        ScrabbleClient client;
        try {
            // this IP address needs to be the IP address of the computer running the server program
            client = new ScrabbleClient("134.82.132.197");

            //Game game = new Game(GameSize.TWO_PLAYER, new Player("Caroline"));
            client.updateServer();
//            Player nick = new Player("Nick");
//
//            client.updateServer(nick);
//
//            Player caroline = new Player("Caroline");
//
//            client.updateServer(caroline);
//
//            Player jenna = new Player("Jenna");
//
//            client.updateServer(jenna);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ScrabbleClient.class.getName()).log(Level.SEVERE,
                                                                 null, ex);
        }

//        try {
//            InetAddress localaddr = InetAddress.getLocalHost();
//
//            System.out.println("Local IP Address : " + localaddr);
//            System.out.println("Local hostname : " + localaddr.getHostName());
//            Socket skt = new Socket("134.82.132.139", 1025);
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                    skt.getInputStream()));
//            System.out.print("Received string: ");
//
//            while (!in.ready()) {
//            }
//            System.out.println(in.readLine()); // Read one line and output it
//
//            System.out.print("'\n");
//            //in.close();
//
//            Player nick = new Player("Nick");
//
//            PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
//            System.out.print("Sending string: '" + nick + "'\n");
//            out.print(nick);
//            //out.flush();
//            out.close();
//            //skt.close();
//        } catch (Exception e) {
//            System.out.println(e);
//            System.out.print("Whoops! It didn't work!\n");
//        }
    }

}
