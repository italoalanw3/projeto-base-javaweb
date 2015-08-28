package projeto.modelo.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="endereco")
public class Endereco extends EntidadeAbstrata implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
				
	@NotEmpty(message="{javax.validation.constraints.NotNull.message}")
    @Size(min=8, max=100, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "logradouro")
	private String logradouro;
		
    @Size(min=1, max=10, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "numero")
	private String numero;
		
    @Size(min=2, max=150, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "bairro")
	private String bairro;
		
    @Size(min=4, max=100, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "cidade")
	private String cidade;
		
    @Size(min=4, max=10, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "cep")
	private String cep;
		
    @Size(min=2, max=10, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "uf")
	private String uf;		
		
    @Size(min=2, max=100, message="{javax.validation.constraints.Size.message}") 
	@Column(name = "complemento")
	private String complemento;
    
    public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
