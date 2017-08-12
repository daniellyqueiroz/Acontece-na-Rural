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
	private Long id;
	
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
	
	
	public Comentario(Long id, Publicacao publicacao, Usuario usuario, String texto, Date dataCriacao, Date dataModificacao){
		this.id = id;
		this.publicacao = publicacao;
		this.usuario = usuario;
		this.texto = texto;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
		
	}


	public Long getId() {
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
	
	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataModificacao == null) ? 0 : dataModificacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((publicacao == null) ? 0 : publicacao.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataModificacao == null) {
			if (other.dataModificacao != null)
				return false;
		} else if (!dataModificacao.equals(other.dataModificacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (publicacao == null) {
			if (other.publicacao != null)
				return false;
		} else if (!publicacao.equals(other.publicacao))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Comentario [id=" + id + ", publicacao=" + publicacao + ", usuario=" + usuario + ", texto=" + texto
				+ ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + "]";
	}
	
	

}
