package br.com.petasoft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="ca_cidadao")
@Table(name="ca_cidadao")
public class Cidadao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false,unique=false,length=50)
	private String nome;
	
	@Column(nullable=true,unique=true,length=50)
	private String login;
	
	@Column(nullable=true,unique=false,length=16)
	private String senha;
	
	@Column(nullable=true)
	private Date dataNascimento;
	
	@Column(nullable=true, length=1)
	private String genero;

	@Column(nullable=false)
	private Date dataCriacao;

	@ManyToOne(targetEntity=Cidade.class, fetch=FetchType.EAGER, optional=false)
	private Cidade cidade;
	
	@Column(nullable=true, length=255)
	private String tokenFacebook;
	
	@Column(nullable=true, length=255)
	private String tokenGPlus;
	
	@Column(nullable=true, length=14)
	private String cpf;
	
	@Column(nullable=true, length=50)
	private String endereco;
	
	@Column(nullable=true, length=15)
	private String telefone;	
	
	@Column(nullable=true)
	private boolean deleted;

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getTokenFacebook() {
		return tokenFacebook;
	}

	public void setTokenFacebook(String tokenFacebook) {
		this.tokenFacebook = tokenFacebook;
	}

	public String getTokenGPlus() {
		return tokenGPlus;
	}

	public void setTokenGPlus(String tokenGPlus) {
		this.tokenGPlus = tokenGPlus;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	
	
	
}
