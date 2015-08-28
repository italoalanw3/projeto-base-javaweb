package projeto.controller.supercontroller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import projeto.controller.anotacoes.Transacional;
import projeto.facade.IFacade;
import projeto.modelo.entidade.EntidadeAbstrata;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

public abstract class CrudController<T extends EntidadeAbstrata> extends Controller{
	
	protected IFacade<T> facade;
	protected Validator validator;

	/**
	 *	@Get("/novo") 
	 */
	public abstract void form();
	
	/**
	 *	@Get("/novo/entidade.id") 
	 * utilizado para carregar formulario para edição
	 */
	@Transacional	
	@Get("/edita/{id}")	
	public abstract void form(T entidade);
	
	/**
	 *	@Get("/entidade") 
	 */
	public abstract void findAll();
	
	/**
	 *	@Post("/entidade/") 
	 */
	public abstract void save(@NotNull @Valid T entidade);
	
	/**
	 * @Get("/entidade/remove/{id}")
	 */
	public abstract void delete(@NotNull @Valid T entidade);	
	
	/**
	 * @Get("/entidade/{id}")
	 */
	//public abstract void carrega(@NotNull @Valid int id);
	
	 	//Redirecionamento para casos de erros: Validaçăo ou falha de cadastro/ediçăo;
	 	public void messageSucessSave(TIPO_FORMULARIO tipo) {
	 		switch (tipo) {
	 		case NOVO:
	 			result.include("mensagemAdicionar","mensagem.adicionado"); // ? indica que não existe mensagem para internacionalização
	 			break;
	 		case EDITA:
	 			result.include("mensagemAlterar","mensagem.alterado"); // ? indica que não existe mensagem para internacionalização
	 			break;
	 		}
	 		result.redirectTo(classType()).findAll();
	 	}
	 
	 	public enum TIPO_FORMULARIO {
	 		NOVO, EDITA;
	 	}
	 
	 	protected abstract Class<? extends CrudController> classType();
	
}
