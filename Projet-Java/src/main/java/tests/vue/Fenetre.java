/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.vue;
import Projet.Vue.Table;
import Projet.Vue.SButton;
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
        this.setTitle("Table");
        this.setSize(800, 600);
    
        JPanel panel = new JPanel();
    
        //Table tableau = new Table(1,6,2020,panel);
    
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        this.getContentPane().add(new JScrollPane(panel));
        this.setVisible(true);
    
    
   }   
    
  
 
public JPanel parameters (){
    
    /// Formulaire pour rechercher
    
    JPanel parametersPan = new JPanel();
    JButton button = new JButton("Rechercher");
    JTextField jtf = new JTextField();
    String[] tab = {"Etudiant", "Professeur", "Salle", "Groupe","Promotion"};
    JComboBox combo = new JComboBox(tab);
    JLabel lbl = new JLabel("    Nom: ");
    
    /// Création de la boite d'entrée
    Font police = new Font("Arial", Font.CENTER_BASELINE, 14);
    jtf.setFont(police);
    jtf.setPreferredSize(new Dimension(150, 30));
 
    ///Ajout de tous les JElements dans butto
    parametersPan.add(combo);
    parametersPan.add(lbl);
    parametersPan.add(jtf);
    parametersPan.add(button);
   
  return parametersPan;
}
private JMenuBar toolBar(){
    
  JMenuBar menuBar = new JMenuBar();
  JMenu planning = new JMenu("Planning");
  JMenu recap = new JMenu("Recapitulatif");
  JMenu maj = new JMenu("Mise à jour");
  JMenu stat = new JMenu("Statistiques");
  menuBar.add(planning);
  menuBar.add(recap);
  menuBar.add(maj);
  menuBar.add(stat);
  
  return  menuBar;
}
}
