/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.PersonneDAO;
import Entites.Personne;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Client
 */
public class LoginController implements Initializable {

    @FXML
    private TextField Login;
    @FXML
    private PasswordField motPasse;
    @FXML
    private Button annuler;
    @FXML
    private Button valider;

    /**
     * Initializes the controller class.
     */
    public PersonneDAO sp = new PersonneDAO();
    public Personne loggedMember;

    @FXML
    private void handleCancelButtonAction(ActionEvent event) throws IOException {
        Parent test2_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene test2_scene = new Scene(test2_parent);
        Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        test1_stage.setScene(test2_scene);
        test1_stage.show();

    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws IOException {
         System.out.println("Normalement avant connecté");
        loggedMember = sp.findbylogin(Login.getText(), motPasse.getText());
//        
         if  ( motPasse.getText().isEmpty()&&
                 Login.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Veuillez saisir vos données");
            Login.setText("");
            motPasse.setText("");
             
         }
         else if  ( motPasse.getText().isEmpty()||
                 Login.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Veuillez saisir vos données");
            Login.setText("");
            motPasse.setText("");
             
         }
                     
             
  //else {
       //(loggedMember != null && !motPasse.getText().isEmpty()) 
       else  if ( loggedMember != null && !Login.getText().isEmpty()&& !motPasse.getText().isEmpty()) {
        if( loggedMember.getMatricule().equals(Login.getText()) && 
                loggedMember.getMotDePasse().equals(motPasse.getText())) {
            System.out.println("different null");
           String x= loggedMember.getFonction();
            if ("ouvrier".equalsIgnoreCase(x)) { //Foction est une colonne de base
System.out.println("dans ouvrier");
                Parent test2_parent = FXMLLoader.load(getClass().getResource("Interfaceouvrier.fxml"));
                Scene test2_scene;
                test2_scene = new Scene(test2_parent);
                Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // Scene scene = new ;
                test1_stage.setScene(test2_scene);
                test1_stage.show();
                test1_stage.setTitle("Gestion Scanner");
                test1_stage.setMaximized(true);
            } else if ("Agent".equalsIgnoreCase(x)) {
                 System.out.println("dans agent");
                Parent test2_parent = FXMLLoader.load(getClass().getResource("Projet.fxml"));
                Scene test2_scene;
                test2_scene = new Scene(test2_parent);
                Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                // Scene scene = new ;
                test1_stage.setScene(test2_scene);
                test1_stage.show();
                test1_stage.setTitle("Gestion Logistique");
                test1_stage.setMaximized(true);
            } else if ("Administrateur".equalsIgnoreCase(x)) {
                System.out.println("dans admin");
                Parent test2_parent = FXMLLoader.load(getClass().getResource("InterfaceAdmin.fxml"));
                Scene test2_scene;
                test2_scene = new Scene(test2_parent);
                Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                test1_stage.setScene(test2_scene);
                test1_stage.show();
                test1_stage.setTitle("Gestion Application");
            
             } else if ("Superviseur".equalsIgnoreCase(x)) {
                System.out.println("dans superv");
                Parent test2_parent = FXMLLoader.load(getClass().getResource("InterfaceSuperviseur.fxml"));
                Scene test2_scene;
                test2_scene = new Scene(test2_parent);
                Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                test1_stage.setScene(test2_scene);
                test1_stage.show();
                test1_stage.setTitle("Supervision");
            }
            
         }else {
            JOptionPane.showMessageDialog(null, "Vérifier le saisie de vos données");
            Login.setText("");
            motPasse.setText("");} 
         }else {
            JOptionPane.showMessageDialog(null, " Données erronées");
            Login.setText("");
            motPasse.setText("");
        } 
         
}

        
            

//        System.out.println("Normalement avant connecté");
//        loggedMember = sp.findbylogin(Login.getText(), motPasse.getText());
//        String motPasse1=loggedMember.getMotDePasse();
//        if (loggedMember != null && !motPasse.getText().isEmpty())
//        { if( !motPasse1.equals(motPasse))}
//            System.out.println("different null");
//           String x= loggedMember.getFonction();
//            if ("ouvrier".equalsIgnoreCase(x)) { //Foction est une colonne de base
//                System.out.println("dans ouvrier");
//                Parent test2_parent = FXMLLoader.load(getClass().getResource("Interfaceouvrier.fxml"));
//                Scene test2_scene;
//                test2_scene = new Scene(test2_parent);
//                Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                test1_stage.setScene(test2_scene);
//                test1_stage.show();
//                test1_stage.setTitle("Gestion Scanner");
//            } else if ("agent".equalsIgnoreCase(x)) {
//                System.out.println("dans agent");
//                Parent test2_parent = FXMLLoader.load(getClass().getResource("Projet.fxml"));
//                Scene test2_scene;
//                test2_scene = new Scene(test2_parent);
//                Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                // Scene scene = new ;
//                test1_stage.setScene(test2_scene);
//                test1_stage.show();
//                test1_stage.setTitle("Gestion Logistique");
//                test1_stage.setMaximized(true);
//            } else if ("Administrateur".equalsIgnoreCase(x)) {
//                System.out.println("dans admin");
//                Parent test2_parent = FXMLLoader.load(getClass().getResource("inscription.fxml"));
//                Scene test2_scene;
//                test2_scene = new Scene(test2_parent);
//                Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                test1_stage.setScene(test2_scene);
//                test1_stage.show();
//                test1_stage.setTitle("Inscription");
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Les données insérées sont erronées");
//            Login.setText("");
//            motPasse.setText("");
//        }

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

