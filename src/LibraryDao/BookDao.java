/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryDao;

import LibraryModel.Book;
import LibraryModel.Bookcategory;
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
public class BookDao {
     Session session = null;
      public void saveBook(Book c){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(c);
        tx.commit();
        session.close();
    }
   public void updateBook(Book c){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(c);
        tx.commit();
        session.close();
    } 
    
   public void deleteBook(Book c){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(c);
        tx.commit();
        session.close();
    }
   
   public List<Book> displayBook(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Book> books = (List<Book>) session.createCriteria(Book.class);
        tx.commit();
        session.close();
        return books;
    } 
   
   public List<Book> findByBookId(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<Book> books = (List<Book>) session.createCriteria(Book.class).add(Restrictions.eq("bookid", id));
        tx.commit();
        session.close();
        return books;
    }
    public  List<Book>listAll(){
        List<Book>bk = null;
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
        Query q = ss.createQuery("from Book");
        return q.list();
    } 
    public  List<Bookcategory>gettAll(){
        List<Bookcategory>bc = null;
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tx = ss.beginTransaction();
        Query q = ss.createQuery("from Bookcategory");
        return q.list();
    } 
}
