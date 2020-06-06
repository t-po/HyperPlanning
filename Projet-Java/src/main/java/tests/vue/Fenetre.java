/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.vue;
import CalendrierJpanel.SButton;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
/**
 * 
 * @author Hippo
 */
public class Fenetre extends JFrame{
    Panneau panneau = new Panneau();
    JPanel panel = new JPanel();
    public Fenetre(){
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Table");
    this.setSize(800, 600);

    Table tableau = new Table(1,6,2020, panel);
    
    
    //Nous ajoutons notre tableau à notre contentPane dans un scroll
    //Sinon les titres des colonnes ne s'afficheront pas !
    this.setLayout(new BorderLayout());
    this.getContentPane().add(new JScrollPane(panel));
    //this.getContentPane().add(tableau.creationBtn(), BorderLayout.NORTH);
    
    //this.setContentPane(new JScrollPane(new Table()));
    
    
    this.setVisible(true);
    
    
   }   
    
  /*public JTable tableCreation(int premJour, int mois, int annee) {
      
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
    String  title[] = {"", "Lundi 0" + premJour + "/" + mois, "Mardi 0" + ++premJour + "/" + mois, "Mercredi 0" + ++premJour + "/" + mois, "Jeudi 0" + ++premJour + "/" + mois, "Vendredi 0" + ++premJour + "/" + mois, "Samedi 0" + ++premJour + "/" + mois, "Dimanche 0" + ++premJour + "/" + mois};
    JTable tableau = new JTable(data, title);
    
    //font du tableau
    tableau.setFont(new Font("Calibri",Font.PLAIN, 15));
    
    //font special première collone ------------ src : https://github.com/t-po/HyperPlanning/blob/dev/Projet-Java/src/main/java/tests/vue/Fenetre.java
    DefaultTableCellRenderer premCol = new DefaultTableCellRenderer(){
        Font font = new Font("Calibri", Font.BOLD, 15);
        Color color =new Color(238, 238, 238);
        
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int colunm){
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, colunm);
            setFont(font);
            setBackground(color);
            return this;
        }
    };
    tableau.getColumnModel().getColumn(0).setCellRenderer(premCol);
    //-------------------------------
    
    //couleur verte pour colonne
    /*DefaultTableCellRenderer greenColor = new DefaultTableCellRenderer(){
      Color colorFull =new Color(150, 194, 148);
      Color colorEmpty = Color.WHITE;
      
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
          String str = new String();
          super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
          for (int i=0; i<tableau.getRowCount();i++){
            for(int j=0; j<tableau.getColumnCount();j++){
                str = tableau.getValueAt(i, j).toString();
                
                if (str !=""){
    
                    
                   setBackground(colorFull);
                }else {
    
                    setBackground(colorEmpty);
                }
            }
    
        }
          System.out.println("\n");
          
          
          return this;
      }
    };
    //for (int i=1; i<tableau.getColumnCount();i++){
        tableau.getColumnModel().getColumn(1).setCellRenderer(greenColor);
    //}*/
    
    //On agrandi la auteur de toutes les lignes.
    /*tableau.setRowHeight(80);
    tableau.getTableHeader().setReorderingAllowed(false);
    return tableau;
    }*/

    
}
