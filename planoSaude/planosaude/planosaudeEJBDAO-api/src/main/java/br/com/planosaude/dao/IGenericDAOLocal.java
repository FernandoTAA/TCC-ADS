package br.com.planosaude.dao;

public interface IGenericDAOLocal<T> {

	public void save(T t);

	public void update(T t);

}
