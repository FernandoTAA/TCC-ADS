package br.com.planosaude.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TELEFONE")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 2382114093763330906L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;

	@Column(name="TELEFONE", length=14, nullable=false)
	private String telefone;
	
	@Column(name="CONTATO", length=50, nullable=false)
	private String Contato;

	@OneToOne(mappedBy = "telefone")
	private Pessoa pessoa;

	public Long getId() {
		return id;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getContato() {
		return Contato;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setContato(String contato) {
		Contato = contato;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
