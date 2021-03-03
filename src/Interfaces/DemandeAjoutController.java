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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class DemandeAjoutController implements Initializable {

    private TextField serie_etape;
    private TextField nom_etape;
    private TextField serie_composant;
    private TextField nom_composant;
    private TableView  tableview;
    private TableColumn  numserieEtape;
    @FXML
    private Button valider;
    @FXML
    private TextField nom_projet;
    @FXML
    private TextField num_serie_projet;
    private TableColumn  nomEtapes;
    private TableColumn  numsériecomposant;
    private TableColumn  nomcomp;
    private ComboBox comboetape;
    
    @FXML
    private TableView  tableprojet;
    @FXML
    private TableColumn  numprojettable;
    @FXML
    private TableColumn  nomprojettable;
    @FXML
    private Button update;
    @FXML
    private ComboBox  comboprojet;
    @FXML
    private TextField numserievarianttext;
    @FXML
    private TextField nomvarianttext;
    private TableView tablevariant;
    private TableColumn  numvariant;
    private TableColumn  nomvarianttable;
    @FXML
    private TextField numserieprojet;
    @FXML
    private TextField nomprojet;
    @FXML
    private Button validervariant;
    @FXML
    private TextField numserievariant1;
    @FXML
    private ListView  listvariant;
    @FXML
    private ComboBox  comboprojetsvariant;
    @FXML
    private ComboBox combovariantsvariant;
    @FXML
    private ListView listesousvariant;
    @FXML
    private TextField numsvar;
    @FXML
    private TextField nomsvar;
    @FXML
    private Button validersvar;
    @FXML
    private TextField nomserievariant1;
    @FXML
    private TableView  tableview1;
    @FXML
    private TableColumn numserieEtape1;
    @FXML
    private TableColumn  nomEtapes1;
    @FXML
    private TableColumn  numsériecomposant1;
    @FXML
    private TableColumn  nomcomp1;
    @FXML
    private ComboBox comboetape1;
   
    
    
   private final ObservableList<String> masterData = FXCollections.observableArrayList();
    private TableView  tablesousvariant;
    private TableColumn numsousvarianttable;
    private TableColumn  nomsousvarianttable;
    @FXML
    private ComboBox comboprojetsv;
    @FXML
    private ComboBox combovariantsv;
    @FXML
    private ComboBox combosv;
    @FXML
    private TextField numtextsv;
    @FXML
    private TextField nomtextsv;
    @FXML
    private TextField codebarre;
    @FXML
    private TextField numetape;
    @FXML
    private TextField nometape;
    @FXML
    private TextField numcomposant;
    @FXML
    private TextField nomcomposant;
    @FXML
    private Button ajoutercomposant;
    @FXML
    private Button ajoutetap;

     ProjetDAO Pr = new ProjetDAO();
     VariantDAO Vr = new VariantDAO ();
     SousVariantDAO Svr = new SousVariantDAO ();
     EtapeDAO ET= new EtapeDAO();
   ComposantDAO Cp = new ComposantDAO();
     ObservableList<Etape> listeEtape = FXCollections.observableArrayList();
    ObservableList<Composant> listeComposant= FXCollections.observableArrayList();
     ObservableList<Variant> listeVariant= FXCollections.observableArrayList();
     ObservableList<Sousvariant> Sliste = null;
     List<Composant> sliste= null;
      List<Composant> listeAjout= null;
      List<Variant> listeAjoutvariant= null;
      List<Sousvariant> listeAjoutSousvariant= null;
    private TableColumn colcodebarre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numserieEtape1.setCellValueFactory(new PropertyValueFactory<Composant, String>("numeroEtape"));//le meme nom du paramètre numéro serie qui existe dans la classe Etape
        nomEtapes1.setCellValueFactory(new PropertyValueFactory<Composant, String>("nomEtape"));//le meme nom du paramètre nom Etape qui existe dans la classe Etape
     numsériecomposant1.setCellValueFactory(new PropertyValueFactory<Composant, String>("numeroComposant"));//on respecte les identifiants de la classe Composant
        nomcomp1.setCellValueFactory(new PropertyValueFactory<Composant, String>("nomComposant"));//on respecte les identifiants de la classe Composant
        // TODO
        nomprojettable.setCellValueFactory(new PropertyValueFactory<Projet, String>("nomProjet"));//on respecte les identifiants de la classe Composant
       
      numprojettable.setCellValueFactory(new PropertyValueFactory<Projet, String>("numeroSerie"));//on respecte les identifiants de la classe Composant
      List Etape = Cp.findEtapeComposant();
       
      
        System.out.println(Etape);
         ObservableList<Projet> liste = FXCollections.observableArrayList(Etape);
         comboetape1.setItems(liste);
         
          comboetape1.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> afficheLaSelection((String) newValue));
         List list = Pr.findListProjet();
       ObservableList<Projet> listeprojet = FXCollections.observableArrayList(list);
       comboprojet.setItems(listeprojet);
        comboprojet.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> afficheprojet((String) newValue));
