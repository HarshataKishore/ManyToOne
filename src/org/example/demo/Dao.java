package org.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Dao {

	public static void main(String[] args) {
		
		Person p = new Person();
		p.setName("Padma");
		p.setState("Chennai");
		
		Car c1 = new Car();
		c1.setCar_name("Maruthi");
		c1.setCar_model("Swift");
		c1.setPerson(p);
		
		Car c2 = new Car();
		c2.setCar_name("Hundai");
		c2.setCar_model("i20");
		c2.setPerson(p);
  		
		Configuration con = new Configuration();
        con.configure();
        
        SessionFactory sef = con.buildSessionFactory();
        Session ses = sef.openSession();
        Transaction tr = ses.beginTransaction();
        ses.save(p);
        ses.save(c1);
        ses.save(c2);
        ses.getTransaction().commit();
        ses.close();
        
	}

}
