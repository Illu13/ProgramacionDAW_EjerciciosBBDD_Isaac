package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;
import model.Valoracionmateria;

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
	
	public static int lastId() {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT max(id) as ID FROM estudiante;", Estudiante.class);
		Estudiante es = (Estudiante) q.getSingleResult();

		em.close();

		return es.getId() + 1;
	}
	
	public static void modificar(Estudiante l) {

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void insertar(Estudiante l) {

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void eliminar(Estudiante l) {

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		l = em.merge(l);
		em.remove(l);
		em.getTransaction().commit();
		em.close();
	}

	

	public static List<Estudiante> findAll() {


		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM estudiante;", Estudiante.class);

		List<Estudiante> est = (List<Estudiante>) q.getResultList();

		 
		em.close();
		
		return est;

	}

}
