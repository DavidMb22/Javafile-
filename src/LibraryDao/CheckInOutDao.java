/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryDao;

import LibraryModel.Checkinout;
import LibraryUtil.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ngabo David
 */
public class CheckInOutDao {
     public void SaveCheckOut(Checkinout chout){
    Session sess = HibernateUtil.getSessionFactory().openSession();
    Transaction trans = sess.beginTransaction();
    sess.save(chout);
    trans.commit();
   }
     public List<Checkinout> getCheckOut(){
        Session session =HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Criteria cr =session.createCriteria(Checkinout.class);
        List<Checkinout> cl = cr.list();
        tr.commit();
        session.close();
        return  cl;
        }
}
