package br.com.petasoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="ca_administrador")
@Table(name="ca_administrador")
public class Administrador {

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
	
	@Column(nullable=false)
	private int nivalDeAcesso = 0;

	@Column(nullable=false)
	private boolean deleted = false;

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

	public int getNivalDeAcesso() {
		return nivalDeAcesso;
	}

	public void setNivalDeAcesso(int nivalDeAcesso) {
		this.nivalDeAcesso = nivalDeAcesso;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
