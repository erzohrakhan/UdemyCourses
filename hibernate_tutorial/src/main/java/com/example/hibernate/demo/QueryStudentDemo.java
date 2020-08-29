package com.example.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// Create Session factory
		/*
		 * To achieve this purpose, we need to have a ServiceRegistry that holds the
		 * Services needed by Hibernate. From this registry, we can build a Metadata
		 * object that represents the application's domain model and its mapping to the
		 * database.
		 */
		// Configuration con = new
		// Configuration().configure().addAnnotatedClass(Alien.class);

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		SessionFactory sf = new MetadataSources(registry).addAnnotatedClass(Student.class).buildMetadata()
				.buildSessionFactory();
		Session session = sf.getCurrentSession();

		try {

			// start a transcation
			Transaction tx = session.beginTransaction();
			// query students
			List<Student> student = session.createQuery("from Student").getResultList();

			displayStudents(student);

			student = session.createQuery("from Student s where s.lastName='Khan'").getResultList();
			displayStudents(student);
			
			student = session.createQuery("from Student s where s.lastName='Khan' or s.lastName='am I'").getResultList();
			displayStudents(student);
			
			
			tx.commit();
			System.out.println("Done!");
		} finally {
			session.close();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	private static void displayStudents(List<Student> student) {
		System.out.println("---------------------\n\n");
		for (Student temp : student)
			System.out.println(temp);
	}

}
