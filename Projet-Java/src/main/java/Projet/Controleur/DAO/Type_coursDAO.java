package Projet.Controleur.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;

import Projet.Modèle.Data.Type_cours;

public class Type_coursDAO extends DAO<Type_cours> {
    public Type_coursDAO(Connection conn){
        super(conn);
    }

    public boolean create(Type_cours obj){
        return false;
    }

    public boolean update(Type_cours obj){
        try{
            PreparedStatement statement = this.connect.prepareStatement("UPDATE type_cours SET NOM = ? WHERE ID = ?");
            statement.setString(1, obj.getNom());
            statement.setInt(2, obj.getId());
            statement.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Type_cours obj){
        return false;
    }

    public Type_cours find(int id){
        Type_cours type_cours = new Type_cours();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM type_cours WHERE ID = "+ id);
            if(result.first()){
                type_cours = new Type_cours(id, result.getString("NOM"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return type_cours;
    }
}