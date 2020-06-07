package Projet.Controleur.DAO;

import java.sql.Connection;

import Projet.Modèle.SdzConnection;

public class DAOFactory {
    protected static final Connection conn = SdzConnection.getInstance();

    public static UtilisateurDAO getUtilisateurDAO(){
        return new UtilisateurDAO(conn);
    }

    public static PromotionDAO getPromotionDAO(){
        return new PromotionDAO(conn);
    }

    public static GroupeDAO getGroupeDAO(){
        return new GroupeDAO(conn);
    }

    public static EtudiantDAO getEtudiantDAO(){
        return new EtudiantDAO(conn);
    }

    public static CoursDAO getCoursDAO(){
        return new CoursDAO(conn);
    }

    public static Type_coursDAO getType_coursDAO(){
        return new Type_coursDAO(conn);
    }

    public static SiteDAO getSiteDAO(){
        return new SiteDAO(conn);
    }

    public static SalleDAO getSalleDAO(){
        return new SalleDAO(conn);
    }

    public static SeanceDAO getSeanceDAO(){
        return new SeanceDAO(conn);
    }
}