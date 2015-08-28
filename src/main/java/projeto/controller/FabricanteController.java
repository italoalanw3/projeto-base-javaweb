package projeto.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.HibernateException;

import projeto.controller.anotacoes.Transacional;
import projeto.controller.supercontroller.CrudController;
import projeto.facade.FabricanteFacade;
import projeto.modelo.dao.hibernate.HibernateDaoException;
import projeto.modelo.entidade.Fabricante;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

import java.util.List;

@Controller
@Path("/fabricante")
public class FabricanteController extends CrudController<Fabricante> {

	public FabricanteController() {
	}

	@Inject
	public FabricanteController(Result result, Validator validator,
			FabricanteFacade fabricanteFacade) {
		this.result = result;
		this.validator = validator;
		this.facade = fabricanteFacade;
	}

	@Override
	@Get("/novo")
	public void form() {

	}

	@Override
	public void form(Fabricante fabricante) {
		try {
			result.include("fabricante", facade.load(fabricante.getId()));
		} catch (HibernateException e) {
			Message msg = new SimpleMessage("message.hibernate.exception", "message.hibernate.exception");
			validator.add(msg);
		} catch (Exception e) {
			Message msg = new SimpleMessage("message.exception", "message.exception");
			validator.add(msg);
		}
	}

	@Transacional
	@Override
	@Post("/")
	public void save(@NotNull @Valid Fabricante fabricante) {
		try {
			validator.onErrorForwardTo(this).form();
			if (fabricante.getId() == 0) {
				facade.create(fabricante);
				messageSucessSave(TIPO_FORMULARIO.NOVO);
			} else {
				facade.edit(fabricante);
				messageSucessSave(TIPO_FORMULARIO.EDITA);
			}

		} catch (HibernateException e) {
			Message msg = new SimpleMessage("message.hibernate.exception", "message.hibernate.exception");
			validator.add(msg);
		} catch (Exception e) {
			Message msg = new SimpleMessage("message.exception", "message.exception");
			validator.add(msg);
		}

		validator.onErrorForwardTo(this).form();		
	}

	@Override
	@Get("/")
	public void findAll() {
		try {
			List<Fabricante> fabricantes = this.facade.list();
			if (fabricantes.isEmpty() == false) {
				result.include("fabricantes", fabricantes);
			}
		} catch (HibernateException e) {
			Message msg = new SimpleMessage("message.hibernate.exception", "message.hibernate.exception");
			validator.add(msg);
		} catch (Exception e) {
			Message msg = new SimpleMessage("message.exception", "message.exception");
			validator.add(msg);
		}
	}

	@Transacional
	@Override
	@Get("/delete/{id}")
	public void delete(Fabricante fabricante) {
		try {
			facade.remove(fabricante);
			result.include("mensagemRemover","mensagem.adicionado");
			result.redirectTo(this).findAll();	
		} catch (HibernateException e) {
			Message msg = new SimpleMessage("message.hibernate.exception", "message.hibernate.exception");
			validator.add(msg);
		} catch (Exception e) {
			Message msg = new SimpleMessage("message.exception", "message.exception");
			validator.add(msg);
		}
		
	}

	@Override
	protected Class<FabricanteController> classType() {
		// TODO Auto-generated method stub
		return FabricanteController.class;
	}

}
