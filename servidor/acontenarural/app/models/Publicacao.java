package models;


import java.util.Arrays;
import java.util.Date;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table
public class Publicacao extends Model{
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn (nullable= false, updatable = false)//nao ser criado com o valor null e nem ser atualizado
	private Usuario usuario;
	
	@Column (nullable =false)
	private String texto;
	
	private String[] imagens;//criar um objeto anexo com id e link 
	
	@WhenCreated
	@Column (nullable=false, updatable = false) 
	private Date dataCriacao;
	
	@WhenModified
	@Column  
	private Date dataModificacao;
	
	@OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL)
	@JoinColumn
	private Reacao [] reacoes;
	
	private String[] tags;// ser Cursos [OBJETO]
	
	@OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL)
	@OrderBy("id DESC")
	@JoinColumn
	private Comentario[] comentarios;//verificar se eh array ou arrayList
	
	
	
	public Publicacao(Long id, Usuario usuario, String texto, String[] imagens, Date dataCriacao, Date dataModificacao, Reacao [] reacoes,
			String[] tags, Comentario[] comentarios){
		
		this.id = id;
		this.usuario = usuario;
		this.texto = texto;
		this.imagens = imagens;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
		this.reacoes= reacoes;
		this.tags = tags;
		this.comentarios = comentarios;
	}

	public Reacao[] getReacoes() {
		return reacoes;
	}

	public void setReacoes(Reacao[] reacoes) {
		this.reacoes = reacoes;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public Comentario[] getComentarios() {
		return comentarios;
	}

	public void setComentarios(Comentario[] comentarios) {
		this.comentarios = comentarios;
	}

	public Long getId() {
		return id;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public String getTexto() {
		return texto;
	}

	public String[] getImagens() {
		return imagens;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}
	public Date getDataModificacao() {
		return dataModificacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(comentarios);
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataModificacao == null) ? 0 : dataModificacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(imagens);
		result = prime * result + Arrays.hashCode(reacoes);
		result = prime * result + Arrays.hashCode(tags);
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
		Publicacao other = (Publicacao) obj;
		if (!Arrays.equals(comentarios, other.comentarios))
			return false;
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
		if (!Arrays.equals(imagens, other.imagens))
			return false;
		if (!Arrays.equals(reacoes, other.reacoes))
			return false;
		if (!Arrays.equals(tags, other.tags))
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
		return "Publicacao [id=" + id + ", usuario=" + usuario + ", texto=" + texto + ", imagens="
				+ Arrays.toString(imagens) + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao
				+ ", reacoes=" + Arrays.toString(reacoes) + ", tags=" + Arrays.toString(tags) + ", comentarios="
				+ Arrays.toString(comentarios) + "]";
	}
	
	
	public static Publicacao buscar(Long id){
		return Ebean.createQuery(Publicacao.class).where().eq("id", id).findUnique();
	}
}

