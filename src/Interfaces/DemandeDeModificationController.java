/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.ComposantDAO;
import DAO.EtapeDAO;
import DAO.ProjetDAO;
import DAO.SousVariantDAO;
import DAO.VariantDAO;
import Entites.Composant;
import Entites.Etape;
import Entites.Projet;
import Entites.Sousvariant;
import Entites.Variant;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DemandeDeModificationController implements Initializable {

    @FXML
    private TextField TextNumProj;
    @FXML
    private TextField TextNomProj;
    @FXML
    private Button charger1;
    @FXML
    private TableView tableProjet;
    @FXML
    private TableColumn numProjet;
    @FXML
    private TableColumn  nomProjet;
    @FXML
    private Button actualiser;
    @FXML
    private ComboBox ComboProjet;
    @FXML
    private TableView  tablevariant;
    @FXML
    private TableColumn  numvariant;
    @FXML
    private TableColumn  nomvariant;
    @FXML
    private TextField numeroProjet;
    @FXML
    private TextField nomdeProjet;
    @FXML
    private TextField numerovariant;
    @FXML
    private TextField nomdevariant;
    @FXML
    private Button Enregistrer;
    @FXML
    private Button actualiser1;
    @FXML
    private TextField numsvariant;
    @FXML
    private TextField nomsvariant;
    private TableColumn  numetape;
    private TableColumn  nometape;
    private TableColumn  nomcomposant;
    @FXML
    private ComboBox  ComboSVariant;
    @FXML
    private TextField numvariant1;
    @FXML
    private TextField textnomvariant;
    private TextField numEtape;
    private TextField nomEtape;
    private TextField numComposant;
    private TextField nomComposant;
    @FXML
    private Button save;
    @FXML
    private Button save1;
    VariantDAO vr = new VariantDAO();
     EtapeDAO ET = new EtapeDAO();
     ComposantDAO comp = new ComposantDAO();
    ProjetDAO Pr = new ProjetDAO();
    SousVariantDAO Svr = new SousVariantDAO();
    
    Projet PrSelect = new Projet();
    Variant Pres = new Variant();
    Etape sv = new Etape();
    Composant cm = new Composant();
    Sousvariant PresSV= new Sousvariant();
    
    Variant var;

    ObservableList<Projet> liste = null;
    ObservableList<Variant> list = null;
    ObservableList<Sousvariant> Sliste = null;
    ObservableList<Composant> listec = null;
    private TableView  tablecomposant;
    private TableColumn  numerocomposant;
    @FXML
    private ComboBox  ComboPRojet;
    @FXML
    private TableView  tableSV;
    @FXML
    private TableColumn  numSV;
    @FXML
    private TableColumn  nomSV;
    private ComboBox Comboetape;
    private TableColumn  numrtape;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        numProjet.setCellValueFactory(new PropertyValueFactory<Projet, String>("numeroSerie"));//le meme nom du paramètre numéro serie qui existe dans la classe Etape
        nomProjet.setCellValueFactory(new PropertyValueFactory<Projet, String>("nomProjet"));//le meme nom du paramètre nom Etape qui existe dans la classe Etape
        numvariant.setCellValueFactory(new PropertyValueFactory<Variant, String>("numSerieVariant"));//le meme nom du paramètre numéro serie qui existe dans la classe Etape
        nomvariant.setCellValueFactory(new PropertyValueFactory<Variant, String>("nomVariant"));//le meme nom du paramètre nom Etape qui existe dans la classe Etape
numSV.setCellValueFactory(new PropertyValueFactory<Variant, String>("numSerieSousVariant"));//le meme nom du paramètre numéro serie qui existe dans la classe Etape
        nomSV.setCellValueFactory(new PropertyValueFactory<Variant, String>("nomSousVariant"));//le meme nom du paramètre nom Etape qui existe dans la classe Etape
//numrtape.setCellValueFactory(new PropertyValueFactory<Composant, String>("numeroEtape"));//le meme nom du paramètre numéro serie qui existe dans la classe Etape
//        nometape.setCellValueFactory(new PropertyValueFactory<Composant, String>("nomEtape"));//le meme nom du paramètre nom Etape qui existe dans la classe Etape

       // nomcomposant.setCellValueFactory(new PropertyValueFactory<Etape, String>("nomComposant"));//le meme nom du paramètre nom Etape qui existe dans la classe Etape
       List<Projet> proj = Pr.findlistDesProjets();
        System.out.println(proj);
        for (Projet pr : proj) {
            liste = FXCollections.observableArrayList();
            liste.add(pr);
            System.out.println("liste" + liste);
            int j = tableProjet.getItems().size();
            tableProjet.getItems().addAll(j, liste);

        }
         
        List list = Pr.findListProjet();
        ObservableList<Projet> liste = FXCollections.observableArrayList(list);
        ComboProjet.setItems(liste);
        ComboPRojet.setItems(liste);
        tableProjet.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> afficheLaSelection((Projet) newValue));
         
        ComboPRojet.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> affichecombov((String) newValue));
         
