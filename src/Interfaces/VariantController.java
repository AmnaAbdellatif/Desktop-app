/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.SousVariantDAO;
import DAO.VariantDAO;
import Entites.Sousvariant;
import Entites.Variant;
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
import java.util.stream.Collectors;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Pagination;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class VariantController implements Initializable {
    private Variant selectedVariant;
    /**
     * This method accepts a variant to initialize the view
     * @param variant 
     */
    
    
    @FXML
    private Button NextButton;
    @FXML
    private Button précedentButton1;
    @FXML
    private Button menuprincipal;
    @FXML
    private Hyperlink hyperlink;
    @FXML
    private ListView  ListViewVariant;
    private TableView  tableSousVariant;
    private TableColumn  colonneNumserie;
    private TableColumn  colonneNom;
    @FXML
    private Button date;
    @FXML
    private TextField dateftxt;
   
   
    @FXML
    private TextField searchbox;
    @FXML
    private TextField txtNomvariant;
    @FXML
    private TextField txtnumVariant;
     @FXML
    private ImageView handle;
    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private TextField txtNumprojet;
    @FXML
    private TextField txtNomvprojet;

    
    VariantDAO sv=new VariantDAO();
    SousVariantDAO svv=new SousVariantDAO();
    Variant var = new Variant();
    Sousvariant Svar = new  Sousvariant () ;
    
   private final ObservableList<String> masterData = FXCollections.observableArrayList();

   private ObservableList<Sousvariant> filteredData = FXCollections.observableArrayList();
     ObservableList<Sousvariant> listeSV = FXCollections.observableArrayList();
    @FXML
    private TextField txtnumsousvar;
    @FXML
    private TextField txtnomsousvar;
   
    
    
    /**
     * Initializes the controller class.
     */
//    public void initData(Variant variant)
//    {
//        String Nom_variant = null;
//        String Num_serie_variant = null;
//        selectedVariant = variant;
//        txtNomvariant.setText(selectedVariant.getNomVariant());
//        txtnumVariant.setText(selectedVariant.getNumSerieVariant());
//        List list=svv.findlistSousVariant(selectedVariant.getNomVariant());
//        ObservableList <Sousvariant> liste = FXCollections.observableArrayList(list);
//        System.out.println("avant list" +liste);
//            ListViewVariant.setItems(liste);
//            System.out.println(liste);
//            this.txtNomvariant.setText(Nom_variant);
//        this.txtnumVariant.setText(Num_serie_variant);
//        
//        
//    }
    public void setcomboboxselection (String projet){
        txtNomvprojet.setText(projet);
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
        dateftxt.setText( ""+mediumDateFormat.format(aujourdhui)     
        );
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
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//        colonneNom.setCellValueFactory(new PropertyValueFactory<Variant, String>("nomSousVariant"));
//        colonneNumserie.setCellValueFactory(new PropertyValueFactory<Variant, String>("numSerieSousVariant"));
//            tableSousVariant.setItems(listeSV);
           
            
        ListViewVariant.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> afficheLaSelection((String) newValue));
  DateCourante();
       
    } 
    
   
      
    
    
     public void afficheLaSelection(String num_sousVariant) {
//         tableSousVariant.getItems().setAll(nom_sous_variant);
 ListViewVariant.getSelectionModel().getSelectedItem();
        txtnomsousvar.setText( ListViewVariant.getSelectionModel().getSelectedItem().toString());
        List<String> liste = svv.findnum_serieSousVariant(txtnomsousvar.getText());
        txtnumsousvar.setText( liste.stream().map(Object::toString).collect(Collectors.joining(", ")));
        
////        List liste = svv.findnum_serieSousVariant(nom_sous_variant);
////        //Variant v = null;
////        Variant v= new Variant();
////        Date d =null;
////        
////        int i=0;
////        String cb=null;
////         Sousvariant SvarTable = new Sousvariant(nom_sous_variant,v, (String) liste.get(i),"",0,i,d,d,"");
////       listeSV = FXCollections.observableArrayList(SvarTable);
////        System.out.println(listeSV);
////        int j = tableSousVariant.getItems().size(); 
////        tableSousVariant.getItems().addAll(j,listeSV);
//        tableSousVariant.getItems().setAll(colonneNom);
//        tableSousVariant.getItems().setAll(colonneNumserie);
//        
//        colonneNom.setCellValueFactory(param -> {
//            return new SimpleObjectProperty<>(nom_sous_variant);
//        });
//        colonneNumserie.setCellValueFactory(param -> {
//            return new SimpleObjectProperty<>(liste);
//        });


    }
      public void settext (String Nom_variant,String Num_serie_variant,String nom_projet){
        this.txtNomvariant.setText(Nom_variant);
        this.txtnumVariant.setText(Num_serie_variant);
        this.txtNomvprojet.setText(nom_projet);
        List list=svv.findlistSousVariant(txtNomvariant.getText());
        ObservableList <Sousvariant> liste = FXCollections.observableArrayList(list);
        System.out.println("avant list" +liste);
            ListViewVariant.setItems(liste);
            
        
        
    
}
        
      @FXML
    private void search(KeyEvent event) {
          ObservableList<String> listv = ListViewVariant.getItems();
        System.out.println(listv);
        FilteredList<String> filteredData = new FilteredList<>(listv, s -> true);

        ListViewVariant.setItems(filteredData);
        System.out.println(filteredData);
        
        searchbox.textProperty().addListener(obs -> {
            String filter = searchbox.getText();
            String s1=filter.toUpperCase();
            String s2=filter.toLowerCase();
            if (filter == null || filter.length() == 0) {
                filteredData.setPredicate(s -> true);
            } else{
                filteredData.setPredicate(s -> s.startsWith(s1) || s.startsWith(s2));
            }
        });
        SortedList<String> sortedData = new SortedList<>(filteredData);
        ListViewVariant.setItems(sortedData);

    }

    @FXML
    private void handlemenuButtonAction(ActionEvent event) throws IOException {
        Parent test2_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene test2_scene = new Scene(test2_parent);
            
            Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            test1_stage.setTitle("Bienvenue");
            test1_stage.setScene(test2_scene);
            test1_stage.show();
    }

    private void handleAjoutButtonAction(ActionEvent event) throws IOException {
        try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("demande-ajout.fxml"));
           Parent root2=loader.load();
           Stage stage=new Stage();
           stage.setTitle(" Ajout");
           stage.setScene(new Scene(root2));
           stage.show();
    }
        catch(Exception e){
           System.out.println("can't load new window");
       }
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
    private void dateAction(ActionEvent event) {
        Date now= new Date();
      
       DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
      
      
        // Model Data
        String dateTimeString = df.format(now);
        
        // Show in VIEW
        dateftxt.setText(dateTimeString);
    }

    @FXML
    private void handleAjouterButtonAction(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("demande-ajout.fxml"));
            Parent root2 = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajout");
            stage.setScene(new Scene(root2));
            stage.show();

        } catch (Exception e) {
            System.out.println("can't load new window");
        }
    }
     public void settext (String Numero_serie){
        this.txtNumprojet.setText(Numero_serie);
        
    
}

    @FXML
    private void supprimerButtonAction(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Suppression.fxml"));
            Parent root2 = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Suppression");
            stage.setScene(new Scene(root2));
            stage.show();

        } catch (Exception e) {
            System.out.println("can't load new window");
        }
    }

    @FXML
    private void handleSuivantButtonAction(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InterfaceEtape.fxml"));
        Parent test2_parent = loader.load();
        
      Scene test2_scene = new Scene(test2_parent);
      String Nom_variant=txtNomvariant.getText();
      String Num_serie_variant=txtnumVariant.getText();
       String Nom_projet=txtNomvprojet.getText();
       String numero_serie=txtNumprojet.getText();
       
       String numsousvar=txtnumsousvar.getText();
       String Nom_sousvar=txtnomsousvar.getText();
       
        //access the controller and call a method
        InterfaceEtapeController controller = loader.getController();
      // controller.initData((String) txtnumsousvar.getText());
        controller.settext(Nom_variant, Num_serie_variant, Nom_projet,numero_serie,numsousvar,Nom_sousvar);
        //This line gets the Stage information
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Gestion Logistique");
        window.setScene(test2_scene);
        window.show();
        

    }
    public void settextvariant (String Nom_variant,String Num_serie_variant,String Nom_projet,String numero_serie,
     String numSousvar,String nomSousvar)
     {
        this.txtNomvariant.setText(Nom_variant);
        this.txtnumVariant.setText(Num_serie_variant);
        this.txtNomvprojet.setText(Nom_projet);
          this.txtNumprojet.setText(numero_serie);
        this.txtnomsousvar.setText(numSousvar); 
         this.txtnumsousvar.setText(nomSousvar);
         List list=svv.findlistSousVariant(txtNomvariant.getText());
        ObservableList <Sousvariant> liste = FXCollections.observableArrayList(list);
        System.out.println("avant list" +liste);
            ListViewVariant.setItems(liste);
        
     }
     @FXML
    private void handlePrecedentButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Projet.fxml"));
        Parent test2_parent = loader.load();
        
      Scene test2_scene = new Scene(test2_parent);
      String Nom_variant=txtNomvariant.getText();
      String Num_serie_variant=txtnumVariant.getText();
       String Nom_projet=txtNomvprojet.getText();
       String numero_serie=txtNumprojet.getText();
        String Nomprojet=txtNomvprojet.getText();
       
      
       
        //access the controller and call a method
        ProjetController controller = loader.getController();
      // controller.initData((String) txtnumsousvar.getText());
        controller.settext(Nom_variant, Num_serie_variant,numero_serie,Nomprojet);
        
        //This line gets the Stage information
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Gestion Logistique");
        window.setScene(test2_scene);
        window.show();
        
    }

}

   


