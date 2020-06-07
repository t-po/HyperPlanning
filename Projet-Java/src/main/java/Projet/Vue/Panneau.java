/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projet.Vue;
import javax.swing.*;

import Projet.Controleur.DAO.CoursDAO;
import Projet.Controleur.DAO.DAOFactory;
import Projet.Controleur.DAO.SeanceDAO;
import Projet.Controleur.DAO.Type_coursDAO;
import Projet.Modèle.Data.Cours;
import Projet.Modèle.Data.Groupe;
import Projet.Modèle.Data.Salle;
import Projet.Modèle.Data.Seance;
import Projet.Modèle.Data.Type_cours;
import Projet.Modèle.Data.Utilisateur;

import java.awt.*;
import java.util.Iterator;

/**
 *
 * @author Hippo
 */
public class Panneau extends JPanel {
    private String titreCour="titre du cours", prof="professeur", groupe="groupe";
    private int row,col,id;

    public Panneau(int row,int col,Object id){
      this.row = row;
      this.col = col;
      this.id = (int) id;
    }

    public void paintComponent(Graphics g){
      int i = 60;
      SeanceDAO seanceDAO = DAOFactory.getSeanceDAO();
      Seance seance = seanceDAO.find(id);
      CoursDAO coursDAO = DAOFactory.getCoursDAO();
      Cours cours = coursDAO.find(seance.getId_cours());
      Type_coursDAO type_coursDAO = DAOFactory.getType_coursDAO();
      Type_cours type_cours = type_coursDAO.find(seance.getId_type());
      Iterator<Utilisateur> prof = seance.getListEnseignant().iterator();
      Iterator<Groupe> groupe = seance.getListGroupe().iterator();
      Iterator<Salle> salle = seance.getListSalle().iterator();
      Font contenu = new Font("Calibri", Font.PLAIN, 20);
      g.drawString(cours.getNom()+" "+type_cours.getNom(), 300, 20);
      while(prof.hasNext()){g.drawString("Professeur : "+prof.next().getNom(), 100, i);i+=20;}
      while(groupe.hasNext()){g.drawString("Groupe : "+groupe.next().getNom(), 100, i);i+=20;}
      while(salle.hasNext()){g.drawString("Salle : "+salle.next().getNom(), 100, i);i+=20;}
      g.drawString("Date : "+seance.getDate().toString(), 100, i);i+=20;  
      g.drawString("Heure début : "+seance.getHeure_debut().toString(), 100, i);i+=20; 
      g.drawString("Heure fin : "+seance.getHeure_fin().toString(), 100, i);i+=20; 
      g.drawString("Etat 1 validé 2 annulé : "+seance.getEtat(), 100, i);i+=20;          
  } 
}
