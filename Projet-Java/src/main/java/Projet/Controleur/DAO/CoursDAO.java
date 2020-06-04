package Projet.Controleur.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Projet.Modèle.Data.Cours;

public class CoursDAO extends DAO<Cours> {
    public CoursDAO(Connection conn){
        super(conn);
    }

    public boolean create(Cours obj){
        return false;
    }

    public boolean update(Cours obj){
        try{
            PreparedStatement statement = this.connect.prepareStatement("UPDATE cours SET NOM = ? WHERE ID = ?");
            statement.setString(1, obj.getNom());
            statement.setInt(2, obj.getId());
            statement.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Cours obj){
        return false;
    }

    public Cours find(int id){
        Cours cours = new Cours();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cours WHERE ID = "+ id);
            if(result.first()){
                cours = new Cours(id, result.getString("NOM"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cours;
    }
}