package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.avaje.ebean.*;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Usuario extends Model{
	@Id
	private Long id;
	
	@Column (nullable= false)
	private String nome;
	
	@Column 
	private String token;
	
	@Column (nullable= false)
	private String curso;
	
	@Column 
	private String imagem;
	
	@Column 
    private String descricao;
	
	@WhenCreated
	@Column (nullable=false, updatable = false) 
	private Date dataCriacao;
	
	@WhenModified
	@Column  
	private Date dataModificacao;
	
	
	private List<Publicacao> publicacoesSalvas;//tabela id de usuario, id de publicacao
    
    private int tempoLembreteAva; // perguntar a Joao
    
    public Usuario(String nome, String token, String curso, String imagem, String descricao, 
    				 int tempoLembreteAva){
    	
    	this.nome = nome;
    	this.token = token;
    	this.curso = curso;
    	this.imagem = imagem;
    	this.descricao = descricao;
    	this.publicacoesSalvas = new ArrayList<Publicacao>();
    	this.tempoLembreteAva = tempoLembreteAva;
    }
    public Usuario(){
    	
    }

	public Long getId() {
		return id;
	}

	

	public String getNome() {
		return nome;
	}

	

	public String getToken() {
		return token;
	}

	
	public String getCurso() {
		return curso;
	}

	

	public String getImagem() {
		return imagem;
	}

	

	public String getDescricao() {
		return descricao;
	}

	

	/*public Publicacao[] getPublicacoesSalvas() {
		return publicacoesSalvas;
	}*/

	/*public void setPublicacoesSalvas(Publicacao[] publicacoesSalvas) {
		this.publicacoesSalvas = publicacoesSalvas;
	}*/

	public int getTempoLembreteAva() {
		return tempoLembreteAva;
	}

	public void setTempoLembreteAva(int tempoLembreteAva) {
		this.tempoLembreteAva = tempoLembreteAva;
	}
	public static  List<Usuario> listar(){
		return Ebean.createQuery(Usuario.class).where().findList();
	}
	
	public static Usuario buscar(Long id){
		return Ebean.createQuery(Usuario.class).where().eq("id", id).findUnique();
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imagem == null) ? 0 : imagem.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		//result = prime * result + Arrays.hashCode(publicacoesSalvas);
		result = prime * result + tempoLembreteAva;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imagem == null) {
			if (other.imagem != null)
				return false;
		} else if (!imagem.equals(other.imagem))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		//if (!Arrays.equals(publicacoesSalvas, other.publicacoesSalvas))
			//return false;
		if (tempoLembreteAva != other.tempoLembreteAva)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}


	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", token=" + token + ", curso=" + curso + ", imagem=" + imagem
				+ ", descricao=" + descricao + ", publicacoesSalvas=" //+ Arrays.toString(publicacoesSalvas)
				+ ", tempoLembreteAva=" + tempoLembreteAva + "]";
	}
    
    
}

