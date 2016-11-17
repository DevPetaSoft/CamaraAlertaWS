package br.com.petasoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="ca_administrador")
@Table(name="ca_administrador")
public class Administrador extends User implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Column(nullable=false)
	private int nivalDeAcesso = 0;

	@Column(nullable=false)
	private boolean deleted = false;


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
