package br.com.planosaude.ws;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.planosaude.business.IPessoaBusinessLocal;
import br.com.planosaude.dao.entity.Pessoa;
import br.com.planosaude.ws.enums.StatusRetorno;
import br.com.planosaude.ws.vo.Retorno;
import br.com.planosaude.ws.vo.RetornoPessoas;

@WebService
public class AtualizacaoCadastralWebService {
	
	@EJB
	private IPessoaBusinessLocal pessoaBusiness;

	@WebMethod
	public RetornoPessoas buscarTodasPessoas() {
		RetornoPessoas retorno = new RetornoPessoas();
		try {
			retorno.setPessoas(pessoaBusiness.buscarTodasPessoas());
			retorno.setCodigoStatus(StatusRetorno.SUCESSO.getCodigoStatus());
			retorno.setStatus(StatusRetorno.SUCESSO.name());
		} catch (Exception exception) {
			retorno.setCodigoStatus(StatusRetorno.EXCECAO.getCodigoStatus());
			retorno.setStatus(String.format("%s: %s", StatusRetorno.EXCECAO.name(), exception.getMessage()));
		}
		return retorno;
	}
	
	@WebMethod
	public Retorno savePessoa(@WebParam(name="pessoa") Pessoa pessoa) {
		Retorno retorno = new Retorno();
		try {
			pessoaBusiness.updatePessoa(pessoa);
			retorno.setCodigoStatus(StatusRetorno.SUCESSO.getCodigoStatus());
			retorno.setStatus(StatusRetorno.SUCESSO.name());
		} catch (Exception exception) {
			retorno.setCodigoStatus(StatusRetorno.EXCECAO.getCodigoStatus());
			retorno.setStatus(String.format("%s: %s", StatusRetorno.EXCECAO.name(), exception.getMessage()));
		}
		return retorno;
	}
	
}
