package br.com.petasoft.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.petasoft.infra.CriadorDeSession;
import br.com.petasoft.model.Cidadao;
import br.com.petasoft.model.Denuncia;

public class DenunciaDAO {

private final Session session;
	
	/*
	 * Construtor do DAO da denuncia, � inicializado uma nova sess�o
	 * */
	public DenunciaDAO(){
		this.session = CriadorDeSession.getSession();
	}
	
	public void salvarNovaDenuncia(Denuncia denuncia){
		Transaction tx = session.beginTransaction();
		Denuncia d = new Denuncia();
		session.save(denuncia);
		tx.commit();
	}
	
}
