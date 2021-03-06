/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet.Vue;

import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.event.*;

import Projet.Controleur.DAO.CoursDAO;
import Projet.Controleur.DAO.DAOFactory;
import Projet.Controleur.DAO.SeanceDAO;
import Projet.Controleur.DAO.Type_coursDAO;
import Projet.Modèle.Data.Cours;
import Projet.Modèle.Data.Salle;
import Projet.Modèle.Data.Seance;
import Projet.Modèle.Data.Type_cours;
import Projet.Modèle.Data.Utilisateur;

/**
 *
 * @author Hippo
 */
public class Table extends JPanel implements ActionListener{
    private int premJour, mois, annee, nvPremJour, semaine;
   /* private Object[][] data = {
      {"8h30-10h00", "28 ans", "1.80 m", "", "", "", "", ""},
      {"10h15-11h45", "28 ans", "1.80 m", "", "", "", "", ""},
      {"12h00-13h30", "24 ans", "1.90 m", "", "", "", "", ""},
      {"13h45-15h15", "32 ans", "1.85 m", "", "", "", "", ""},
      {"15h30-17h00", "", "", "", "", "", "", ""},
      {"17h15-18h45", "", "", "", "", "", "", ""},
      {"19h00-20h30", "", "", "", "", "", "", ""}
    };*/
    private Utilisateur utilisateur;
    SButton next, prev;
    JPanel container;
    JTable tableau;
    Object[][] tableauID;

    //Les titres des colonnes
    

    
    
    public Table(int premJour, int mois, int annee, JPanel container, Utilisateur utilisateur, int semaine){
        this.container = container;
        this.semaine = semaine;
        this.utilisateur = utilisateur;
        System.out.println("Table begin");
        System.out.println("date entrée : "+premJour+"/"+mois+"/"+annee);
        this.premJour = jour(annee,mois,premJour); this.mois = mois; this.annee = annee; this.nvPremJour=this.premJour;
        System.out.println("premJour après prg jour : "+this.premJour);
        creationTable();
        container.setLayout(new BorderLayout());
        this.container.add(new JScrollPane(tableau));
        this.container.add(creationBtn(), BorderLayout.NORTH);
        this.container.setVisible(true);
    }
    
    public JPanel getContainer(){
        return this.container;
    }
    

