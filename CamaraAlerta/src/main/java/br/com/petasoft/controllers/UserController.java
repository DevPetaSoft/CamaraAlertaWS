package br.com.petasoft.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.boilerplate.NoCache;
import br.com.petasoft.dao.PessoaDao;
import br.com.petasoft.model.Pessoa;

@Controller
@Path("/user")
public class UserController extends br.com.caelum.vraptor.boilerplate.AbstractController {
	public static PessoaDao pDao = new PessoaDao();
	@Get("/teste")
	@NoCache
	public void teste(){
		this.success("teste");
	}
	
	@Post("/teste")
	@NoCache
	public void testePost(){
		Pessoa p = new Pessoa();
		p.setCpf("123");
		p.setNome("teste");
		pDao.salvar(p);
		this.success("Ok");
	}
}
