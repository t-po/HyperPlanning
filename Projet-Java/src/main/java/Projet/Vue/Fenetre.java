/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet.Vue;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.BorderLayout;
import java.awt.Color; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
   
    //Nous ajoutons notre tableau à notre contentPane dans un scroll
    //Sinon les titres des colonnes ne s'afficheront pas !
    this.getContentPane().add(new JScrollPane(tableCreation()));
    
    //Creation des parametres en fin de page
    this.getContentPane().add(parameters(), BorderLayout.SOUTH);
    this.getContentPane().add(toolBar(), BorderLayout.NORTH);
    this.setBackground(Color.green);
    this.setVisible(true);
    
  }   
    
  public JTable tableCreation() {
        Object[][] data = {
      {"8h30-10h00", "28 ans", "1.80 m", "", "", "", "", ""},
      {"10h15-11h45", "28 ans", "1.80 m", "", "", "", "", ""},
      {"12h00-13h30", "24 ans", "1.90 m", "", "", "", "", ""},
      {"13h45-15h15", "32 ans", "1.85 m", "", "", "", "", ""},
      {"15h30-17h00", "", "", "", "", "", "", ""},
      {"17h15-18h45", "", "", "", "", "", "", ""},
      {"19h00-20h30", "", "", "", "", "", "", ""}
    };

    //Les titres des colonnes
    String  title[] = {"", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        System.out.println("3");
    JTable tableau = new JTable(data, title);
    
    //font du tableau
    tableau.setFont(new Font("Calibri",Font.PLAIN, 15));
    
    //font special première collone ------------ src : https://github.com/t-po/HyperPlanning/blob/dev/Projet-Java/src/main/java/tests/vue/Fenetre.java
    DefaultTableCellRenderer diffFont = new DefaultTableCellRenderer(){
        Font font = new Font("Calibri", Font.BOLD, 15);
        
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int colunm){
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, colunm);
            setFont(font);
            return this;
        }
    };
    tableau.getColumnModel().getColumn(0).setCellRenderer(diffFont);
    //-------------------------------
    
    //couleur verte pour colonne
    DefaultTableCellRenderer diffColor = new DefaultTableCellRenderer(){
      Color color = Color.GREEN;
      
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
          super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
          setBackground(color);
          return this;
      }
    };
    tableau.getColumnModel().getColumn(0).setCellRenderer(diffColor);
    //On agrandi la auteur de toutes les lignes.
    tableau.setRowHeight(80);
    System.out.println("4");
    return tableau;
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
  JMenu nav = new JMenu("Navigation");

  JMenuItem planning =  new JMenuItem("Planning");
  JMenuItem recap =  new JMenuItem("Recapitulatif");
  JMenuItem stat =  new JMenuItem("Statistiques");
  
  nav.add(planning);
  nav.add(recap);
  nav.add(stat);
  menuBar.add(nav);

  
  return  menuBar;
}
}
