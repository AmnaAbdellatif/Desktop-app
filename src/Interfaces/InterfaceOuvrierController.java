/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.ComposantDAO;
import DAO.EtapeDAO;
import DAO.SupervisionDAO;
import Entites.Etape;
import Entites.Projet;
import Entites.Supervision;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Client
 */
public class InterfaceOuvrierController implements Initializable {

    @FXML
    private ComboBox  comboetape;
    @FXML
    private TextField datedebut;
    @FXML
    private TextField dateactuelle;
 ComposantDAO Cp = new ComposantDAO();
 EtapeDAO ET=new EtapeDAO();
 SupervisionDAO Superv= new SupervisionDAO();
 Supervision Pr = new Supervision();
 
    @FXML
    private Button date;
    @FXML
    private Button date1;
    @FXML
    private Button valider;
    @FXML
    private TextField qteproduite;
    @FXML
    private TextField codeabarre;
    @FXML
    private TextField nomprojet;
    @FXML
    private TextField numprojet;
    @FXML
    private TextField nomvariant;
    @FXML
    private TextField numvariant;
    @FXML
    private TextField nomsousvariant;
    @FXML
    private TextField numsousvar;
    @FXML
    private TextField responsabletext;
    @FXML
    private TextField qtedemandetext;
    @FXML
    private TextField dateedition;
    @FXML
    private TextField dateprevu;
    @FXML
    private Button quitter;
    /**
     * Initializes the controller class.
     */
   
//    String codebarre;
  
  Scanner sc = new Scanner(System.in);
    @FXML
    private Button buttonok;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       
      
        
 

        // TODO
    }    

    @FXML
    private void dateAction(ActionEvent event) {
         Date now = new Date();

        DateFormat df = new SimpleDateFormat("HH:mm:ss");

        // Model Data
        String dateTimeString = df.format(now);

        // Show in VIEW
        datedebut.setText(dateTimeString);
    }

    @FXML
    private void date1Action(ActionEvent event) {
         Date now = new Date();

        DateFormat df = new SimpleDateFormat("HH:mm:ss");

        // Model Data
        String dateTimeString = df.format(now);

        // Show in VIEW
        dateactuelle.setText(dateTimeString);
    }

    @FXML
    private void valideronAction(ActionEvent event) throws ParseException {
        Object pr =comboetape.getSelectionModel().getSelectedItem();
       
       // List text1=Cp.findnumeroetape(pr.toString());
        int i= 0; 
      int quantiteProduite = Integer.parseInt(qteproduite.getText());
  int CodeBarre = Integer.parseInt(codeabarre.getText());
        String S1 = datedebut.getText();
  String S2= dateactuelle.getText();
  String d = dateedition.getText();
  String d1= dateprevu.getText();
  //String sDate1="31/12/1998";  
    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(d1);  
    System.out.println(d1+"\t"+date1);  
    //SimpleDateFormat format = new SimpleDateFormat("[yyyy-MM-dd]");
  Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(d);  
  //Date dateedition = format.parse(d);
  //Date dateprevu = format.parse(d1);
//   List list = svv.findcode_barre(Svar);
//        System.out.println(list);
SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
Date datedebut = format1.parse(S1);
  Date dateactuelle = format1.parse(S2);
  
        int a = 0;
       
        //txtcodebarre.setText(list.get(i).toString());
   List w =  Superv.findQTEdemande(nomsousvariant.getText());
         // int quantitedemanD;
        
           
        
          int quantitedemanD = Integer.parseInt(qtedemandetext.getText());
     //  List  Resp =  superv.findResponsable(nomsousvariant.getText());
       // quantitedemanD = Integer.parseInt(w.get(a));
        
 Double r = 0.1;
// Date ds = new Date();
   
   Supervision superv= new Supervision(numprojet.getText(),nomprojet.getText(),
   numvariant.getText(),nomvariant.getText(),numsousvar.getText(),nomsousvariant.getText(),CodeBarre,quantitedemanD
           ,responsabletext.getText(),date2,date1,"finie",
          pr.toString(),quantiteProduite,dateactuelle,datedebut,"en cours");
   Superv.insert(superv);
   List <Etape> liste = ET.findetape(pr.toString());
     Etape E1 = liste.get(0);
       E1.setStatutEtape("finie");
       E1.setTempsPrevuEtape(date1);
       ET.update(E1);
     
     Alert alert=new Alert(Alert.AlertType.INFORMATION);
//        alert.initOwner(App.getPrimaryStage());
          alert.setTitle("Message Validation");
//          alert.setHeaderText("No Person Selected");
          alert.setContentText("Etape validée");
          alert.showAndWait();
    }

