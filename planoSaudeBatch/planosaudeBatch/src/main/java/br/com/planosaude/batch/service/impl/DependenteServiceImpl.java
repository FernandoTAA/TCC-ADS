package br.com.planosaude.batch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.planosaude.batch.repository.DependenteRepository;
import br.com.planosaude.batch.service.DependenteService;
import br.com.planosaude.batch.vo.DependenteProxyVO;

@Service
public class DependenteServiceImpl extends GenericServiceImpl implements DependenteService {

	@Autowired
	private DependenteRepository dependenteRepository;

	@Transactional
	public List<DependenteProxyVO> obterDependentes(Long idPessoa) {
		return dependenteRepository.obterDependentes(idPessoa);
	}
	
}
