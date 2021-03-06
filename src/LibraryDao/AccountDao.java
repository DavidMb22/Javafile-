/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryDao;

import LibraryModel.Account;
import LibraryUtil.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ngabo David
 */
public class AccountDao {
     Session session = null;
 public void createAccount(Account acc){
  session = HibernateUtil.getSessionFactory().openSession();
     Transaction tx = session.beginTransaction();
     session.save(acc);
     tx.commit();
     session.close();
 } 
 
  public String findByUsername(String username){
     String password = null; 
     session = HibernateUtil.getSessionFactory().openSession();
     Transaction tx = session.beginTransaction();
     List accounts = session.createCriteria(Account.class).add(Restrictions.eq("username", username)).setProjection(Projections.property("password")).list();
     tx.commit();
     session.close();
     for(Object a:accounts){
       password = a.toString();
     }
     return password;
 } 
}
