/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.vue;
import CalendrierJpanel.SButton;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;

/**
 *
 * @author Hippo
 */
public class Panneau extends JPanel {
    SButton next;
    SButton prev;
    public Panneau() {
        this.next = new SButton("Next",270,0,50,28,true,this);
        this.prev = new SButton("Prev",100,0,50,28,true,this);
    }
    
}
