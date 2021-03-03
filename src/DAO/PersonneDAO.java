/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entites.Personne;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nourhane
 */
public class PersonneDAO implements PersonneDAOInterface<Personne> {

    static Session session = null;
        private Session currentSession;
     
    private Transaction currentTransaction;
 
    public PersonneDAO() {
    }
    Personne findObj;
//    public Session openCurrentSession() {
//        currentSession = getSessionFactory().openSession();
//        return currentSession;
//    }
// 
//    public Session openCurrentSessionwithTransaction() {
//        currentSession = getSessionFactory().openSession();
//        currentTransaction = currentSession.beginTransaction();
//        return currentSession;
//    }
//     
//    public void closeCurrentSession() {
//        currentSession.close();
//    }
//     
//    public void closeCurrentSessionwithTransaction() {
//        currentTransaction.commit();
//        currentSession.close();
//    }
//     
//    private static SessionFactory getSessionFactory() {
//        Configuration configuration = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties());
//        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
//        return sessionFactory;
//    }
// 
//    public Session getCurrentSession() {
//        return currentSession;
//    }
// 
//    public void setCurrentSession(Session currentSession) {
//        this.currentSession = currentSession;
//    }
// 
//    public Transaction getCurrentTransaction() {
//        return currentTransaction;
//    }
// 
//    public void setCurrentTransaction(Transaction currentTransaction) {
//        this.currentTransaction = currentTransaction;
//    }
//    
//    


    @Override
    public void insert(Personne prs) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.save(prs);

        tx.commit();

        session.close();
    }

   

    @Override
    public void delete(Personne t) {
       session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.delete(t);

        tx.commit();

        session.close();
    }

    @Override
    public void update(Personne t) {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();
        session.merge(t);
        session.flush();
        tx.commit();

        session.close();
       //To change body of generated methods, choose Tools | Templates.
    }
    
    public Personne findbylogin(String Login, String motPasse) {
       // Personne findObj = null;
        try {
            System.out.println("dans fonction");
            // Getting Session Object From SessionFactory
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.getTransaction();
            session.beginTransaction();

            findObj = (Personne) session.get(Personne.class,Login);
              findObj = (Personne) session.get(Personne.class,motPasse);
        } catch (Exception sqlException) {
            if (null != session.getTransaction()) {
              //  logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return findObj;
        
    }
    public Personne findbymotPasse( String motPasse) {
       // Personne findObj = null;
        try {
            System.out.println("dans fonction");
            // Getting Session Object From SessionFactory
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.getTransaction();
            session.beginTransaction();
               findObj = (Personne) session.get(Personne.class,motPasse);
        } catch (Exception sqlException) {
            if (null != session.getTransaction()) {
              //  logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                session.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return findObj;
        
    }
    public List findListdesPersonnes() {
         session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.getTransaction();
        session.beginTransaction();

        List noms = session.createCriteria(Personne.class)
                 
                .list();
        tx.commit();
        session.close();
        return noms;
    }

   

    
    

    

   

    

}
