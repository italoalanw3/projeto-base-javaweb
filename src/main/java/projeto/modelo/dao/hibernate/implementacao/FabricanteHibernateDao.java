package projeto.modelo.dao.hibernate.implementacao;

import javax.inject.Inject;

import org.hibernate.Session;

import projeto.modelo.dao.hibernate.HibernateDao;
import projeto.modelo.dao.interfaces.IFabricanteDao;
import projeto.modelo.entidade.Fabricante;

public class FabricanteHibernateDao extends HibernateDao<Fabricante> implements IFabricanteDao {

	/** 
	 * Contrutor default: requerido pelo CDI
	 */
	public FabricanteHibernateDao() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	public FabricanteHibernateDao(Session session) {
		// TODO Auto-generated constructor stub
		this.session = session;
	}
	
	
}
