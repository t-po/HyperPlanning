package Projet.Modèle.Data;

public class Etudiant {
    int id_utilisateur = 0;
    int numero = 0;
    int id_groupe = 0;

    public Etudiant(int id_utilisateur, int numero, int id_groupe){
        this.id_utilisateur = id_utilisateur;
        this.numero = numero;
        this.id_groupe = id_groupe;
    }

    public Etudiant(){}

    public int getId_utilisateur(){
        return this.id_utilisateur;
    }

    public int getNumero(){
        return this.numero;
    }

    public int getId_groupe(){
        return this.id_groupe;
    }
}