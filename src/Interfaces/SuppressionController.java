/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.ProjetDAO;
import DAO.SousVariantDAO;
import DAO.VariantDAO;
import Entites.Projet;
import Entites.Sousvariant;
import Entites.Variant;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SuppressionController implements Initializable {

    @FXML
    private TableView tableProjet;
    @FXML
    private TableColumn colonneNumProjet;
    @FXML
    private TableColumn colonneNomprojet;
    @FXML
    private AnchorPane comboboxvariant;
    private ListView listviewvariant;
    @FXML
    private TableView tablevariant;
    @FXML
    private TableColumn colonnenumerovariant;
    @FXML
    private TableColumn colonnenomvariant;
    @FXML
    private Button supprimerbuttonvariant;
    @FXML
    private ComboBox combosousvariant;
    private ListView listviewsousvariant;
    @FXML
    private TableView tabsousvariant;
    @FXML
    private TableColumn colonnenumSV;
    @FXML
    private TableColumn colonnenomSV;
    @FXML
    private ComboBox comboboxprojet;
    private TextField search;
    private TextField searchSV;
    @FXML
    private Button supprimerbuttonsousvariant;
    @FXML
    private Button supprimerbuttonProjet;

    public Session session;
    private final ObservableList<String> masterData = FXCollections.observableArrayList();
    private ObservableList<Sousvariant> filteredData = FXCollections.observableArrayList();
    //private ObservableList<Projet> filteredData = FXCollections.observableArrayList();
    ObservableList<Projet> listeP = FXCollections.observableArrayList();
    ObservableList<Variant> listeV = FXCollections.observableArrayList();
    ObservableList<Sousvariant> listeSV = FXCollections.observableArrayList();

    ProjetDAO sp = new ProjetDAO();
    VariantDAO sv = new VariantDAO();
    SousVariantDAO svv = new SousVariantDAO();
    private int selectedIndex = -1;
    @FXML
    private TextField numprojetvariant;
    @FXML
    private TextField nomprojetvariant;
    @FXML
    private TextField numvarianttext;
    @FXML
    private TextField nomvarianttext;
    @FXML
    private TextField numvariantsv;
    @FXML
    private TextField nomseriesv;
    @FXML
    private TextField numseriesousvariant;
    @FXML
    private TextField nomsousvariant;
    @FXML
    private AnchorPane comboprojetsousvariant;
    @FXML
    private ComboBox comboprojetsv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        colonneNomprojet.setCellValueFactory(new PropertyValueFactory<Projet, String>("nomProjet"));
        colonneNumProjet.setCellValueFactory(new PropertyValueFactory<Projet, String>("numeroSerie"));
        ObservableList<Projet> liste = null;
        List<Projet> proj = sp.findlistDesProjets();
        System.out.println(proj);
        for (Projet pr : proj) {
            liste = FXCollections.observableArrayList();
            liste.add(pr);
            System.out.println("liste" + liste);
            int j = tableProjet.getItems().size();
            tableProjet.getItems().addAll(j, liste);

        }
        List list = sp.findListProjet();
        ObservableList<Projet> liste1 = FXCollections.observableArrayList(list);
        comboboxprojet.setItems(liste1);
        comboprojetsv.setItems(liste1);
        comboprojetsv.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> affichevariant((String) newValue));
         

        colonnenomvariant.setCellValueFactory(new PropertyValueFactory<Variant, String>("nomVariant"));
        colonnenumerovariant.setCellValueFactory(new PropertyValueFactory<Variant, String>("numSerieVariant"));
 tablevariant.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> affichetextfield((Variant) newValue));
 tabsousvariant. getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> affichetextfieldsv((Sousvariant) newValue));
        
              
        
        List list1 = sv.findVariant();
        ObservableList<Variant> listeV = FXCollections.observableArrayList(list1);
        combosousvariant.setItems(listeV);

        List list2 = svv.findlistSousVariant();
        ObservableList<Sousvariant> listeSV = FXCollections.observableArrayList(list2);
//        tabsousvariant.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> afficheLaSelection1((Sousvariant) newValue));
        colonnenomSV.setCellValueFactory(new PropertyValueFactory<Sousvariant, String>("nomSousVariant"));
        colonnenumSV.setCellValueFactory(new PropertyValueFactory<Sousvariant, String>("numSerieSousVariant"));

     
    }


//    public void afficheLaSelection1(Sousvariant nom_sous_variant) {
//        List Svar = svv.findnum_serieSousVariant(nom_sous_variant.toString());
//        System.out.println(Svar);
//        int e = 0;
//        Variant v = new Variant();
//        Date d = null;
//        //String cb=null;
//        Sousvariant SvarTable = new Sousvariant(nom_sous_variant, v, (String) Svar.get(e), "", 0, e, d, d,"");
//        listeSV = FXCollections.observableArrayList(SvarTable);
////        colonnenomSV.setCellValueFactory(param -> {
////            return new SimpleObjectProperty<>(nom_sous_variant);
////        });
//        System.out.println(listeSV);
////        int j = tabsousvariant.getItems().size();
////        System.out.println("bouclefor2");
//
//        tabsousvariant.getItems().addAll(listeSV);