//        numvariant.setCellValueFactory(new PropertyValueFactory<Variant, String>("numSerieVariant"));//on respecte les identifiants de la classe Composant
//        nomvarianttable.setCellValueFactory(new PropertyValueFactory<Variant, String>("nomVariant"));//on respecte les identifiants de la classe Composant
//           numsousvarianttable.setCellValueFactory(new PropertyValueFactory<Sousvariant, String>("numSerieSousVariant"));//on respecte les identifiants de la classe Composant
//        nomsousvarianttable.setCellValueFactory(new PropertyValueFactory<Sousvariant, String>("nomSousVariant"));//on respecte les identifiants de la classe Composant
         //colcodebarre.setCellValueFactory(new PropertyValueFactory<Sousvariant, String>("codeBarre"));//on respecte les identifiants de la classe Composant
           
        List list5 = Pr.findListProjet(); 
           ObservableList<Projet> liste1 = FXCollections.observableArrayList(list5);
           comboprojetsvariant.setItems(liste1);
           comboprojetsv.setItems(liste1);
           comboprojetsv.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> affichelistv((String) newValue));
  
        
            comboprojetsvariant.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> affichecombovariant((String) newValue));
            combovariantsvariant.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> affichelistvariant((String) newValue));
  
            List <Sousvariant> Svar = Svr.findlistSousVariant();
            ObservableList Sliste = FXCollections.observableArrayList(Svar);
        System.out.println(Svar);
       
       
