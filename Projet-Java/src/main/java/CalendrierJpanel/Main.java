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
        System.out.println("1");
        JFrame fen = new JFrame();
        System.out.println("2");
        fen.setLocationRelativeTo(null);
        System.out.println("3");
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("4");
        fen.setTitle("JTable");
        System.out.println("5");
        fen.setSize(800, 600);
        System.out.println("6");
        JPanel jp = new JPanel();
        System.out.println("7");
        Calendrier calendar = new Calendrier(0,0,3,2020,jp);
        System.out.println("8");
        fen.setContentPane(jp);
        System.out.println("9");
        fen.setVisible(true);
        
    }
    
}
