/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.PersonneDAO;
import Entites.Personne;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Client
 */
public class InscriptionController implements Initializable {

    @FXML
    private Button btnValider;
    @FXML
    private ComboBox<String> combofonction;
    @FXML
    private TextField textnom;
    @FXML
    private TextField textprenom;
    @FXML
    private TextField textmotdepasse;
    @FXML
    private TextField motdepasse;
    @FXML
    private TextField txetmatricule;
    @FXML
    private Label message;
PersonneDAO pers = new PersonneDAO();
    /**
     * Initializes the controller class.
     */
    

    @FXML
    private void btnValiderAction(ActionEvent event) {
               if(
                ! motdepasse.getText().equals(textmotdepasse.getText()))
                  
//         && motdepasse.getText()!= textmotdepasse.getText())
        {
             message.setText("votre mot de passe est incorrect");
                     }  
                     else {
        
              
        
        
           
             
         String s2 =textmotdepasse.getText();
         Object pr=combofonction.getSelectionModel().getSelectedItem();
       
            Personne prs = new Personne (txetmatricule.getText(),textnom.getText(),textprenom.getText(),""+pr, textmotdepasse.getText());
           
            pers.insert(prs);
           
          Alert alert=new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
          alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
          alert.setContentText("Les données sont bien enregistrées : Utilisateur ajouté");
          alert.showAndWait();
          
          
    }
    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList <String> liste = FXCollections.observableArrayList("Agent logistique ","Ouvrier","Superviseur","Admin");
        combofonction.setItems(liste);
        // TODO
    }   
}
