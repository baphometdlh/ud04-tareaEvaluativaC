package ejercicios;

import entidades.*;
import jakarta.persistence.*;

public class Ud04TareaEvaluativaC2 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud04");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			//borramos un objeto Student
			System.out.println("Borrando un objeto Student...");
			
			int student_id = 12;
			
			Student tempStudent = entityManager.getReference(Student.class,student_id);
			
			//comenzamos transacción
			entityManager.getTransaction().begin();
			
			//borramos el objeto studnet pero no se elimina el course
			entityManager.remove(tempStudent);
			
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

}
