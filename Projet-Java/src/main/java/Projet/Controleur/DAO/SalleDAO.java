package Projet.Controleur.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import Projet.Modèle.Data.Salle;

public class SalleDAO extends DAO<Salle>{
    public SalleDAO(Connection conn){
        super(conn);
    }

    public boolean create(Salle obj){
        return false;
    }

    public boolean update(Salle obj){
        return false;
    }

    public boolean delete(Salle obj){
        return false;
    }

    public void printAllSalle(){
        try{
            ResultSet res;
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM salle");
            while(result.next()){
                res = this.connect.createStatement().executeQuery("SELECT * FROM site WHERE ID= "+result.getInt("ID_SITE"));
                res.next();
                System.out.println(result.getInt("ID")+" "+result.getString("NOM")+" "+result.getInt("CAPACITE")+" "+res.getString("NOM"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Salle find(int id){
        Salle salle = new Salle();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM salle WHERE ID = "+id);
            if(result.first()){
                salle = new Salle(id,result.getString("NOM"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return salle;
    }
}