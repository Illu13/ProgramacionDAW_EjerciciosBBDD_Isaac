package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Materia;


public class ControladorMateria {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");

	
	public static List<Materia> findAll() {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM materia;", Materia.class);

		List<Materia> locs = (List<Materia>) q.getResultList();

		em.close();

		return locs;

	}
	
	
	public static Materia findById(int idM) {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM materia where id = " + idM + ";", Materia.class);

		Materia locs =  (Materia) q.getSingleResult();

		em.close();

		return locs;

	}

}
