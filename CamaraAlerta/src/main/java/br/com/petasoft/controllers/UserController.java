package br.com.petasoft.controllers;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.boilerplate.NoCache;
import br.com.petasoft.dao.CidadeDAO;
import br.com.petasoft.dao.UsuarioDAO;
import br.com.petasoft.model.Cidadao;
import br.com.petasoft.model.Cidade;

@Controller
@Path("/user")
public class UserController extends br.com.caelum.vraptor.boilerplate.AbstractController {
	final static Logger logger = Logger.getLogger(UserController.class);
	
	public static CidadeDAO cDao = new CidadeDAO();
	public static UsuarioDAO uDao = new UsuarioDAO();
	
/*	@Get("/teste")
	@NoCache
	public void teste(){
		this.success("teste");
	}*/
	
	@Post("/teste")
	@NoCache
	public void testePost(){
		Cidade cidade = new Cidade();
		cidade.setEstado("Minas Gerais");
		cidade.setNome("Varginha");
		cDao.Salvar(cidade);
		this.success(cidade);
	}
	
	/*
	 *  Requisi��o get para realizar o login via facebook,
	 *  Se encontrar um usu�rio pelo token, ele retorna o usu�rio,
	 *  caso ao contr�rio, � enviada uma flag para realizar um novo cadastro.
	 */
	@Get("/facebookLogin")
	public void facebookLogin(String token){
		Cidadao cidadao = new Cidadao();
		cidadao = uDao.buscarUsuarioPorFacebookToken(token);
		if(cidadao == null){
			this.success("novoCadastro");
		}else{
			this.success(cidadao);
		}
	}
	
	/*
	 *  Requisi��o get para realizar o login via facebook,
	 *  Se encontrar um usu�rio pelo token, ele retorna o usu�rio,
	 *  caso ao contr�rio, � enviada uma flag para realizar um novo cadastro.
	 */
	@Get("/gplusLogin")
	public void gplusLogin(String token){
		Cidadao cidadao = new Cidadao();
		cidadao = uDao.buscarUsuarioPorGPlusToken(token);
		if(cidadao == null){
			this.success("novoCadastro");
		}else{
			this.success(cidadao);
		}
	}
	
}
