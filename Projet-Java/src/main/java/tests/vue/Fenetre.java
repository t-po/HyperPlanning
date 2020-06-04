/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.vue;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Hippo
 */
public class Fenetre extends JFrame{
    
    public Fenetre(){
        this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("JTable");
    this.setSize(800, 600);

    //Les données du tableau
    Object[][] data = {
      {"8h30-10h", "28 ans", "1.80 m", "", "", "", "", ""},
      {"10h15-11h45", "28 ans", "1.80 m", "", "", "", "", ""},
      {"12h00-13h30", "24 ans", "1.90 m", "", "", "", "", ""},
      {"13h45-15h15", "32 ans", "1.85 m", "", "", "", "", ""},
      {"15h30-17h00", "", "", "", "", "", "", ""},
      {"17h15-18h45", "", "", "", "", "", "", ""},
      {"19h00-20h30", "", "", "", "", "", "", ""}
    };

    //Les titres des colonnes
    String  title[] = {"", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
    JTable tableau = new JTable(data, title);
    
    //On agrandi la auteur de toutes les lignes.
    for(int i = 0; i < tableau.getRowCount(); i++){
        tableau.setRowHeight(i, 80);
      }
    //Nous ajoutons notre tableau à notre contentPane dans un scroll
    //Sinon les titres des colonnes ne s'afficheront pas !
    this.getContentPane().add(new JScrollPane(tableau));
    
    this.setBackground(Color.green);
    this.setVisible(true);
    
  }   

    
}
