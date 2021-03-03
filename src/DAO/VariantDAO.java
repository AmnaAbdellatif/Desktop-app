/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entites.Projet;
import Entites.Variant;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author hp
 */
public class VariantDAO implements VariantDAOInterface<Variant> {

    public Session session;
    Variant vr;

   public List<Variant> findlistVariant(String nom_projet) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Variant.class).setProjection(Projections.property("nomVariant"))
                .add(Restrictions.like("nomProjet", nom_projet))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
  
    public List<Variant> findnum_serieVariant(String nom_variant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Variant.class).setProjection(Projections.property("numSerieVariant"))
                .add(Restrictions.like("nomVariant", nom_variant))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
    
    public void insert1(Projet p,Variant vr) {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        System.out.println("sur persist");
         session.save(p);
       // vr.setProjet(p);
        session.save(vr);
        tx.commit();
        System.out.println("sous commit");

        session.close();
        System.out.println("close session");
       //To change body of generated methods, choose Tools | Templates.
    }
    public List<Variant> findListDesVariant(String nomProjet) {
         
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
         System.out.println("dans find");
        List<Variant> noms = session.createCriteria(Variant.class)
                .add(Restrictions.like("nomProjet",nomProjet))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
//    public void insert(Projet p,Variant vr) {
//        session = HibernateUtil.getSessionFactory().openSession();
//        
//        Transaction tx = session.getTransaction();
//        session.beginTransaction();
//                try {
//        System.out.println("sur save projetvariant");
//        session.save(p);
//        System.out.println("entre save  p et v ");
//        session.save(vr);
//        System.out.println("sous save projetvariant");
//        session.flush();
//        System.out.println("sous flush");
//        tx.commit();
//        System.out.println("sous tx commit");
//} catch (Exception e) {
//		e.printStackTrace();
//		tx.rollback(); 
//		
//	} finally {
//        session.close();
//        System.out.println("close session");
//        
//    }
//    }

    @Override
    public void delete(Variant vr) {
       session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        System.out.println("sur delete");
        session.delete(vr);
        System.out.println("sous delete");

        tx.commit();

        session.close();  }

    @Override
    public void update(Variant vr) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.merge(vr);
        session.flush();

        tx.commit();

        session.close();
         //To change body of generated methods, choose Tools | Templates.
    }

    public List<Variant> findVariant() {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Variant.class).setProjection(Projections.property("nomVariant"))
      
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }
   
     public List<Variant> findnumVariant(String nomSousVariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Variant.class).setProjection(Projections.property("numSerieVariant"))
                .add(Restrictions.like("nomSousVariant", nomSousVariant))
                .list();
        tx.commit();
        session.close();
        return noms;
    }


    @Override
    public void insert(Variant vr) {
    session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        System.out.println("sur persist");
        session.save(vr);
        tx.commit();
        System.out.println("sous commit");

        session.close();
        System.out.println("close session");
    }

    public List<Variant> findlistDesVariant(String nomProjet){
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        
        List  noms = (List)session.createCriteria(Variant.class)
                .add(Restrictions.like("nomProjet", nomProjet))
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }
   
    public List<Projet> findProjet(String nomVariant){
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        
         List noms = session.createCriteria(Variant.class).setProjection(Projections.property("nomProjet"))
                .add(Restrictions.like("nomVariant", nomVariant))
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }
    public List<Projet> findnumProjet(String nomVariant){
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        
         List noms = session.createCriteria(Variant.class).setProjection(Projections.property("nProjet"))
                .add(Restrictions.like("nomVariant", nomVariant))
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }
   

}  


