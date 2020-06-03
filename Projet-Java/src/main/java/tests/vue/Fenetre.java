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
    this.setSize(300, 120);

    //Les données du tableau
    Object[][] data = {
      {"Cysboy", "28 ans", "1.80 m"},
      {"BZHHydde", "28 ans", "1.80 m"},
      {"IamBow", "24 ans", "1.90 m"},
      {"FunMan", "32 ans", "1.85 m"}
    };

    //Les titres des colonnes
    String  title[] = {"Pseudo", "Age", "Taille"};
    JTable tableau = new JTable(data, title);
    //Nous ajoutons notre tableau à notre contentPane dans un scroll
    //Sinon les titres des colonnes ne s'afficheront pas !
    this.getContentPane().add(new JScrollPane(tableau));
  }   

  public static void main(String[] args){
    Fenetre fen = new Fenetre();
    fen.setVisible(true);
  }   
}
