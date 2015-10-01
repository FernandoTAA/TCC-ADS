package br.com.planosaude.batch.service;

import java.util.List;

import br.com.planosaude.batch.vo.DependenteProxyVO;

/**
 * Classe responsavel por manipular os {@link DependenteProxyVO} de acordo com
 * as regras de negocio.
 * 
 * @author FernandoTAA
 *
 */
public interface DependenteService extends GenericService {

	/**
	 * Busca todas os {@link DependenteProxyVO} de acordo com o identificado da
	 * Pessoa.
	 * 
	 * @param idPessoa - {@link Long} com o identificador da Pessoa.
	 * @return - {@link List} de {@link DependenteProxyVO} da Pessoa.
	 */
	public List<DependenteProxyVO> obterDependentes(Long idPessoa);

}
