package br.com.planosaude.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.planosaude.dao.IPessoaDAOLocal;
import br.com.planosaude.dao.entity.Pessoa;

@Stateless
public class PessoaBusiness extends GenericBusiness<Pessoa> implements IPessoaBusinessLocal {

	@EJB
	private IPessoaDAOLocal pessoaDAO;
	
	public List<Pessoa> buscarTodasPessoas() {
		return pessoaDAO.buscarTodasPessoas();
	}

	@Override
	public void savePessoa(Pessoa pessoa) {
		pessoaDAO.save(pessoa);
	}

	@Override
	public void updatePessoa(Pessoa pessoa) {
		pessoaDAO.update(pessoa);
	}

}
