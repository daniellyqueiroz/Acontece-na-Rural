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
	private Long id;
	
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
	
	public Reacao(Long id, Tipo tipo, Publicacao publicacao, Usuario usuario){
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

	public Long getId() {
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataModificacao == null) ? 0 : dataModificacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((publicacao == null) ? 0 : publicacao.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Reacao other = (Reacao) obj;
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
		if (tipo != other.tipo)
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
		return "Reacao [id=" + id + ", tipo=" + tipo + ", publicacao=" + publicacao + ", usuario=" + usuario
				+ ", dataModificacao=" + dataModificacao + ", dataCriacao=" + dataCriacao + "]";
	}
	
	
}
