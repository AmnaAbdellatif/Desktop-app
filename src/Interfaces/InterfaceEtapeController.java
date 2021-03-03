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
import Entites.Sousvariant;
import Entites.Variant;
import java.io.IOException;
import static java.lang.Thread.sleep;
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
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Pagination;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class InterfaceEtapeController implements Initializable {
private Sousvariant selectedSousVariant;
private Etape selectedEtape;
private Variant selectedVariant;

    @FXML
    private Button ButtonSuivant;
    @FXML
    private Button ButtonSuivant1;
    @FXML
    private Button menuprincipal;
    @FXML
    private Hyperlink hyperlink;
    @FXML
    private Button AjoutButton;
    @FXML
    private Button supprimer;
    @FXML
    private ImageView handle;
    @FXML
    private TextField txtNumProjet;
    @FXML
    private TextField txtNumVariant;
    @FXML
    private TextField txtNumSV;
    @FXML
    private TextField txtQuantite;
    @FXML
    private TextField txtNomProjet;
    @FXML
    private TextField txtNomVariant;
    @FXML
    private TextField txtNomSV;
    @FXML
    private TableView  tableviewEtape;
    @FXML
    private TableColumn  colonnenumetape;
    @FXML
    private TableColumn  colonnenometape;
    @FXML
    private TextField txtResponsable;
     @FXML
    private Button date;
     @FXML
    private TextField txtdate;
      @FXML
    private Button Buttonmodifier;
    @FXML
    private TableColumn  colonnenumcomposant;
    @FXML
    private TableColumn  colonnenomcomposant;
  

VariantDAO sv = new VariantDAO();
Variant var = new Variant();
ComposantDAO Cp=new ComposantDAO();
SousVariantDAO svv=new SousVariantDAO();
 EtapeDAO  ET=new EtapeDAO();
 ObservableList<Etape> listeET = FXCollections.observableArrayList();
   private final ObservableList<String> masterData = FXCollections.observableArrayList();
   
    ObservableList<Composant> listeCP = FXCollections.observableArrayList();
    ObservableList<Variant> listeV = FXCollections.observableArrayList();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                  
        // TODO
       // tableviewEtape.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 
       
        
        
     DateCourante();
    }
     public void DateCourante()
    {
        Thread clock=new Thread()
        {
            public void run() {
                
            
        
for (;;)
{
    Date aujourdhui = new Date();
DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(
DateFormat.MEDIUM,
DateFormat.MEDIUM);
String s=(mediumDateFormat.format(aujourdhui));
    Calendar Cal= new GregorianCalendar();
    int seconde =Cal.get(Calendar.SECOND);
      int minute =Cal.get(Calendar.MINUTE);
        int heure =Cal.get(Calendar.HOUR);
        txtdate.setText( ""+mediumDateFormat.format(aujourdhui) )    
               ;
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
        Logger.getLogger(ProjetController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
            }
        
    

};
clock.start();
    
    } 
     @FXML
    private void dateAction(ActionEvent event) {
    
     Date now= new Date();
      
       DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
      
      
        // Model Data
        String dateTimeString = df.format(now);
        
        // Show in VIEW
        
    txtdate.setText(dateTimeString);
    }
    
////    public void initData(String sousvariant)
////    {
////        colonnenometape.setCellValueFactory(new PropertyValueFactory<Composant, String>("nomEtape"));
////       colonnenumetape.setCellValueFactory(new PropertyValueFactory<Composant, String>("numeroEtape")); 
////        colonnenumcomposant.setCellValueFactory(new PropertyValueFactory<Composant,String>("numeroComposant"));
////        colonnenomcomposant.setCellValueFactory(new PropertyValueFactory<Composant, String>("nomComposant"));
////        
////      // selectedSousVariant = sousvariant;
//////        txtNomSV.setText(selectedSousVariant.getNomSousVariant());
//////        txtNumSV.setText(selectedSousVariant.getNumSerieSousVariant());
////          List<String> list2 = ET.findnumero_etape(txtNumSV.getText());
////      //  List list1 = Cp.findComposant(list2.toString()); //findlistEtape(twtnumsousvar.getText());
////        System.out.println("liste etapes" + list2);
////      //  System.out.println("liste composant" + list1);
////      //  ObservableList<Etape> listeET = FXCollections.observableArrayList(list1);
////        tableviewEtape.setItems(listeCP);
//////    int k=tablecompo.getItems().size();
//////    tablecompo.getItems().addAll(k, listeET);
//////
//////        List<String> list3 = ET.findnumero_etape(twtnumsousvar.getText());
//////        System.out.println(list3);
////        for (int j = 0; j < list2.size(); j++) {
////            System.out.println("list2.getj" +list2.get(j));
////            String x = list2.get(j);
////            List<Composant> list4 = Cp.findComposant(x);
////            System.out.println("list4" + list4);
////            ObservableList<Composant> listeCP = FXCollections.observableArrayList(list4);
////            int l = tableviewEtape.getItems().size();
////            tableviewEtape.getItems().addAll(l++, listeCP);
////
////        }
           //}
          //tableviewComposant.getItems().addAll(listeCP);
//          List<Projet> proj=sp.findlistDesProjets();
//        System.out.println(proj);
//        for (Projet pr : proj){
//            liste=FXCollections.observableArrayList();
//            liste.add(pr);
//            System.out.println("liste" +liste);
//            int j=tableProjet.getItems().size();
//            tableProjet.getItems().addAll(j,liste);
//             
         
   
     public void settext (String Nom_variant,String Num_serie_variant,String Nom_projet,String numero_serie,
     String numSousvar,String nomSousvar)
     {
        this.txtNomVariant.setText(Nom_variant);
        this.txtNumVariant.setText(Num_serie_variant);
        this.txtNomProjet.setText(Nom_projet);
          this.txtNumProjet.setText(numero_serie);
        this.txtNumSV.setText(numSousvar); 
         this.txtNomSV.setText(nomSousvar);
         
        colonnenometape.setCellValueFactory(new PropertyValueFactory<Composant, String>("nomEtape"));
       colonnenumetape.setCellValueFactory(new PropertyValueFactory<Composant, String>("numeroEtape")); 
        colonnenumcomposant.setCellValueFactory(new PropertyValueFactory<Composant,String>("numeroComposant"));
        colonnenomcomposant.setCellValueFactory(new PropertyValueFactory<Composant, String>("nomComposant"));
        
          List<String> list2 = ET.findnumero_etape(txtNumSV.getText());
          System.out.println("liste2" +list2);
       tableviewEtape.setItems(listeCP);
         System.out.println("tableviewEtape" +listeCP);
       for (int j = 0; j < list2.size(); j++) {
            System.out.println("list2.getj" +list2.get(j));
            String x = list2.get(j);
            List<Composant> list4 = Cp.findComposant(x);
            System.out.println("list4" + list4);
            ObservableList<Composant> listeCP = FXCollections.observableArrayList(list4);
            int l = tableviewEtape.getItems().size();
            tableviewEtape.getItems().addAll(l++, listeCP);
       }
    
}


    @FXML
    private void handlePrecedentButtonAction(ActionEvent event) throws IOException {
        
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Variant.fxml"));
        Parent test2_parent = loader.load();
        
      Scene test2_scene = new Scene(test2_parent);
      String Nom_variant=txtNomVariant.getText();
      String Num_serie_variant=txtNumVariant.getText();
       String Nom_projet=txtNomProjet.getText();
       String numero_serie=txtNumProjet.getText();
        String NomSV=txtNomSV.getText();
                String NumSV=txtNumSV.getText();
       
      
       
        //access the controller and call a method
        VariantController controller = loader.getController();
      // controller.initData((String) txtnumsousvar.getText());
        controller.settextvariant(Nom_variant, Num_serie_variant,Nom_projet,numero_serie,NumSV,NomSV);
        
        //This line gets the Stage information
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Gestion Logistique");
        window.setScene(test2_scene);
        window.show();
    }


    @FXML
    private void handlemenuButtonAction(ActionEvent event) throws IOException {
           Parent test2_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene test2_scene = new Scene(test2_parent);
            
            Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            test1_stage.setTitle("Agent Logistique");
            test1_stage.setScene(test2_scene);
           test1_stage.show();
        
    }

    

    @FXML
    private void handleAjouterButtonAction(ActionEvent event) {
                      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("demande-ajout.fxml"));
        Parent root2 = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Ajout");
        stage.setScene(new Scene (root2));
        stage.show();
    } catch (Exception e) {
        System.out.println("can't load new window");
    }


        

    }

    @FXML
    private void supprimerButtonAction(ActionEvent event) {
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
    private void SuivantButtonAction(ActionEvent event) throws IOException {
//        try {
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Ordre de fabrication.fxml"));
       // Parent test2_parent = loader.load();
        Parent root2 = loader.load();
     // Scene test2_scene = new Scene(test2_parent);
      String Nom_variant=txtNomVariant.getText();
      String Num_serie_variant=txtNumVariant.getText();
       String Nom_projet=txtNomProjet.getText();
       String numero_serie=txtNumProjet.getText();
       String Nom_sousVariant=txtNomSV.getText();
       String num_SousVariant=txtNumSV.getText();
        String Quantite=txtQuantite.getText();
         String Responsable=txtResponsable.getText();
        //access the controller and call a method
        OrdreDeFabricationController controller = loader.getController();
       // controller.initData1((Sousvariant) tableviewEtape.getSelectionModel().getSelectedItem());
        controller.settext1(Nom_variant, Num_serie_variant, Nom_projet,numero_serie,Nom_sousVariant,num_SousVariant,Quantite,Responsable);
       // controller.initData1((Etape) tableviewEtape.getSelectionModel().getSelectedItem());
       
//This line gets the Stage information
        Stage stage = new Stage();
        stage.setTitle("Gestion Logistique");
        stage.setScene(new Scene (root2));
        stage.show();
//       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setTitle("Gestion Logistique");
//        window.setScene(test2_scene);
//        window.show();
//    } catch (Exception e) {
//        System.out.println("can't load new window");
//    }

    }
    
@FXML
    private void handle(ActionEvent event) {
    }

    @FXML
    private void ButtonmodifierAction(ActionEvent event) {
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


}
    