//        List Slist = Svr.findlistSousVariant();
//        ObservableList<Projet> sliste = FXCollections.observableArrayList(Slist);
//        
//        ComboSVariant.setItems(sliste);
//        System.out.println("liste" + liste);
//        int i = tablevariant.getItems().size();
//        System.out.println("bouclefor");
//        tablevariant.getItems().addAll(i, sliste);
       
         tablevariant.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> affichetextfield((Variant) newValue));
       tableSV.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> affichetextfieldsv((Sousvariant) newValue));
       
//        List<Composant> cp = comp.findEtapeComposant();
//        System.out.println(proj);
//        for (Composant cpp : cp) {
//            listec = FXCollections.observableArrayList();
//            listec.add(cpp);
//            System.out.println("liste" + listec);
//            int j = tableetape.getItems().size();
//            tableetape.getItems().addAll(j, listec);
//
//        }
          
         
           
    }   
     private void afficheLaSelection(Projet selection) {
        System.out.println("selection" + selection);
        if (selection!=null){
        TextNomProj.setText(selection.getNomProjet());
        TextNumProj.setText(selection.getNumeroSerie());
        PrSelect.setNomProjet(selection.getNomProjet());
        PrSelect.setNumeroSerie(selection.getNomProjet());
        }
        System.out.println(PrSelect);

}

    @FXML
    private void handleupdateButtonAction(ActionEvent event) {
         System.out.println(PrSelect);
        PrSelect.setNomProjet(TextNomProj.getText());
        PrSelect.setNumeroSerie(TextNumProj.getText());
        System.out.println(PrSelect);
        Pr.update(PrSelect);
        System.out.println("update");
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
          alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
          alert.setContentText("Les modifications sont bien Enregistrées");
          alert.showAndWait();
    }

    @FXML
    private void handleactualiserAction(ActionEvent event) {
        List<Projet> proj = Pr.findlistDesProjets();
        System.out.println(proj);
        int j = 0;
        liste = FXCollections.observableArrayList();
         tableProjet.getItems().clear();
        liste.addAll(proj);
        System.out.println("liste" + liste);
        //  int j = tableProjet.getItems().size();
        tableProjet.getItems().clear();
        tableProjet.setItems(liste);

        
    }

    @FXML
    private void ComboboxonAction(ActionEvent event) {
         try {
            tablevariant.refresh();

            Object var = ComboProjet.getSelectionModel().getSelectedItem();
            List liste = vr.findListDesVariant(var.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
            System.out.println(liste);
            
            tablevariant.setItems(data);
             Object pr=ComboProjet.getSelectionModel().getSelectedItem();
             List text1=Pr.findnumero_serie1(pr.toString());
            int i= 0; 
            numeroProjet.setText((String) text1.get(i));
            nomdeProjet.setText(pr.toString());
            

        } catch (UnsupportedOperationException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    private void handleenregistrerButtonAction(ActionEvent event) {
        Projet p1=new Projet(numeroProjet.getText(),nomdeProjet.getText());
        Variant v;
          int i=0;
       v  = new Variant(numerovariant.getText(),p1,nomdevariant.getText(),"",nomdeProjet.getText());
       
        System.out.println("select vaaaa" +Pres);
        Pres.setNomVariant(nomdevariant.getText());
        Pres.setNumSerieVariant(numerovariant.getText());
        Pres.setNomProjet(nomdeProjet.getText());
        Pres.setProjet(PrSelect);
      //  Pres.setNumeroserie(numeroProjet.getText());
        System.out.println(Pres);
        vr.update(v);
        System.out.println("v" +v);
        System.out.println("update");
         Alert alert=new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
          alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
          alert.setContentText("Les modifications sont bien Enregistrées");
          alert.showAndWait();
         
          
        
    }
     private void affichetextfield(Variant selection) {
        System.out.println("selection" + selection);
         if (selection!=null){
        numerovariant.setText(selection.getNumSerieVariant());
        
        nomdevariant.setText(selection.getNomVariant());
         Pres.setNomVariant(selection.getNomVariant());
        Pres.setNumSerieVariant(selection.getNumSerieVariant());
        
        System.out.println("Pres" +Pres);
         }
        
       
    }


    @FXML
    private void handleactualiserButtonAction(ActionEvent event) {
        
         List<Variant> var = vr.findListDesVariant(nomdeProjet.getText());
        System.out.println(var);
        int j = 0;
        list = FXCollections.observableArrayList();
         tablevariant.getItems().clear();
        list.addAll(var);
        System.out.println("liste" + list);
        //  int j = tableProjet.getItems().size();
        tablevariant.getItems().clear();
        tablevariant.setItems(list);   
    }


    @FXML
    private void handlesaveButtonAction(ActionEvent event) {
        Projet p1=new Projet("",""); 
        int i = 0;
       Variant v1;
        v1 = new Variant(numvariant1.getText(),p1,textnomvariant.getText(),"","");
      
        Date d=new Date() ;  
       Sousvariant sv1;
     // int k = Integer.parseInt(codebarre.getText());
        sv1 = new Sousvariant(nomsvariant.getText(),v1,numsvariant.getText(),textnomvariant.getText(),i,i,d,d,"");
//        PresSV.setNomSousVariant(nomsvariant.getText());
//        PresSV.setNumSerieSousVariant(numsvariant.getText());
        //System.out.println("presSvar"  +PresSV);
         Svr.update(sv1);
        
        System.out.println("update");
         Alert alert=new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
          alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
          alert.setContentText("Les modifications sont bien Enregistrées");
          alert.showAndWait();
    }
//    private void afficheetape(Etape selection) {
//        System.out.println("selection" + selection);
//         if (selection!=null){
//        numEtape.setText(selection.getNomEtape());
//        nomEtape.setText(selection.getNumeroEtape());
////       numComposant.setText(selection.getNomComposant());
////        nomComposant.setText(selection.getNumeroComposant());
//        sv.setNomEtape(selection.getNomEtape());
//        sv.setNumeroEtape(selection.getNumeroEtape());
//         }
//    }
//         private void affichecomposant(Composant selection) {
//             System.out.println("selection" + selection);
//         if (selection!=null){
//             nomComposant.setText(selection.getNomComposant());
//             numComposant.setText(selection.getNumeroComposant());
//        cm.setNomComposant(selection.getNomComposant());
//        cm.setNumeroComposant(selection.getNumeroComposant());
//        System.out.println(sv);
//         }
//         }
    

    @FXML
    private void handleActualiserButtonActionsvariant(ActionEvent event) { 
         
         

         List<Sousvariant> Sousvar = Svr.findlistDESSousVariant(textnomvariant.getText());
        System.out.println("sous var actualisr" +Sousvar);
        int j = 0;
        Sliste = FXCollections.observableArrayList();
         tableSV.getItems().clear();
        Sliste.addAll(Sousvar);
        System.out.println("liste" + Sliste);
        //  int j = tableProjet.getItems().size();
        tableSV.getItems().clear();
        tableSV.setItems(Sliste);
        
         
    
    }

    private void affichecombov(String variant) {
        Object var = ComboPRojet.getSelectionModel().getSelectedItem();
           
        List list = vr.findlistVariant(var.toString());
        ObservableList<Variant> liste = FXCollections.observableArrayList(list);
        ComboSVariant.setItems(liste);
       
       
    }

    @FXML
    private void combovariant(ActionEvent event) {
          Object pr =ComboSVariant.getSelectionModel().getSelectedItem();
       textnomvariant.setText(pr.toString());
        List text1=vr.findnum_serieVariant(pr.toString());
        int i= 0; 
       numvariant1.setText((String) text1.get(i));
        ObservableList<Variant> list = null;
    
        
            List liste = Svr.findlistDESSousVariant(pr.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
            System.out.println(liste);
             tableSV.setItems(data);
        
    }

    private void affichetextfieldsv(Sousvariant selection) {
        System.out.println("selectionsv" + selection);
         if (selection!=null){
        numsvariant.setText(selection.getNumSerieSousVariant());
        
        nomsvariant.setText(selection.getNomSousVariant());
        PresSV.setNomSousVariant(selection.getNomSousVariant());
         
        PresSV.setNumSerieSousVariant(selection.getNumSerieSousVariant());
        //PresSV.setNomVariant(selection.getNomVariant());
       
        System.out.println("PresSV" +PresSV);

    

         }
    }  
//         private void affichetextfielEtape(Composant selection) {
//             
//         
//        System.out.println("selection" + selection);
//         if (selection!=null){
//             
//        numsvariant1.setText(selection.getNumeroEtape());
//        
//        nomsvariant1.setText(selection.getNomEtape());
//        cm.setNomEtape(selection.getNomEtape());
//          cm.setNumeroEtape(selection.getNomEtape());
//        
//         
//}
//         }
}
