package br.com.planosaude.gui.vo;

import br.com.planosaude.dao.entity.Dependente;
import br.com.planosaude.dao.type.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DependenteVO {

	private Dependente dependete;

	private StringProperty nome;
	private ObjectProperty<Date> dataNascimento;

	public DependenteVO(Dependente dependete) {
		super();
		this.dependete = dependete;
		this.nome = new SimpleStringProperty(dependete.getNome());

		if (dependete.getDataNascimento() != null && dependete.getDataNascimento().getDate() != null) {
			this.dataNascimento = new SimpleObjectProperty<Date>(dependete.getDataNascimento());
		} else {
			this.dataNascimento = new SimpleObjectProperty<Date>();
		}
	}

	public Dependente getDependete() {
		return dependete;
	}

	public void setDependete(Dependente dependete) {
		this.dependete = dependete;
	}

	public StringProperty getNome() {
		return nome;
	}

	public void setNome(StringProperty nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento.get();
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento.set(dataNascimento);
	}
}
