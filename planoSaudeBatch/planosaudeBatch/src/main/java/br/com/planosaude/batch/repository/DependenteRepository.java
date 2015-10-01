package br.com.planosaude.batch.repository;

import java.util.List;

import br.com.planosaude.batch.vo.DependenteProxyVO;

public interface DependenteRepository extends GenericRepository {

	public List<DependenteProxyVO> obterDependentes(Long idPessoa);

}
