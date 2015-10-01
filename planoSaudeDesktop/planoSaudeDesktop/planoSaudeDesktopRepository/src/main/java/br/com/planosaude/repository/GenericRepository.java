package br.com.planosaude.repository;

/**
 * Classe generica para a criacao com qualquer outro repositorio com
 * funcionalidades genericas que e reponsavel em manipular os objetos da
 * entidade.
 * 
 * @author FernandoTAA
 *
 * @param <T>
 *            - Entidade para qual esse repositorio pertencerá.
 */
public interface GenericRepository<T> {

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
