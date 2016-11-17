package br.com.petasoft.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="ca_denuncia")
@Table(name="ca_denuncia")
public class Denuncia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false,unique=false, length=4000)
	private String descricao;
	
	@Column(nullable=false,unique=false)
	private Date data;
	
	@Column(nullable=false,unique=false)
	private boolean anonima;
	
	@Column(nullable=false,unique=false, length=4000)
	private String mensagem;
	
	@Column(nullable=false,unique=false)
	private ArrayList<String> fotos;
	
	@ManyToOne(targetEntity=Coordenadas.class, fetch=FetchType.EAGER, optional=false)
	private Coordenadas coordenadas;
	
	@Column(nullable=false,unique=false)
	private int status;
	
	@Column(nullable=false,unique=false)
	private boolean comunicacaoPermitida;
	
	@Column(nullable=false,unique=false, length=4000)
	private String relatorio;
	
	@ManyToOne(targetEntity=Cidadao.class, fetch=FetchType.EAGER, optional=false)
	private Cidadao cidadao;
	
	@ManyToOne(targetEntity=Vereador.class, fetch=FetchType.EAGER, optional=false)
	private Vereador vereador;

	@Column(nullable=false,unique=false)
	private boolean deleted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean isAnonima() {
		return anonima;
	}

	public void setAnonima(boolean anonima) {
		this.anonima = anonima;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public ArrayList<String> getFotos() {
		return fotos;
	}

	public void setFotos(ArrayList<String> fotos) {
		this.fotos = fotos;
	}

	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isComunicacaoPermitida() {
		return comunicacaoPermitida;
	}

	public void setComunicacaoPermitida(boolean comunicacaoPermitida) {
		this.comunicacaoPermitida = comunicacaoPermitida;
	}

	public String getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}

	public Cidadao getCidadao() {
		return cidadao;
	}

	public void setCidadao(Cidadao cidadao) {
		this.cidadao = cidadao;
	}

	public Vereador getVereador() {
		return vereador;
	}

	public void setVereador(Vereador vereador) {
		this.vereador = vereador;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}
