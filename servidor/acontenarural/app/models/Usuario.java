package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.avaje.ebean.*;
import com.avaje.ebean.annotation.JsonIgnore;
import com.avaje.ebean.annotation.WhenCreated;
import com.avaje.ebean.annotation.WhenModified;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@JsonAutoDetect
public class Usuario extends Model{
	@Id
	private Long id;
	
	@Column (nullable= false)
	private int avaId;
	
	@Column (nullable= false)
	private String username;
	
	@JsonIgnore
	@Column 
	private String token;
	
	@Column (nullable= false)
	private String nome;
	
	@Column 
	private String matricula;
	
	@Column 
	private String imagem;
	
	@Column 
	private String imagemSmall;
	
	@Column 
	private String cidade;
	
	@Column 
	private String pais;
	
	@Column 
	private String instituicao;
	
	@Column 
	private String email;
	
	@Column 
    private String departamento;
	
	@WhenCreated
	@Column (nullable=false, updatable = false) 
	private Date dataCriacao;
	
	@WhenModified
	@Column  
	private Date dataModificacao;
	
	private List<Publicacao> publicacoesSalvas;//tabela id de usuario, id de publicacao
    
    private TempoAva tempoLembreteAva;
    
    public Usuario(int avaId, String matricula, String username, String nome,String email, String instituicao, 
    		 String departamento, String cidade, String pais, String imagem, String imagemSmall){
    	
    	this.avaId = avaId;
    	this.matricula = matricula;
    	this.username = username;
    	this.nome = nome;
    	this.email = email;
    	this.instituicao = instituicao;
    	this.imagem = imagem;
    	this.departamento = departamento;
    	this.cidade = cidade;
    	this.pais = pais;
    	this.imagemSmall = imagemSmall;
    	this.token = token;
    	this.publicacoesSalvas = new ArrayList<Publicacao>();
    	this.tempoLembreteAva = TempoAva.OITOHORAS;
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
	public void setToken(String token) {
		this.token = token;
	}
	
	

	public int getAvaId() {
		return avaId;
	}
	public String getUsername() {
		return username;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getImagem() {
		return imagem;
	}
	public String getImagemSmall() {
		return imagemSmall;
	}
	public String getCidade() {
		return cidade;
	}
	public String getPais() {
		return pais;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public String getEmail() {
		return email;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTempoLembreteAva(int tempoLembreteAva) {
		this.tempoLembreteAva = tempoLembreteAva;
	}
	
	public enum TempoAva{
		DOISHORAS(2),
		QUATROHORAS(4),
		OITOHORAS(8),
		DOZEHORAS(12),
		VQUATRO(24),
		QOITO(48);
		
		public int tempo;
		
		TempoAva(int tempo){
			this.tempo = tempo;
		}
	}
	
	/*public int hashCode() {
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
	*/
	public static  List<Usuario> listar(){
		return Ebean.createQuery(Usuario.class).where().findList();
	}
	
	public static Usuario buscar(Long id){
		return Ebean.createQuery(Usuario.class).where().eq("id", id).findUnique();
	}
	
	public static Usuario buscar(String username){
		return Ebean.createQuery(Usuario.class).where().eq("username", username).findUnique();
	}
	
	public static Usuario getUserToken(String token) {
		 return Ebean.createQuery(Usuario.class).where().eq("token", token).findUnique();
	}
    
    
}

