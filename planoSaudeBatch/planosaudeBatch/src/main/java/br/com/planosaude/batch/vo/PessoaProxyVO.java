package br.com.planosaude.batch.vo;

import java.util.Date;

import br.com.planosaude.batch.client.atualizacaocadastral.Endereco;
import br.com.planosaude.batch.client.atualizacaocadastral.Pessoa;
import br.com.planosaude.batch.client.atualizacaocadastral.Telefone;
import br.com.planosaude.batch.util.DateUtils;

public class PessoaProxyVO extends Pessoa {

	@Override
	public Endereco getEndereco() {
		if (super.getEndereco() == null) {
			super.setEndereco(new Endereco());
		}
		return super.getEndereco();
	}
	
	@Override
	public Telefone getTelefone() {
		if (super.getTelefone() == null) {
			super.setTelefone(new Telefone());
		}
		return super.getTelefone();
	}
	
	public void setDataNascimentoDate(Date dataNascimento) {
		if (super.getDataNascimento() == null) {
			super.setDataNascimento(new br.com.planosaude.batch.client.atualizacaocadastral.Date());
		}
		super.getDataNascimento().setDate(DateUtils.getXMLGregorianCalendar(dataNascimento));
	}

	public void setDataVencimentoPlanoDate(Date dataVencimentoPlano) {
		if (super.getDataVencimentoPlano() == null) {
			super.setDataVencimentoPlano(new br.com.planosaude.batch.client.atualizacaocadastral.Date());
		}
		super.getDataVencimentoPlano().setDate(DateUtils.getXMLGregorianCalendar(dataVencimentoPlano));
	}
	
	public void setEnderecoId(Long id) {
		this.getEndereco().setId(id);
	}

	public void setLogradouro(String logradouro) {
		this.getEndereco().setLogradouro(logradouro);
	}

	public void setNumero(Integer numero) {
		this.getEndereco().setNumero(numero);
	}

	public void setComplemento(String complemento) {
		this.getEndereco().setComplemento(complemento);
	}

	public void setCep(String cep) {
		this.getEndereco().setCep(cep);
	}

	public void setCidade(String cidade) {
		this.getEndereco().setCidade(cidade);
	}

	public void setUf(String uf) {
		this.getEndereco().setUf(uf);
	}

	public void setTelefoneId(Long id) {
		this.getTelefone().setId(id);
	}

	public void setTelefoneString(String telefone) {
		this.getTelefone().setTelefone(telefone);
	}

	public void setContato(String contato) {
		this.getTelefone().setContato(contato);
	}

}
