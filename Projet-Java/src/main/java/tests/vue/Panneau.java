/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.vue;
import CalendrierJpanel.SButton;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author Hippo
 */
public class Panneau extends JPanel {

    String titreCour="titre du cours", prof="professeur", groupe="groupe";
    
    public void paintComponent(Graphics g){
            Font contenu = new Font("Calibri", Font.PLAIN, 20);
            g.drawString(titreCour, 300, 20);
            g.drawString("Professeur : "+prof, 100, 60);
            g.drawString("Groupe : "+groupe, 100, 80);
            
        }
}
