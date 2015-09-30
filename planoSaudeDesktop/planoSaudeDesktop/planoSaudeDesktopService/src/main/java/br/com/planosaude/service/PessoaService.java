package br.com.planosaude.service;

import java.util.List;

import br.com.planosaude.dao.entity.Pessoa;

public interface PessoaService extends GenericService<Pessoa> {

	public List<Pessoa> obterTodasPessoas();

	public void save(Pessoa pessoa);

	public void update(Pessoa pessoa);

}
