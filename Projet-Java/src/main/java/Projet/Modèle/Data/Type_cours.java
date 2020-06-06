package Projet.Modèle.Data;

public class Type_cours {
    int id = 0;
    String nom = "";

    public Type_cours(int id, String nom){
        this.id = id;
        this.nom = nom;
    }

    public Type_cours(){}

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