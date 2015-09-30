package br.com.planosaude.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.planosaude.dao.entity.Pessoa;
import br.com.planosaude.repository.PessoaRepository;
import br.com.planosaude.service.PessoaService;

@Service
public class PessoaServiceImpl extends GenericServiceImpl<Pessoa> implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public List<Pessoa> obterTodasPessoas() {
		return pessoaRepository.obterTodasPessoas();
	}

	@Override
	public void save(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	@Override
	public void update(Pessoa pessoa) {
		pessoaRepository.update(pessoa);
	}

}