package projeto.modelo.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grupo_usuario")
public class GrupoUsuario extends EntidadeAbstrata implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nome", unique = true)
	private String nome;
	
	@ManyToMany(mappedBy = "grupos")
	private List<Usuario> usuarios;
	
	
	public GrupoUsuario() {
	}	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuario(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
