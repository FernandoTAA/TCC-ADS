package br.com.planosaude.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.planosaude.dao.entity.Pessoa;
import br.com.planosaude.repository.PessoaRepository;

@Repository
public class PessoaRepositoryImpl extends GenericRepositoryImpl<Pessoa> implements PessoaRepository {

	@Override
	@SuppressWarnings("unchecked")
	public List<Pessoa> obterTodasPessoas() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT pessoa ");
		sql.append(" FROM Pessoa pessoa ");
		sql.append("   LEFT JOIN FETCH pessoa.dependentes ");
		return getEntityManager().createQuery(sql.toString()).getResultList();
	}

}
