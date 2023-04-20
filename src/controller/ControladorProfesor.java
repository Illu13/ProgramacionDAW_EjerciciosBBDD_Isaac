package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Materia;
import model.Profesor;

public class ControladorProfesor {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");

	
	public static List<Profesor> findAll() {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM profesor;", Profesor.class);

		List<Profesor> locs = (List<Profesor>) q.getResultList();

		em.close();

		return locs;

	}
	
	public static Profesor findById(int idM) {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM profesor where id = " + idM + ";", Profesor.class);

		Profesor locs =  (Profesor) q.getSingleResult();

		em.close();

		return locs;

	}

}
