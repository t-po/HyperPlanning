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

    public Groupe find(String nom){
        Groupe groupe= new Groupe();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM groupe WHERE NOM = '" + nom+"'");
            if(result.first()){
                groupe = new Groupe(result.getInt("ID"),result.getString("NOM"),result.getInt("ID_PROMOTION"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return groupe;
    }

    public Groupe find(int id){
        Groupe groupe= new Groupe();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM groupe WHERE ID = " + id);
            if(result.first()){
                groupe = new Groupe(id,result.getString("NOM"),result.getInt("ID_PROMOTION"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return groupe;
    }

    public void printAllGroupe(){
        try{
            ResultSet res;
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM groupe");
            while(result.next()){
                res = this.connect.createStatement().executeQuery("SELECT * FROM promotion WHERE ID="+result.getInt("ID_PROMOTION"));
                if(res.next()){
                    System.out.println(result.getInt("ID")+" "+result.getString("NOM")+" "+res.getString("NOM"));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}