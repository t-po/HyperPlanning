package Projet.Modèle.Data;

public class Site {
    int id = 0;
    String nom = "";

    public Site(int id, String nom){
        this.id = id;
        this.nom = nom;
    }

    public Site(){}

    public int getId(int id){
        return this.id;
    }

    public String getNom(){
        return this.nom;
    }
}