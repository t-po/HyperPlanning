package Projet.Modèle.Data;

import java.util.HashSet;
import java.util.Set;

public class Utilisateur {
    private int id = 0;
    private String email ="";
    private String passwd ="";
    private String nom ="";
    private String prenom="";
    private int droit=0;

    private Set<Cours> listCours = new HashSet<Cours>();

    public Utilisateur(int id, String email, String passwd, String nom, String prenom, int droit){
        this.id = id;
        this.email = email;
        this.passwd = passwd;
        this.nom = nom;
        this.prenom = prenom;
        this.droit = droit;
    }
    public Utilisateur(){}

    public Set<Cours> getListCours(){
        return this.listCours;
    }

    public void addCours(Cours cours){
        if(!listCours.contains(cours)){
            listCours.add(cours);
        }
    }

    public void removeCours(Cours cours){
        listCours.remove(cours);
    }

    public void setListCours(Set<Cours> listCours){
        this.listCours = listCours;
    }

    public int getId(){
        return this.id;
    }
    
    public String getEmail(){
        return this.email;
    }

    public String getPasswd(){
        return this.passwd;
    }

    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public int getDroit(){
        return this.droit;
    }
}