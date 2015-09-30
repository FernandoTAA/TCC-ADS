package br.com.planosaude.gui.vo;

import br.com.planosaude.dao.entity.Pessoa;
import br.com.planosaude.dao.type.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PessoaVO {

	private Pessoa pessoa;

	private StringProperty nome;
	private StringProperty tipoPlano;
	private ObjectProperty<Date> dataVencimento;
	private StringProperty cidade;
	private StringProperty uf;

	public PessoaVO(Pessoa pessoa) {
		super();
		this.pessoa = pessoa;
		this.nome = new SimpleStringProperty(pessoa.getNome());

		if (pessoa.getTipoPlano() != null) {
			this.tipoPlano = new SimpleStringProperty(pessoa.getTipoPlano().name());
		}
		
		if (pessoa.getEndereco() != null) {
			this.cidade = new SimpleStringProperty(pessoa.getEndereco().getCidade());
			this.uf = new SimpleStringProperty(pessoa.getEndereco().getUF());
		}
		
		if (pessoa.getDataVencimentoPlano() != null && pessoa.getDataVencimentoPlano().getDate() != null) {
			this.dataVencimento = new SimpleObjectProperty<Date>(pessoa.getDataVencimentoPlano());
		} else {
			this.dataVencimento = new SimpleObjectProperty<Date>();
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public StringProperty getNome() {
		return nome;
	}

	public void setNome(StringProperty nome) {
		this.nome = nome;
	}

	public StringProperty getTipoPlano() {
		return tipoPlano;
	}

	public void setTipoPlano(StringProperty tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public Date getDataVencimento() {
		return dataVencimento.get();
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento.set(dataVencimento);
	}

	public StringProperty getCidade() {
		return cidade;
	}

	public void setCidade(StringProperty cidade) {
		this.cidade = cidade;
	}

	public StringProperty getUf() {
		return uf;
	}

	public void setUf(StringProperty uf) {
		this.uf = uf;
	}

}