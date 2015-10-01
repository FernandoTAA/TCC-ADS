package br.com.planosaude.batch.client;

import javax.jws.HandlerChain;

import br.com.planosaude.batch.client.atualizacaocadastral.AtualizacaoCadastralWebServiceService;

@HandlerChain(file = "config/handler-chain.xml")
public class AtualizacaoCadastralWebServiceServiceProxy extends AtualizacaoCadastralWebServiceService {

}
