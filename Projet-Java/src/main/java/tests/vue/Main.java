/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.vue;

import CalendrierJpanel.Calendrier;
import javax.swing.JPanel;

/**
 *
 * @author Hippo
 */
public class Main {
    public static void main(String[] args){
    Fenetre fenetre = new Fenetre();
    int l;
    JPanel jp=new JPanel();
    Calendrier cal = new Calendrier(0,0,6,2020,jp);
    System.out.println(cal.jour(2020, 1, 2));
    }
}
