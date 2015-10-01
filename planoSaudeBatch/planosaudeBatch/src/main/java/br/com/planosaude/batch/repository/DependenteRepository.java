package br.com.planosaude.batch.repository;

import java.util.List;

import br.com.planosaude.batch.vo.DependenteProxyVO;

/**
 * Classe que manipular as rotinas de persistencia e consulta.
 * 
 * @author FernandoTAA
 *
 */
public interface DependenteRepository extends GenericRepository {

	/**
	 * Metodo que busca todos os dependentes de uma Pessoa. 
	 * 
	 * @param idPessoa - {@link Long} com o identificador da Pessoa.
	 * @return - {@link List} de {@link DependenteProxyVO} da Pessoa determinada.
	 */
	public List<DependenteProxyVO> obterDependentes(Long idPessoa);

}
