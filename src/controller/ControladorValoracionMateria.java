package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;
import model.Valoracionmateria;

public class ControladorValoracionMateria {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroeducativo");

	
	public static List<Valoracionmateria> findByIds(int idM,int idP) {

		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM valoracionmateria where idmateria = " + idM + " and" + " idprofesor= " + idP + ";", Valoracionmateria.class);

		List<Valoracionmateria> locs = (List<Valoracionmateria>) q.getResultList();

		em.close();

		return locs;

	}
	
	public static void modificar(Valoracionmateria l) {

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
		em.close();
	}

	
	

}
