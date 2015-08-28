package projeto.controller.interceptadores;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.ext.ParamConverter.Lazy;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import projeto.controller.anotacoes.Transacional;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.validator.Validator;


@Intercepts
@RequestScoped
@AcceptsWithAnnotations(Transacional.class)
@Lazy
public class TransacaoInterceptador{			
	
	private static final Logger LOG = Logger.getLogger(TransacaoInterceptador.class);
	
	private Session session;
    private Calendar timeTransacao;
    			
    public TransacaoInterceptador() {
	}
    
	@Inject	
    public TransacaoInterceptador(Session session) {
    	this.session = session;
	}
		
    @AroundCall
	public void intercept(SimpleInterceptorStack stack){    			
        try {        	
        	timeTransacao = Calendar.getInstance();
        	LOG.debug("Transação iniciada em: " + new SimpleDateFormat("hh:mm:ss:ms dd/MM/yyyy").format(timeTransacao.getTime()));
            session.getTransaction().begin();            
            stack.next();
            session.getTransaction().commit();
            LOG.debug("Commit da Transação iniciada em: "+new SimpleDateFormat("hh:mm:ss:ms dd/MM/yyyy").format(timeTransacao.getTime()));
            LOG.debug("Tempo total de transação: "+(Calendar.getInstance().getTimeInMillis() - timeTransacao.getTimeInMillis()));        	
        }
        catch(Exception e){
          	session.getTransaction().rollback();
            LOG.debug("Rollback da Transação via Exception (iniciada em: "+new SimpleDateFormat("hh:mm:ss:ms dd/MM/yyyy").format(timeTransacao.getTime())+") - "+e.getMessage());
            LOG.debug("Tempo total de transação: "+(Calendar.getInstance().getTimeInMillis() - timeTransacao.getTimeInMillis())+" em milisegundos");
        } finally {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
            	session.getTransaction().rollback();
                LOG.debug("Rollback da Transação via Validation (iniciada em: "+new SimpleDateFormat("hh:mm:ss:ms dd/MM/yyyy").format(timeTransacao.getTime())+")");
                LOG.debug("Tempo total de transação: "+(Calendar.getInstance().getTimeInMillis() - timeTransacao.getTimeInMillis())+" em milisegundos");
            }
       	}
	}
    
    
    
	
}
