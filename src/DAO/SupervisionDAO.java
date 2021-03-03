/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entites.Etape;
import Entites.Sousvariant;
import Entites.Supervision;
import java.util.Date;
import java.util.List;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author HP
 */
public class SupervisionDAO implements SupervisionDAOInterface<Supervision> {
     public Session session;
Supervision SV;
    @Override
    public void insert(Supervision sv) {
    
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        System.out.println("sur persist");
        session.save(sv);
        tx.commit();
        System.out.println("sous commit");

        session.close();
        System.out.println("close session");
         //To change body of generated methods, choose Tools | Templates.
      }

    @Override
    public void delete(Supervision t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Supervision t) {
          session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.merge(t);
        session.flush();

        tx.commit();

        session.close();
        }

    public List <String> findListOrdre(String statutSousvariant ) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();

        List noms;
         statutSousvariant= "en cours";
         noms = session.createCriteria(Supervision.class)
                 .setProjection(Projections.property("nomSousvariant"))
                 .add(Restrictions.like("statutSousvariant",statutSousvariant ))
                
                 .list();
       // statutSousvariant StatutSousvariant=(statutSousvariant)criteria.uniqueResult();
//        long employeeId = 25;
// 
//        try {
//            session.beginTransaction();
             
//            Criteria criteria = session.createCriteria(Employee.class);
//            criteria.add(Restrictions.eq("id", employeeId));
//                
         
        tx.commit();
        session.close();
        return noms;
        }
     public List <Supervision> findEtapefinies(String numeroSousvariant,String statutEtape ) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();

        List noms;
        statutEtape= "finie";
         noms = session.createCriteria(Supervision.class)
//                 .setProjection(Projections.property("nomEtape"))
//                 .setProjection(Projections.property("quantiteProduiteEtape"))
                 .add(Restrictions.like("numeroSousvariant",numeroSousvariant ))
                 .add(Restrictions.like("statutEtape",statutEtape ))
                
                 .list();
       // statutSousvariant StatutSousvariant=(statutSousvariant)criteria.uniqueResult();
//        long employeeId = 25;
// 
//        try {
//            session.beginTransaction();
             
//            Criteria criteria = session.createCriteria(Employee.class);
//            criteria.add(Restrictions.eq("id", employeeId));
//                
         
        tx.commit();
        session.close();
        return noms;
        }


    public List <Sousvariant>  findnum_serieSousVariant(String nom_sous_variant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("numeroSousvariant"))
                .add(Restrictions.like("nomSousvariant", nom_sous_variant))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
    public List<Date> findDatePrevu(String nomsousvariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List Date;
        Date = session.createCriteria(Supervision.class).setProjection(Projections.property("datePrevu"))
                .add(Restrictions.like("nomSousvariant", nomsousvariant))
                
                .list();
        tx.commit();
        session.close();
        return Date;
    }
      public List<Date> findDateOrdre(String nomsousvariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List Date;
        Date = session.createCriteria(Supervision.class).setProjection(Projections.property("dateEditionOrdre"))
                .add(Restrictions.like("nomSousvariant", nomsousvariant))
                
                .list();
        tx.commit();
        session.close();
        return Date;
    }
      
     public List <Supervision>  findnomVariant(String nom_sous_variant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("nomVariant"))
                .add(Restrictions.like("nomSousvariant", nom_sous_variant))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
     public List <String>  findQTEdemande(String nomSousvariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("quantiteDemande"))
                .add(Restrictions.like("nomSousvariant", nomSousvariant))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
      public List <String>  findQTEdemande() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Sousvariant.class).setProjection(Projections.property("quantiteDemande"))
              
                .list();
        tx.commit();
        session.close();
        return noms;
        }
       public List <Supervision>  findQTEProduiteEtape (String numeroSousvariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
       
         //statutEtape= "finie";
         noms = session.createCriteria(Supervision.class)
//                 .setProjection(Projections.property("nomSousvariant")).setProjection(Projections.property("nomEtape"))
//               .setProjection(Projections.property("quantiteProduiteEtape"))
                 .add(Restrictions.like("numeroSousvariant",numeroSousvariant ))
                
                 .list();
       
        tx.commit();
        session.close();
        return noms;
        }
        public List <Supervision>  findQTEProduiteEtapesuperv (String numeroSousvariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
       
         //statutEtape= "finie";
         noms = session.createCriteria(Supervision.class)
//                 .setProjection(Projections.property("nomSousvariant")).setProjection(Projections.property("nomEtape"))
               .setProjection(Projections.property("quantiteProduiteEtape"))
                 .add(Restrictions.like("numeroSousvariant",numeroSousvariant ))
                
                 .list();
       
        tx.commit();
        session.close();
        return noms;
        }
     
      public List <Supervision> findnumVariant (String nom_sous_variant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("numeroVariant"))
                .add(Restrictions.like("nomSousvariant", nom_sous_variant))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
       public List <Supervision> findnomProjet (String nom_sous_variant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("nomProjet"))
                .add(Restrictions.like("nomSousvariant", nom_sous_variant))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
        public List <Supervision> findnumProjet (String nom_sous_variant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("numeroProjet"))
                .add(Restrictions.like("nomSousvariant", nom_sous_variant))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
       public List <String> findResponsable (String nom_sous_variant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("responsable"))
                .add(Restrictions.like("nomSousvariant", nom_sous_variant))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