//    @FXML
//    private void barcodeKeyTyped(KeyEvent event) {
////        String codebarre = codeabarre.getText();
//String codebarre= sc.nextLine();
//       int codebarre1 = Integer.parseInt(codebarre);
//        
//     List nomprojettext =  Superv.findnomProjetCode(codebarre1);
//     List numprojettext =  Superv.findnumProjetCode(codebarre1);
//     List nomvarianttext = Superv.findnomVariantCode(codebarre1);
//     List numvarianttext = Superv.findnumVariantCode(codebarre1);
//     List nomsvarianttext = Superv.findnomsousVariantCode(codebarre1);
//     List numsvarianttext = Superv.findnumsousVariantCode(codebarre1);
//     List quantitedemande=Superv.findQtedemandeCode(codebarre1); 
//        
//        nomprojet.setText(nomprojettext.toString());
//    nomprojet.setText(nomprojettext.toString());
//    numprojet.setText(numprojettext.toString());
//    nomvariant.setText(nomvarianttext.toString());
//   nomsousvariant.setText(nomsvarianttext.toString());
//     numsousvar.setText(numsvarianttext.toString());
//      String  qteprevue1 = String.valueOf(quantitedemande); 
//      qtedemandetext.setText( qteprevue1);
//
//       List dateprévu=Superv.findDatePrevuCode(codebarre1);
//        
//        List dateeditionordre=Superv.findDateOrdreCode(codebarre1);
////        dateprévu.setText((String) text6.get(l));
////            
//            Date now = new Date();
////        Set date format as you want
//        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yy"); 
//        this.dateedition.setText(sf.format(now));
//         this.dateedition.setText(dateeditionordre.toString());
//          this.dateprevu.setText(sf.format(now));
//         this.dateprevu.setText(dateprévu.toString());
//         
//         
//        
//        
//        
//        
//    }

    @FXML
    private void quitteronAction(ActionEvent event) throws IOException {
         Parent test2_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene test2_scene = new Scene(test2_parent);

        Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        test1_stage.setTitle("Bienvenue");
        test1_stage.setScene(test2_scene);
        test1_stage.show();
    }


   // private void buttonokAction(ActionEvent event) {
