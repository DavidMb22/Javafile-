/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryDao;

import LibraryModel.Client;
import LibraryUtil.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ngabo David
 */
public class ClientDao {
    Session session = null;
    public void saveClient(Client c){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
    }
   public void updateClient(Client c){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(c);
        tx.commit();
        session.close();
    } 
    
   public void deleteClient(Client c){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
        session.close();
    }
   
   public List<Client> displayClient(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Client> clients = (List<Client>) session.createCriteria(Client.class);
        tx.commit();
        session.close();
        return clients;
    } 
   
   public List<Client> findByClientId(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Client> clients = (List<Client>) session.createCriteria(Client.class).add(Restrictions.eq("regno", id));
        tx.commit();
        session.close();
        return clients;
    } 
   public  List<Client>listAll(){
        List<Client>cl = null;
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
        Query q = ss.createQuery("from Client");
        return q.list();
    } 
}
