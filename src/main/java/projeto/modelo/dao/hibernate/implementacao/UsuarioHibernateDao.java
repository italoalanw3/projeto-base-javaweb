package projeto.modelo.dao.hibernate.implementacao;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import projeto.modelo.dao.hibernate.HibernateDao;
import projeto.modelo.dao.interfaces.IUsuarioDao;
import projeto.modelo.entidade.Usuario;

public class UsuarioHibernateDao extends HibernateDao<Usuario> implements IUsuarioDao {
	
	public UsuarioHibernateDao() {
	}
	
	@Inject
	public UsuarioHibernateDao(Session session) {
		this.session = session;
	}
	
	public boolean verificaExiste(String valor) {
		boolean isExiste = false;
		try {
			session.getTransaction().begin();			
			// Retorna true se estiver vazio
			isExiste = !session.createCriteria(Usuario.class)
					.add(Restrictions.eq("email", valor)).list().isEmpty();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		}
		return isExiste;
	}

	public Usuario validarUsuario(Usuario usuario) {
		try {
			Usuario usuarioValido;
			session.getTransaction().begin();
			usuarioValido = (Usuario) session
					.createCriteria(Usuario.class)
					.add(Restrictions.eq("email", usuario.getEmail()))
					.add(Restrictions.and(Restrictions.eq("senha",
							usuario.getSenha()))).uniqueResult();
			if (usuarioValido == null) {
				usuario.setSenha("");
				usuario.setNome(""); // Reseta a senha para não voltar valor
							// descriptografado
			}
			session.getTransaction().commit();
			return usuarioValido;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			return null;
		}
		
	}

}
