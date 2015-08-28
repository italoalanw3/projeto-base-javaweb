package projeto.modelo.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto extends EntidadeAbstrata implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

}
