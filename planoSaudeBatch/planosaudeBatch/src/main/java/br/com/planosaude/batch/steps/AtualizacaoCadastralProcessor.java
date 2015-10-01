package br.com.planosaude.batch.steps;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.planosaude.batch.service.DependenteService;
import br.com.planosaude.batch.vo.PessoaProxyVO;

public class AtualizacaoCadastralProcessor implements ItemProcessor<PessoaProxyVO, PessoaProxyVO> {

	private static final Logger LOGGER = Logger.getLogger(AtualizacaoCadastralProcessor.class);

	@Autowired
	private DependenteService dependenteService;
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public PessoaProxyVO process(PessoaProxyVO pessoa) throws Exception {
		LOGGER.info(String.format("Processando pessoa.id=%d", pessoa.getId()));
		pessoa.getDependentes().addAll(dependenteService.obterDependentes(pessoa.getId()));
		return pessoa;
	}
	
}