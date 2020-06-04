/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalendrierJpanel;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Hippo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame fen = new JFrame();
        fen.setLocationRelativeTo(null);
    fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fen.setTitle("JTable");
    fen.setSize(800, 600);
        JPanel jp = new JPanel();
        Calendrier calendar = new Calendrier(0,0,3,2020,jp);
        fen.setContentPane(jp);
        fen.setVisible(true);
        
    }
    
}
