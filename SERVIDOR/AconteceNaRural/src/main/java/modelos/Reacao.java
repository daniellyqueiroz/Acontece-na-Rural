package modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Reacao {
	@Id
	private long id;
	
	@Enumerated //enum
	@Column (nullable = false)
	private Tipo tipo;
	
	@ManyToOne
	@JoinColumn
	private Publicacao publicacao;
	
	@ManyToOne
	@JoinColumn (nullable= false, updatable = false)
	private Usuario usuario;
	
	private Date dataModificacao;
	private Date dataCriacao;
	
	public Reacao(long id, Tipo tipo, Publicacao publicacao, Usuario usuario){
		this.id = id;
		this.tipo = tipo;
		this.publicacao = publicacao;
		this.usuario = usuario;
	}
	
	
	
	public Date getDataModificacao() {
		return dataModificacao;
	}



	public Date getDataCriacao() {
		return dataCriacao;
	}



	public Tipo getTipo() {
		return tipo;
	}



	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}



	public Publicacao getPublicacao() {
		return publicacao;
	}



	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}



	public long getId() {
		return id;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public enum Tipo{
		CURTIR("Curtir"),
		DESCURTIR("Descurtir");
		public String label;
		Tipo(String label){
			this.label = label;
		}
	}
}
