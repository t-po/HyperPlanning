package Projet.Controleur.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Projet.Modèle.Data.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur>{
    public UtilisateurDAO(Connection conn){
        super(conn);
    }

    public boolean create(Utilisateur obj){
        return false;
    }

    public boolean delete(Utilisateur obj){
        return false;
    }

    public boolean update(Utilisateur obj){
        return false;
    }

    public Utilisateur connexion(String email, String passwd){
        Utilisateur utilisateur = new Utilisateur();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE EMAIL = '"+email+"' AND PASSWD = '"+passwd+"'");
            if(result.first()){
                utilisateur = new Utilisateur(result.getInt("ID"),result.getString("EMAIL"),result.getString("PASSWD"),result.getString("NOM"),result.getString("PRENOM"),result.getInt("DROIT"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return utilisateur;
    }

    public void printAllEnseignant(){
        Utilisateur enseignant = new Utilisateur();
        try{
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM utilisateur WHERE DROIT = "+3);
            while(result.next()){
                enseignant = find(result.getInt("ID"));
                System.out.println(enseignant.getId()+" "+enseignant.getEmail()+" "+enseignant.getNom()+" "+enseignant.getPrenom());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Utilisateur find(String nom){
        Utilisateur utilisateur = new Utilisateur();
        try{
            ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE NOM = '"+nom+"'");
            if(result.first()){
                utilisateur = new Utilisateur(result.getInt("ID"),result.getString("EMAIL"),result.getString("PASSWD"),result.getString("NOM"),result.getString("PRENOM"),result.getInt("DROIT"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return utilisateur;
    }

    public Utilisateur find(int id){
        Utilisateur utilisateur = new Utilisateur();
        try{
            ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE ID = "+id);
            if(result.first()){
                utilisateur = new Utilisateur(id,result.getString("EMAIL"),result.getString("PASSWD"),result.getString("NOM"),result.getString("PRENOM"),result.getInt("DROIT"));
            }
            if(result.getInt("DROIT") == 3){
                result = this.connect.createStatement().executeQuery("SELECT ID FROM cours INNER JOIN enseignant ON enseignant.ID_COURS = cours.ID AND enseignant.ID_UTILISATEUR = " + id);
                CoursDAO coursDAO = new CoursDAO(this.connect);
                while(result.next()){
                    utilisateur.addCours(coursDAO.find(result.getInt("ID")));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return utilisateur;
    }
}