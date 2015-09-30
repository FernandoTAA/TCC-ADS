package br.com.planosaude.repository;

import java.util.List;

import br.com.planosaude.dao.entity.Pessoa;

public interface PessoaRepository extends GenericRepository<Pessoa> {

	public List<Pessoa> obterTodasPessoas();

}
