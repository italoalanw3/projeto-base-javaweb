package projeto.modelo.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="fabricante")
public class Fabricante extends EntidadeAbstrata implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "{org.hibernate.validator.constraints.NotEmpty.message}")
	@Size(min = 4, max = 100, message = "{javax.validation.constraints.Size.message}")
	@Column(name = "nome")
	private String nome;
	
	
	public Fabricante() {	
	}
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
