package br.com.planosaude.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class GenericDAO<T> implements IGenericDAOLocal<T> {
	
	@PersistenceContext(unitName = "planosaudePU")
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(T t) {
		getEntityManager().persist(t);
	}

	@Override
	@Transactional
	public void update(T t) {
		getEntityManager().merge(t);
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
