package br.com.petasoft.dao;

import java.util.Date;

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
	
	public Cidadao salvarNovoCidadaoFacebookToken(String token, String nome, String email){
		Transaction tx = session.beginTransaction();
		Cidadao c = new Cidadao();
		c.setDataCriacao(new Date());
		c.setTokenFacebook(token);
		c.setNome(nome);
		c.setEmail(email);
		session.save(c);
		tx.commit();
		return c;
	}
	
	public Cidadao buscarPorLoginESenha(String login, String senha){
		Criteria criteria =  this.session.createCriteria(Cidadao.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("senha", senha));
		Cidadao cidadao = (Cidadao) criteria.uniqueResult();
		return cidadao;
	}
	
	
	/*
	 * Função para criar um novo cadastro de um cidadao 
	 * */
	public void salvarNovoCidadao(Cidadao cidadao){
		Transaction tx = session.beginTransaction();
		Cidadao c = new Cidadao();
		session.save(cidadao);
		tx.commit();
	}
	
	/*
	 * Consulta de um cidadao pelo Login
	 * */
	public Cidadao buscarUsuarioPorLogin(String login){
		Criteria criteria = this.session.createCriteria(Cidadao.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("deleted", false));
		Cidadao cidadao = (Cidadao) criteria.uniqueResult();
		return cidadao;
	}
	
	/*
	 * Consulta de um cidadao pelo Email
	 * */
	public Cidadao buscarUsuarioPorEmail(String email){
		Criteria criteria = this.session.createCriteria(Cidadao.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("deleted", false));
		Cidadao cidadao = (Cidadao) criteria.uniqueResult();
		return cidadao;
	}
}
