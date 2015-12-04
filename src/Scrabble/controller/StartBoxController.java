/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Nov 17, 2015
 * Time: 6:22:47 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.controller
 * File: StartAGameController
 * Description:
 *
 * ****************************************
 */
package Scrabble.controller;

import Scrabble.model.Game;
import Scrabble.model.GameSize;
import Scrabble.model.Player;
import Scrabble.model.ScrabbleClient;
import Scrabble.model.ScrabbleServer;
import Scrabble.view.StartBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author calw001
 */
public class StartBoxController implements ActionListener {

    StartBox view;
    InetAddress existingIP = null;
    ScrabbleServer scrabbleServer;
    Game theGame;

    public StartBoxController(StartBox window) {
        this.view = window;
        view.getJoinExistingGameBtn().addActionListener(this);
        view.getStartNewGameBtn().addActionListener(this);
        view.getIPAddressBtn().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getJoinExistingGameBtn()) {
//            if (existingIP == null) {
//                JOptionPane.showMessageDialog(null,
//                                              "No existing games. Start your own!");
//                // create JDialog box saying there are no existing games
//
//            } else {
            String iPOfExistingGame = JOptionPane.showInputDialog(null,
                                                                  "IP address of the game you'd like to join",
                                                                  "Join Game",
                                                                  JOptionPane.WARNING_MESSAGE);
            try {
                ScrabbleClient client = new ScrabbleClient(iPOfExistingGame);
                System.out.println("created client");
                this.theGame = client.getTheGame();
                if (theGame == null) {
                    System.out.println("game is null");
                }
//                System.out.println(
//                        "got the game, size of game is " + theGame.getGameSize().getValue());

                String name = JOptionPane.showInputDialog(null,
                                                          "What's your name?",
                                                          "Enter Name",
                                                          JOptionPane.WARNING_MESSAGE);

                Player newPlayer = new Player(name, scrabbleServer);
                theGame.addPlayer(newPlayer);
                theGame.setCurPlayer(newPlayer);

                newPlayer.setClientServer(client);
                System.out.println("Added player: " + newPlayer);
                if (theGame.getHasEnoughPlayers()) {
                    System.out.println("starting game");
                    for (Player player : theGame.getPlayerList()) {
                        player.createScrabbleMain();
                        //newPlayer.getClientServer().runClient();
                    }
                    //ScrabbleMain startScrabbleGame = new ScrabbleMain();
                    // start the Scrabble game!
                }
            } catch (IOException ex) {
                Logger.getLogger(StartBoxController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StartBoxController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            }

            //}
        }
        if (e.getSource() == view.getStartNewGameBtn()) {
            // ask for name and create a player

            String name = JOptionPane.showInputDialog(null, "What's your name?",
                                                      "Enter Name",
                                                      JOptionPane.WARNING_MESSAGE);

            String[] numPlayers = {"1", "2", "3", "4"};
            String n = (String) JOptionPane.showInputDialog(null,
                                                            "How many players would you like in this game?",
                                                            "Number of Players",
                                                            JOptionPane.QUESTION_MESSAGE,
                                                            null,
                                                            numPlayers,
                                                            numPlayers[0]);

            // number of players to wait
            int size = Integer.valueOf(n);
            System.out.println("size " + size);

            try {
                existingIP = InetAddress.getLocalHost();
            } catch (UnknownHostException ex) {
                Logger.getLogger(StartBoxController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            }

            //set default to two-player
            GameSize gameSize = GameSize.TWO_PLAYER;
            System.out.println("pre-GameSize: " + gameSize.getValue());

            if (size == 1) {
                gameSize = GameSize.ONE_PLAYER;
            } else if (size == 3) {
                gameSize = GameSize.THREE_PLAYER;
            } else if (size == 4) {
                gameSize = GameSize.FOUR_PLAYER;
            }

            try {
                System.out.println("x");
                if (gameSize.getValue() != 1) {
                    System.out.println(
                            "entered if. gamesize: " + gameSize.getValue());
                    try {
                        System.out.println(
                                "entered try. gameSize: " + gameSize.getValue());
                        scrabbleServer = new ScrabbleServer(gameSize);
                        System.out.println(
                                "scrabbleServer made, here it is! " + scrabbleServer);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(StartBoxController.class.getName()).log(
                                Level.SEVERE,
                                null,
                                ex);
                    }
                } else {
                    // create a dummy server so I can get the Game
                    scrabbleServer = new ScrabbleServer();
                }
                System.out.println("a");
            } catch (IOException ex) {
                System.out.println("scrabbleServer not made!");
                Logger.getLogger(StartBoxController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            }
            System.out.println("finished creating server");

            //this.theGame = scrabbleServer.createGame(gameSize, gameCreator);
            System.out.println("this is the scrabble server" + scrabbleServer);
            //scrabbleServer.createGame(gameSize);
            //System.out.println("created theGame");
            this.theGame = scrabbleServer.getTheGame();
            //this.theGame = new Game(gameSize, gameCreator);
            System.out.println("got the game");

            // create gameCreator player
            Player gameCreator = new Player(name,
                                            scrabbleServer);
            System.out.println("created gameCreator");
            System.out.println(gameCreator);
            System.out.println(gameSize.getValue());

            // add gameCreator to the game
            this.theGame.addPlayer(gameCreator);
            this.theGame.setCurPlayer(gameCreator);

            // set gameCreator to curPlayer so program will be happy
            this.theGame.setCurPlayer(gameCreator);

            System.out.println(theGame.getNumConnectedPlayers());
            System.out.println(gameSize.getValue());

            if (theGame.getHasEnoughPlayers()) {
                System.out.println("hopefully Scrabble window pops up");
                for (Player player : theGame.getPlayerList()) {
                    player.createScrabbleMain();
                }
//                String[] a = {""};
//                ScrabbleMain.main(a);

//                /* Set the Nimbus look and feel */
//                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//                 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//                 */
//                try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
////                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
////                    break;
////                }
////            }
//                    UIManager.setLookAndFeel(
//                            UIManager.getSystemLookAndFeelClassName());
//                } catch (ClassNotFoundException ex) {
//                    java.util.logging.Logger.getLogger(
//                            StartBoxMain.class.getName()).log(
//                                    java.util.logging.Level.SEVERE, null, ex);
//                } catch (InstantiationException ex) {
//                    java.util.logging.Logger.getLogger(
//                            StartBoxMain.class.getName()).log(
//                                    java.util.logging.Level.SEVERE, null, ex);
//                } catch (IllegalAccessException ex) {
//                    java.util.logging.Logger.getLogger(
//                            StartBoxMain.class.getName()).log(
//                                    java.util.logging.Level.SEVERE, null, ex);
//                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//                    java.util.logging.Logger.getLogger(
//                            StartBoxMain.class.getName()).log(
//                                    java.util.logging.Level.SEVERE, null, ex);
//                }
//                //</editor-fold>
//                //</editor-fold>
//
//                java.awt.EventQueue.invokeLater(new Runnable() {
//                    public void run() {
//
////                StartBox startBoxView = new StartBox();
////
////                startBoxView.setVisible(true);
//                        StartBoxMain sbm = new StartBoxMain();
//
////                StartBoxController startBoxController = new StartBoxController(
////                        startBoxView);
//                        ScrabbleBoard scrabbleBoardView = new ScrabbleBoard(
//                                theGame, null);
//
//                        theGame.setTheBoard(scrabbleBoardView);
//
//                        scrabbleBoardView.setBackground(Color.BLUE);
//                        scrabbleBoardView.setTitle("Scrabble Game");
//                        scrabbleBoardView.setSize(900, 600);
//                        //Hand playerHand = player.getMyHand();
//                        scrabbleBoardView.setVisible(true);
//
//                        ScrabbleController scrabbleController = new ScrabbleController(
//                                scrabbleBoardView);
//
//                    }
//                });
                // start the Scrabble game!
            }

            System.out.println("Game Creator: " + gameCreator);
        }
        if (e.getSource() == view.getIPAddressBtn()) {
            System.out.println("ip address button pressed");

            InetAddress localaddr;
            try {
                localaddr = InetAddress.getLocalHost();
                System.out.println(localaddr);
                JOptionPane.showMessageDialog(null,
                                              "This computer's IP address: " + "\n" + localaddr);
            } catch (UnknownHostException ex) {
                Logger.getLogger(StartBoxController.class.getName()).log(
                        Level.SEVERE,
                        null,
                        ex);
            }

        }

    }

}
