package projeto.modelo.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cliente_fisico")
public class ClienteFisico extends Cliente implements Serializable{	
	
	private static final long serialVersionUID = 1L;

    @Size(min=3, max=200, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "apelido")
	private String apelido;
	
	@NotEmpty(message="{javax.validation.constraints.NotNull.message}")
    @Size(min=3, max=200, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "cpf")
	private String cpf;
		
    @Size(min=2, max=20, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "rg")
	private String rg;
		
    @Size(min=8, max=20, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "emissor")
	private String emissor;
		
    @Size(min=8, max=20, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "telefone")
	private String telefone;
	
    public ClienteFisico() {
	}
}