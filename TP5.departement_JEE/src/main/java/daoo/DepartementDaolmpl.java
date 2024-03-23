package daoo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.Departement;
import util.JPAutil;

public class DepartementDaolmpl implements IDepartementDAO {
	private EntityManager entityManager=JPAutil.getEntityManager("TP5.departement_JEE");
	@Override
	public Departement save(Departement p) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(p);
	tx.commit();
	return p;
	}
	@Override
	public List<Departement> DepartementParMC(String mc) {
	List<Departement> prods = entityManager.createQuery("select p from Departement p where p.NOM_departement like :mc").setParameter("mc", "%"+mc+"%").getResultList();

	return prods;
	}
	@Override
	public Departement getDepartement(Long id) {
	return entityManager.find(Departement.class, id);
	}
	@Override
	public Departement updateDepartement(Departement p) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.merge(p);
	tx.commit();
	return p;
	}
	@Override
	public void deleteDepartement(Long id) {
		Departement Departement  = entityManager.find(Departement.class, id);
	entityManager.getTransaction().begin();
	entityManager.remove(Departement);
	entityManager.getTransaction().commit();
	}
	
	

}