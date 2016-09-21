package br.com.petasoft.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.petasoft.infra.CriadorDeSession;
import br.com.petasoft.model.Cidade;

public class CidadeDAO {

	private final Session session;
	
	/*
	 * Construtor do DAO da cidade, � inicializado uma nova sess�o
	 * */
	public CidadeDAO(){
		this.session = CriadorDeSession.getSession();
	}
	/*
	 * Executa a transa��o para cadastrar uma nova cidade no banco de dados
	 */
	public void Salvar(Cidade cidade){
		Transaction tx = session.beginTransaction();

		session.save(cidade);

		tx.commit();
	}

}
