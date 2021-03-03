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
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class OrdreFab1Controller implements Initializable {

    @FXML
    private AnchorPane imprimepage;
    @FXML
    private TableView  tableview;
    @FXML
    private TableColumn  colonneNUMetape;
    @FXML
    private TableColumn  colonneNometape;
    @FXML
    private TableColumn  colonneNumcompo;
    @FXML
    private TableColumn  colonneNomcompo;
    @FXML
    private Label lblcodebarre;
    @FXML
    private Label lbldatesaisi;
    @FXML
    private Label lbldateprevu;
    @FXML
    private Label lblnomprojet;
    @FXML
    private Label lblnumproj;
    @FXML
    private Label lblnomvar;
    @FXML
    private Label lblnumvar;
    @FXML
    private Label lblnomsousvar;
    @FXML
    private Label lblnumsousvar;
    @FXML
    private Label lblquantite;
    @FXML
    private Label lblresponsable;
    SousVariantDAO svv = new SousVariantDAO();
    ObservableList<Etape> listeET = FXCollections.observableArrayList();
    ObservableList<Composant> listeCP = FXCollections.observableArrayList();
    EtapeDAO ET = new EtapeDAO();
    ComposantDAO Cp = new ComposantDAO();
    SupervisionDAO Supervis = new SupervisionDAO();
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }   
    public void settext2(String datesaisi,String datelimite,String Nom_variant, String Num_serie_variant, String Nom_projet, String numero_serie, String Nom_sousVariant, String num_SousVariant, String Quantite,
            String Responsable) {
        this.lbldatesaisi.setText(datesaisi);
        this.lbldateprevu.setText(datelimite);
        this.lblnomvar.setText(Nom_variant);
        this.lblnumvar.setText(Num_serie_variant);
        this.lblnomprojet.setText(Nom_projet);
        this.lblnumproj.setText(numero_serie);
        this.lblnumsousvar.setText(num_SousVariant);
        this.lblnomsousvar.setText(Nom_sousVariant);
        this.lblquantite.setText(Quantite);
        this.lblresponsable.setText(Responsable);
        String Svar = lblnomsousvar.getText();
        System.out.println(Svar);
        List list = svv.findcode_barre(Svar);
        System.out.println(list);
        int i = 0;
        System.out.println(list);
        lblcodebarre.setText(list.get(i).toString());
        System.out.println(list);

        colonneNUMetape.setCellValueFactory(new PropertyValueFactory<Composant, String>("numeroEtape"));
        colonneNometape.setCellValueFactory(new PropertyValueFactory<Composant, String>("nomEtape"));
        colonneNumcompo.setCellValueFactory(new PropertyValueFactory<Composant, String>("numeroComposant"));
        colonneNomcompo.setCellValueFactory(new PropertyValueFactory<Composant, String>("nomComposant"));
        List<String> list2 = ET.findnumero_etape(lblnumsousvar.getText());
        //  List list1 = Cp.findComposant(list2.toString()); //findlistEtape(twtnumsousvar.getText());
        System.out.println("liste etapes" + list2);
        //  System.out.println("liste composant" + list1);
        //  ObservableList<Etape> listeET = FXCollections.observableArrayList(list1);
        tableview.setItems(listeCP);
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
            int l = tableview.getItems().size();
            tableview.getItems().addAll(l++, listeCP);

        }

    
}
}
