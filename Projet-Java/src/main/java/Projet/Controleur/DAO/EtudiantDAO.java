package Projet.Controleur.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Projet.Modèle.Data.Etudiant;

public class EtudiantDAO extends DAO<Etudiant> {
    public EtudiantDAO(Connection conn){
        super(conn);
    }

    public boolean create(Etudiant obj){
        return false;
    }

    public boolean update(Etudiant obj){
        return false;
    }

    public boolean delete(Etudiant obj){
        return false;
    }

    public Etudiant find(int id){
        Etudiant etudiant = new Etudiant();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM etudiant WHERE ID_UTILISATEUR = "+id);
            if(result.first()){
                etudiant = new Etudiant(result.getInt("ID_UTILISATEUR"),result.getInt("NUMERO"),result.getInt("ID_GROUPE"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return etudiant;
    }
    
}