//    }    
    }

    private void handleAjouterButtonAction(ActionEvent event) {
         String s1=serie_etape.getText();
       String s2 = nom_etape.getText();
       String s3= serie_composant.getText();
       String s4=nom_composant.getText();
    
         Composant C = new Composant(s3, s4,s2, s1); //de meme respecte le constructeur de la classe Composant
        listeComposant = FXCollections.observableArrayList(C);
       System.out.println(listeComposant);
       int j = tableview.getItems().size();
        System.out.println("bouclefor");
        tableview.getItems().addAll(j, listeComposant);

    }

    @FXML
    private void handleValiderButtonAction(ActionEvent event) {
         Projet p = new Projet(num_serie_projet.getText(),nom_projet.getText());
     
//        Variant v;
//        int i = 0;
//        v= new Variant(numserievariant.getText(),p,nomvariant.getText(),"","",i,"");
//        System.out.println("sur vrinsert" +v);
        Pr.insert(p);
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
          alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
          alert.setContentText("L'ajout du projet est bien effectuée");
          alert.showAndWait();
    
      //  Vr.insert1(v,p);
       // System.out.println("sous vrinsert" +v);
        //Sousvariant sv= new Sousvariant();
//        Date x =null;
//        Sousvariant Sousvr =new Sousvariant(numseriesousvariant.getText(),v,"","",i, nomsousvariant.getText(),x,x);
//        Svr.insert(Sousvr);
        
        
//        Etape e= new Etape(Sousvr,serie_etape.getText(), nom_etape.getText(),"");
//        ET.insert(e);
//        float f = 0;
//        Composant t= new Composant (serie_composant.getText(),nom_composant.getText(),"","",f,i);
//        Cp.insert(t);
//        
//        ObservableList<Composant> liste = null;
//        Composant C = new Composant("", "","", "",f,i);
//        ObservableList<Composant> tableaucomposant= FXCollections.observableArrayList();
//        for (Composant pr : tableaucomposant)
//         tableaucomposant = FXCollections.observableArrayList(C);
//         
//         System.out.println("liste" + liste);
//         int j = tableview.getItems().size();
//         Cp.insert(C);  
        
        
    }
    private void afficheLaSelection(String Composant) {
        sliste = Cp.findlistComposant(Composant.toString());
        System.out.println("list1" +sliste);
     listeComposant = FXCollections.observableArrayList(sliste);
        
//        comboetape.setItems(sliste);
        System.out.println("liste" + listeComposant);
        int i = tableview1.getItems().size();
        System.out.println("bouclefor");
       // int i = tableview.getItems().size();
        System.out.println("bouclefor");
        tableview1.getItems().addAll(i, listeComposant);
         System.out.println("lisst" +sliste.get(0));
//         for (int j = 1; j<sliste.size(); j++){
//             System.out.println("listeAjout" +sliste);
//             sliste.add(sliste.get(j));
//             
//         }
         System.out.println("sliste size" +sliste.size());
//        List<Composant> cliste = Cp.findComposant(Etape);
//        ObservableList<Composant> listeComposant = FXCollections.observableArrayList(cliste);
//        
////        comboetape.setItems(sliste);
//        System.out.println("liste" + listeComposant);
//        int j = tableview1.getItems().size();
//        System.out.println("bouclefor");
//       // int i = tableview.getItems().size();
//        System.out.println("bouclefor");
//        tableview1.getItems().addAll(j, listeComposant);
        
    }
    private void afficheprojet(String string) {
       Object pr =comboprojet.getSelectionModel().getSelectedItem();
       nomprojet.setText(pr.toString());
        List text1=Pr.findnumero_serie1(pr.toString());
        int i= 0; 
        numserieprojet.setText((String) text1.get(i));
        ObservableList<Variant> list = null;
    
         Object var = comboprojet.getSelectionModel().getSelectedItem();
            List liste = Vr.findlistVariant(var.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
            System.out.println(liste);
             listvariant.setItems(data);
//           int j = tablevariant.getItems().size();
//            tablevariant.getItems().addAll(j, liste);
             
    
             
//         List<Variant> var = Vr.findListDesVariant(Vr.toString());
//        System.out.println(var);
//        for (Variant va : var) {
//            list = FXCollections.observableArrayList();
//            list.add(va);
//            System.out.println("list" + list);
//            int j = tablevariant.getItems().size();
//            tablevariant.getItems().addAll(j, list);

    
    }


    @FXML
    private void etapeOnAction(ActionEvent event) {
        
    }

    @FXML
    private void buttonupdateonaction(ActionEvent event) {
        ObservableList<Projet> liste=null;
    
        List<Projet> proj = Pr.findlistDesProjets();
        System.out.println(proj);
        for (Projet pr : proj) {
            liste = FXCollections.observableArrayList();
            liste.add(pr);
            System.out.println("liste" + liste);
            int j = tableprojet.getItems().size();
            tableprojet.getItems().addAll(j, liste);
           
    }
    }

    @FXML
    private void handlevalidervariant(ActionEvent event) {
      
      Projet p1=new Projet(numserieprojet.getText(),nomprojet.getText());
      Variant v;
          int i=0;
//       v  = new Variant(numserievarianttext.getText(),p1,nomvarianttext.getText(),"",nomprojet.getText());
//         Vr.insert(v);
               
//listeAjoutvariant = tablevariant.getItems();
 //ObservableList<Variant> listeVariants = FXCollections.observableArrayList(listeAjoutvariant);
 
//        System.out.println("longueur =" +sliste.size());
//        for (Variant vr: listeVariants) {
            
             v  = new Variant(numserievarianttext.getText(),p1,nomvarianttext.getText(),"",nomprojet.getText());
         Vr.insert(v);
            
        //}
        
          Alert alert=new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
          alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
          alert.setContentText("L'ajout des variants est bien effectuée");
          alert.showAndWait();
    
    }

    private void buttonajouteronaction(ActionEvent event) {
        ObservableList<Variant> listevariant= FXCollections.observableArrayList();
        String s1=numserievarianttext.getText();
       String s2 = nomvarianttext.getText();
       
      
        Variant v;
       
       Projet p =new Projet("","");
        v= new Variant(s1,p,s2,"","");
//        System.out.println("sur vrinsert" +v);
//        Vr.insert(v);
        listevariant = FXCollections.observableArrayList(v);
       System.out.println(listevariant);
       int j = tablevariant.getItems().size();
        System.out.println("bouclefor");
        tablevariant.getItems().addAll(j, listevariant);
        numserievarianttext.clear();
nomvarianttext.clear();
    }

    private void affichecombovariant(String Variant) {
        List listes = Vr.findlistVariant(Variant);
       ObservableList<Variant> listevariant = FXCollections.observableArrayList(listes);
       combovariantsvariant.setItems(listevariant);
    }

    private void affichelistvariant(String string) {
        Object pr =combovariantsvariant.getSelectionModel().getSelectedItem();
       nomserievariant1.setText(pr.toString());
        List text1=Vr.findnum_serieVariant(pr.toString());
        int i= 0; 
        numserievariant1.setText((String) text1.get(i));
        ObservableList<Variant> list = null;
    
         Object var = combovariantsvariant.getSelectionModel().getSelectedItem();
            List liste = Svr.findlistSousVariant(var.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
            System.out.println(liste);
             listesousvariant.setItems(data);
       
    }

    @FXML
    private void handlesousvaar(ActionEvent event) {
         Projet p = new Projet("","");
       int i = 0;
      
       Date d = new Date();
       Variant v1=new Variant(numserievariant1.getText(),p,nomserievariant1.getText(),"","");
        
        int s = 0;
        Date d1=new Date() ;  
       Sousvariant sv1;
       int g= Integer.parseInt(codebarre.getText());
//      int k = Integer.parseInt(codebarre.getText());
        sv1 = new Sousvariant(nomsvar.getText(),v1,numsvar.getText(),nomserievariant1.getText(),s,g,d1,d1,"");
         Svr.insert(sv1);
         
//         listeAjoutSousvariant = tablesousvariant.getItems();
// ObservableList<Sousvariant> listesousvar = FXCollections.observableArrayList(listeAjoutSousvariant);
// 
//       
            
//        for (Sousvariant svr: listesousvar) {
//            System.out.println("listeAjout sous var" +listesousvar);
//            System.out.println("pr" +svr.getNomSousVariant());
////            sv1 = new Sousvariant(nomsvar.getText(),v1,numsvar.getText(),
////                    nomserievariant1.getText(),i,codebarre.getLength(),d,d,"");
////            Svr.insert(sv1);
       // }
        
          Alert alert=new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
          alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
          alert.setContentText("L'ajout des sous variants est bien effectuée");
          alert.showAndWait();
    }

    

    private void affichelistv(String Variant) {
        List listes = Vr.findlistVariant(Variant);
       ObservableList<Variant> listevariant = FXCollections.observableArrayList(listes);
       combovariantsv.setItems(listevariant);
       
  
    }

    private void affichelistsvariant(String Sousvariant) {
        List listesv=Svr.findlistSousVariant(Sousvariant);
        ObservableList<Sousvariant> listesvariant = FXCollections.observableArrayList(listesv);
       combovariantsv.setItems(listesvariant);
       Object sv =combovariantsv.getSelectionModel().getSelectedItem();
       nomtextsv.setText(sv.toString());
        List text1=Svr.findnum_serieSousVariant(sv.toString());
        int i= 0; 
        numtextsv.setText((String) text1.get(i));
    }

    @FXML
    private void combovariantsvAction(ActionEvent event) {
         Object sv =combovariantsv.getSelectionModel().getSelectedItem();
         List listes = Svr.findlistSousVariant(sv.toString());
       ObservableList<Variant> listevariant = FXCollections.observableArrayList(listes);
       combosv.setItems(listevariant);
       
      
    }

    @FXML
    private void combosvonAction(ActionEvent event) {
        
         Object sv =combosv.getSelectionModel().getSelectedItem();
          nomtextsv.setText(sv.toString());
        List text1=Svr.findnum_serieSousVariant(sv.toString());
        int i= 0; 
        numtextsv.setText((String) text1.get(i));
        

    }

    @FXML
   private void handleAjouterButtonCMPAction(ActionEvent event) {
       
        Composant cp = new Composant(numcomposant.getText(),nomcomposant.getText(),nometape.getText(),numetape.getText());
        Cp.insert(cp);
                
    
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
          alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
          alert.setContentText("L'ajout du composant et etape  est bien effectué");
          alert.showAndWait();
           
    }

    @FXML
    private void handleAjouteretapButtonAction(ActionEvent event) {
        
       Projet p = new Projet("","");
       int i = 0;
      
       Date d = new Date();
       Variant v1=new Variant("",p,"","","");
        
        Sousvariant sv = new Sousvariant(nomtextsv.getText(),v1,numtextsv.getText(),"",i,i,d,d,"");
      //  Etape e = new Etape(sv,"","","","",d,i);
        
          //ObservableList<Etape> listeEtape = FXCollections.observableArrayList();
//          tableview1.setItems(listeEtape);
//          System.out.println(listeEtape);
//          System.out.println("sur table");
//List<Composant> sliste = null;
//        ObservableList<Composant> listeComposant = FXCollections.observableArrayList(sliste);
System.out.println("listecompo" +listeComposant);
listeAjout = tableview1.getItems();
 ObservableList<Composant> listeComposant = FXCollections.observableArrayList(listeAjout);
 
        System.out.println("longueur =" +sliste.size());
        for (Composant pr: listeComposant) {
            System.out.println("listeAjout" +sliste);
            System.out.println("pr" +pr.getNomEtape());
            
            Etape e = new Etape(sv,pr.getNomEtape(),pr.getNumeroEtape(),numtextsv.getText(),"",d,i);     
            ET.insert(e);
        }
        
                        
                   
       System.out.println("sous for");
       
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
          alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
          alert.setContentText("L'ajout du sous variant est bien effectué");
          alert.showAndWait();
    }

    private void buttonajoutersvonaction(ActionEvent event) {
        ObservableList<Sousvariant> listesousvariant= FXCollections.observableArrayList();
        String s1=numsvar.getText();
       String s2 = nomsvar.getText();
       
      
        Projet p1=new Projet("",""); 
        int i = 0;
       Variant v1;
        v1 = new Variant(numserievariant1.getText(),p1,nomserievariant1.getText(),"","");
      
        Date d=new Date() ;  
       Sousvariant sv1;
      int k = Integer.parseInt(codebarre.getText());
        sv1 = new Sousvariant(s2,v1,s1,nomserievariant1.getText(),i,k,d,d,"");
//         Svr.insert(sv1);
        
        
        
        
        listesousvariant = FXCollections.observableArrayList(sv1);
       System.out.println(listesousvariant);
       int j = tablesousvariant.getItems().size();
        System.out.println("bouclefor");
        tablesousvariant.getItems().addAll(j, listesousvariant);
        numsvar.clear();
nomsvar.clear();
codebarre.clear();
    }
}
    


