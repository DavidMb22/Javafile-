package LibraryModel;
// Generated May 20, 2020 1:50:33 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Checkinout generated by hbm2java
 */
public class Checkinout  implements java.io.Serializable {


     private String clientname;
     private Date datetime;
     private String status;
     private String bookname;
     private String author;

    public Checkinout() {
    }

	
    public Checkinout(String clientname) {
        this.clientname = clientname;
    }
    public Checkinout(String clientname, Date datetime, String status, String bookname, String author) {
       this.clientname = clientname;
       this.datetime = datetime;
       this.status = status;
       this.bookname = bookname;
       this.author = author;
    }
   
    public String getClientname() {
        return this.clientname;
    }
    
    public void setClientname(String clientname) {
        this.clientname = clientname;
    }
    public Date getDatetime() {
        return this.datetime;
    }
    
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String getBookname() {
        return this.bookname;
    }
    
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }




}

