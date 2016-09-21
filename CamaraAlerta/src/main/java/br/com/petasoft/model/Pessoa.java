package br.com.petasoft.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="ca_pessoa")
@Table(name="ca_pessoa")
public class Pessoa {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false,unique=false,length=50)
	private String nome;
	
	@Column(nullable=false,unique=true,length=50)
	private String cpf;

	@Column(nullable=false)
	private Date nascimento;
	
	@Column(nullable=false)
	private String telefone;
	
	@Column(nullable=true)
	private Date dataCriacao;
	
	@Column(nullable=true)
	private boolean deleted;
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}


}
