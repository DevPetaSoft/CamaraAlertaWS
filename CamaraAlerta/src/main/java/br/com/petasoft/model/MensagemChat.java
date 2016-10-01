package br.com.petasoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="ca_mensagem_chat")
@Table(name="ca_mensagem_chat")
public class MensagemChat {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false,unique=false, length=4000)
	private String mensagem;
	
	@Column(nullable=false,unique=false)
	private int enviadoPor;
	
	@Column(nullable=false,unique=false)
	private int ordem;
	
	@ManyToOne(targetEntity=Denuncia.class, fetch=FetchType.EAGER, optional=false)
	private Denuncia denuncia;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getEnviadoPor() {
		return enviadoPor;
	}

	public void setEnviadoPor(int enviadoPor) {
		this.enviadoPor = enviadoPor;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public Denuncia getDenuncia() {
		return denuncia;
	}

	public void setDenuncia(Denuncia denuncia) {
		this.denuncia = denuncia;
	}
	
	
}
