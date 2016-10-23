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
		LOGGER.info("Realizando login por facebook");
		Cidadao cidadao = new Cidadao();
		cidadao = uDao.buscarUsuarioPorFacebookToken(token);
		if(cidadao == null){
			this.success("novoCadastro");
		}else{
			this.success(cidadao);
		}
	}
	
	/*
	 *  Requisi��o get para realizar o login via google plus,
	 *  Se encontrar um usu�rio pelo token, ele retorna o usu�rio,
	 *  caso ao contr�rio, � enviada uma flag para realizar um novo cadastro.
	 */
	@Get("/gplusLogin")
	public void gplusLogin(String token){
		LOGGER.info("Realizando login por google plus");
		Cidadao cidadao = new Cidadao();
		cidadao = uDao.buscarUsuarioPorGPlusToken(token);
		if(cidadao == null){
			this.success("novoCadastro");
		}else{
			this.success(cidadao);
		}
	}
	
	
	@Post("/login")
	public void login(String login, String senha){
		LOGGER.info("LOGIN: "+ login);
		LOGGER.info("SENHA: "+ senha);
		Cidadao cidadao;
		cidadao = uDao.buscarPorLoginESenha(login, senha);
		if(cidadao == null){
			this.fail("Usu�rio n�o encontrado, verifique seu e-mail e senha!");
		}else{
			this.success(cidadao);
		}
	}
	
}
