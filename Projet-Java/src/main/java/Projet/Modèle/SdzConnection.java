package Projet.Modèle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SdzConnection {
    private String url ="jdbc:mysql://localhost:3306/edt";
    private String user ="root";
    private String passwd="";
    private static Connection connect;

    private SdzConnection(){
        try {
            connect = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getInstance(){
        if(connect == null){
            new SdzConnection();
        }
        return connect;
    }
}