package projeto.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import projeto.controller.sessao.UserInfo;
import projeto.facade.UsuarioFacade;
import projeto.modelo.entidade.Usuario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {

	private Validator validator;
	private Result result;
	private UserInfo userInfo;
	private UsuarioFacade usuarioFacade;
	
	public LoginController() {
	}

	@Inject
	public LoginController(Validator validator, Result result, UserInfo userInfo, UsuarioFacade usuarioFacade) {
		this.validator = validator;
		this.result = result;
		this.userInfo = userInfo;
		this.usuarioFacade = usuarioFacade;
	}
	
	
	@Get("login")
	public void login() {
	}
	
	public void erros(){
		Message msg1 = new SimpleMessage("login.erro", "?");
		Message msg2 = new SimpleMessage("login.email.senha.invalido",
				"login.erro.email.senha.invalido");
		List<Message> msgs = new ArrayList<Message>();
		msgs.add(msg1);
		msgs.add(msg2);
		validator.addAll(msgs);
		validator.onErrorForwardTo(this).login();
	}

	@Post("/login")
	public void login(Usuario usuario) {
		if(usuario.getEmail() == null || usuario.getSenha() == null){
			erros();
		}
		if (!usuarioFacade.autenticarUsuario(usuario)) {
			erros();	
		}		

		usuario.setAutenticado(true);
		this.userInfo.setUsuarioLogado(usuario);

		result.redirectTo(HomeController.class).index();

	}

	@Get("/logout")
	public void logout() {
		userInfo.logout();

		result.redirectTo(this).login();
	}
}