//       String c= codeabarre.getText();
//        int codebarre1 = Integer.parseInt(c);
//        
//     List nomprojettext =  Superv.findnomProjetCode(codebarre1);
//     List numprojettext =  Superv.findnumProjetCode(codebarre1);
//     List nomvarianttext = Superv.findnomVariantCode(codebarre1);
//     List numvarianttext = Superv.findnumVariantCode(codebarre1);
//     List nomsvarianttext = Superv.findnomsousVariantCode(codebarre1);
//     List numsvarianttext = Superv.findnumsousVariantCode(codebarre1);
//     List quantitedemande=Superv.findQtedemandeCode(codebarre1); 
//     List responsable=Superv.findresponsableCode(codebarre1); 
//        System.out.println("liste qte" +quantitedemande);
//        
//        //nomprojet.setText(nomprojettext.toString());
//   // numprojet.setText(numprojettext.toString());
//    //nomvariant.setText(nomvarianttext.toString());
//    //numvariant.setText(numvarianttext.toString());
//  // nomsousvariant.setText(nomsvarianttext.toString());
//     //  numsousvar.setText(numsvarianttext.toString());
//    // responsabletext.setText(responsable.toString());
//        
//      String  qteprevue1 = String.valueOf(quantitedemande.get(0)); 
//      qtedemandetext.setText( qteprevue1);
//      
//
//       List dateprévu=Superv.findDatePrevuCode(codebarre1);
//        
//        List dateeditionordre=Superv.findDateOrdreCode(codebarre1);
////        dateprévu.setText((String) text6.get(l));
////            
//            Date now = new Date();
////        Set date format as you want
//        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yy"); 
//        this.dateedition.setText(sf.format(now));
//         this.dateedition.setText(dateeditionordre.get(0).toString());
//          this.dateprevu.setText(sf.format(now));
//         this.dateprevu.setText(dateprévu.get(0).toString());
//         
//        
//        String str[] = new String[numsvarianttext.size()]; 
//        for (int j = 0; j < numsvarianttext.size(); j++) { 
//  
//            // Assign each value to String array 
//            str[j] = (String) numsvarianttext.get(j); 
//         
//       
//          List Etape = ET.findListEtapesSV( str[j]); 
//        System.out.println(Etape);
//         ObservableList<Projet> liste = FXCollections.observableArrayList(Etape);
//         comboetape.setItems(liste);
//             
//        } 
//        String strpr[] = new String[nomprojettext.size()]; 
//        for (int j = 0; j < nomprojettext.size(); j++) { 
//  
//            // Assign each value to String array 
//            strpr[j] = (String) nomprojettext.get(j); 
//         nomprojet.setText( strpr[j]);
//         
//         
//    }
//        String strprnum[] = new String[numprojettext.size()]; 
//        for (int j = 0; j < numprojettext.size(); j++) { 
//  
//            // Assign each value to String array 
//            strprnum[j] = (String) numprojettext.get(j); 
//       numprojet.setText(strprnum[j]);
//         
//         
//    }
//      String strvar[] = new String[nomvarianttext.size()]; 
//        for (int j = 0; j < nomvarianttext.size(); j++) { 
//  
//            // Assign each value to String array 
//            strvar[j] = (String) nomvarianttext.get(j); 
//      nomvariant.setText(strvar[j]);
//         
//         
//    }
//        String strnumvar[] = new String[numvarianttext.size()]; 
//        for (int j = 0; j < numvarianttext.size(); j++) { 
//  
//            // Assign each value to String array 
//            strnumvar[j] = (String) numvarianttext.get(j); 
//     numvariant.setText(strnumvar[j]);       
//    }  
//        
//        String strsousvar[] = new String[nomsvarianttext.size()]; 
//        for (int j = 0; j < nomsvarianttext.size(); j++) { 
//  
//            // Assign each value to String array 
//            strsousvar[j] = (String) nomsvarianttext.get(j); 
//     nomsousvariant.setText(strsousvar[j]);
//         
//         
//    }  
//         String strsousvarnum[] = new String[numsvarianttext.size()]; 
//        for (int j = 0; j < numsvarianttext.size(); j++) { 
//  
//            // Assign each value to String array 
//            strsousvarnum[j] = (String) numsvarianttext.get(j); 
//     numsousvar.setText(strsousvarnum[j]);
//         
//         
//    }  
//        String strresp[] = new String[responsable.size()]; 
//        for (int j = 0; j < responsable.size(); j++) { 
//  
//            // Assign each value to String array 
//            strresp[j] = (String) responsable.get(j); 
//     responsabletext.setText(strresp[j]);
//         
         
    //} 
        
