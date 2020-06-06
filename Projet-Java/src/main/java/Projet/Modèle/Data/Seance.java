package Projet.Modèle.Data;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

public class Seance {
    int id = 0;
    int semaine = 0;
    Date date = null;
    Time heure_debut = null;
    Time heure_fin = null;
    int etat = 0;
    int id_cours = 0;
    int id_type = 0;

    Set<Groupe> listGroupe = new HashSet<Groupe>();
    Set<Utilisateur> listEnseignant = new HashSet<Utilisateur>();
    Set<Salle> listSalle = new HashSet<Salle>();

    public Seance(int id, int semaine, Date date, Time debut, Time fin, int etat, int id_cours, int id_type){
        this.id = id;
        this.semaine = semaine;
        this.date = date;
        this.heure_debut = debut;
        this.heure_fin = fin;
        this.etat = etat;
        this.id_cours = id_cours;
        this.id_type = id_type;
    }

    public Seance(){}

    public Set<Groupe> getListGroupe(){
        return this.listGroupe;
    }

    public void addGroupe(Groupe groupe){
        if(!listGroupe.contains(groupe)){
            listGroupe.add(groupe);
        }
    }

    public void removeGroupe(Groupe groupe){
        listGroupe.remove(groupe);
    }

    public void setListGroupe(Set<Groupe> listGroupe){
        this.listGroupe = listGroupe;
    }

    public Set<Utilisateur> getListEnseignant(){
        return this.listEnseignant;
    }

    public void addEnseignant(Utilisateur enseignant){
        if(!listEnseignant.contains(enseignant)){
            listEnseignant.add(enseignant);
        }
    }

    public void removeEnseignant(Utilisateur enseignant){
        listEnseignant.remove(enseignant);
    }

    public void setListEnseignant(Set<Utilisateur> listEnseignant){
        this.listEnseignant = listEnseignant;
    }

    public Set<Salle> getListSalle(){
        return this.listSalle;
    }

    public void addSalle(Salle salle){
        if(!listSalle.contains(salle)){
            this.listSalle.add(salle);
        }
    }

    public void removeSalle(Salle salle){
        this.listSalle.remove(salle);
    }

    public void setListSalle(Set<Salle> listSalle){
        this.listSalle = listSalle;
    }

    public int getId(){
        return this.id;
    }

    public int getSemaine(){
        return this.semaine;
    }

    public Date getDate(){
        return this.date;
    }

    public Time getHeure_debut(){
        return this.heure_debut;
    }

    public Time getHeure_fin(){
        return this.heure_fin;
    }

    public int getEtat(){
        return this.etat;
    }

    public int getId_cours(){
        return this.id_cours;
    }

    public int getId_type(){
        return this.id_type;
    }
}