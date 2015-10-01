package br.com.planosaude.repository;

import java.util.List;

import br.com.planosaude.dao.entity.Pessoa;

/**
 * Classe que manipular os objetos da entidade {@link Pessoa}.
 * 
 * @author FernandoTAA
 *
 */
public interface PessoaRepository extends GenericRepository<Pessoa> {

	/**
	 * Metodo que busca todas as {@link Pessoa} persistidas.
	 * 
	 * @return - {@link List} de {@link Pessoa} persistidas.
	 */
	public List<Pessoa> obterTodasPessoas();

}
