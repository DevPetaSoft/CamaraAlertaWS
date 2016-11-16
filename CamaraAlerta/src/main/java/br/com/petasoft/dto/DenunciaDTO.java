package br.com.petasoft.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.petasoft.model.Denuncia;

public class DenunciaDTO implements Serializable{
	
	private Denuncia denuncia;
	private List<String> listaFotos = new ArrayList<String>();

	public DenunciaDTO(Denuncia denuncia, ArrayList<String> listaFotos){
		this.denuncia = denuncia;
		this.listaFotos = listaFotos;
	}
	
	public Denuncia getDenuncia(){
		return this.denuncia;
	}
	
	public void setDenuncia(Denuncia denuncia){
		this.denuncia = denuncia;
	}
	
	public List<String> getListaFotos(){
		return this.listaFotos;
	}
	
	public void setListaFotos(ArrayList<String> listaFotos){
		this.listaFotos = listaFotos;
	}
}
