package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Materia;
import model.Tipologiasexo;

public class ControladorSexo {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");

	
	public static List<Tipologiasexo> findAll() {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM tipologiasexo;", Tipologiasexo.class);

		List<Tipologiasexo> locs = (List<Tipologiasexo>) q.getResultList();

		em.close();

		return locs;

	}
	

}
