package projeto.facade;

import java.util.List;

import org.hibernate.HibernateException;
import projeto.modelo.entidade.EntidadeAbstrata;

public interface IFacade<T extends EntidadeAbstrata> {
	
	public void create(T entity) throws HibernateException, Exception;
	
	public void edit(T entity) throws HibernateException, Exception;
	
	public void remove(T entity) throws HibernateException, Exception;
	
	public T load(Long id) throws HibernateException, Exception;
	
	public List<T> list() throws HibernateException, Exception;
			
	public List<T> listPagination(int first, int max) throws HibernateException, Exception;
	
	public int count() throws HibernateException, Exception;
}
