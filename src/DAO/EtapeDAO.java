/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entites.Etape;
import Entites.Sousvariant;
import Entites.Supervision;
import Entites.Variant;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author HP
 */
public class EtapeDAO  implements EtapeDAOInterface<Etape> {
    public Session session;
    Etape et;
    
     public List<Etape>  findlistEtape(String numSerieSousVariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
      //  List noms;
//        List noms = (list) session.createCriteria (Projet.class)
//                .add(Restrictions.like("numSerieSousVariant", numSerieSousVariant).list));
       List noms = (List) session.createCriteria(Etape.class)
                .add(Restrictions.like("numSerieSousVariant", numSerieSousVariant))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
     public List<Etape> findListDesEtapes(String nomSousVariant) {
         
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
         System.out.println("dans find");
        List<Etape> noms = session.createCriteria(Etape.class)
                .add(Restrictions.like("nomSousVariant",nomSousVariant))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
      public List<Etape> findListEtapesSV(String numSerieSousVariant) {
         
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
         System.out.println("dans find");
        List<Etape> noms = session.createCriteria(Etape.class)
                .add(Restrictions.like("numSerieSousVariant",numSerieSousVariant)).setProjection(Projections.property("nomEtape"))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
      public List<String> findnumero_etape(String numSerieSousVariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Etape.class).setProjection(Projections.property("numeroEtape"))
                .add(Restrictions.like("numSerieSousVariant", numSerieSousVariant))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
      public List<String> findnum_etape(String nomEtape) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Etape.class).setProjection(Projections.property("numeroEtape"))
                .add(Restrictions.like("nomEtape", nomEtape))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
       public List<Etape> findtempsprevu (String numSerieSousVariant,String statutEtape) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        statutEtape= "finie";
        noms = session.createCriteria(Etape.class)
                //.setProjection(Projections.property("tempsPrevuEtape"))
                .add(Restrictions.like("numSerieSousVariant", numSerieSousVariant))
                .add(Restrictions.like("statutEtape", statutEtape))
                
                .list();
        tx.commit();
        session.close();
        return noms;
    }
        public List<Date> findtempsprevucalcul (String numSerieSousVariant,String statutEtape) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        statutEtape= "finie";
        noms = session.createCriteria(Etape.class)
                .setProjection(Projections.property("tempsPrevuEtape"))
                .add(Restrictions.like("numSerieSousVariant", numSerieSousVariant))
                .add(Restrictions.like("statutEtape", statutEtape))
                
                .list();
        tx.commit();
        session.close();
        return noms;
    }
       public List<String> findnbreOuvrier(String numSerieSousVariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        
        noms = session.createCriteria(Etape.class)
                .setProjection(Projections.property("nombreOuvrier"))
                .add(Restrictions.like("numSerieSousVariant", numSerieSousVariant))
                               
                .list();
        tx.commit();
        session.close();
        return noms;
    }
      
       
    

    @Override
    public void insert(Etape t) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.save(t);

        tx.commit();

        session.close();
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Etape t) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(t);

        tx.commit();

        session.close();
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Etape t) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.merge(t);
        session.flush();

        tx.commit();

        session.close();
        //To change body of generated methods, choose Tools | Templates.
    }
    public List<Etape> findListDesEtapes() {
     
         
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
         System.out.println("dans find list des Etapes");
        List<Etape> noms = session.createCriteria(Etape.class)
                .setProjection(Projections.property("nomEtape"))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
     public List<Etape> findnumeroetape(String nomEtape) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Etape.class)
                .add(Restrictions.like("nomEtape", nomEtape))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
      public List <Etape> findListEtapenonfinie(String numSerieSousVariant,String  statutEtape ) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();

        List noms;
         statutEtape= "non finie";
         noms = session.createCriteria(Etape.class)
                 .setProjection(Projections.property("nomEtape"))
                 .add(Restrictions.like("numSerieSousVariant",numSerieSousVariant ))
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
       public List<Etape> findetape(String nomEtape) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Etape.class)
                .add(Restrictions.like("nomEtape", nomEtape))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
       
       
}
