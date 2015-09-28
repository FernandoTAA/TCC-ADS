package br.com.planosaude.ws.vo;

import java.util.List;

import br.com.planosaude.dao.entity.Pessoa;

public class RetornoPessoas extends Retorno {

	private static final long serialVersionUID = 3764507215348593734L;

	private List<Pessoa> pessoas;

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}
