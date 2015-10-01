package br.com.planosaude.business;

import java.util.List;

import javax.ejb.Local;

import br.com.planosaude.dao.entity.Pessoa;

/**
 * Classe responsavel por manipular as {@link Pessoa} de acordo com as regras de
 * negocio.
 * 
 * @author FernandoTAA
 *
 */
@Local
public interface IPessoaBusinessLocal extends IGenericBusinessLocal<Pessoa> {

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
	public void savePessoa(Pessoa pessoa);

	/**
	 * Atualiza a {@link Pessoa} informada no parametro.
	 * 
	 * @param pessoa - {@link Pessoa} a ser atualizada.
	 */
	public void updatePessoa(Pessoa pessoa);

}
