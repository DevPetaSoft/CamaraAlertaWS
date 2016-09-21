package br.com.petasoft.controllers;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.boilerplate.NoCache;
import br.com.petasoft.dao.CidadeDAO;
import br.com.petasoft.dao.PessoaDao;
import br.com.petasoft.model.Cidade;
import br.com.petasoft.model.Pessoa;

@Controller
@Path("/user")
public class UserController extends br.com.caelum.vraptor.boilerplate.AbstractController {
	public static PessoaDao pDao = new PessoaDao();
	public static CidadeDAO cDao = new CidadeDAO();
	
	@Get("/teste")
	@NoCache
	public void teste(){
		this.success("teste");
	}
	
	@Post("/teste")
	@NoCache
	public void testePost(){
		Cidade cidade = new Cidade();
		cidade.setEstado("Minas Gerais");
		cidade.setNome("Varginha");
		cDao.Salvar(cidade);
		this.success("Ok");
	}
}
