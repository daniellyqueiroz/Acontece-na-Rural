package models;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

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
@JsonAutoDetect
public class Publicacao extends Model{
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn (nullable= false, updatable = false)//nao ser criado com o valor null e nem ser atualizado
	private Usuario usuario;
	
	@Column (nullable =false)
	private String texto;
	
	//private String[] imagens;//criar um objeto anexo com id e link 
	
	@WhenCreated
	@Column (nullable=false, updatable = false) 
	private Date dataCriacao;
	
	@WhenModified
	@Column  
	private Date dataModificacao;
	
	@OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL)
	@JoinColumn
	private  List<Reacao> reacao;
	
	//private String[] tags;// ser Cursos [OBJETO]
	
	@OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL)
	@OrderBy("id DESC")
	@JoinColumn
	private List<Comentario> comentarios;
	
	
	
	public Publicacao(Usuario usuario, String texto){
		
		this.usuario = usuario;
		this.texto = texto;
		this.reacao= new ArrayList<Reacao>();
		this.comentarios = new ArrayList<Comentario>();
	}

	public List<Reacao> getReacoes() {
		return reacao;
	}

	public void setReacoes(List<Reacao> reacao) {
		this.reacao = reacao;
	}


	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
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


	public Date getDataCriacao() {
		return dataCriacao;
	}
	public Date getDataModificacao() {
		return dataModificacao;
	}

	
	/*public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(comentarios);
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
		if (!Arrays.equals(comentarios)))
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
	//	if (!Arrays.equals(reacoes, other.reacoes))
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
	}*/

	
	
	public static Publicacao buscar(Long id){
		return Ebean.createQuery(Publicacao.class).where().eq("id", id).findUnique();
	}
	
	//retornar todas as publica��es no qual o id do usuario
	//public static  List<Publicacao> buscar(Long idUsuario){
		//return Ebean.createQuery(Publicacao.class).usuario.where().eq("id", idUsuario).findList();
	//}

	public static  List<Publicacao> listar(){
		return Ebean.createQuery(Publicacao.class).where().findList();
	}

}

