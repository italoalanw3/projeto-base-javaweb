package projeto.modelo.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import projeto.modelo.util.SegurancaUtilMD5;

@Entity
@Table(name = "usuario")
public class Usuario extends EntidadeAbstrata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "{javax.validation.constraints.NotNull.message}")
	@Size(min = 8, max = 50, message = "{javax.validation.constraints.Size.message}")
	@Column(name = "nome")	
	private String nome;
	
	@NotEmpty(message = "{javax.validation.constraints.NotNull.message}")
	@Size(min = 5, max = 50, message = "{javax.validation.constraints.Size.message}")
	@Column(name = "email", unique = true)
	private String email;
	
	@NotEmpty(message = "{javax.validation.constraints.NotNull.message}")
	@Size(min = 3, max = 50, message = "{javax.validation.constraints.Size.message}")
	@Column(name = "senha")
	private String senha;

	@ManyToMany
	@JoinTable(name = "grupos_usuarios", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_grupo_usuario"))
	private List<GrupoUsuario> grupos;

	@Transient
	private boolean autenticado;
	
	public Usuario() {
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		senha = SegurancaUtilMD5.md5(senha);
		this.senha = senha;
	}

	public List<GrupoUsuario> getGrupos() {
		return grupos;
	}

	public void setGrupoUsuario(List<GrupoUsuario> grupos) {
		this.grupos = grupos;
	}

	public boolean getAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

}
