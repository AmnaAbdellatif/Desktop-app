/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.PersonneDAO;
import Entites.Personne;
import java.awt.Desktop;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class InterfaceAdminController implements Initializable {

    @FXML
    private Button AjoutButton;
    @FXML
    private Button modifieButton;
    @FXML
    private Button menuprincipal;
    @FXML
    private Hyperlink hyperlink;
    @FXML
    private TableView  tablePersonne;
    @FXML
    private TableColumn nomutilisateur;
    @FXML
    private TableColumn  prénomutilisateur;
    @FXML
    private TableColumn  modepasseutilisateur;
    @FXML
    private TableColumn  matriculeutilisateur;
    @FXML
    private TableColumn  fonctionutilisateur;
    @FXML
    private TextField textprenom;
    @FXML
    private TextField textnumero;
    @FXML
    private TextField textnom;
    @FXML
    private Button enregistrermodification;
    @FXML
    private Button actualiser;
    @FXML
    private TextField Textfonction;
    @FXML
    private TextField textmotpasse;
    @FXML
    private TableView  tablesupprimer;
    @FXML
    private TableColumn colonneNumpersonne;
    @FXML
    private TableColumn colonneNompersonne;
    @FXML
    private TableColumn prenompersonne;
    @FXML
    private TableColumn  fonctionpersonne;
    @FXML
    private TableColumn  motpasseutilisateur;
    @FXML
    private Button charger1;
    @FXML
    private Button charger11;
PersonneDAO pers = new PersonneDAO();
Personne PrSelect = new Personne();  

 ObservableList<Personne> liste = null;
 ObservableList<Personne> liste1 = null;
    @FXML
    private Button showDateTime;
    
    @FXML
    private TextField txtdate;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         nomutilisateur.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));//le meme nom du paramètre numéro serie qui existe dans la classe Etape
        prénomutilisateur.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));//le meme nom du paramètre nom Etape qui existe dans la classe Etape
        fonctionutilisateur.setCellValueFactory(new PropertyValueFactory<Personne, String>("fonction"));//le meme nom du paramètre numéro serie qui existe dans la classe Etape
        matriculeutilisateur.setCellValueFactory(new PropertyValueFactory<Personne, String>("matricule"));
       modepasseutilisateur.setCellValueFactory(new PropertyValueFactory<Personne, String>("motDePasse"));
       colonneNumpersonne.setCellValueFactory(new PropertyValueFactory<Personne, String>("matricule"));
        colonneNompersonne.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));
         prenompersonne.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));
          motpasseutilisateur.setCellValueFactory(new PropertyValueFactory<Personne, String>("motDePasse"));
           fonctionpersonne.setCellValueFactory(new PropertyValueFactory<Personne, String>("fonction"));
        
        List<Personne> person = pers.findListdesPersonnes();
        System.out.println(person);
        
        for (Personne prs : person) {
            liste = FXCollections.observableArrayList();
            liste.add(prs);
            System.out.println("liste" + liste);
            int j = tablePersonne.getItems().size();
            System.out.println("bouclefor");
            tablePersonne.getItems().addAll(j, liste);
            tablesupprimer.getItems().addAll(j,liste);
        tablePersonne.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> afficheModification((Personne) newValue));
     
         //DateCourante();
    } 
        // TODO
    } 
