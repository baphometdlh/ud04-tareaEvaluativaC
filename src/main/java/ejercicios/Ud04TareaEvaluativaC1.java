package ejercicios;

import entidades.*;
import jakarta.persistence.*;

public class Ud04TareaEvaluativaC1 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud04");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			//creamos un objeto Course y le añadimos un student
			System.out.println("Creando un nuevo Curso y agregando un alumno...");
			
			Student student = entityManager.getReference(Student.class, 14);
			Course course = createCourse();
			
			student.getCourses().add(course);
			course.getStudents().add(student);
			
			//comenzamos transaccion
			entityManager.getTransaction().begin();
			
			//guardamos el curso y su asociacion con el student
			entityManager.persist(course);
			
			//hacemos commit
			entityManager.getTransaction().commit();
			
			System.out.println("Hecho!");
		}
		catch(Exception e) {
			//hacemos rollback
			System.out.println("Realizando Rollback");
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			entityManager.close();
			factory.close();
		}

	}
	
	private static Course createCourse() {
		Course tempCourse = new Course();
		
		tempCourse.setName("Acceso a Datos");
		tempCourse.setCredits(5);
		
		return tempCourse;
	}

}
