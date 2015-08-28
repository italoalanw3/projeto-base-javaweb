package projeto.facade;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;

import projeto.modelo.dao.hibernate.implementacao.UsuarioHibernateDao;
import projeto.modelo.entidade.Usuario;

public class UsuarioFacade implements IFacade<Usuario> {
	
	@Inject
	private UsuarioHibernateDao usuarioDao;
	
	public UsuarioFacade() {
	}

	@Override
	public void create(Usuario entity) throws HibernateException, Exception {
		usuarioDao.save(entity);
	}

	@Override
	public void edit(Usuario entity) throws HibernateException, Exception {
		usuarioDao.update(entity);		
	}

	@Override
	public void remove(Usuario entity) throws HibernateException, Exception {
		usuarioDao.delete(entity);		
	}

	@Override
	public Usuario load(Long id) throws HibernateException, Exception {
		return usuarioDao.find(id);
	}

	@Override
	public List<Usuario> list() throws HibernateException, Exception {
		return usuarioDao.findAll();
	}

	@Override
	public List<Usuario> listPagination(int first, int max)
			throws HibernateException, Exception {
		return usuarioDao.findRange(first, max);
	}

	@Override
	public int count() throws HibernateException, Exception {
		return usuarioDao.count();
	}
	
	public boolean autenticarUsuario(Usuario usuario){
		return usuarioDao.validarUsuario(usuario) != null ? true : false;
	}
}
