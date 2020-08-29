package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			// create a student object
			System.out.println("Creating a new student object..");
			Student student1 = new Student("Habiba", "Mehta", "habiba@gmail.com");
			// start a transcation
			Transaction tx = session.beginTransaction();

			// save the student
			session.save(student1);
			tx.commit();
			System.out.println("Saving the student  " + student1.getId());
			session = sf.getCurrentSession();
			tx = session.beginTransaction();
			System.out.println("getting student with " + student1.getId());
			Student student = session.get(Student.class, student1.getId());
			System.out.println(student.toString());
			tx.commit();

			System.out.println("Done!");
		} finally {
			session.close();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
