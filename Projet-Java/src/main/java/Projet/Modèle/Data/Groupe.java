package Projet.Modèle.Data;

public class Groupe {
    int id = 0;
    String nom = "";
    int id_promotion = 0;

    public Groupe(int id, String nom, int id_promotion){
        this.id = id;
        this.nom = nom;
        this.id_promotion = id_promotion;
    }

    public Groupe(){}

    public int getId(){
        return this.id;
    }

    public String getNom(){
        return this.nom;
    }

    public int getId_promotion(){
        return this.id_promotion;
    }
}