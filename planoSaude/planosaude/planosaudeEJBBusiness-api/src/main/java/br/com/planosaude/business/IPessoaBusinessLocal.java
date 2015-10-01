package br.com.planosaude.business;

import java.util.List;

import javax.ejb.Local;

import br.com.planosaude.dao.entity.Pessoa;

@Local
public interface IPessoaBusinessLocal extends IGenericBusinessLocal<Pessoa> {

	public List<Pessoa> buscarTodasPessoas();

	public void savePessoa(Pessoa pessoa);

	public void updatePessoa(Pessoa pessoa);

}
