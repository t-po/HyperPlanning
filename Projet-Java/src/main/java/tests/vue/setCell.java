/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Hippo
 */
public class setCell {
    public void premCol(JTable tableau){
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
    }
}
