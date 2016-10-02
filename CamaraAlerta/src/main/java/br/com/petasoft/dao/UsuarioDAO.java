package br.com.petasoft.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.petasoft.infra.CriadorDeSession;
import br.com.petasoft.model.Cidadao;
import br.com.petasoft.model.Vereador;

public class UsuarioDAO {
	private final Session session;
	
	/*
	 * Construtor do DAO do usu�rio, � inicializado uma nova sess�o
	 * */
	public UsuarioDAO(){
		this.session = CriadorDeSession.getSession();
	}
	
	/*
	 * Consulta de um cidadao pelo tokent deo facebook
	 * */
	public Cidadao buscarUsuarioPorFacebookToken(String token){
		Criteria criteria = this.session.createCriteria(Cidadao.class);
		criteria.add(Restrictions.eq("tokenFacebook", token));
		criteria.add(Restrictions.eq("deleted", false));
		Cidadao cidadao = (Cidadao) criteria.uniqueResult();
		return cidadao;
	}
	
	/*
	 * Consulta de um cidadao pelo tokent deo facebook
	 * */
	public Cidadao buscarUsuarioPorGPlusToken(String token){
		Criteria criteria = this.session.createCriteria(Cidadao.class);
		criteria.add(Restrictions.eq("tokenGPlus", token));
		criteria.add(Restrictions.eq("deleted", false));
		Cidadao cidadao = (Cidadao) criteria.uniqueResult();
		return cidadao;
	}
}
