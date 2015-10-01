package br.com.planosaude.batch.service;

import java.util.List;

import br.com.planosaude.batch.vo.DependenteProxyVO;

public interface DependenteService extends GenericService {

	public List<DependenteProxyVO> obterDependentes(Long idPessoa);

}
