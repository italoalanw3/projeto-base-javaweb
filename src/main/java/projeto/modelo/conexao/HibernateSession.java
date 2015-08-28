package projeto.modelo.conexao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@RequestScoped
public class HibernateSession {

	@Inject
	private SessionFactory factory;
	private Calendar dataSession;
	
	private Logger log;
	
	public HibernateSession() {
		// TODO Auto-generated constructor stub
	}
	
	@Produces @RequestScoped	
	public Session getSession() {
		log = Logger.getLogger(HibernateSession.class);
		Session session = factory.openSession();
		dataSession = Calendar.getInstance();
		log.debug("-------------------------------------------------");
		log.debug("Criando session do hibernate as "+ new SimpleDateFormat("hh:mm:ss:ms dd/MM/yyyy").format(dataSession.getTime()));		
		return session;
	}
		
	public void close(@Disposes Session session) {
		if (session.isOpen()) {
			log.debug("Destruindo session do hibernate que foi criada as " + new SimpleDateFormat("hh:mm:ss:ms dd/mm/yyyy").format(dataSession.getTime()));
			log.debug("Tempo total de sessão do hibernate: "+((Calendar.getInstance().getTimeInMillis() - dataSession.getTimeInMillis()))+" em milisegundos");			
			session.close();			
		}
	}
}
