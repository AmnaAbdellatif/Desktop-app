/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entites.Projet;
import Entites.Variant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.collections.ObservableList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author hp
 */
public class ProjetDAO implements PersonneDAOInterface<Projet> {

    public Session session;
    Projet pr;

    public List<Projet> findListProjet() {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();

        List noms = session.createCriteria(Projet.class)
                .setProjection(Projections.property("nomProjet"))
                .list();
        // System.out.println("nb personnes = " + noms.size());
        Iterator it = noms.iterator();
        while (it.hasNext()) {
            String nom_projet = (String) it.next();
            System.out.println("Projet : " + nom_projet);
        }
        tx.commit();
        session.close();
        return noms;
    }
    public List<Projet> findlistDesProjets(){
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        
        List  noms = (List)session.createCriteria(Projet.class)
                .list();
        tx.commit();
        session.close();
        return noms;
        
    }
//            
//    public List<Projet> findnumero_serie(String nom_projet) {
//   session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = session.getTransaction();
//        session.beginTransaction();
//        List noms;
//        noms = session.createCriteria(Projet.class).setProjection(Projections.property("numeroSerie"))
//                .add(Restrictions.like("nom_variant", nom_projet))
//                .list();
//        tx.commit();
//        session.close();
//        return noms;
//    }
     public List<Projet> findnumero_serie1(String nom_projet) {
   session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        List noms;
        noms = session.createCriteria(Projet.class).setProjection(Projections.property("numeroSerie"))
                .add(Restrictions.like("nomProjet", nom_projet))
                .list();
        tx.commit();
        session.close();
        return noms;
    }
    

    @Override
    public void insert(Projet pr) {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.save(pr);
        tx.commit();

        session.close(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Projet pr) {
        
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(pr);

        tx.commit();

        session.close(); //To change body of generated methods, choose Tools | Templates.
        }

    @Override
    public void update(Projet pr) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.merge(pr);
        session.flush();
        tx.commit();

        session.close();
        //To change body of generated methods, choose Tools | Templates.
    }

    

}
