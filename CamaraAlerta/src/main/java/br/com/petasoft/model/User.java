package br.com.petasoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity(name="ca_usuario")
@Table(name="ca_usuario")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false,unique=false,length=50)
	private String nome;
	
	@Column(nullable=true,unique=true,length=50)
	private String login;
	
	@Column(nullable=true,unique=false,length=16)
	private String senha;
	
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

	@Column(nullable=true, length=255)
	private String tokenFacebook;
	
	@Column(nullable=true, length=255)
	private String tokenGPlus;
}
