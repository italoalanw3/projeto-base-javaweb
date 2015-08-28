package projeto.modelo.dao.hibernate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import projeto.modelo.dao.IDao;
import projeto.modelo.entidade.EntidadeAbstrata;

public abstract class HibernateDao<T extends EntidadeAbstrata> implements
		IDao<T> {

	protected Session session;
	protected Class<T> clazz;	

	public HibernateDao() {
		clazz = inferGenericType();		
	}

	public void save(T entity) throws HibernateException, Exception {
		session.saveOrUpdate(entity);
	}	
	
	public void update(T entity) throws HibernateException, Exception {
		session.saveOrUpdate(entity);
	}

	public void delete(T entity) throws HibernateException, Exception {		
		session.delete(entity);		
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() throws Exception {		
		return session.createCriteria(clazz).list();		
	}

	@SuppressWarnings("unchecked")
	public T find(Long id) throws Exception, HibernateDaoException, HibernateException {
		return (T) session.get(clazz, id);
	}

	public int count() throws HibernateException, Exception {
		return session.createCriteria(clazz).list().size();					
	}

	@SuppressWarnings("unchecked")
	public List<T> findRange(int first, int max) throws HibernateException, Exception {
		return (List<T>) session.createCriteria(clazz).setFirstResult(first).setMaxResults(max);		
	}

	@SuppressWarnings("unchecked")
	private Class<T> inferGenericType() {
		return (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
