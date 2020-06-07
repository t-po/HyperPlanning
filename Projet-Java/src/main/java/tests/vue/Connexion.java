/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.vue;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.BorderLayout;
import java.awt.Color; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author adrienloizeau
 */
public class Connexion extends JFrame{
   
    
  public Connexion(){

    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Connexion");
    this.setSize(700, 75);
    this.setVisible(true);
    this.getContentPane().add(parameters(), BorderLayout.CENTER);
    
    }
    
    
public JPanel parameters(){
    
    JPanel interPan = new JPanel();
    
    JButton btnLogin = new JButton("Se connecter");
    JLabel lblMail = new JLabel("Mail: ");
    JTextField tfMail = new JTextField();
    
    JLabel lblPassword = new JLabel("Mot de passe: ");
    JPasswordField tfPassword = new JPasswordField(10);
    
    lblMail.setLabelFor(tfMail);
    lblPassword.setLabelFor(tfPassword);
    
    Font police = new Font("Arial", Font.BOLD, 14);
    tfMail.setFont(police);
    tfPassword.setFont(police);
    
    tfMail.setPreferredSize(new Dimension(150, 30));
    tfPassword.setPreferredSize(new Dimension(150,30));
    
    interPan.add(lblMail);
    interPan.add(tfMail);
    interPan.add(lblPassword);
    interPan.add(tfPassword);
    interPan.add(btnLogin);


    return interPan;
}
        
}
