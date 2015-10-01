package br.com.planosaude.batch.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import br.com.planosaude.batch.repository.GenericRepository;

public class GenericRepositoryImpl implements GenericRepository {

	@Autowired
	private JdbcDaoSupport jdbcTemplate;

	protected JdbcDaoSupport getJdbcTemplate() {
		return jdbcTemplate;
	}

}
