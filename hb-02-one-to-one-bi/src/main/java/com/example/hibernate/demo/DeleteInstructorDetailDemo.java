package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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

		SessionFactory sf = new MetadataSources(registry).addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildMetadata().buildSessionFactory();
		Session session = sf.getCurrentSession();

		try {
			// start a transaction
			Transaction tx = session.beginTransaction();
			// get the instructor detail
			int id = 2;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			// print the instructor details
			System.out.println(instructorDetail);
			// print the Instructor
			System.out.println(instructorDetail.getInstructor());
			//Delete instructor detail
			session.delete(instructorDetail);

			tx.commit();
			System.out.println("Done!");
		}catch(Exception e ) {
			System.out.println(e);
		}
		finally {
			session.close();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
