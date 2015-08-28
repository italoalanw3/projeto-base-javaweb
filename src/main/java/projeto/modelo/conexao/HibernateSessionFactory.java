package projeto.modelo.conexao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
@ApplicationScoped
public class HibernateSessionFactory {

	private final SessionFactory factory;
	Logger log = Logger.getLogger(HibernateSessionFactory.class);
	
	public HibernateSessionFactory() {
		log.info("Criando SessionFactory...");
		factory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
		log.info("Nova SessionFactory disponivel " + factory);
	}

	@Produces
	public final SessionFactory sessionFactory() {
		return factory;
	}
	
	public void iniciarComAplicacao(@Observes ServletContext servlet){
		System.out.println("HibernateSessionFactory disponivel: "+factory);
	}
}
