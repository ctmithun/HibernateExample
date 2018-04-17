package net.roseindia;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import net.roseindia.model.*;

/**
 * @author Deepak Kumar Web: http://www.roseindia.net
 */
public class GetAllData {
	public static void main(String[] args) throws Exception {

		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		
		/*CriteriaQuery<Employee> cq = session.getCriteriaBuilder().createQuery(Employee.class);
		cq.from(Employee.class);
		List<Employee> employeeList = session.createQuery(cq).getResultList();

		for (Employee employee : employeeList) {
			System.out.println("ID: " + employee.getId());
			System.out.println("Name: " + employee.getEmpName());
		}  */
		/*Employee emp = session.load(Employee.class, 5);
		System.out.println("Load Employeed Name: "+emp.getEmpName());
		tr.commit();*/
		
		//Criteria query example
		EntityManager enm = sessFact.createEntityManager();
		CriteriaBuilder en = sessFact.getCriteriaBuilder();
		CriteriaQuery<Integer> qu = en.createQuery(Integer.class);
		Root<Employee> ro = qu.from(Employee.class);
		qu.select(ro.get("id"));
		qu.where(en.like(ro.get("empName"), "Sachin%"), en.equal(ro.get("empSalary"), 10000	));
		List<Integer> list= enm.createQuery(qu).getResultList();
        for (Integer name : list) {
           System.out.println("PK: " + name);
        }
		System.out.println("Data printed");
		sessFact.close();
	}
}