public List <Supervision> findnomsousVariantCode (int codeBarre) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("nomSousvariant"))
                .add(Restrictions.like("codeBarre", codeBarre))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
   
     public List <Supervision> findnumsousVariantCode (int codeBarre) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("numeroSousvariant"))
                .add(Restrictions.like("codeBarre", codeBarre))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
      public List <Supervision> findnomVariantCode (int codeBarre) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("nomVariant"))
                .add(Restrictions.like("codeBarre", codeBarre))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
      public List <Supervision> findnumVariantCode (int codeBarre) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("numeroVariant"))
                .add(Restrictions.like("codeBarre", codeBarre))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
       public List <Supervision> findnomProjetCode (int codeBarre) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("nomProjet"))
                .add(Restrictions.like("codeBarre", codeBarre))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
        public List <Supervision> findnumProjetCode (int codeBarre) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("numeroProjet"))
                .add(Restrictions.like("codeBarre", codeBarre))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
         public List <Supervision> findresponsableCode (int codeBarre) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("responsable"))
                .add(Restrictions.like("codeBarre", codeBarre))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
          public List <String> findQtedemandeCode (int codeBarre) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("quantiteDemande"))
                .add(Restrictions.like("codeBarre", codeBarre))
                .list();
        tx.commit();
        session.close();
        return noms;
        }
           public List<Date> findDatePrevuCode (int codeBarre) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List Date;
        Date = session.createCriteria(Supervision.class).setProjection(Projections.property("datePrevu"))
                .add(Restrictions.like("codeBarre", codeBarre))
                
                .list();
        tx.commit();
        session.close();
        return Date;
    }
      public List<Date> findDateOrdreCode (int codeBarre) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List Date;
        Date = session.createCriteria(Supervision.class).setProjection(Projections.property("dateEditionOrdre"))
                .add(Restrictions.like("codeBarre", codeBarre))
                
                .list();
        tx.commit();
        session.close();
        return Date;
    }
      
       public List<Date> findDebutprodOrdreCode (String nomSousvariant,String statutEtape) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List Date;
        statutEtape= "finie";
        Date = session.createCriteria(Supervision.class)
                .setProjection(Projections.property("dateDebutProduction"))
                .add(Restrictions.like("nomSousvariant", nomSousvariant))
                .add(Restrictions.like("statutEtape", statutEtape))
                .list();
        tx.commit();
        session.close();
        return Date;
    }
       
        public List<Date> findDatescannCode (String nomSousvariant,String statutEtape) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List Date;
         statutEtape= "finie";
        Date = session.createCriteria(Supervision.class).setProjection(Projections.property("dateActuelleScan"))
                .add(Restrictions.like("nomSousvariant", nomSousvariant))
                 .add(Restrictions.like("statutEtape", statutEtape))
                .list();
        tx.commit();
        session.close();
        return Date;
    }
        public List<String> findnomEtape(String numeroSousvariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Supervision.class).setProjection(Projections.property("nomEtape"))
                .add(Restrictions.like("numeroSousvariant", numeroSousvariant))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
         public List<Date> findcalculscan(String nomsousvariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List Date;
        Date = session.createCriteria(Supervision.class).setProjection(Projections.property("calculDateScan"))
                .add(Restrictions.like("nomSousvariant", nomsousvariant))
                
                .list();
        tx.commit();
        session.close();
        return Date;
    }

}
   
   
    

