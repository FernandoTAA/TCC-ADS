package br.com.planosaude.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.planosaude.dao.entity.Pessoa;

/**
 * Classe que manipular os objetos da entidade {@link Pessoa}.
 * 
 * @author FernandoTAA
 *
 */
@Local
public interface IPessoaDAOLocal extends IGenericDAOLocal<Pessoa> {

	/**
	 * Metodo que busca todas as {@link Pessoa} persistidas.
	 * 
	 * @return - {@link List} de {@link Pessoa} persistidas.
	 */
	public List<Pessoa> obterTodasPessoas();

}
