/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.ProjetDAO;
import DAO.VariantDAO;
import Entites.Projet;
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
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ProjetController implements Initializable {

    @FXML
    private ComboBox choiceBoxProjet;
    @FXML
    private Button ButtonSuivant;
    @FXML
    private Button menuprincipal;
    @FXML
    private Hyperlink hyperlink;
    @FXML
    private Button AjoutButton;
    @FXML
    private ListView ListViewProjet;
    @FXML
    private Button showDateTime;
    @FXML
    private TextField TextDate;
    @FXML
    private ImageView handle;
    private TableColumn colonne1;
    private TableColumn colonne2;
    private TableView tableSelectionnee;
    @FXML
    private TextField searchbox;
      @FXML
    private Button supprimer;
       @FXML
    private TextField txtNumrProjet;
 
    
    private int minute;
    private int hour;
    private int second;
    
    ProjetDAO sp = new ProjetDAO();
    VariantDAO sv = new VariantDAO();
    Variant var = new Variant();
    private final ObservableList<String> masterData = FXCollections.observableArrayList();
    private ObservableList<Variant> filteredData = FXCollections.observableArrayList();
    ObservableList<Variant> listeV = FXCollections.observableArrayList();
    String projet;
    @FXML
    private Button buttonmodifier;
    @FXML
    private TextField txtnumvariant;
    @FXML
    private TextField txtnomvariant;
    @FXML
    private Label txtnomprojet;
   
    /**
     * // * Initializes the controller class.
     */
    @Override
    @SuppressWarnings("empty-statement")
    public void initialize(URL url, ResourceBundle rb) {
//        colonne2.setCellValueFactory(new PropertyValueFactory<Variant, String>("nomVariant"));
//        colonne1.setCellValueFactory(new PropertyValueFactory<Variant, String>("numSerieVariant"));
//       
//        tableSelectionnee.setItems(listeV);
//Date aujourdhui = new Date();
//DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(
//DateFormat.MEDIUM,
//DateFormat.MEDIUM);
//String s=(mediumDateFormat.format(aujourdhui));
//TextDate.setText(s);


List list = sp.findListProjet();
        ObservableList<Projet> liste = FXCollections.observableArrayList(list);
        choiceBoxProjet.setItems(liste);
        ListViewProjet.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> afficheLaSelection((String) newValue));
        
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
        TextDate.setText( ""+mediumDateFormat.format(aujourdhui)     
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
    void nomprojet(){
        projet=(String) choiceBoxProjet.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void search(KeyEvent event) {
        
        ObservableList<String> listv = ListViewProjet.getItems();
        System.out.println(listv);
        FilteredList<String> filteredData = new FilteredList<>(listv, s -> true);

        ListViewProjet.setItems(filteredData);
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
        ListViewProjet.setItems(sortedData);

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

    @FXML
    private void handleAjouterButtonAction(ActionEvent event) throws IOException {
//        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("demande-ajout.fxml"));
            Parent root2 = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Ajout");
            stage.setScene(new Scene(root2));
            stage.show();

//        } catch (Exception e) {
//            System.out.println("can't load new window");
//        }
    }
    public void settext (String Nom_variant,String Num_serie_variant,String numero_serie,String nomProjet)
     
     {
        this.txtNumrProjet.setText(numero_serie);
        this.txtnomprojet.setText(nomProjet);
        this.choiceBoxProjet.getSelectionModel().getSelectedItem();
        this.txtnomvariant.setText(Nom_variant);
        this.txtnumvariant.setText(Num_serie_variant);
        List list=sv.findlistVariant(txtnomprojet.getText());
        ObservableList <Variant> liste = FXCollections.observableArrayList(list);
        System.out.println("avant list" +liste);
            ListViewProjet.setItems(liste);
            
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
    private void handleComboBoxProjet(ActionEvent ev) {

 try {
            ListViewProjet.refresh();

            Object var = choiceBoxProjet.getSelectionModel().getSelectedItem();
            List liste = sv.findlistVariant(var.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
            System.out.println(liste);
             ListViewProjet.setItems(data);
              Object pr=choiceBoxProjet.getSelectionModel().getSelectedItem();
             List text1=sp.findnumero_serie1(pr.toString());
            int i= 0; 
            txtNumrProjet.setText((String) text1.get(i));
            txtnomprojet.setText(var.toString());


        } catch (UnsupportedOperationException e1) {
            e1.printStackTrace();
        }
    }
    

    @FXML
    private void showDateTimeAction(ActionEvent event) {
        Date now = new Date();

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        // Model Data
        String dateTimeString = df.format(now);

        // Show in VIEW
       // TextDate.setText(dateTimeString);
    }

    public void afficheLaSelection(String nom_variant) {
        //if (nom_variant!=null){
           
////        List var = sv.findnum_serieVariant(txtNumrProjet.getText());
////        System.out.println(var);
////        int i=0;
////        Projet p=null;
////      
////         Variant varTable = new Variant((String) var.get(i),p,nom_variant, "","");
////       listeV = FXCollections.observableArrayList(varTable);
////        System.out.println(listeV);
       // txtnumvariant.setText(nom_variant.getNumSerieVariant());
          ListViewProjet.getSelectionModel().getSelectedItem();
        txtnomvariant.setText( ListViewProjet.getSelectionModel().getSelectedItem().toString());
        List var = sv.findnum_serieVariant(txtnomvariant.getText());
        txtnumvariant.setText(var.get(0).toString());
//        int j = tableSelectionnee.getItems().size();
//        System.out.println("bouclefor");
//        tableSelectionnee.getItems().addAll(j, listeV);
       // }
    }
    

    @FXML
    private void handlesuivantButtonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Variant.fxml"));
        Parent test2_parent = loader.load();
        
      Scene test2_scene = new Scene(test2_parent);
          String Numero_serie=txtNumrProjet.getText();
        //access the controller and call a method
        VariantController controller = loader.getController();
         String Nom_variant=txtnomvariant.getText();
      String Num_serie_variant=txtnumvariant.getText();
      String nom_projet= txtnomprojet.getText();
              
      controller.settext(Nom_variant, Num_serie_variant,nom_projet);
      //  controller.initData();
       // controller.setcomboboxselection((String)choiceBoxProjet.getSelectionModel().getSelectedItem());
        controller.settext(Numero_serie);
        //This line gets the Stage information
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("Gestion Logistique");
        window.setScene(test2_scene);
        window.show();
        
        
    
    }

    @FXML
    private void supprimerButtonAction(ActionEvent event) throws IOException {
//        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Suppression.fxml"));
            Parent root2 = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Suppression");
            stage.setScene(new Scene(root2));
            stage.show();

//        } catch (Exception e) {
//            System.out.println("can't load new window");
//        }
        
    }

    @FXML
    private void ButtonmodifierAction(ActionEvent event)throws IOException {
//         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Demande de modification.fxml"));
            Parent root2 = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Modification");
            stage.setScene(new Scene(root2));
            stage.show();

//        } catch (Exception e) {
//            System.out.println("can't load new window");
//        }
    }
}
