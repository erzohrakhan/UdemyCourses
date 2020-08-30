package com.example.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildMetadata()
				.buildSessionFactory();
		Session session = sf.getCurrentSession();

		try {
			// create a student object
			System.out.println("Creating a new Instructor object..");

			// start a transcation
			Transaction tx = session.beginTransaction();

			// Get the instructor from db
			int id = 2;
			Instructor instructor = session.get(Instructor.class, id);

			// Create some courses
			Course course1 = new Course("Crciket");
			Course course2 = new Course("Badminton");

			// add courses to the instructor
			instructor.add(course1);
			instructor.add(course2);

			// save the courses
			session.save(course1);
			session.save(course2);

		
			System.out.println("Saving the courses");
			
			tx.commit();
			System.out.println("Done!");
		} finally {
			session.close();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
