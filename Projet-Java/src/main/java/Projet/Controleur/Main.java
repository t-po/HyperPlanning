package Projet.Controleur;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import Projet.Controleur.DAO.*;
import Projet.Modèle.Data.*;

public class Main {
    public static void main(String[] args) {
        int test = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("1-Test utilisateur\n2-Test administrateur");
        test = input.nextInt();
        input.nextLine();
        if(test == 1){

        }
        if(test == 2){
            UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
            SeanceDAO seanceDAO = DAOFactory.getSeanceDAO();
            SalleDAO salleDAO = DAOFactory.getSalleDAO();
            GroupeDAO groupeDAO = DAOFactory.getGroupeDAO();
            CoursDAO coursDAO = DAOFactory.getCoursDAO();
            Type_coursDAO type_coursDAO = DAOFactory.getType_coursDAO();
            boolean co = false;
            String mail,mdp;
            int idP = 0,idS=0, idG=0,idSalle=0, modif = 0;
            while(!co){
                System.out.println("Entrer votre mail");
                mail = input.nextLine();
                System.out.println("Entre votre mot de passe");
                mdp = input.nextLine();
                Utilisateur personne =  utilisateurDAO.connexion(mail,mdp);
                if(personne.getId()!=0 && personne.getDroit()==1){
                    co = true;
                }
                else{
                    System.out.println("Vous n'êtes pas un administrateur");
                }
            }
            int choix = 0;
            while(co){
                System.out.println("1-Afficher toutes les heures de cours \n2-Afficher les enseignants\n3-Affecter un enseignant sur un cours\n4-Affecter un groupe sur une seance\n5-Changer un type et nom de cours\n6-Affecter une salle sur une seance\n7-Ajouter une séance\n8-Annuler/Valider cours\n9-Enlever un groupe ou un prof \n0-Quitter");
                if(input.hasNextInt()){
                    choix = input.nextInt();
                    input.nextLine();
                }
                if(choix == 0){
                    co = false;
                }
                if(choix == 1){
                    seanceDAO.printAllSeance();
                }
                if(choix == 2){
                    utilisateurDAO.printAllEnseignant();
                }
                if(choix == 3){
                    seanceDAO.printAllSeance();
                    utilisateurDAO.printAllEnseignant();
                    System.out.println("Choisir un ID de prof");
                    idP = input.nextInt();
                    input.nextLine();
                    System.out.println("Choisir un ID de Seance");
                    idS = input.nextInt();
                    input.nextLine();
                    Seance addProfSeance = seanceDAO.find(idS);
                    Utilisateur addProfProf = utilisateurDAO.find(idP);
                    if(seanceDAO.addEnseignant(addProfSeance, addProfProf)){
                        System.out.println("Affectation réussi");
                    }
                    else{
                        System.out.println("Echec");
                    }
                }
                if(choix ==4){
                    seanceDAO.printAllSeance();
                    groupeDAO.printAllGroupe();
                    System.out.println("Choisir un ID de groupe");
                    idG = input.nextInt();
                    input.nextLine();
                    System.out.println("Choisir un ID de Seance");
                    idS = input.nextInt();
                    input.nextLine();
                    Seance addGroupeSeance = seanceDAO.find(idS);
                    Groupe addGroupeGroupe = groupeDAO.find(idG);
                    if(seanceDAO.addGroupe(addGroupeSeance, addGroupeGroupe)){
                        System.out.println("Affectation réussi");
                    }
                    else{
                        System.out.println("Echec");
                    }
                }
                if(choix ==5){
                    seanceDAO.printAllSeance();
                    System.out.println("Choisir un ID de séance");
                    idS = input.nextInt();
                    input.nextLine();
                    System.out.println("1-Changer le nom du cours\n2-Changer le type de cours");
                    modif = input.nextInt();
                    input.nextLine();
                    System.out.println("Choisir un nouveau nom");
                    String nouvNom = input.nextLine();
                    if(modif == 1){
                        if(coursDAO.modif(nouvNom, idS)){
                            System.out.println("Changement effectué");
                        }
                        else{
                            System.out.println("Changement raté");
                        }
                    }
                    if(modif == 2){
                        if(type_coursDAO.modif(nouvNom, idS)){
                            System.out.println("Changement effectué");
                        }
                        else{
                            System.out.println("Changement raté");
                        }
                    }
                }
                if(choix ==6){
                    seanceDAO.printAllSeance();
                    salleDAO.printAllSalle();
                    System.out.println("Choisir un ID de salle");
                    idSalle = input.nextInt();
                    input.nextLine();
                    System.out.println("Choisir un ID de Seance");
                    idS = input.nextInt();
                    input.nextLine();
                    Seance addSalleSeance = seanceDAO.find(idS);
                    Salle addSalleSalle = salleDAO.find(idSalle);
                    if(seanceDAO.setSalle(addSalleSeance, addSalleSalle)){
                        System.out.println("Affectation réussi");
                    }
                    else{
                        System.out.println("Echec");
                    }
                }
                if(choix ==7){
                    int semaine,etat,an,mois,jour,hD,hF,mD,mF,idCours,idType,quit = 1000;
                    Date date;
                    Time timeD,timeF;
                    System.out.println("Choisir une Semaine");
                    semaine =input.nextInt();
                    input.nextLine();
                    System.out.println("Choisir une année puis un mois puis un jour ");
                    an=input.nextInt();
                    input.nextLine();
                    mois=input.nextInt();
                    input.nextLine();
                    jour=input.nextInt();
                    input.nextLine();
                    date = new Date(an,mois,jour);
                    System.out.println("Choisir une heure puis les minutes de début");
                    hD=input.nextInt();
                    input.nextLine();
                    mD=input.nextInt();
                    input.nextLine();
                    timeD = new Time(hD,mD,0);
                    System.out.println("Choisir une heure puis les minutes de fin");
                    hF=input.nextInt();
                    input.nextLine();
                    mF=input.nextInt();
                    input.nextLine();
                    timeF= new Time(hF,mF,0);
                    coursDAO.listCours();
                    System.out.println("Choisir un id de cours");
                    idCours=input.nextInt();
                    input.nextLine();
                    type_coursDAO.listType();
                    System.out.println("Choisir un id de type de cours");
                    idType=input.nextInt();
                    input.nextLine();
                    Seance seance = new Seance(0,semaine,date,timeD,timeF,1,idCours,idType);
                    groupeDAO.printAllGroupe();
                    while(quit!=0){
                        System.out.println("Choisir un ID de groupe ou 0 pour quitter");
                        quit=input.nextInt();
                        input.nextLine();
                        if(quit!=0)seance.addGroupe(groupeDAO.find(quit));
                    }
                    quit=1000;
                    utilisateurDAO.printAllEnseignant();
                    while(quit!=0){
                        System.out.println("Choisir un ID d'enseignant ou 0 pour quitter");
                        quit=input.nextInt();
                        input.nextLine();
                        if(quit!=0)seance.addEnseignant(utilisateurDAO.find(quit));
                    }
                    quit=1000;
                    salleDAO.printAllSalle();
                    while(quit!=0){
                        System.out.println("Choisir un ID de salle ou 0 pour quitter");
                        quit=input.nextInt();
                        input.nextLine();
                        if(quit!=0)seance.addSalle(salleDAO.find(quit));
                    }
                    quit=1000;
                    seanceDAO.addSeance(seance);
                }
                if(choix ==8){
                    seanceDAO.printAllSeance();
                    System.out.println("Choisir un ID à valider ou annuler");
                    modif = input.nextInt();
                    input.nextLine();
                    Seance seanceAnnuler = seanceDAO.find(modif);
                    if(seanceAnnuler.getEtat()==0){
                        if(seanceDAO.valider(seanceAnnuler)){
                            System.out.println("Seance Validé");
                        }
                        else{
                            System.out.println("Echec de changement");
                        }
                    }
                    else{
                        if(seanceDAO.annuler(seanceAnnuler)){
                            System.out.println("Seance annulé");
                        }
                        else{
                            System.out.println("Echec de changement");
                        }
                    }
                }
                if(choix ==9){
                    seanceDAO.printAllSeance();
                    System.out.println("Choisir un id de séance");
                    idS= input.nextInt();
                    input.nextLine();
                    Seance seanceModif = seanceDAO.find(idS);
                    System.out.println("1-Retirer un groupe \n2-Retirer un prof ?");
                    modif = input.nextInt();
                    input.nextLine();
                    System.out.println("Choisir le nom");
                    String nom = input.nextLine();
                    if(modif == 1){
                        Groupe groupe = groupeDAO.find(nom);
                        if(seanceDAO.retirerGroupe(seanceModif, groupe)){
                            System.out.println("Groupe retiré");
                        }
                        else{
                            System.out.println("Echec");
                        }
                    }
                    if(modif == 2){
                        Utilisateur enseignantRetire = utilisateurDAO.find(nom);
                        if(seanceDAO.retirerProf(seanceModif, enseignantRetire)){
                            System.out.println("Enseignant retiré");
                        }
                        else{
                            System.out.println("Echec");
                        }
                    }
                }
            }
            input.close();
        }
    }
}