package Projet.Controleur.DAO;

import java.sql.Connection;

import Projet.Modèle.SdzConnection;

public class DAOFactory {
    protected static final Connection conn = SdzConnection.getInstance();

    public static DAO getUtilisateurDAO(){
        return new UtilisateurDAO(conn);
    }

    public static DAO getPromotionDAO(){
        return new PromotionDAO(conn);
    }

    public static DAO getGroupeDAO(){
        return new GroupeDAO(conn);
    }

    public static DAO getEtudiantDAO(){
        return new EtudiantDAO(conn);
    }

    public static DAO getCoursDAO(){
        return new CoursDAO(conn);
    }

    public static DAO getType_coursDAO(){
        return new Type_coursDAO(conn);
    }

    public static DAO getSiteDAO(){
        return new SiteDAO(conn);
    }

    public static DAO getSalleDAO(){
        return new SalleDAO(conn);
    }

    public static DAO getSeanceDAO(){
        return new SeanceDAO(conn);
    }
}