package projeto.modelo.dao;

import java.util.List;

import org.hibernate.HibernateException;

import projeto.modelo.dao.hibernate.HibernateDaoException;

public interface IDao<T> {

	public void save(T entity) throws HibernateException, Exception;
	
	public void update(T entity) throws HibernateException, Exception;
	
	public void delete(T entity) throws HibernateException, Exception;
	
	public T find(Long id) throws HibernateDaoException, Exception;
	
	public List<T> findAll() throws Exception;	
	
	public List<T> findRange(int first, int max) throws HibernateException, Exception;
	
	public int count() throws HibernateException, Exception;
}
