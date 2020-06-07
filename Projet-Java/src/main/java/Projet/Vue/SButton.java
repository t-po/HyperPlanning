/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet.Vue;

import javax.swing.*;

/**
 *
 * @author Hippo
 */
public class SButton extends JButton{
    public SButton(String label,int x0,int y0,int x,int y,boolean visible,JPanel contentPane){
	 	super(label);
	 	setFont(new java.awt.Font("Monospaced", 1, 14));
        setBounds(x0,y0,x,y);
        setVisible(visible);
        setOpaque(false);
        contentPane.add(this);
     }
}
