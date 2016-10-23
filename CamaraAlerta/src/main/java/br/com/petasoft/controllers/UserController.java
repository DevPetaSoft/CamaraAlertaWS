package br.com.petasoft.controllers;

import javax.ws.rs.Produces;

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
	 *  Requisição get para realizar o login via facebook,
	 *  Se encontrar um usuário pelo token, ele retorna o usuário,
	 *  caso ao contrário, é enviada uma flag para realizar um novo cadastro.
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
	 *  Requisição get para realizar o login via google plus,
	 *  Se encontrar um usuário pelo token, ele retorna o usuário,
	 *  caso ao contrário, é enviada uma flag para realizar um novo cadastro.
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
	
	// Realiza a o login de um cidadao
	@Produces("text/json; charset=UTF-8")
	@Post("/login")
	public void cidadaoLogin(String login, String senha){
		Cidadao cidadao;
		cidadao = uDao.buscarPorLoginESenha(login, senha);
		if(cidadao == null){
			this.fail("Usuário não encontrado, verifique seu e-mail e senha!");
		}else{
			this.success(cidadao);
		}
	}
	
}
