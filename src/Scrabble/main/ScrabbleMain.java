/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: NAMES of team members
 * Date: Nov 18, 2015
 * Time: 3:33:34 PM
 *
 * Project: csci205FinalProject
 * Package: Scrabble.main
 * File: ScrabbleMain
 * Description:
 *
 * ****************************************
 */
package Scrabble.main;

import Scrabble.controller.ScrabbleController;
import Scrabble.model.Game;
import Scrabble.model.Player;
import Scrabble.view.ScrabbleBoard;
import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author calw001
 */
public class ScrabbleMain {
    private static Player player;
    private static Game game;

    public ScrabbleMain(Player player) {
        this.player = player;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartBoxMain.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartBoxMain.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartBoxMain.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartBoxMain.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

//                StartBox startBoxView = new StartBox();
//
//                startBoxView.setVisible(true);
                StartBoxMain sbm = new StartBoxMain();

//                StartBoxController startBoxController = new StartBoxController(
//                        startBoxView);
                ScrabbleBoard scrabbleBoardView = new ScrabbleBoard(player);
                player.setScrabbleBoard(scrabbleBoardView);

                scrabbleBoardView.setBackground(Color.BLUE);
                scrabbleBoardView.setTitle("Scrabble Game");
                scrabbleBoardView.setSize(900, 600);
                //Hand playerHand = player.getMyHand();
                scrabbleBoardView.setVisible(true);

                ScrabbleController scrabbleController = new ScrabbleController(
                        scrabbleBoardView);

            }
        });
    }

}
