/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalendrierJpanel;

import Projet.Vue.SButton;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Hippo
 */
public class Calendrier extends JPanel implements ActionListener{
    JPanel container;
	Vector btnVect = new Vector();
	SButton suiv;
	SButton prec;
	
	int x0,y0,mois,annee;//x0 et y0 sont les coordonnées pour setLocation
	
	public Calendrier(int x0,int y0,int iMois,int iAnnee,JPanel container){
		super();
                System.out.println("1");
		this.container = container;
		this.x0  = x0;
		this.y0  = y0;
		this.mois  = iMois;
		this.annee  = iAnnee;
		container.setLayout(null);
		setOpaque(true); //si vous utiliser une image comme fond
		setBounds(x0,y0,420,360);
		setLayout(null);
		container.add(this);
	System.out.println("2");	
		prec = new SButton("<<",100,0,50,28,true,this);	
            System.out.println("1");
		new SLabel(string(iMois)+" "+iAnnee,1,14,150,0,120,30,this);
            System.out.println("2");
		suiv = new SButton(">>",270,0,50,28,true,this);	
		prec.addActionListener(this);
		suiv.addActionListener(this);
        System.out.println("3");
		new SLabel("Dim",1,12,0,30,60,30,this);
		new SLabel("Lun",1,12,60,30,60,30,this);
		new SLabel("Mar",1,12,120,30,60,30,this);
		new SLabel("Mer",1,12,180,30,60,30,this);
		new SLabel("Jeu",1,12,240,30,60,30,this);
		new SLabel("Ven",1,12,300,30,60,30,this);
		new SLabel("Sam",1,12,360,30,60,30,this);
	System.out.println("4");
		remplirVect();
        System.out.println("5");
		afficherGrille(iMois,iAnnee);
        System.out.println("6");
	}
	
	//procedure de remplissage du vecteur par des boutton standard
	public void remplirVect(){
		int ligne = 0;
		while (ligne<6){
			int colonne = 0;
			while( colonne<7){
				JButton btn = new JButton();
				btn.setBounds(colonne*60,(ligne*60)+60,60,60);
				btn.setVisible(false);
				btnVect.addElement(btn);
				colonne++;
			}
			ligne++;
		}
	}
	
	public void afficherGrille(int iMois,int iAnnee){
		for (int i = jour(iAnnee,iMois,1);i<(jour(iAnnee,iMois,1)+nbreJour(iMois,iAnnee));i++){
			JButton b = new JButton();
			b = (JButton)btnVect.elementAt(i-1);
			b.setVisible(true);
			b.setLabel(new Integer(i-jour(iAnnee,iMois,1)+1).toString());
			add(b);
			b.addActionListener(this);
		}			
	}
		
	
	public int jour(int annee,int mois, int jour){
    	int retour = 0;
    	for(int i=1900;i<annee;i++)
    		if(i%4 == 0)retour+=366;
    		else retour+=365;
    	for(int i=1;i<mois;i++){
    		if((i==1)||(i==3)||(i==5)||(i==7)||(i==8)||(i==10)||(i==12))retour+=31;
    		if((i==4)||(i==6)||(i==9)||(i==11))retour+=30;
    		if((i==2)&&(annee%4==0))retour+=29;
    		if((i==2)&&(annee%4!=0))retour+=28;
    	}
    	for(int i=0;i<jour;i++)
    		retour+=1;
    	if(retour%7==0) retour = 7;
    	else retour = retour%7;
    	return (retour);
    }
    
    public String string(int i){
    	String retour = new String();
    	
    	switch(i){
    		case 1 : { retour ="Janvier";break; }
    		case 2 : { retour ="Février";break; }
    		case 3 : { retour ="Mars";break; }
    		case 4 : { retour ="Avril";break; }
    		case 5 : { retour ="Mai";break; }
    		case 6 : { retour ="Juin";break; }
    		case 7 : { retour ="Juillet";break; }
    		case 8 : { retour ="Aout";break; }
    		case 9 : { retour ="Septembre";break; }
    		case 10: { retour ="Octobre";break; }
    		case 11: { retour ="Novembre";break; }
    		case 12: { retour ="Décembre";break; }
    	}
    	return retour;
    }
    
    public int nbreJour(int mois,int annee){
    	int retour = 0;
    	
    	switch(mois){
    		case 1 : { retour = 31;break; }
    		case 2 : { 
    					if(annee%4 == 0) retour = 29;
    					else retour = 28;
    					break; }
    		case 3 : { retour =31;break; }
    		case 4 : { retour =30;break; }
    		case 5 : { retour =31;break; }
    		case 6 : { retour =30;break; }
    		case 7 : { retour =31;break; }
    		case 8 : { retour =31;break; }
    		case 9 : { retour =30;break; }
    		case 10: { retour =31;break; }
    		case 11: { retour =30;break; }
    		case 12: { retour =31;break; }
    	}
    	return retour;
    }
    
    public void actionPerformed(ActionEvent e){
    	if(e.getSource() == suiv){
            System.out.println("icicici");
    		container.removeAll();
    		int m,a;
    		if(mois==12){
    			m=1;
    			a=annee+1;}
    			else{
    				m=mois+1;
    				a=annee;}
    		container.add(new Calendrier(x0,y0,m,a,container));
    		container.repaint();
    	}
    	if(e.getSource() == prec){
    		container.removeAll();
                System.out.println("container before : " + this.container);
    		int m,a;
    		if(mois==1){
    			m=12;
    			a=annee-1;}
    			else{
    				m=mois-1;
    				a=annee;}
    		container.add(new Calendrier(x0,y0,m,a,container));
    		container.repaint();
                System.out.println("container after : " + this.container);
    	}
    }
    		
}

// les deux classes qui suivent font partie de ma bibliothèque de composants personélisée
// changer les si elles vous plaisent pa ;)

