package br.com.planosaude.batch.repository.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import br.com.planosaude.batch.repository.DependenteRepository;
import br.com.planosaude.batch.vo.DependenteProxyVO;

@Repository
public class DependenteRepositoryImpl extends GenericRepositoryImpl implements DependenteRepository {

	public List<DependenteProxyVO> obterDependentes(Long idPessoa) {
		final StringBuffer sql = new StringBuffer();

		sql.append(" SELECT id, ");
		sql.append("        nome, ");
		sql.append("        data_nascimento as dataNascimentoDate ");
		sql.append(" FROM dependente ");
		sql.append(" WHERE id_pessoa = ? ");

		return this.getJdbcTemplate().getJdbcTemplate().query(sql.toString(),
				new Object[] { idPessoa },new BeanPropertyRowMapper<DependenteProxyVO>(DependenteProxyVO.class));
	}

}
