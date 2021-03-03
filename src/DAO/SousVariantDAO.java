/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


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
 * @author hp
 */
public class SousVariantDAO implements SousVariantDAOInterface<Sousvariant> {

    public Session session;
    Sousvariant Svr;
   
  
 
    

   public List <Sousvariant>  findlistSousVariant(String nom_variant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms =  session.createCriteria(Sousvariant.class).setProjection(Projections.property("nomSousVariant"))
                .add(Restrictions.like("nomVariant", nom_variant))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
   public List<Sousvariant> findnomVariant(String nomSousVariant) {
   session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Sousvariant.class).setProjection(Projections.property("nomVariant"))
                .add(Restrictions.like("nomSousVariant", nomSousVariant))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
   public List<Sousvariant> findnumVariant(String nomSousVariant) {
   session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Sousvariant.class).setProjection(Projections.property("Variant"))
                .add(Restrictions.like("nomSousVariant", nomSousVariant))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
   public List<Date> findDatePrevu(String nomSousVariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List Date;
        Date = session.createCriteria(Supervision.class).setProjection(Projections.property("datePrevu"))
                .add(Restrictions.like("nomSousvariant", nomSousVariant))
                
                .list();
        tx.commit();
        session.close();
        return Date;
    }
   
    public List<Date> findDateOrdre(String nomSousVariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List Date;
        Date = session.createCriteria(Supervision.class).setProjection(Projections.property("dateEditionOrdre"))
                .add(Restrictions.like("nomSousvariant",  nomSousVariant))
                
                .list();
        tx.commit();
        session.close();
        return Date;
    }
   public List<String>  findcode_barre(String nomSousVariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms =  session.createCriteria(Sousvariant.class).setProjection(Projections.property("codeBarre"))
                .add(Restrictions.like("nomSousVariant", nomSousVariant))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
    public List<String> findnum_serieSousVariant(String nom_sous_variant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Sousvariant.class).setProjection(Projections.property("numSerieSousVariant"))
                .add(Restrictions.like("nomSousVariant", nom_sous_variant))
                .list();
        tx.commit();
        session.close();
        return noms;
    }

    

    @Override
    public void insert(Sousvariant Svr) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        System.out.println("sur persist");
        session.save(Svr);
        tx.commit();
        System.out.println("sous commit");

        session.close();
        System.out.println("close session");
    //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Sousvariant Svar) {
      session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(Svar);

        tx.commit();

        session.close();  }

    @Override
    public void update(Sousvariant Svr) {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.merge(Svr);
        session.flush();

        tx.commit();

        session.close();
    //To change body of generated methods, choose Tools | Templates.
    }

   public List<Sousvariant> findlistSousVariant() {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Sousvariant.class).setProjection(Projections.property("nomSousVariant"))

      
                .list();
      
                
        tx.commit();
        session.close();
        return noms;
   }
   
//   public List<Sousvariant> findlistDesSVariant(){
//         session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.getTransaction();
//        session.beginTransaction();
//        
//        List  noms = (List)session.createCriteria(Sousvariant.class)
//                .list();
//        tx.commit();
//        session.close();
//        return noms;
//        
//    }
   public List <Sousvariant>  findlistDESSousVariant(String nomVariant) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = (List) session.createCriteria(Sousvariant.class)
                .add(Restrictions.like("nomVariant", nomVariant))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
   


  
    
    

   
        
    }

    

    
      
    

    




