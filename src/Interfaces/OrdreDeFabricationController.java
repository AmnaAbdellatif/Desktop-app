/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.ComposantDAO;
import DAO.EtapeDAO;
import DAO.SousVariantDAO;
import DAO.SupervisionDAO;
import Entites.Composant;
import Entites.Etape;
import Entites.Sousvariant;
import Entites.Supervision;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JTextArea;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class OrdreDeFabricationController implements Initializable {

    private Sousvariant selectedSousVariant;
    private Etape selectedEtape;

    @FXML
    private TextField txtcodebarre;
    @FXML
    private TextField txtdate;
    @FXML
    private TextField txtnomproj;
    @FXML
    private TextField txtnumproj;
    @FXML
    private TextField txtnomvar;
    @FXML
    private TextField txtnumvar;
    @FXML
    private TextField txtnomsousvar;
    @FXML
    private TextField twtnumsousvar;
    @FXML
    private TextField twtQTE;
    @FXML
    private TextField txtresponsable;
     
    //private JTextArea txtresponsable1= new JTextArea();
    private TextArea txtresponsable1= new TextArea();

    

    @FXML
    private Button btnimprimer;

    /**
     * Initializes the controller class.
     */
    SousVariantDAO svv = new SousVariantDAO();
    ObservableList<Etape> listeET = FXCollections.observableArrayList();
    ObservableList<Composant> listeCP = FXCollections.observableArrayList();
    EtapeDAO ET = new EtapeDAO();
    ComposantDAO Cp = new ComposantDAO();
    SupervisionDAO Supervis = new SupervisionDAO();
    @FXML
    private TableView tablecomposant;
  
    @FXML
    private TableColumn colonneNomcompo;
    @FXML
    private TableColumn colonneNUMetape;
    @FXML
    private TableColumn colonneNometape;
    @FXML
    private TableColumn colonneNumcompo;
    @FXML
    private AnchorPane imprimepage;
    @FXML
    private Button btnsave;
    @FXML
    private TextField txtdate1;
   
    
//private FileChooser fc= new FileChooser();
//    private Window ownerWindow;
//   
//
//private static boolean jobRunning = true;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

//        public void initData1 (Etape etape)
//    {
//        selectedEtape=etape;
//           ObservableList <Etape> list = FXCollections.observableArrayList(selectedEtape);
//     
//        
//        
//        //txtetape.setText(selectedEtape.getNumeroEtape());
//       
//        
//    }
    public void settext1(String Nom_variant, String Num_serie_variant, String Nom_projet, String numero_serie, String Nom_sousVariant, String num_SousVariant, String Quantite, String Responsable) {
        this.txtnomvar.setText(Nom_variant);
        this.txtnumvar.setText(Num_serie_variant);
        this.txtnomproj.setText(Nom_projet);
        this.txtnumproj.setText(numero_serie);
        this.twtnumsousvar.setText(num_SousVariant);
        this.txtnomsousvar.setText(Nom_sousVariant);
        this.twtQTE.setText(Quantite);
        this.txtresponsable.setText(Responsable);
        String Svar = txtnomsousvar.getText();
        System.out.println(Svar);
        List list = svv.findcode_barre(Svar);
        System.out.println(list);
        int i = 0;
        System.out.println(list);
        txtcodebarre.setText(list.get(i).toString());
        System.out.println(list);

        colonneNUMetape.setCellValueFactory(new PropertyValueFactory<Composant, String>("numeroEtape"));
        colonneNometape.setCellValueFactory(new PropertyValueFactory<Composant, String>("nomEtape"));
        colonneNumcompo.setCellValueFactory(new PropertyValueFactory<Composant, String>("numeroComposant"));
        colonneNomcompo.setCellValueFactory(new PropertyValueFactory<Composant, String>("nomComposant"));
        List<String> list2 = ET.findnumero_etape(twtnumsousvar.getText());
        //  List list1 = Cp.findComposant(list2.toString()); //findlistEtape(twtnumsousvar.getText());
        System.out.println("liste etapes" + list2);
        //  System.out.println("liste composant" + list1);
        //  ObservableList<Etape> listeET = FXCollections.observableArrayList(list1);
        tablecomposant.setItems(listeCP);
//    int k=tablecompo.getItems().size();
//    tablecompo.getItems().addAll(k, listeET);
//
//        List<String> list3 = ET.findnumero_etape(twtnumsousvar.getText());
//        System.out.println(list3);
        for (int j = 0; j < list2.size(); j++) {
            System.out.println("list2.getj" + list2.get(j));
            String x = list2.get(j);
            List<Composant> list4 = Cp.findComposant(x);
            System.out.println("list4" + list4);
            ObservableList<Composant> listeCP = FXCollections.observableArrayList(list4);
            int l = tablecomposant.getItems().size();
            tablecomposant.getItems().addAll(l++, listeCP);

        }

    }
//    public void initData(Sousvariant ordre ) throws IOException
//    {
//        Parent test2_parent = FXMLLoader.load(getClass().getResource("Ordre de fabrication.fxml"));
//        Scene test2_scene;
//        test2_scene = new Scene(test2_parent);
//        Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        test1_stage.setScene(test2_scene);
//        
//    }

    @FXML
    private void btnimprimerAction(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("OrdreFab1.fxml"));
       // Parent test2_parent = loader.load();
        Parent root2 = loader.load();
     // Scene test2_scene = new Scene(test2_parent);
      String datesaisi=txtdate.getText();
      String datelimite=txtdate1.getText();
      String Nom_variant=txtnomvar.getText();
      String Num_serie_variant=txtnumvar.getText();
       String Nom_projet=txtnomproj.getText();
       String numero_serie=txtnumproj.getText();
       String Nom_sousVariant=txtnomsousvar.getText();
       String num_SousVariant=twtnumsousvar.getText();
        String Quantite=twtQTE.getText();
         String Responsable=txtresponsable.getText();
        //access the controller and call a method
        OrdreFab1Controller controller = loader.getController();
       // controller.initData1((Sousvariant) tableviewEtape.getSelectionModel().getSelectedItem());
        controller.settext2(datesaisi,datelimite,Nom_variant, Num_serie_variant, Nom_projet,numero_serie,Nom_sousVariant,num_SousVariant,Quantite,Responsable);
       // controller.initData1((Etape) tableviewEtape.getSelectionModel().getSelectedItem());
       
//This line gets the Stage information
        Stage stage = new Stage();
        stage.setTitle("Gestion Logistique");
        stage.setScene(new Scene (root2));
        stage.show();
         Printer printer = Printer.getDefaultPrinter();
        printer.createPageLayout(Paper.NA_LETTER , PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);

        System.out.println("dans Print2()");
        PrinterJob job = PrinterJob.createPrinterJob();
         
        job.showPrintDialog(stage);
        job.showPageSetupDialog(stage);
        if (job != null) {
            boolean success = job.printPage(root2);
            if ( success   ) {
                job.endJob();
            }
        
//      String x=   txtcodebarre.getText();
//      txtresponsable1.appendText( "txt" +x);
//        try {
//            txtresponsable1.print();
            
            
            
//        Parent test2_parent = FXMLLoader.load(getClass().getResource("OrdreFab1.fxml"));
//        Scene test2_scene;
//        test2_scene = new Scene(test2_parent);
//        Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();  
//        test1_stage.setScene(test2_scene);
//        System.out.println("dans Print()");
       
//        } catch (PrinterException ex) {
//            Logger.getLogger(OrdreDeFabricationController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        }
    }
       
 

     
    @FXML
    private void btnsaveAction(ActionEvent event) throws ParseException {
        Date d = new Date() ;
        Date d1 =new Date();
        int i = 0;
        String S1 = txtdate1.getText();
        String S2 = txtdate.getText();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date dayprévu = format.parse(S2);
        Date datesaisie = format.parse(S1);

        int codebarre = Integer.parseInt(txtcodebarre.getText());
        int quantite = Integer.parseInt(twtQTE.getText());

        Supervision s;
        //Double r=null;
        //Date ds = new Date();
        s = new Supervision(txtnumproj.getText(), txtnomproj.getText(), txtnumvar.getText(), txtnomvar.getText(), twtnumsousvar.getText(), txtnomsousvar.getText(), codebarre, quantite, txtresponsable.getText(), datesaisie, dayprévu, "", "", i,d, d1, "");
        Supervis.insert(s);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
        alert.setTitle("Message Enregistrement");
//          alert.setHeaderText("No Person Selected");
        alert.setContentText("Les données sont bien Enregistrées");
        alert.showAndWait();

    }
}
