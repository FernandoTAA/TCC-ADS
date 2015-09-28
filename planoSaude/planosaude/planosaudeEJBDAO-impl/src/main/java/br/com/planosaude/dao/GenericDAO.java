package br.com.planosaude.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAO<T> implements IGenericDAOLocal<T> {
	
	@PersistenceContext(unitName = "planosaudePU")
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
