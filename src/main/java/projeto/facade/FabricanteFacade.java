package projeto.facade;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import projeto.modelo.dao.hibernate.implementacao.FabricanteHibernateDao;
import projeto.modelo.entidade.Fabricante;

public class FabricanteFacade implements IFacade<Fabricante> {
	
	@Inject
	private FabricanteHibernateDao fabricanteDao;	
	
	public FabricanteFacade() {
	}

	public void create(Fabricante entity) throws HibernateException, Exception {
		fabricanteDao.save(entity);		
	}

	public void edit(Fabricante entity) throws HibernateException, Exception {
		fabricanteDao.save(entity);
	}

	public void remove(Fabricante entity) throws HibernateException, Exception {
		fabricanteDao.delete(entity);		
	}

	public List<Fabricante> list() throws HibernateException, Exception {
		return fabricanteDao.findAll();
	}

	public Fabricante load(Long id) throws HibernateException, Exception {
		return fabricanteDao.find(id);
	}

	public List<Fabricante> listPagination(int first, int max)
			throws HibernateException, Exception {
		return fabricanteDao.findRange(first, max);
	}

	public int count() throws HibernateException, Exception {
		return fabricanteDao.count();
	}	


	
}
