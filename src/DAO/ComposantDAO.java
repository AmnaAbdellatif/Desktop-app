/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entites.Composant;
import Entites.Etape;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author HP
 */
public class ComposantDAO implements ComposantDAOInterface<Composant> {
      
    public Session session;
    Composant Cp;
    
     public List<Composant>  findlistComposant(String nomEtape) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
      //  List noms;
//        List noms = (list) session.createCriteria (Projet.class)
//                .add(Restrictions.like("numSerieSousVariant", numSerieSousVariant).list));
       List noms = (List) session.createCriteria(Composant.class)
                .add(Restrictions.like("nomEtape", nomEtape))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
     public List<Composant> findnumero_composant(String nomComposant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Etape.class)
                .add(Restrictions.like("nomComposant", nomComposant))
                .list();
        tx.commit();
        session.close();
        return noms;
    }

    @Override
    public void insert(Composant Cp) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        System.out.println("sur persist");
        session.save(Cp);
        tx.commit();
        System.out.println("sous commit");

        session.close();
        System.out.println("close session");
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Composant Cp) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(Cp);

        tx.commit();

        session.close();
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Composant t) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.merge(t);
        session.flush();

        tx.commit();

        session.close();
         //To change body of generated methods, choose Tools | Templates.
    }
     public List<Composant> findListDesComposants(String nomSousVariant) {
         
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
         System.out.println("dans find");
        List<Composant> noms = session.createCriteria(Composant.class)
                .add(Restrictions.like("nomSousVariant",nomSousVariant))
                .list();
        tx.commit();
        session.close();
        return noms;
    } 
     public List<Composant> findComposant(String numeroEtape) {
     
         
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
         System.out.println("dans find list des composants");
        List<Composant> noms = session.createCriteria(Composant.class)
                
                 
                .add(Restrictions.like("numeroEtape", numeroEtape))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
   
   public List<Composant> findEtapeComposant() {
     
         
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
         System.out.println("dans find list des composants");
        List<Composant> noms = session.createCriteria(Composant.class)
            .setProjection(Projections.property("nomEtape"))
                 
                
                .list();
        tx.commit();
        session.close();
        return noms;
    }
   public List<Composant> findnumeroetape(String nomEtape) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Composant.class).setProjection(Projections.property("numeroEtape"))
                .add(Restrictions.like("nomEtape", nomEtape))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
//   public List<Composant> findnumero_etape(String nomEtape) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.getTransaction();
//        session.beginTransaction();
//        List noms;
//        noms = session.createCriteria(Composant.class)
//                .add(Restrictions.like("nomEtape", nomEtape))
//                .list();
//        tx.commit();
//        session.close();
//        return noms;
//    }
   
     
}
