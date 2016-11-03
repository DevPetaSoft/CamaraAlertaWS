package br.com.petasoft.controllers;

import java.util.Date;

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
	 *  Requisi��o get para realizar o login via facebook,
	 *  Se encontrar um usu�rio pelo token, ele retorna o usu�rio,
	 *  caso ao contr�rio, � enviada uma flag para realizar um novo cadastro.
	 */
	@Post("/facebookLogin")
	public void facebookLogin(String token, String nome, String email){
		LOGGER.info("Realizando login por facebook");
		Cidadao cidadao = new Cidadao();
		cidadao = uDao.buscarUsuarioPorFacebookToken(token);
		if(cidadao == null){
			cidadao = uDao.salvarNovoCidadaoFacebookToken(token, nome, email);
			LOGGER.info(cidadao.getNome());
			this.success(cidadao);
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
	
	// Realiza a o login de um cidadao
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
	
	// Cria um novo cadastro de um cidadao contendo nome, login, email e senha
	@Post("/novoCidadao")
	public void novoCadastroCidadao(String nome, String login, String email, String senha){
		//try{
			LOGGER.info("Tentando criar um novo cidadao");
			Cidadao cidadao = uDao.buscarUsuarioPorEmail(email);
			if(cidadao==null){
				cidadao = uDao.buscarUsuarioPorLogin(login);
				if(cidadao==null){
					cidadao = new Cidadao();
					cidadao.setNome(nome);
					cidadao.setLogin(login);
					cidadao.setEmail(email);
					cidadao.setSenha(senha);
					cidadao.setDataCriacao(new Date());
					uDao.salvarNovoCidadao(cidadao);	
					this.success("Cadastro criado com sucesso!");				
				}else{
					this.fail("Login já cadastrado no sistema!");
				}				
			}else{
				this.fail("E-mail já cadastrado no sistema!");
			}
			/*	}
	catch(Throwable ex){
			this.fail("Não foi possivel completar o seu cadastro");
		}*/
	}
	
}
