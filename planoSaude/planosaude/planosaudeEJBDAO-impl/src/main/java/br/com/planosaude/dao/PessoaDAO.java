package br.com.planosaude.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.transaction.Transactional;

import br.com.planosaude.dao.entity.Pessoa;

@Stateless
public class PessoaDAO extends GenericDAO<Pessoa> implements IPessoaDAOLocal {

	@Transactional
	@SuppressWarnings("unchecked")
	public List<Pessoa> buscarTodasPessoas() {
		return getEntityManager().createQuery("SELECT pessoa FROM Pessoa pessoa").getResultList();
	}

	@Transactional
	public void savePessoa(Pessoa pessoa) {
		getEntityManager().persist(pessoa);
	}

}
