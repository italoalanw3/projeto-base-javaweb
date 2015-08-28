package projeto.modelo.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public abstract class Cliente extends EntidadeAbstrata {

	@NotEmpty(message = "{javax.validation.constraints.NotNull.message}")
	@Size(min = 4, max = 100, message = "{javax.validation.constraints.Size.message}")
	@Column(name = "nome")
	private String nome;

	@NotEmpty(message = "{javax.validation.constraints.NotNull.message}")
	@Size(min = 8, max = 200, message = "{javax.validation.constraints.Size.message}")
	@Column(name = "email")
	private String email;

	@Size(min = 2, max = 100, message = "{javax.validation.constraints.Size.message}")
	@Column(name = "observacoes")
	private String observacoes;

	@Column(name = "situacao")
	private boolean situacao;

	@Column(name = "limite_credito")
	private BigDecimal limiteCredito;

	@Column(name = "limite_desconto")
	private BigDecimal limiteDesconto;

	@OneToOne
	@JoinColumn(name = "id_endereco", nullable=false)
	private Endereco endereco;

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

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public BigDecimal getLimiteDesconto() {
		return limiteDesconto;
	}

	public void setLimiteDesconto(BigDecimal limiteDesconto) {
		this.limiteDesconto = limiteDesconto;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
