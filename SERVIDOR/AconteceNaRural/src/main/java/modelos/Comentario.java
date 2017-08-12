package modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
@Entity
@Table
public class Comentario {
	@Id
	private long id;
	
	@ManyToOne
	@JoinColumn
	private Publicacao publicacao;
	
	@ManyToOne
	@JoinColumn (nullable= false, updatable = false)
	private Usuario usuario;
	
	@Column (nullable =false)
	private String texto;
	
	private Date dataCriacao;
	private Date dataModificacao;
	
	
	public Comentario(long id, Publicacao publicacao, Usuario usuario, String texto, Date dataCriacao, Date dataModificacao){
		this.id = id;
		this.publicacao = publicacao;
		this.usuario = usuario;
		this.texto = texto;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
		
	}


	public long getId() {
		return id;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getTexto() {
		return texto;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}
	
	

}
