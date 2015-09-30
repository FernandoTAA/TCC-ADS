package br.com.planosaude.dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.planosaude.dao.enums.TipoPlano;
import br.com.planosaude.dao.type.Date;

@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = -8647768563379185935L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME", length = 50, nullable = false)
	private String nome;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "date", column = @Column(name = "DATA_NASCIMENTO", nullable = false) ) })
	private Date dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_PLANO", length = 10, nullable = false)
	private TipoPlano tipoPlano;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "date", column = @Column(name = "DATA_VENCIMENTO_PLANO", nullable = false) ) })
	private Date dataVencimentoPlano;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_TELEFONE")
	private Telefone telefone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
	private List<Dependente> dependentes;

	public Pessoa() {
		super();
		dataNascimento = new Date();
		dataVencimentoPlano = new Date();
		endereco = new Endereco();
		telefone = new Telefone();
		dependentes = new ArrayList<Dependente>();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public TipoPlano getTipoPlano() {
		return tipoPlano;
	}

	public Date getDataVencimentoPlano() {
		return dataVencimentoPlano;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setTipoPlano(TipoPlano tipoPlano) {
		this.tipoPlano = tipoPlano;
	}

	public void setDataVencimentoPlano(Date dataVencimentoPlano) {
		this.dataVencimentoPlano = dataVencimentoPlano;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
