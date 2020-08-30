package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Student;

public class CreateDemo {

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
			// create a student object
			System.out.println("Creating a new Instructor object..");
			Instructor instructor1 = new Instructor("Madhu", "Patel", "madhu@gmail.com");
			InstructorDetail insD1 = new InstructorDetail("youtube.com/madhu", "Reading");

			//associate the objects
			instructor1.setInstructorDetail(insD1);
			// start a transcation
			Transaction tx = session.beginTransaction();

			// save the student
			System.out.println("Saving the student");
			// Note this will also save Intstructor details because of CASCADETYPE.all

			session.save(instructor1);
			//session.save(instructor1);

			tx.commit();
			System.out.println("Done!");
		} finally {
			session.close();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
