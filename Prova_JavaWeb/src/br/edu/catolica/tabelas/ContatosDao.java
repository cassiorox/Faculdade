package br.edu.catolica.tabelas;

import org.hibernate.*;
import br.edu.catolica.conexao.HibernateUtil;

public class ContatosDao {
	
	public void salvar(Contatos contato)
	{
		Session sessao = null;
		Transaction transacao = null;
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			sessao.save(contato);
			transacao.commit();
			sessao.close();
		} catch(HibernateException e) {
			System.out.println("Nao foi possivel inserir o contato. Erro" + e.getMessage());			
		}
	}
	
	public static void main(String [] args){
		Contatos contato1 = new Contatos();
		contato1.setName("Cassio");
		contato1.setEmail("cassiorox_@hotmail.com");
		//contato1.setLogin("cassio");
		
		ContatosDao contatoCrud = new ContatosDao();
		contatoCrud.salvar(contato1);
	}

}
