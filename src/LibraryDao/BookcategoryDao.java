/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryDao;

import LibraryModel.Bookcategory;
import LibraryUtil.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ngabo David
 */
public class BookcategoryDao {
     Session session = null;
    public void saveBookcategory(Bookcategory c){
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
    }
    
    public void updateBookcategory(Bookcategory c){
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(c);
        tx.commit();
        session.close();
    }
     public void deleteBookcategory(Bookcategory c){
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
        session.close();
    }
    public List<Bookcategory> displayBookcategory(){
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Bookcategory> categories = (List<Bookcategory>) session.createCriteria(Bookcategory.class);
        tx.commit();
        session.close();
        return categories;
    }
     public List<Bookcategory> findBycategoryId(String id){
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Bookcategory> categories = (List<Bookcategory>) session.createCriteria(Bookcategory.class).add(Restrictions.eq("categoryId", id));
        tx.commit();
        session.close();
        return categories;
    }
    
      public String getcategoryName(String id){
          String sql ="select categoryName from Bookcategory where categoryId = '"+id+"'";
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Object name = session.createQuery(sql).uniqueResult();
        tx.commit();
        session.close();
        return name.toString();
    }
    
       public String getcategoryId(String name){
          String sql ="select categoryId from Bookcategory where categoryName = '"+name+"'";
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Object id = session.createQuery(sql).uniqueResult();
        tx.commit();
        session.close();
        return id.toString();
}
}
