package Projet.Controleur.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Iterator;
import java.util.Set;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import Projet.Modèle.Data.Groupe;
import Projet.Modèle.Data.Salle;
import Projet.Modèle.Data.Seance;
import Projet.Modèle.Data.Utilisateur;

public class SeanceDAO extends DAO<Seance>{
    public SeanceDAO(Connection conn){
        super(conn);
    }

    public boolean create(Seance obj){
        return false;
    }

    public boolean update(Seance obj){
        return false;
    }

    public boolean delete(Seance obj){
        return false;
    }

    public Seance find(int id){
        Seance seance = new Seance();
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance WHERE ID = "+ id);
            if(result.first()){
                seance = new Seance(id,result.getInt("SEMAINE"),result.getDate("DATE"),result.getTime("HEURE_DEBUT"),result.getTime("HEURE_FIN"),result.getInt("ETAT"),result.getInt("ID_COURS"),result.getInt("ID_TYPE"));

                result = this.connect.createStatement().executeQuery("SELECT ID FROM groupe INNER JOIN seance_groupes ON groupe.ID = seance_groupes.ID_GROUPE AND seance_groupes.ID_SEANCE = "+ id);
                GroupeDAO groupeDAO = new GroupeDAO(this.connect);
                while(result.next()){
                    seance.addGroupe(groupeDAO.find(result.getInt("ID")));
                }

                result = this.connect.createStatement().executeQuery("SELECT ID FROM utilisateur INNER JOIN seance_enseignants ON utilisateur.ID = seance_enseignants.ID_ENSEIGNANT AND seance_enseignants.ID_SEANCE = "+id);
                UtilisateurDAO utilisateurDAO = new UtilisateurDAO(this.connect);
                while(result.next()){
                    seance.addEnseignant(utilisateurDAO.find(result.getInt("ID")));
                }

                result = this.connect.createStatement().executeQuery("SELECT ID FROM salle INNER JOIN seance_salles ON salle.ID = seance_salles.ID_SALLE AND seance_salles.ID_SEANCE = "+ id);
                SalleDAO salleDAO = new SalleDAO(this.connect);
                while(result.next()){
                    seance.addSalle(salleDAO.find(result.getInt("ID")));
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return seance;
    }

    public boolean annuler(Seance obj){
        try{
            Statement result = this.connect.createStatement();
            result.execute("UPDATE seance SET ETAT = 0 WHERE ID="+obj.getId());
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean valider(Seance obj){
        try{
            Statement result = this.connect.createStatement();
            result.execute("UPDATE seance SET ETAT = 1 WHERE ID="+obj.getId());
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean retirerGroupe(Seance seance, Groupe groupe){
        try{
            Statement result = this.connect.createStatement();
            result.execute("DELETE FROM seance_groupes WHERE ID_GROUPE = "+ groupe.getId() +" AND ID_SEANCE = "+ seance.getId());
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean retirerGroupe(Seance seance, Utilisateur prof){
        try{
            Statement result = this.connect.createStatement();
            result.execute("DELETE FROM seance_enseignants WHERE ID_ENSEIGNANT = "+ prof.getId() +" AND ID_SEANCE = "+ seance.getId());
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deplacer(Seance seance, Date date, Time debut, Time fin, Salle salle){
        return false;
    }

    public boolean addSeance(Seance seance, Set<Groupe> groupeSet, Set<Utilisateur> enseignantSet){
        try{
            Statement statement = this.connect.createStatement();
            PreparedStatement result = this.connect.prepareStatement("INSERT INTO seance (ID,SEMAINE,DATE,HEURE_DEBUT,HEURE_FIN,ETAT,ID_COURS,ID_TYPE) VALUES(?,?,?,?,?,?,?,?)");
            result.setInt(1, seance.getId());
            result.setInt(2, seance.getSemaine());
            result.setDate(3, seance.getDate());
            result.setTime(4, seance.getHeure_debut());
            result.setTime(5, seance.getHeure_fin());
            result.setInt(6, seance.getEtat());
            result.setInt(7, seance.getId_cours());
            result.setInt(8, seance.getId_type());
            result.execute();
            Iterator<Groupe> groupe = groupeSet.iterator();
            Iterator<Utilisateur> enseignant = enseignantSet.iterator();
            while(groupe.hasNext()){
                Groupe groupeA=groupe.next();
                statement.execute("INSERT INTO seance_groupes VALUES(ID_SEANCE,ID_GROUPE) VALUES ("+ seance.getId()+","+groupeA.getId()+")");
            }
            while(enseignant.hasNext()){
                Utilisateur enseignantA = enseignant.next();
                statement.execute("INSERT INTO seance_enseignants VALUES(ID_SEANCE,ID_ENSEIGNANT) VALUES ("+ seance.getId()+","+enseignantA.getId()+")");
            }
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean setSalle(Seance seance, Salle salle){
        boolean test = true;
        Time horaireD = seance.getHeure_debut();
        Time horaireF = seance.getHeure_fin();
        Date date = seance.getDate();
        int numberE = 0;
        int numberP = 0;
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_salles WHERE ID_SALLE = "+salle.getId());
            ResultSet res;
            while(result.next()){
                res = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance WHERE ID = "+result.getInt("ID_SEANCE"));
                if(res.first()){
                    if(res.getTime("HEURE_DEBUT").getTime() <= horaireD.getTime() && res.getTime("HEURE_FIN").getTime() > horaireD.getTime()|| res.getTime("HEURE_DEBUT").getTime() <= horaireF.getTime() && res.getTime("HEURE_FIN").getTime() > horaireF.getTime()){
                        if(res.getDate("DATE").getDay() == date.getDay() && res.getDate("DATE").getMonth() == date.getMonth() && res.getDate("DATE").getYear() == date.getYear() && res.getInt("SEMAINE") == seance.getSemaine()){
                            test = false;
                        }
                    }
                }
            }
            result = this.connect.createStatement().executeQuery("SELECT * FROM seance_groupes WHERE ID_SEANCE = "+seance.getId());
            while(result.next()){
                res= this.connect.createStatement().executeQuery("SELECT COUNT(*) FROM etudiant WHERE ID_GROUPE= "+result.getInt("ID_GROUPE"));
                numberE += res.getInt("COUNT(*)");
            }
            result = this.connect.createStatement().executeQuery("SELECT * FROM seance_salles WHERE ID_SEANCE = "+seance.getId());
            while(result.next()){
                res= this.connect.createStatement().executeQuery("SELECT * FROM salle WHERE ID = "+result.getInt("ID_SALLE"));
                numberP += res.getInt("CAPACITE");
            }
            if(numberE>numberP){
                test = false;
            }
            if(test){
                PreparedStatement statement = this.connect.prepareStatement("INSERT INTO seance_salles (ID_SEANCE, ID_SALLE) VALUES (?,?)");
                statement.setInt(1, seance.getId());
                statement.setInt(2, salle.getId());
                statement.execute();
                return true;
            }
            else{
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean addGroupe(Seance seance, Groupe groupe){
        boolean test = true;
        Time horaireD = seance.getHeure_debut();
        Time horaireF = seance.getHeure_fin();
        Date date = seance.getDate();
        int numberE = 0;
        int numberP = 0;
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_groupes WHERE ID_GROUPE = "+ groupe.getId());
            ResultSet res;
            while(result.next()){
                res = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance WHERE ID = "+ result.getInt("ID_SEANCE"));
                if(res.first()){
                    if(res.getTime("HEURE_DEBUT").getTime() <= horaireD.getTime() && res.getTime("HEURE_FIN").getTime() > horaireD.getTime()|| res.getTime("HEURE_DEBUT").getTime() <= horaireF.getTime() && res.getTime("HEURE_FIN").getTime() > horaireF.getTime()){
                        if(res.getDate("DATE").getDay() == date.getDay() && res.getDate("DATE").getMonth() == date.getMonth() && res.getDate("DATE").getYear() == date.getYear() && res.getInt("SEMAINE") == seance.getSemaine()){
                            test = false;
                        }
                    }
                }
            }
            result = this.connect.createStatement().executeQuery("SELECT * FROM seance_groupes WHERE ID_SEANCE = "+seance.getId());
            while(result.next()){
                res= this.connect.createStatement().executeQuery("SELECT COUNT(*) FROM etudiant WHERE ID_GROUPE= "+result.getInt("ID_GROUPE"));
                numberE += res.getInt("COUNT(*)");
            }
            result = this.connect.createStatement().executeQuery("SELECT * FROM seance_salles WHERE ID_SEANCE = "+seance.getId());
            while(result.next()){
                res= this.connect.createStatement().executeQuery("SELECT * FROM salle WHERE ID = "+result.getInt("ID_SALLE"));
                numberP += res.getInt("CAPACITE");
            }
            if(numberE>numberP){
                test = false;
            }
            if(test){
                PreparedStatement statement = this.connect.prepareStatement("INSERT INTO seance_groupes (ID_SEANCE, ID_GROUPE) VALUES (?,?)");
                statement.setInt(1, seance.getId());
                statement.setInt(2, groupe.getId());
                statement.execute();
                return true;
            }
            else{
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean addEnseignant(Seance seance, Utilisateur enseignant){
        if(enseignant.getDroit() != 3){
            return false;
        }
        boolean test = true;
        Time horaireD = seance.getHeure_debut();
        Time horaireF = seance.getHeure_fin();
        Date date = seance.getDate();
        ResultSet res;
        try{
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_enseignants WHERE ID_ENSEIGNANT = "+ enseignant.getId());
            while(result.next()){
                res = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance WHERE ID = "+ result.getInt("ID_SEANCE"));
                if(res.first()){
                    if(res.getTime("HEURE_DEBUT").getTime() <= horaireD.getTime() && res.getTime("HEURE_FIN").getTime() > horaireD.getTime()|| res.getTime("HEURE_DEBUT").getTime() <= horaireF.getTime() && res.getTime("HEURE_FIN").getTime() > horaireF.getTime()){
                        if(res.getDate("DATE").getDay() == date.getDay() && res.getDate("DATE").getMonth() == date.getMonth() && res.getDate("DATE").getYear() == date.getYear() && res.getInt("SEMAINE") == seance.getSemaine()){
                            test = false;
                        }
                    }
                }
            }
            if(test){
                PreparedStatement statement = this.connect.prepareStatement("INSERT INTO seance_enseignants (ID_SEANCE, ID_ENSEIGNANT) VALUES (?,?)");
                statement.setInt(1, seance.getId());
                statement.setInt(2, enseignant.getId());
                statement.execute();
                return true;
            }
            else{
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}