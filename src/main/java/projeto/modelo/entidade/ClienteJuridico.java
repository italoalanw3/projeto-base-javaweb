package projeto.modelo.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cliente_juridico")
public class ClienteJuridico extends Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="{javax.validation.constraints.NotNull.message}")
    @Size(min=4, max=20, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "cnpj")
	private String cnpj;
	
	@NotEmpty(message="{javax.validation.constraints.NotNull.message}")
    @Size(min=4, max=200, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "nome_fantasia")
	private String nomeFantasia;
	
	public ClienteJuridico() {
	}
	
}
