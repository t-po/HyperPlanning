package Projet.Controleur.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import Projet.Modèle.Data.Groupe;

public class GroupeDAO extends DAO<Groupe>{
    public GroupeDAO(Connection conn){
        super(conn);
    }

    public boolean create(Groupe obj){
        return false;
    }

    public boolean update(Groupe obj){
        return false;
    }

    public boolean delete(Groupe obj){
        return false;
    }

    public Groupe find(int id){
        Groupe groupe= new Groupe();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM groupe WHERE ID = " + id);
            if(result.first()){
                groupe = new Groupe(id,result.getString("NOM"),result.getInt("ID_GROUPE"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return groupe;
    }
}