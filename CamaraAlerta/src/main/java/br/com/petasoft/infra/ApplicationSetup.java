package br.com.petasoft.infra;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.boilerplate.factory.SessionFactoryProducer;
import br.com.petasoft.dao.PessoaDao;
import br.com.petasoft.model.Pessoa;


@ApplicationScoped
@Startup
public class ApplicationSetup {
	public static PessoaDao pDao = new PessoaDao();
	
	protected ApplicationSetup() {
	}
	
	@Inject
	public ApplicationSetup(SessionFactoryProducer factoryProducer){
		factoryProducer.initialize("hibernate.cfg.xml");
		Pessoa p = new Pessoa();
		p.setCpf("123");
		p.setNome("teste");
		pDao.salvar(p);
	}
}
