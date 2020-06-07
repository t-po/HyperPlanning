/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet.Vue;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import Projet.Modèle.Data.Utilisateur;

/**
 *
 * @author Hippo
 */
public class Fenetre extends JFrame{
   
    
    public Fenetre(Utilisateur utilisateur){
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Hyper Planning");
        this.setSize(800, 600);
        JPanel panel = new JPanel();
    
        Table tableau = new Table(8,6,2020,panel,utilisateur);
        //Nous ajoutons notre tableau à notre contentPane dans un scroll
        //Sinon les titres des colonnes ne s'afficheront pas !
        this.getContentPane().add(new JScrollPane(panel));
    
        //Creation des parametres en fin de page
        this.getContentPane().add(parameters(), BorderLayout.SOUTH);
        this.getContentPane().add(toolBarre(), BorderLayout.NORTH);
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
    
    // Pour récupérer les paramètres entrées
    /*button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.out.println(combo.getSelectedItem()); // Recupérer la selection de comob
          System.out.println(jtf.getText());    // Recupérer le nom entré
        }
     });
    */
   
  return parametersPan;
}
private JMenuBar toolBarre(){
    
  // tool Barre de navigation entre les pages 
  
  JMenuBar menuBar = new JMenuBar();
  JMenu nav = new JMenu("Navigation");

  JMenuItem planning =  new JMenuItem("Planning");
  JMenuItem recap =  new JMenuItem("Recapitulatif");
  JMenuItem stat =  new JMenuItem("Statistiques");
  
  nav.add(planning);
  nav.add(recap);
  nav.add(stat);
  menuBar.add(nav);

  /* Pour interagir avec la tool barre
  planning.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          
        }
     });
  */
  return  menuBar;
}
}