    private void creationTable(){
        /*this.next = new SButton("Next",270,0,50,28,true,this);
        this.prev = new SButton("Prev",100,0,50,28,true,this);
        this.prev.addActionListener(this);
	    this.next.addActionListener(this);*/
       int mardi=0, mercredi=0, jeudi=0, vendredi=0, samedi=0, dimanche=0;
        if((premJour+7>31 && mois%2!=0) || (premJour+7>30 && mois%2==0) || (premJour+7>28 && mois==2 && (annee-2020)%4!=0)  || (premJour+7>29 && mois==2 && (annee-2020)%4==0)){
            for(int i=1; i<7; i++ ){
                 switch (i){
                     case 1: if(premJour+i>31) mardi=31;
                            else if(premJour+i>30) mardi=30;
                            else if(premJour+i>29) mardi=29;
                            else if(premJour+i>30) mardi=28;
                            break;
                     case 2: if(premJour+i>31) mercredi=31;
                            else if(premJour+i>30) mercredi=30;
                            else if(premJour+i>29) mercredi=29;
                            else if(premJour+i>30) mercredi=28;
                            break;
                     case 3: if(premJour+i>31) jeudi=31;
                            else if(premJour+i>30) jeudi=30;
                            else if(premJour+i>29) jeudi=29;
                            else if(premJour+i>30) jeudi=28;
                            break;
                     case 4: if(premJour+i>31) vendredi=31;
                            else if(premJour+i>30) vendredi=30;
                            else if(premJour+i>29) vendredi=29;
                            else if(premJour+i>30) vendredi=28;
                            break;
                     case 5: if(premJour+i>31) samedi=31;
                            else if(premJour+i>30) samedi=30;
                            else if(premJour+i>29) samedi=29;
                            else if(premJour+i>30) samedi=28;
                            break;
                     case 6: if(premJour+i>31) dimanche=31;
                            else if(premJour+i>30) dimanche=30;
                            else if(premJour+i>29) dimanche=29;
                            else if(premJour+i>30) dimanche=28;
                            break;
                 }
                         
                
            }
        }else{
            System.out.println("premjour?? : "+nvPremJour);
            mardi=++ nvPremJour;mercredi=++ nvPremJour;jeudi=++ nvPremJour;vendredi=++ nvPremJour;samedi=++ nvPremJour;dimanche=++ nvPremJour;
            System.out.println("suis dans le else");
        }
        System.out.println("premJour? : "+premJour);
        //if((this.premJour+7 <31 && mois%2 ==0) || (this.premJour+7 <30 && mois%2 ==1) || (this.premJour+7 <28 && mois ==2)){
            String title[] = {"", "Lundi" + this.premJour + "/" + this.mois, "Mardi" + mardi + "/" + this. mois, "Mercredi" + mercredi + "/" + this.mois, "Jeudi" + jeudi + "/" + this.mois, "Vendredi" + vendredi + "/" + this.mois, "Samedi" + samedi + "/" + mois, "Dimanche" + dimanche + "/" + mois};
       
            Object [][] data = (Object[][])setupCours();
            this.tableau = new JTable(data, title);

            
            tableau.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    int row = tableau.rowAtPoint(evt.getPoint());
                    int col = tableau.columnAtPoint(evt.getPoint());
                    if (row >= 0 && col >= 1) {
                        recupInfos(tableau, row,col);
                        detailCour(row,col);
                    }
                }
            });
        
        
        
        
        //font du tableau
        this.tableau.setFont(new Font("Calibri",Font.PLAIN, 15));
        
        setCell cell = new setCell();
        cell.premCol(tableau);
        //-------------------------------
        //On agrandi la auteur de toutes les lignes.
        tableau.setRowHeight(80);
        tableau.getTableHeader().setReorderingAllowed(false);
        //return tableau;
    }
    

    private JPanel creationBtn(){
        JPanel panel = new JPanel();
        this.next = new SButton("Prev",100,0,50,28,true,this);
        this.prev = new SButton("Next", 270,0,50,28,true,this);
        
        prev.addActionListener(this);
	next.addActionListener(this);
        
        panel.add(prev);
        panel.add(next);
        
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.container.removeAll();
        if (e.getSource() == this.prev){
            this.premJour=this.nvPremJour;
            this.premJour++;
            this.semaine++;
            System.out.println("ta race"+premJour);
        }
        if(e.getSource() == this.next){
            this.premJour--;
            this.semaine--;
        }

            new Table(this.premJour,this.mois,this.annee, this.container, this.utilisateur,this.semaine);
            this.container.revalidate();
            this.container.repaint();
            this.container.updateUI();
        
        
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
        System.out.println("1er retour : "+retour);
        if(jour!=1 && retour>2){
            retour=jour-retour-1;
        }else{
            if(mois==2 && retour>2){
                if((annee-2020)%4==0)
                    jour=29;
                else jour=28;
                retour=jour-retour-2;
            }
            else if(mois%2==0 && retour>2){
                jour=30;
                retour=jour-retour-2;
            }else if (mois%2!=1 && retour>2){
                jour=31;
                retour=jour-retour-2;
            }
            else{
                retour=jour;
            }
        }
        System.out.println("retour : "+retour);
    	return (retour);
    }



    
    protected static void recupInfos(JTable table, int selectedRow, int selectedCol) {
        if ( selectedRow>=0 ) {
            System.out.println(String.valueOf(table.getValueAt(selectedRow,selectedCol)));
        }
    }
    
    private Object setupCours(){
        //ranger les séances de cours par heure et date
        int annee, mois, jour;
        String heure, nom;
        SeanceDAO seanceDAO = DAOFactory.getSeanceDAO();
        CoursDAO coursDAO = DAOFactory.getCoursDAO();
        Type_coursDAO type_coursDAO = DAOFactory.getType_coursDAO();
        Iterator<Seance> it =seanceDAO.listeSeance(utilisateur).iterator();
        Iterator<Salle> salleIt;
        Seance seance;
        Cours cours;
        Type_cours type_cours;
        Salle salle;
        Object[][] tableauIDbuff = {
            {"8h30-10h00", "", "", "", "", "", "", ""},
            {"10h15-11h45", "", "", "", "", "", "", ""},
            {"12h00-13h30", "", "", "", "", "", "", ""},
            {"13h45-15h15", "", "", "", "", "", "", ""},
            {"15h30-17h00", "", "", "", "", "", "", ""},
            {"17h15-18h45", "", "", "", "", "", "", ""},
            {"19h00-20h30", "", "", "", "", "", "", ""}
          };
        tableauID = tableauIDbuff;
        Object[][] data = {
      {"8h30-10h00", "", "", "", "", "", "", ""},
      {"10h15-11h45", "", "", "", "", "", "", ""},
      {"12h00-13h30", "", "", "", "", "", "", ""},
      {"13h45-15h15", "", "", "", "", "", "", ""},
      {"15h30-17h00", "", "", "", "", "", "", ""},
      {"17h15-18h45", "", "", "", "", "", "", ""},
      {"19h00-20h30", "", "", "", "", "", "", ""}
    };
        while(it.hasNext()){
            seance = it.next();
            cours = coursDAO.find(seance.getId_cours());
            type_cours = type_coursDAO.find(seance.getId_type());
            salleIt = seance.getListSalle().iterator();
            salle = salleIt.next();
            if(seance.getSemaine()==semaine){
                if(seance.getHeure_debut().getHours()==8&&seance.getHeure_debut().getMinutes()==30){
                    data[0][seance.getDate().getDay()]=cours.getNom();
                    tableauID[0][seance.getDate().getDay()]=seance.getId();
                }
                if(seance.getHeure_debut().getHours()==10&&seance.getHeure_debut().getMinutes()==15){
                    data[1][seance.getDate().getDay()]=cours.getNom();
                    tableauID[1][seance.getDate().getDay()]=seance.getId();
                }
                if(seance.getHeure_debut().getHours()==12&&seance.getHeure_debut().getMinutes()==0){
                    data[2][seance.getDate().getDay()]=cours.getNom();
                    tableauID[2][seance.getDate().getDay()]=seance.getId();
                }
                if(seance.getHeure_debut().getHours()==13&&seance.getHeure_debut().getMinutes()==45){
                    data[3][seance.getDate().getDay()]=cours.getNom();
                    tableauID[3][seance.getDate().getDay()]=seance.getId();
                }
                if(seance.getHeure_debut().getHours()==15&&seance.getHeure_debut().getMinutes()==30){
                    data[4][seance.getDate().getDay()]=cours.getNom();
                    tableauID[4][seance.getDate().getDay()]=seance.getId();
                }
                if(seance.getHeure_debut().getHours()==17&&seance.getHeure_debut().getMinutes()==15){
                    data[5][seance.getDate().getDay()]=cours.getNom();
                    tableauID[5][seance.getDate().getDay()]=seance.getId();
                }
                if(seance.getHeure_debut().getHours()==19&&seance.getHeure_debut().getMinutes()==0){
                    data[6][seance.getDate().getDay()]=cours.getNom();
                    tableauID[6][seance.getDate().getDay()]=seance.getId();
                }
            }
        }
        return data;
    }
    
    private void detailCour(int row,int col){
        SButton retour=new SButton("retour",500,100,600,150,true,container);
        
        
        this.container.removeAll();
        System.out.print("ici!!");
        retour.addActionListener(this);
        this.container.add( new Panneau(row,col,tableauID[row][col]));
        this.container.add(retour, BorderLayout.SOUTH);
        this.container.revalidate();
            this.container.repaint();
            this.container.updateUI();
    }
}
