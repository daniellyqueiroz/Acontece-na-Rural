package modelos;

import java.util.Date;

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
public class Publicacao {
	@Id
	private long id;
	
	@ManyToOne
	@JoinColumn (nullable= false, updatable = false)//nao ser criado com o valor null e nem ser atualizado
	private Usuario usuario;
	
	@Column (nullable =false)
	private String texto;
	
	private String[] imagens;//criar um objeto anexo com id e link 
	private Date dataCriacao; // procura anotacao
	private Date dataModificacao;
	
	@OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL)
	@JoinColumn
	private Reacao [] reacoes;
	
	private String[] tags;// ser Cursos [OBJETO]
	
	@OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL)
	@OrderBy("id DESC")
	@JoinColumn
	private Comentario[] comentarios;//verificar se eh array ou arrayList
	
	public Publicacao(long id, Usuario usuario, String texto, String[] imagens, Date dataCriacao, Date dataModificacao, Reacao [] reacoes,
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

	public long getId() {
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
	
	
	



}