//String numberAsString = Integer.toString(quantitedemande.get(codebarre1));
//        String strqte[] = new String[quantitedemande.size()]; 
//        for (int j = 0; j < quantitedemande.size(); j++) { 
//  
//            // Assign each value to String array 
//            
//            strqte[j] = (String) quantitedemande.get(j); 
//     
//      qtedemandetext.setText(strqte[j]);
//         
//         
//    }  
        
        
        
        
    //}

    @FXML
    private void barcodeKeyTyped(KeyEvent event) {
   String c= codeabarre.getText();
        int codebarre1 = Integer.parseInt(c);
        System.out.println("entrer le code à barre:");
        
     List nomprojettext =  Superv.findnomProjetCode(codebarre1);
     List numprojettext =  Superv.findnumProjetCode(codebarre1);
     List nomvarianttext = Superv.findnomVariantCode(codebarre1);
     List numvarianttext = Superv.findnumVariantCode(codebarre1);
     List nomsvarianttext = Superv.findnomsousVariantCode(codebarre1);
     List numsvarianttext = Superv.findnumsousVariantCode(codebarre1);
     List quantitedemande=Superv.findQtedemandeCode(codebarre1); 
     List responsable=Superv.findresponsableCode(codebarre1); 
        System.out.println("liste qte" +quantitedemande);
        
        //nomprojet.setText(nomprojettext.toString());
   // numprojet.setText(numprojettext.toString());
    //nomvariant.setText(nomvarianttext.toString());
    //numvariant.setText(numvarianttext.toString());
  // nomsousvariant.setText(nomsvarianttext.toString());
     //  numsousvar.setText(numsvarianttext.toString());
    // responsabletext.setText(responsable.toString());
        
      String  qteprevue1 = String.valueOf(quantitedemande.get(0)); 
      qtedemandetext.setText( qteprevue1);
      

       List dateprévu=Superv.findDatePrevuCode(codebarre1);
        
        List dateeditionordre=Superv.findDateOrdreCode(codebarre1);
//        dateprévu.setText((String) text6.get(l));
//            
            Date now = new Date();
//        Set date format as you want
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yy"); 
        this.dateedition.setText(sf.format(now));
         this.dateedition.setText(dateeditionordre.get(0).toString());
          this.dateprevu.setText(sf.format(now));
         this.dateprevu.setText(dateprévu.get(0).toString());
         
        
        String str[] = new String[numsvarianttext.size()]; 
        for (int j = 0; j < numsvarianttext.size(); j++) { 
  
            // Assign each value to String array 
            str[j] = (String) numsvarianttext.get(j); 
         
       
          List Etape = ET.findListEtapesSV( str[j]); 
        System.out.println(Etape);
         ObservableList<Projet> liste = FXCollections.observableArrayList(Etape);
         comboetape.setItems(liste);
             
        } 
        String strpr[] = new String[nomprojettext.size()]; 
        for (int j = 0; j < nomprojettext.size(); j++) { 
  
            // Assign each value to String array 
            strpr[j] = (String) nomprojettext.get(j); 
         nomprojet.setText( strpr[j]);
         
         
    }
        String strprnum[] = new String[numprojettext.size()]; 
        for (int j = 0; j < numprojettext.size(); j++) { 
  
            // Assign each value to String array 
            strprnum[j] = (String) numprojettext.get(j); 
       numprojet.setText(strprnum[j]);
         
         
    }
      String strvar[] = new String[nomvarianttext.size()]; 
        for (int j = 0; j < nomvarianttext.size(); j++) { 
  
            // Assign each value to String array 
            strvar[j] = (String) nomvarianttext.get(j); 
      nomvariant.setText(strvar[j]);
         
         
    }
        String strnumvar[] = new String[numvarianttext.size()]; 
        for (int j = 0; j < numvarianttext.size(); j++) { 
  
            // Assign each value to String array 
            strnumvar[j] = (String) numvarianttext.get(j); 
     numvariant.setText(strnumvar[j]);       
    }  
        
        String strsousvar[] = new String[nomsvarianttext.size()]; 
        for (int j = 0; j < nomsvarianttext.size(); j++) { 
  
            // Assign each value to String array 
            strsousvar[j] = (String) nomsvarianttext.get(j); 
     nomsousvariant.setText(strsousvar[j]);
         
         
    }  
         String strsousvarnum[] = new String[numsvarianttext.size()]; 
        for (int j = 0; j < numsvarianttext.size(); j++) { 
  
            // Assign each value to String array 
            strsousvarnum[j] = (String) numsvarianttext.get(j); 
     numsousvar.setText(strsousvarnum[j]);
         
         
    }  
        String strresp[] = new String[responsable.size()]; 
        for (int j = 0; j < responsable.size(); j++) { 
  
            // Assign each value to String array 
            strresp[j] = (String) responsable.get(j); 
     responsabletext.setText(strresp[j]);
     
    }
    }
}
     
    
    

