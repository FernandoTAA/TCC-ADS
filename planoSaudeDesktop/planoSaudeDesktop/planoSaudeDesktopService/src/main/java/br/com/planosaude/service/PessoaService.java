package br.com.planosaude.service;

import java.util.List;

import br.com.planosaude.dao.entity.Pessoa;

/**
 * Classe responsavel por manipular os {@link Pessoa} de acordo com
 * as regras de negocio.
 * 
 * @author FernandoTAA
 *
 */
public interface PessoaService extends GenericService<Pessoa> {

	/**
	 * Busca todas as {@link Pessoa}.
	 * 
	 * @return - {@link List} de {@link Pessoa}.
	 */
	public List<Pessoa> obterTodasPessoas();

	/**
	 * Salva a {@link Pessoa} informada no parametro.
	 * 
	 * @param pessoa - {@link Pessoa} a ser salva.
	 */
	public void save(Pessoa pessoa);

	/**
	 * Atualiza a {@link Pessoa} informada no parametro.
	 * 
	 * @param pessoa - {@link Pessoa} a ser atualizada.
	 */
	public void update(Pessoa pessoa);

}
