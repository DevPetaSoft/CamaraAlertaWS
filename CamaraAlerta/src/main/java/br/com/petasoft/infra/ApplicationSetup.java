package br.com.petasoft.infra;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.boilerplate.factory.SessionFactoryProducer;



@ApplicationScoped
@Startup
public class ApplicationSetup {
	
	protected ApplicationSetup() {
	}
	
	@Inject
	public ApplicationSetup(SessionFactoryProducer factoryProducer){
		factoryProducer.initialize("hibernate.cfg.xml");
		
	}
}
