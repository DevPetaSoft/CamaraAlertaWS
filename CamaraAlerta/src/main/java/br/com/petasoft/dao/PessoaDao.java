package br.com.petasoft.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.petasoft.infra.CriadorDeSession;
import br.com.petasoft.model.Pessoa;

public class PessoaDao {

	private final Session session;
	/*
	 * Construtor do DAO do pessoa
	 */
	public PessoaDao() {
		this.session = CriadorDeSession.getSession();
	}
	/*
	 * Executa a transação para cadastrar uma nova pessoa no banco de dados
	 */
	public void salvar(Pessoa pessoa) {
		Transaction tx = session.beginTransaction();

		session.save(pessoa);

		tx.commit();
	}
	
	/*
	 * Executa uma consulta e retorna todos os elementos da tabela "Pessoa"
	 */
	public List<Pessoa> listaTudo() {
		return this.session.createCriteria(Pessoa.class).list();
	}

	/*
	 * Executa uma consulta comparando o id de cada elemento com um id passado pela página
	 * e retorna somente uma pessoa
	 */
	public Pessoa carrega(int id) {
		return (Pessoa) this.session.load(Pessoa.class, id);
	}

	/*
	 * Executa a transação de alterar os dados de uma pessoa	
	 */
	public void atualiza(Pessoa pessoa) {
		Transaction tx = session.beginTransaction();
		this.session.update(pessoa);
		tx.commit();
	}
	
	/*
	 * Executa a transação para remover um endereço do banco de dados
	 */
	public void remove(Pessoa pessoa) {
		  Transaction tx = session.beginTransaction();
		  this.session.delete(pessoa);
		  tx.commit();
		}
}
