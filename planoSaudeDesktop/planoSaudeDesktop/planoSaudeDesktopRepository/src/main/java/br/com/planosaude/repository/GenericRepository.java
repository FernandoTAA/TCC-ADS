package br.com.planosaude.repository;

import br.com.planosaude.dao.entity.Pessoa;

public interface GenericRepository<T> {

	public void save(T t);

	public void update(T t);
	
}
