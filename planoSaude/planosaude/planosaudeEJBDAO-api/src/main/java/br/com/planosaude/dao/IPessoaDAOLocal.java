package br.com.planosaude.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.planosaude.dao.entity.Pessoa;

@Local
public interface IPessoaDAOLocal extends IGenericDAOLocal<Pessoa> {

	public List<Pessoa> buscarTodasPessoas();

}
