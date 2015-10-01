package br.com.planosaude.dao;

/**
 * Classe generica para a criacao com qualquer outro DAO com funcionalidades
 * genericas que e reponsavel em manipular os objetos da entidade.
 * 
 * @author FernandoTAA
 *
 * @param <T>
 *            - Entidade para qual esse DAO pertencerá.
 */
public interface IGenericDAOLocal<T> {

	/**
	 * Metodo que persiste a entidade.
	 * 
	 * @param t
	 *            - entidade a ser persistida.
	 */
	public void save(T t);

	/**
	 * Metodo que atualiza a entidade.
	 * 
	 * @param t
	 *            - entidade a ser atualizada.
	 */
	public void update(T t);

}
