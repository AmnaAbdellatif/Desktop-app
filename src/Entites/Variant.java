package Entites;
// Generated 7 juin 2019 19:30:34 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Variant generated by hbm2java
 */
public class Variant  implements java.io.Serializable {


     private String numSerieVariant;
     private Projet projet;
     private String nomVariant;
     private String responsable;
     private String nomProjet;
     private Set sousvariants = new HashSet(0);

    public Variant() {
    }

	
    public Variant(String numSerieVariant, Projet projet, String nomVariant, String responsable, String nomProjet) {
        this.numSerieVariant = numSerieVariant;
        this.projet = projet;
        this.nomVariant = nomVariant;
        this.responsable = responsable;
        this.nomProjet = nomProjet;
    }
    public Variant(String numSerieVariant, Projet projet, String nomVariant, String responsable, String nomProjet, Set sousvariants) {
       this.numSerieVariant = numSerieVariant;
       this.projet = projet;
       this.nomVariant = nomVariant;
       this.responsable = responsable;
       this.nomProjet = nomProjet;
       this.sousvariants = sousvariants;
    }
   
    public String getNumSerieVariant() {
        return this.numSerieVariant;
    }
    
    public void setNumSerieVariant(String numSerieVariant) {
        this.numSerieVariant = numSerieVariant;
    }
    public Projet getProjet() {
        return this.projet;
    }
    
    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    public String getNomVariant() {
        return this.nomVariant;
    }
    
    public void setNomVariant(String nomVariant) {
        this.nomVariant = nomVariant;
    }
    public String getResponsable() {
        return this.responsable;
    }
    
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    public String getNomProjet() {
        return this.nomProjet;
    }
    
    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }
    public Set getSousvariants() {
        return this.sousvariants;
    }
    
    public void setSousvariants(Set sousvariants) {
        this.sousvariants = sousvariants;
    }




}