//    }

    @FXML
    private void suppprojetAction(ActionEvent event) {
        ObservableList<Projet> projetSelected, allProjets;
        allProjets = tableProjet.getItems();
        projetSelected = tableProjet.getSelectionModel().getSelectedItems();
        System.out.println("projet selectionnee" +projetSelected.get(0));
        sp.delete(projetSelected.get(0));
        System.out.println(projetSelected);
        projetSelected.forEach(allProjets::remove);
        System.out.println(projetSelected);
        tableProjet.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
        alert.setTitle("Message Suppression");
//          alert.setHeaderText("No Person Selected");
        alert.setContentText("Le projet est supprimé");
        alert.showAndWait();

    }

    @FXML
    private void supprimerbuttonvariantAction(ActionEvent event) {
        
        ObservableList<Variant> variantSelected, allVariants;
        allVariants = tablevariant.getItems();
        variantSelected = tablevariant.getSelectionModel().getSelectedItems();
        Projet p1 = new Projet(numprojetvariant.getText(),nomprojetvariant.getText());
      Variant v;
          int i=0;
           
         
         v = new Variant(numvarianttext.getText(),p1,nomvarianttext.getText(), "",nomprojetvariant.getText());
        
        sv.delete(v);
        variantSelected.forEach(allVariants::remove);
        tablevariant.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        System.out.println("sup var" +variantSelected.get(0));
//        sv.delete(variantSelected.get(0));
//         System.out.println(variantSelected);
//        
//        System.out.println(variantSelected);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
        alert.setTitle("Message Suppression");
//          alert.setHeaderText("No Person Selected");
        alert.setContentText("Les variants sont supprimés");
        alert.showAndWait();
    }

    @FXML
    private void suppSVAction(ActionEvent event) {
         
        ObservableList<Sousvariant> SousvariantSelected, allSousvariants;
        allSousvariants = tabsousvariant.getItems();
        SousvariantSelected = tabsousvariant.getSelectionModel().getSelectedItems();
        Projet p1 = new Projet("", "");
        int i = 0;
        Variant v1;
         
        v1 = new Variant(numvariantsv.getText(), p1, nomseriesv.getText(), "","");
        Date d = new Date() ;
        Sousvariant sv1;
        sv1 = new Sousvariant(nomsousvariant.getText(), v1, numseriesousvariant.getText(),nomseriesv.getText(), i, i, d, d,"");
      
        svv.delete(sv1);
         SousvariantSelected.forEach(allSousvariants::remove);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
        alert.setTitle("Message Suppression");
//          alert.setHeaderText("No Person Selected");
        alert.setContentText("Les Sous variants sont supprimés");
        alert.showAndWait();
    }

    private void combosousvariantAction(ActionEvent event) {
        try {

            Object Svar = combosousvariant.getSelectionModel().getSelectedItem();

            List liste = svv.findlistSousVariant(Svar.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
            System.out.println(liste);
            

        } catch (UnsupportedOperationException e1) {
            e1.printStackTrace();
        }

    }

    @FXML
    private void comboboxprojetAction(ActionEvent event) {
        try {
            
 tablevariant.refresh();
            Object var = comboboxprojet.getSelectionModel().getSelectedItem();
            List liste = sv.findListDesVariant(var.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
            System.out.println(liste);
             tablevariant.getItems();
            tablevariant.setItems(data);
Object pr=comboboxprojet.getSelectionModel().getSelectedItem();
             List text1=sp.findnumero_serie1(pr.toString());

          int j= 0; 
            numprojetvariant.setText((String) text1.get(j));
           nomprojetvariant.setText(pr.toString());        

        } catch (UnsupportedOperationException e1) {
            e1.printStackTrace();
        }
    }

   
    

    private void affichetextfield(Variant selection) {
      System.out.println("selection" + selection);
         if (selection!=null){
        nomvarianttext.setText(selection.getNomVariant());
        
        numvarianttext.setText(selection.getNumSerieVariant());
        
    }

  
}

    

    private void affichevariant(String variant) {
       List list1 = sv.findlistVariant(variant);
        ObservableList<Variant> listeV = FXCollections.observableArrayList(list1);
        combosousvariant.setItems(listeV);
        
// tabsousvariant.refresh();
            
    }

    @FXML
    private void vonaction(ActionEvent event) {
        try {
        Object var = combosousvariant.getSelectionModel().getSelectedItem();
        
            List liste3 = svv.findlistDESSousVariant(var.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste3);
            System.out.println(liste3);
             tabsousvariant.getItems();
            tabsousvariant.setItems(data);
             List text1=sv.findnum_serieVariant(var.toString());
        int j= 0; 
            numvariantsv.setText((String) text1.get(j));
           nomseriesv.setText(var.toString());  

          
            } catch (UnsupportedOperationException e1) {
            e1.printStackTrace();
        }
       
         
    }

    private void affichetextfieldsv(Sousvariant selection) {
        System.out.println("selection" + selection);
         if (selection!=null){
        numseriesousvariant.setText(selection.getNumSerieSousVariant());
        
        nomsousvariant.setText(selection.getNomSousVariant());
        
       
    }
}
}