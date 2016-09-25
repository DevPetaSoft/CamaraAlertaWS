package br.com.petasoft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="ca_vereador")
@Table(name="ca_vereador")
public class Vereador extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable=false)
	private Date dataCadastro;
	
	@Column(nullable=false)
	private int nivalDeAcesso = 0;
	
	@Column(nullable=false)
	private boolean emDia=true;
	
	@ManyToOne(targetEntity=Cidade.class, fetch=FetchType.EAGER, optional=false)
	private Cidade cidade;
	
	@Column(nullable=true, length=14)
	private String cpf;
	
	@ManyToOne(targetEntity=Administrador.class, fetch=FetchType.EAGER, optional=false)
	private Administrador criadoPor;
	
	@Column(nullable=false)
	private boolean deleted = false;

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getNivalDeAcesso() {
		return nivalDeAcesso;
	}

	public void setNivalDeAcesso(int nivalDeAcesso) {
		this.nivalDeAcesso = nivalDeAcesso;
	}

	public boolean isEmDia() {
		return emDia;
	}

	public void setEmDia(boolean emDia) {
		this.emDia = emDia;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Administrador getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(Administrador criadoPor) {
		this.criadoPor = criadoPor;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
