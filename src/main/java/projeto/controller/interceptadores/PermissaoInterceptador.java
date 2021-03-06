package projeto.controller.interceptadores;

import projeto.controller.anotacoes.PermissaoInterceptadorAnnotation;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.BeforeCall;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;

@AcceptsWithAnnotations(PermissaoInterceptadorAnnotation.class)
public class PermissaoInterceptador {
	
	@BeforeCall
	public void verificaPermissao(){
		
	}
	
	/** Intercepta apenas os m�todos que possuem a anota��o */
	@AroundCall
    public boolean around(ControllerMethod method) {
		return true;//return method.containsAnnotation(GRUPO_USUARIO.ADMINISTRADOR);
    }

}