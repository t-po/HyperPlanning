package Projet.Controleur.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import Projet.Modèle.Data.Site;

public class SiteDAO extends DAO<Site>{
    public SiteDAO(Connection conn){
        super(conn);
    }

    public boolean create(Site obj){
        return false;
    }

    public boolean update(Site obj){
        return false;
    }

    public boolean delete(Site obj){
        return false;
    }

    public Site find(int id){
        Site site = new Site();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM site WHERE ID = "+ id);
            if(result.first()){
                site = new Site(id, result.getString("NOM"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return site;
    }
}