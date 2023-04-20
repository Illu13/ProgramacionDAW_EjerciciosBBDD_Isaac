package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;
import model.Valoracionmateria;

public class ControladorValoracionMateria {

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("centroeducativo");

	public static List<Valoracionmateria> findByIds(int idM, int idP) {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM valoracionmateria where idmateria = " + idM + " and"
				+ " idprofesor= " + idP + " order by idestudiante;", Valoracionmateria.class);

		List<Valoracionmateria> locs = (List<Valoracionmateria>) q.getResultList();

		em.close();

		return locs;

	}

	public static Valoracionmateria findByIdsEstu(int idM, int idP, int idE) {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM valoracionmateria where idmateria = " + idM + " and"
				+ " idprofesor= " + idP + " and" + " idestudiante= " + idE + ";", Valoracionmateria.class);

		try {
			Valoracionmateria locs = (Valoracionmateria) q.getSingleResult();
			em.close();
			return locs;
		} catch (NoResultException e) {
			em.close();
			return null;
		}

	}

	public static int findMaxId() {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT max(id) as ID FROM valoracionmateria;", Valoracionmateria.class);

		Valoracionmateria locs = (Valoracionmateria) q.getSingleResult();
		em.close();
		
		return locs.getId() + 1;

	}

	public static void modificar(Valoracionmateria l) {

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}

	public static void insertar(Valoracionmateria l) {

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		em.close();
	}

}
