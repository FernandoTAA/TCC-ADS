package br.com.planosaude.batch.client;

import javax.jws.HandlerChain;

import br.com.planosaude.batch.client.atualizacaocadastral.AtualizacaoCadastralWebService;
import br.com.planosaude.batch.client.atualizacaocadastral.AtualizacaoCadastralWebServiceService;

/**
 * Proxy da classe {@link AtualizacaoCadastralWebServiceService} para monitorar
 * as chamadas metodos feitas na classe {@link AtualizacaoCadastralWebService}.
 * 
 * @author FernandoTAA
 *
 */
@HandlerChain(file = "config/handler-chain.xml")
public class AtualizacaoCadastralWebServiceServiceProxy extends AtualizacaoCadastralWebServiceService {

}
