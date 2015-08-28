package projeto.modelo.dao.hibernate.implementacao;

import javax.inject.Inject;

import org.hibernate.Session;

import projeto.modelo.dao.hibernate.HibernateDao;
import projeto.modelo.dao.interfaces.IProdudoDao;
import projeto.modelo.entidade.Produto;

public class ProdutoHibernateDao extends HibernateDao<Produto> implements IProdudoDao  {

	public ProdutoHibernateDao() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	public ProdutoHibernateDao(Session session) {
		this.session = session;
	}
	
}
