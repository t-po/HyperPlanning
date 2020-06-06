/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet.Vue;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author Hippo
 */
public class Panneau extends JPanel {
    public void paintComponent(Graphics g){
    try {
      Image img = ImageIO.read(new File("image.png"));
      g.drawImage(img, 0, 0, this);
      //Pour une image de fond
      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    } catch (IOException e) {
      e.printStackTrace();
    } 
    g.drawString("Bienvenue sur HyperPlanning", 250, 50);
    
                   
  } 
}
