package Projet.Controleur;

import Projet.Controleur.DAO.*;
import Projet.Modèle.Data.*;

public class Main {
    public static void main(String[] args) {
        DAO<Seance> seanceDAO = DAOFactory.getSeanceDAO();
        for (int  i = 21; i<32; ++i){
            Seance seance = seanceDAO.find(i);
            System.out.println(seance.getId());
        }
    }
}