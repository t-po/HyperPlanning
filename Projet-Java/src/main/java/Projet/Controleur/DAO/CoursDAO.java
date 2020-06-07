package Projet.Controleur.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        return false;
    }

    public void listCours(){
        try{
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM cours");
            while(result.next()){
                System.out.println(result.getInt("ID")+" "+result.getString("NOM"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public boolean modif(String obj,int idSeance){
        try{
            PreparedStatement statement = this.connect.prepareStatement("INSERT INTO cours (NOM) VALUES (?) ");
            statement.setString(1, obj);
            statement.executeUpdate();
            ResultSet result = this.connect.createStatement().executeQuery("SELECT * FROM cours WHERE NOM ='"+obj+"'");
            if(result.last()){
                Statement res = this.connect.createStatement();
                res.execute("UPDATE seance SET ID_COURS ="+result.getInt("ID")+" WHERE ID="+idSeance);
            }
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