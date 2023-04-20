package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;

public class ControladorEstudiante {

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("centroeducativo");

	public static Estudiante findById(int idE) {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM estudiante where id = ?", Estudiante.class);
		q.setParameter(1, idE);
		Estudiante es = (Estudiante) q.getSingleResult();

		em.close();

		return es;
	}
	


	

	public static List<Estudiante> findAll() {


		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM estudiante;", Estudiante.class);

		List<Estudiante> est = (List<Estudiante>) q.getResultList();

		 
		em.close();
		
		return est;

	}

}
