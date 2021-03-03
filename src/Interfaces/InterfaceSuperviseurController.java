
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.EtapeDAO;
import DAO.ProjetDAO;
import DAO.SousVariantDAO;
import DAO.SupervisionDAO;
import DAO.VariantDAO;
import Entites.Composant;
import Entites.Etape;
import Entites.Projet;
import Entites.Supervision;
import com.sun.javafx.scene.control.SelectedCellsMap;
import java.io.IOException;
import static java.lang.Math.E;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import static javassist.CtMethod.ConstParameter.integer;
import static org.hibernate.type.descriptor.java.DateTypeDescriptor.DATE_FORMAT;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class InterfaceSuperviseurController implements Initializable {

    @FXML
    private AnchorPane B;
    @FXML
    private Button menuprincipal;
    @FXML
    private Hyperlink hyperlink;
    private ComboBox  statutvariant;
    @FXML
    private TextField textdate;
    @FXML
    private TextField nomvariant;
    @FXML
    private TextField numvariant;
    @FXML
    private TextField nomsv;
    @FXML
    private TextField numsv;
    @FXML
    private TextField numprojet;
    @FXML
    private TextField nomprojet;
    @FXML
    private TextField dateedition;
    @FXML
    private TextField dateprévu;
    @FXML
    private Button datejour;
    
  public Supervision statut;
    @FXML
    private TextField qprévue;
    private ListView  listnonfinie;
    
     
    @FXML
    private TableView tableEtape;
    private TableColumn  colonneetapefinies;
    private TableColumn quantitéproduite;
    private TableColumn  dateréelle;
    private TableColumn  dateprevu;
    @FXML
    private ComboBox comboprojet;
    @FXML
    private ComboBox combovariant;
    @FXML
    private ComboBox combosousvariant;
    
    @FXML
    private TableColumn  colonnenomEtape;
   
    @FXML
    private TableColumn statutetape;
    @FXML
    private TableColumn tpsprévu;
    @FXML
    private TableColumn nbouvrier;
    @FXML
    private TableColumn etapefinie;
    @FXML
    private TableColumn quantiteproduite;
    private TableColumn tempsréel;
    @FXML
    private TableView tablesupervision;
    @FXML
    private Label nbquantitetotal;
    @FXML
    private Label nbtpsréeltotal;
    @FXML
    private Label nbouvriertotal;
    
   ObservableList<Supervision> qteproduite = FXCollections.observableArrayList();
      ObservableList<Supervision> listeetapefinie = FXCollections.observableArrayList();
   
    ObservableList<Etape> nombreouvrier = FXCollections.observableArrayList();
     ObservableList<Integer> qteproduite1 = FXCollections.observableArrayList();
     List<Integer> liste2 = new ArrayList<Integer>();
      ObservableList<Integer> nbouvrier1 = FXCollections.observableArrayList();
    List<Integer> liste22 =  new ArrayList<Integer>();
    List<Date> listecalcul =  new ArrayList<Date>();
     List<Integer> listesomme =  new ArrayList<Integer>();
      List<Date> listesommeprevu =  new ArrayList<Date>();
         List<Integer> listecommeprevu =  new ArrayList<Integer>();
     // List<String> listeenstring =  new ArrayList<String>();
     ObservableList<String> listedate1= FXCollections.observableArrayList();
   // List<Date> listetempsprevu =  new ArrayList<Date>();
    ObservableList<String> listevide = FXCollections.observableArrayList();
    // ObservableList<String> listetempsprevu = FXCollections.observableArrayList();
  
       List<Date> listetempsprevu =  new ArrayList<Date>();
      Supervision Pr = new Supervision();
      SupervisionDAO Superv = new SupervisionDAO();
      Etape ET = new Etape();
      EtapeDAO Et = new EtapeDAO();
      ProjetDAO pr = new ProjetDAO();
      VariantDAO vr = new VariantDAO();
      SousVariantDAO Svr = new SousVariantDAO();
    
    @FXML
    private TextField textproduitperdu;
    private ListView listtempsreel;
    private VBox vbox;
    @FXML
    private ListView listviewtemps;
    @FXML
    private ListView  listviewtemps1;
    @FXML
    private TextField productivité;
    @FXML
    private TextField tempsperdu;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colonnenomEtape.setCellValueFactory(new PropertyValueFactory<Etape, String>("nomEtape"));//le meme nom du paramètre numéro serie qui existe dans la classe Etape
       statutetape .setCellValueFactory(new PropertyValueFactory<Etape,Supervision>("statutEtape"));
        tpsprévu.setCellValueFactory(new PropertyValueFactory<Etape, String>("tempsPrevuEtape"));
        nbouvrier.setCellValueFactory(new PropertyValueFactory<Etape, String>("nombreOuvrier"));//le meme nom du paramètre numéro serie qui existe dans la classe Etape
        //colonnetempsreel.setCellValueFactory(new PropertyValueFactory<Supervision,String>("quantiteProduiteEtape"));
          etapefinie.setCellValueFactory(new PropertyValueFactory<Supervision,String>("nomEtape"));
       quantiteproduite.setCellValueFactory(new PropertyValueFactory<Supervision, Supervision>("quantiteProduiteEtape"));
//        tempsréel.setCellValueFactory(new PropertyValueFactory<Supervision, Date>("nombreOuvrier"));//le meme nom du paramètre numéro serie qui existe dans la classe Etape
        //colonnetempsreel.setCellValueFactory(new PropertyValueFactory<Supervision,String>("quantiteProduiteEtape"));
        
//       //  dateréelle.setCellValueFactory(new PropertyValueFactory<Supervision, Date>("datePrevu"));
        
         tableEtape.setItems(nombreouvrier);
          //tablesupervision.setItems(qteproduite);
          tablesupervision.setItems(listeetapefinie);
           // colonnetemspprévu.setCellValueFactory(new PropertyValueFactory<>(listetemps.toString()));
                     
        // TODO
         
//          List statut =   Superv.findListOrdre((String) statutvariant.getSelectionModel().getSelectedItem());
//          
//         
//       ObservableList<Supervision> listesousvariant = FXCollections.observableArrayList(statut);
//       statutvariant.setItems(listesousvariant);
//       
       List liste =pr.findListProjet();
            ObservableList<Projet> listeprojet = FXCollections.observableArrayList(liste);
//       ObservableList<Supervision> listesousvariant = FXCollections.observableArrayList(statut);
       comboprojet.setItems(listeprojet);
        comboprojet.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue observable, Object oldValue, Object newValue) -> affichecombovariant((String) newValue));
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
        textdate.setText( ""+mediumDateFormat.format(aujourdhui));   
               
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
    private void handlemenuButtonAction(ActionEvent event) throws IOException {
        Parent test2_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene test2_scene = new Scene(test2_parent);

        Stage test1_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        test1_stage.setTitle("Bienvenue");
        test1_stage.setScene(test2_scene);
        test1_stage.show();
    }

    @FXML
    private void handle(ActionEvent event) {
    }

    @FXML
    private void dateonaction(ActionEvent event) {
         Date now = new Date();

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        // Model Data
        String dateTimeString = df.format(now);

        // Show in VIEW
       textdate.setText(dateTimeString);
        
    }
      

    private void affichecombovariant(String string) {
        Object Pr =comboprojet.getSelectionModel().getSelectedItem();
        nomprojet.setText(Pr.toString());
         List text4=pr.findnumero_serie1(Pr.toString());
        int a= 0; 
        numprojet.setText((String) text4.get(a));
        

            List liste = vr.findlistVariant(Pr.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
          
             combovariant.setItems(data);
    }

    @FXML
    private void variantonaction(ActionEvent event) {
        
         Object pr =combovariant.getSelectionModel().getSelectedItem();
          
        nomvariant.setText(pr.toString());
        List text3=vr.findnum_serieVariant(pr.toString());
        int k=0;
        numvariant.setText((String) text3.get(k));
     
            List liste = Svr.findlistSousVariant(pr.toString());
            ObservableList<String> data = FXCollections.observableArrayList(liste);
           
             combosousvariant.setItems(data);
    }

    @FXML
    private void sousvariantonaction(ActionEvent event) throws ParseException  {
        tableEtape.refresh();
        tablesupervision.refresh();
          Object pr =combosousvariant.getSelectionModel().getSelectedItem();
         
         nomsv.setText(pr.toString());
        List text1=Svr.findnum_serieSousVariant(pr.toString());
        int i= 0; 
       numsv.setText((String) text1.get(i));
        
       
        
        List text6=Svr.findDatePrevu(pr.toString());

        int l= 0; 
        List text7=Svr.findDateOrdre(pr.toString());
        //dateprévu.setText((String) text6.get(l));
            System.out.println("textdate" +text6.get(l));
            Date now = new Date();
        //Set date format as you want
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yy"); 
        this.dateprévu.setText(sf.format(now));
         this.dateprévu.setText(text6.toString());
          this.dateedition.setText(sf.format(now));
         this.dateedition.setText(text7.toString());
             
         List text8=Superv.findQTEdemande(pr.toString());
//          int qteprevue = Integer.parseInt(text8.toString());
          String  qteprevue1 = String.valueOf(text8.get(0));
        int m= 0;
        
        qprévue.setText( qteprevue1);
        
        List liste = Et.findlistEtape(numsv.getText());
        liste = FXCollections.observableArrayList(liste);
            System.out.println("listefini" +liste);
        // int o = tableview.getItems().size();
tableEtape.getItems().size();
//tableEtape.setItems(liste);
 tableEtape.getItems().addAll(liste);
            System.out.println("souslistfini" +liste);
            
//             List listeQ= Superv.findQTEProduiteEtape(numsv.getText());
//        qteproduite = FXCollections.observableArrayList(listeQ);
        List listeEtapefinis= Superv.findEtapefinies(numsv.getText(),"finie");
        listeetapefinie = FXCollections.observableArrayList(listeEtapefinis);
        
            System.out.println("listefini" +liste);
        // int o = tableview.getItems().size();
tablesupervision.getItems().size();
//tableEtape.setItems(liste);
 //tablesupervision.getItems().addAll(listeQ);
 tablesupervision.getItems().addAll(listeEtapefinis);
 
           // System.out.println("listeQ" +listeQ);
            
             List nbouvrier1 = Et.findnbreOuvrier(numsv.getText());
        liste22.addAll(nbouvrier1) ;
            System.out.println("nbouvrier1" +nbouvrier1);
        
    int  S=0;
    int b;
      for (Integer note : liste22) {
    S += note;
}
     
     
 
  
//        for( b=0;b<= liste22.size();b++)
//            {
//              
//             S+=liste22.get(b);  
//            
//            }
       
        System.out.println("somme s"  +S);
    
            String quantitetotal1 = Integer.toString(S);
            nbouvriertotal.setText(quantitetotal1);
            
             List qteproduite1 = Superv.findQTEProduiteEtapesuperv(numsv.getText());
        liste2.addAll(qteproduite1);
            System.out.println("listequantité" +qteproduite1);
        
     
    int b1;
    int S1=0;
         for (Integer note1 : liste2) {
    S1 += note1;
}
    
       
        System.out.println("somme s1"  + S1);
    
            String quantitetotal = Integer.toString(S1);
            nbquantitetotal.setText(quantitetotal);
             
            
            
       
             System.out.println("somme after  s1"  + S1);
     int P=0;
        int qteprevu = Integer.parseInt(qprévue.getText());;
    
P=qteprevu-S1 ;
        System.out.println("quantitecalcul" +P);
       String quantiteperdu = Integer.toString(P);
            textproduitperdu.setText(quantiteperdu);
              
        
           

        
//            for(int b=0;b<= sommeOuvrier.size();b++)
//            {
//              S= S+i;  
//            }
           
//        nbouvriertotal.setText();
        // ObservableList<String> liste = null;
        
       
         //   System.out.println("souslistfini" +tableview.setItems(liste));
         
             
           
List x = Superv.findDebutprodOrdreCode(pr.toString(),"finie");
 System.out.println("x" +x);
List y = Superv.findDatescannCode(pr.toString(),"finie");
System.out.println("y" +y);
Date n= (Date) x.get(0);
Date n1= (Date) y.get(0);
        System.out.println("n" +n);
        System.out.println("n" +n1);
         
Calendar t1=Calendar.getInstance();
t1.setTime(n);
Calendar t2=Calendar.getInstance();
t2.setTime(n1);
long temps1=t1.getTimeInMillis();
long temps2=t2.getTimeInMillis();
long difference=temps2-temps1;
Calendar resultat=Calendar.getInstance();
resultat.setTimeInMillis(difference);
String v=(+resultat.get(Calendar.HOUR)+"h:"+resultat.get(Calendar.MINUTE)+"min:"+resultat.get(Calendar.SECOND)+"s");
//        System.out.println("difference" +difference/1000/60/60);

ObservableList<Integer> listedate = FXCollections.observableArrayList();
listedate1.add(v);
listviewtemps.setItems(listedate1);


           List ds = Superv.findDatescannCode(nomsv.getText(),"finie");
           listecalcul.addAll(ds);
//            List ds1 = Superv.findDatescannCode(nomsv.getText());
//           listevide.addAll(ds);
           System.out.println("ds" +listecalcul);
          // System.out.println("ds1" +listevide);
        int B;
       
        long dc;
        int h;
                 

            for (B=0; B<listecalcul.size();B++)

{
   try{
    dc= listecalcul.get(B+1).getTime()-listecalcul.get(B).getTime();

  String s=(+(dc%86400000)/3600000+":h"
                 +((dc%86400000)%3600000)/60000+":min"+(((dc%86400000)%3600000)%60000)/1000+"s");
    System.out.println(" datee de boucle" +s);
    listevide.add(s);
    System.out.println("listevide" +listevide);
    listviewtemps1.setItems(listevide);
     
     Integer sommeint = (int) (long) dc;
   //  
     listesomme.add(sommeint);
     int q=0  ;
         for (Integer somme: listesomme)
         {
        q+= somme; 
//        long sommedate = Long.parseLong(q);
//        
        System.out.println("s" +q);
       
  
//         
          String sommee=(q/86400000+" jours"+(q%86400000)/3600000+":h"
                 +((q%86400000)%3600000)/60000+":min"+(((q%86400000)%3600000)%60000)/1000+"s");
//        System.out.println(((+sommedate%86400000)%3600000)/60000+ "min:" +(((sommedate%86400000)%3600000)%60000)/1000 +"s");
             System.out.println("sommeeDates" +sommee );
           
             
         }
            Integer premierdate = (int) (long) difference;
           h=q+premierdate; 
           int dureeproduction=0;
           dureeproduction=h*S1;
         System.out.println("sommetotale" +h);
          System.out.println("duree production" +dureeproduction);
         
         long sommetotale=dureeproduction;
         
         String g=(dureeproduction/86400000+" jours"+(dureeproduction%86400000)/3600000+":h"
                 +((dureeproduction%86400000)%3600000)/60000+":min"+(((dureeproduction%86400000)%3600000)%60000)/1000+"s");
         System.out.println("derinier affichage" +g);
         
    nbtpsréeltotal.setText(g);
      List dp = Et.findtempsprevucalcul(numsv.getText(),"finie");
          listetempsprevu.addAll(dp);
         
//           listesommeprevu.addAll(dp);

             String j = null;
        int r = 0;
           Date r1 =new Date();
           long dpr = 0;
           
           System.out.println("liste de temps prevu" +dp);
           //Date d=(Date) dp.addAll(listetempsprevu.size());
           Calendar T=Calendar.getInstance();
//           T.setTime(d);
           long Dateprevu=T.getTimeInMillis();
           System.out.println("temps en long" +Dateprevu);
            long tempsprevu = 0;
            long sumtempsprevu =0;
            long tempsperdu=0;
         for (Date date: listetempsprevu )
         {
            tempsprevu +=date.getTime(); 
           
         
           System.out.println("somme temps prevu" +(tempsprevu/2)*S1);
           sumtempsprevu= ((tempsprevu/2)*S1);
            System.out.println("somme temps prevufinale" +sumtempsprevu);
           tempsperdu= dureeproduction-sumtempsprevu;
             System.out.println("temps perdu" +tempsperdu);
             String tempspredue=(tempsperdu/86400000+" jours"+(tempsperdu%86400000)/3600000+":h"
                 +((tempsperdu%86400000)%3600000)/60000+":min"+(((tempsperdu%86400000)%3600000)%60000)/1000+"s");
         System.out.println("derinier affichage" +tempspredue);
         
          this.tempsperdu.setText(tempspredue);
         } 
           
        double qteproduite= S1;
         double nbreOuvrier= S;
         
        
         double productivité;
         productivité=qteproduite/(dureeproduction*nbreOuvrier);
         System.out.println("productivité" +productivité);
            
String productivitéString = new Double(productivité).toString();
    this.productivité.setText(productivitéString);

  }catch(java.lang.Exception e){
            
   }
    
}

           
             
                 
           
            
       
           
   
//String numberAsString = Long.toString(dc);

//    tempsréel.setCellValueFactory(param -> {
//            return new SimpleObjectProperty<>(listevide);
//      System.out.println(resultat/86400000+" jours"+(resultat%86400000)/3600000+":"+((resultat%86400000)%3600000)/60000+":"+(((resultat%86400000)%3600000)%60000)/1000);
//           
//        });
//     System.out.println("dc" +dc);
//     h=dc/1000/60;
//    System.out.println("h" +h);
    
//SimpleDateFormat SDF = new SimpleDateFormat("HH:mm:ss");
//
//    System.out.println("sous try");
//    long resultat1 = (SDF.parse(listecalcul.get(B+1))).getTime()-(SDF.parse(listecalcul.get(B))).getTime();
//    System.out.println("sous el operation");
//   

    }
}




   
       



   
    
    

        
        
        

    
