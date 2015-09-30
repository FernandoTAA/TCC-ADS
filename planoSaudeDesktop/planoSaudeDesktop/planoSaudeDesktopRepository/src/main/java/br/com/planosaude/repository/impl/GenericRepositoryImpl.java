package br.com.planosaude.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.planosaude.repository.GenericRepository;

@Repository
public class GenericRepositoryImpl<T> implements GenericRepository<T>{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(T t) {
		getEntityManager().persist(t);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void update(T t) {
		getEntityManager().merge(t);
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
