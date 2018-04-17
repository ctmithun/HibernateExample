package net.roseindia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import net.roseindia.model.*;
/**
 * @author Deepak Kumar 
 * Web: http://www.roseindia.net
 */
public class CreateData {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		Employee emp = new Employee();
//		emp.setId(6);
		emp.setEmpName("Sachin 1");
		emp.setEmpMobileNos("000000");
		emp.setEmpAddress("Delhi - India");
		emp.setEmpSalary(10000);
		session.persist(emp);
//		session.save(emp);
		
//		Employee emp1 = (Employee) session.merge(emp);
//		session.merge(emp);
		System.out.println("Id generated: "+emp.getId());
		tr.commit();
		System.out.println("Successfully inserted");
		sessFact.close();
	}

}