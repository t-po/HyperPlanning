package Projet.Modèle.Data;

public class Salle {
    int id = 0;
    String nom = "";

    public Salle(int id, String nom){
        this.id = id;
        this.nom = nom;
    }

    public Salle(){}

    public int getId(){
        return this.id;
    }

    public String getNom(){
        return this.nom;
    }
}