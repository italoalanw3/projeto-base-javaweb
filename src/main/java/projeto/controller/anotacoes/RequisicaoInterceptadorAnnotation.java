package projeto.controller.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.caelum.vraptor.interceptor.AcceptsConstraint;
import br.com.caelum.vraptor.interceptor.WithAnnotationAcceptor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@AcceptsConstraint(WithAnnotationAcceptor.class)
@Inherited
public @interface RequisicaoInterceptadorAnnotation {
	public Class<? extends Object> value();
}
