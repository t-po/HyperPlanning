package Projet.Modèle.Data;

public class Promotion {
    int id = 0;
    String nom = "";

    public Promotion(int id, String nom){
        this.id = id;
        this.nom = nom;
    }

    public Promotion(){}

    public int getId(){
        return this.id;
    }

    public String getNom(){
        return this.nom;
    }
}