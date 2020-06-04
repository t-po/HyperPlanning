/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.vue;

import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Hippo
 */
public class Table extends JTable{
    public Table(TableModel dm, TableColumnModel cm) {
        JTable tableau = new JTable(dm, cm, null);
        for(int i = 0; i < tableau.getRowCount(); i++){
      //On affecte la taille de la ligne à l'indice spécifié !
      if(i == 1)
        tableau.setRowHeight(i, 80);
      }
    }
}
