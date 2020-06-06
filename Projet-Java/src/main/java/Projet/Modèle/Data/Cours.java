package Projet.Modèle.Data;

public class Cours {
    int id = 0;
    String nom = "";

    public Cours(int id, String nom){
        this.id = id;
        this.nom = nom;
    }

    public Cours(){}

    public int getId(){
        return this.id;
    }

    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }
}