package br.com.petasoft.infra;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.petasoft.model.Pessoa;

public class CriadorDeSession {

    /* 
     * A função cria uma sessão com o hibernate
     */
	public static Session getSession() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();

		configuration.configure();

		SessionFactory factory = configuration.buildSessionFactory();

		Session session = factory.openSession();
		return session;
	}
}
