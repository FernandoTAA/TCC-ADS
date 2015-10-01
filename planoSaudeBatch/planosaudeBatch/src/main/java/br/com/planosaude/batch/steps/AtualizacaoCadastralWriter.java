package br.com.planosaude.batch.steps;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemWriter;

import br.com.planosaude.batch.client.AtualizacaoCadastralWebServiceServiceProxy;
import br.com.planosaude.batch.client.atualizacaocadastral.AtualizacaoCadastralWebService;
import br.com.planosaude.batch.client.atualizacaocadastral.Retorno;
import br.com.planosaude.batch.vo.PessoaProxyVO;

public class AtualizacaoCadastralWriter implements ItemWriter<PessoaProxyVO> {

	private static final Logger LOGGER = Logger.getLogger(AtualizacaoCadastralWriter.class);
	
	private final static Integer SUCCESS_CODE = 0;

	public void write(List<? extends PessoaProxyVO> items) throws Exception {
		for (PessoaProxyVO pessoa : items) {
			try {
				LOGGER.info(String.format("Transmitindo pessoa.id=%d", pessoa.getId()));
				Retorno retorno = getWSAtualizacaoCadastralWebService().savePessoa(pessoa);
				if (retorno != null && SUCCESS_CODE.equals(retorno.getCodigoStatus())) {
					LOGGER.info(String.format("Transmitido com SUCESSO pessoa.id=%d", pessoa.getId()));
				} else {
					LOGGER.info(String.format("Transmitido com ERRO pessoa.id=%d; erro=%s", pessoa.getId(), retorno.getStatus()));
				}
			} catch (Exception e) {
				LOGGER.error(String.format("ERRO ao transmitir pessoa.id=%d", pessoa.getId()), e);
			} 
		}		
	}
	
	public AtualizacaoCadastralWebService getWSAtualizacaoCadastralWebService() {
		return new AtualizacaoCadastralWebServiceServiceProxy().getAtualizacaoCadastralWebServicePort();
	}

}
