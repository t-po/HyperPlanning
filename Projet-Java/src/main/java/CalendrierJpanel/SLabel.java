/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalendrierJpanel;

import javax.swing.*;

/**
 *
 * @author Hippo
 */
public class SLabel extends JLabel{
    public SLabel(String label,int horizental,int taillePolice,int x0,int y0,int x,int y,JPanel contentPane){
	 	super(label);
	 	setFont(new java.awt.Font("Monospacede", 1, taillePolice));
        setBounds(x0,y0,x,y);
        if(horizental == 0)
        	setHorizontalAlignment(SwingConstants.LEFT);
        if(horizental == 1)
        	setHorizontalAlignment(SwingConstants.CENTER);
        if(horizental == 2)
        	setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(this);
        
     }
}