//     public void DateCourante()
//    {
//        Thread clock=new Thread()
//        {
//            public void run() {
//                
//            
//        
//for (;;)
//{
//    Date aujourdhui = new Date();
//DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(
//DateFormat.MEDIUM,
//DateFormat.MEDIUM);
//String s=(mediumDateFormat.format(aujourdhui));
//    Calendar Cal= new GregorianCalendar();
//    int seconde =Cal.get(Calendar.SECOND);
//      int minute =Cal.get(Calendar.MINUTE);
//        int heure =Cal.get(Calendar.HOUR);
//        txtdate.setText(""+mediumDateFormat.format(aujourdhui));               
//        try {
//            sleep(1000);
//        } catch (InterruptedException ex) {
//        Logger.getLogger(ProjetController.class.getName()).log(Level.SEVERE, null, ex);
//    }
//}
//            }
//        
//    
//
//};
//clock.start();
//    
//    } 

    @FXML
    private void handleUtilisateurButtonAction(ActionEvent event) {
        try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("inscription.fxml"));
            Parent root2=loader.load();
           Stage stage=new Stage();
           stage.setTitle("Inscription");
          
           stage.setScene(new Scene(root2));
           stage.show();
       }
    
        catch(IOException e){
           System.out.println("can't load new window");
    }
    }

    @FXML
    private void handleAjouterButtonAction(ActionEvent event) throws IOException {
                      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("demande-ajout.fxml"));
        Parent root2 = loader.load();
        Stage stage = new Stage();
        stage.setTitle(" Ajout");
        stage.setScene(new Scene (root2));
        stage.show();
    } catch (Exception e) {
        System.out.println("can't load new window");
    }


       


    }

    @FXML
    private void handlemodifierButtonAction(ActionEvent event) throws IOException {
         try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Demande de modification.fxml"));
        Parent root2 = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Modification");
        stage.setScene(new Scene (root2));
        stage.show();
    } catch (Exception e) {
        System.out.println("can't load new window");
    }


    }

    @FXML
    private void handlemenuButtonAction(ActionEvent event) throws IOException {
        Parent test2_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene test2_scene = new Scene(test2_parent);
            
            Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            test1_stage.setTitle("Gestion Logistique");
            test1_stage.setFullScreen(true);
            test1_stage.setScene(test2_scene);
            test1_stage.show();

    }

    @FXML
    private void handle(ActionEvent event) {
         try {
            Desktop.getDesktop().browse(new URI("https://tn.draexlmaier.com/draexlmaier-group/"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleupdateButtonAction(ActionEvent event) {
        System.out.println(PrSelect);
        PrSelect.setMatricule(textnumero.getText());
        PrSelect.setNom(textnom.getText());
        PrSelect.setPrenom(textprenom.getText());
          PrSelect.setFonction(Textfonction.getText());
           PrSelect.setMotDePasse(textmotpasse.getText());
           
        System.out.println(PrSelect);
        pers.update(PrSelect);
        System.out.println("update");
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
          alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
          alert.setContentText("Les modifications sont bien Enregistrées");
          alert.showAndWait();
    }
    
     private void afficheModification(Personne selection) {
       System.out.println("selection" + selection);
        if (selection!=null){
        textnom.setText(selection.getNom());
        textprenom.setText(selection.getPrenom());
        textnumero.setText(selection.getMatricule());
        Textfonction.setText(selection.getFonction());
        textmotpasse.setText(selection.getMotDePasse());
        
        PrSelect.setNom(selection.getNom());
        PrSelect.setPrenom(selection.getPrenom());
        PrSelect.setMatricule(selection.getMatricule());
        PrSelect.setFonction(selection.getFonction());
        PrSelect.setMotDePasse(selection.getMotDePasse());
        }
        System.out.println(PrSelect);
    }


    @FXML
    private void handleactualiserButtonAction(ActionEvent event) {
        List<Personne> pr = pers.findListdesPersonnes();
        System.out.println(pr);
        int j = 0;
        liste = FXCollections.observableArrayList();
         tablePersonne.getItems().clear();
        liste.addAll(pr);
        System.out.println("liste" + liste);
        //  int j = tableProjet.getItems().size();
        tablePersonne.getItems().clear();
        tablePersonne.setItems(liste);
    }

    @FXML
    private void handlesupprimerButtonAction(ActionEvent event) {
        tablesupprimer.refresh();
        ObservableList<Personne> personneSelected,allPersonnes;
        allPersonnes=tablesupprimer.getItems();
        personneSelected=tablesupprimer.getSelectionModel().getSelectedItems();
         pers.delete(personneSelected.get(0));
         System.out.println(personneSelected);
        personneSelected.forEach(allPersonnes::remove);
        System.out.println(personneSelected);


    }



    @FXML
    private void handledateAction(ActionEvent event) {
        Date now = new Date();
//
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        // Model Data
        String dateTimeString = df.format(now);

        // Show in VIEW
        txtdate.setText(dateTimeString);
    }

    @FXML
    private void supprimerbuttonn(ActionEvent event) {
        try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Suppression.fxml"));
        Parent root2 = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Suppression");
        stage.setScene(new Scene (root2));
        stage.show();
    } catch (Exception e) {
        System.out.println("can't load new window");
    }
    }

    @FXML
    private void handleupdate1ButtonAction(ActionEvent event) {
        List<Personne> pr = pers.findListdesPersonnes();
        System.out.println(pr);
        int j = 0;
        liste1 = FXCollections.observableArrayList();
         tablesupprimer.getItems().clear();
        liste1.addAll(pr);
        System.out.println("liste" + liste);
        //  int j = tableProjet.getItems().size();
        tablesupprimer.getItems().clear();
        tablesupprimer.setItems(liste1);
    }
    }
    
    

