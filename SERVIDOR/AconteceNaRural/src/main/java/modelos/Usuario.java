package modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Usuario {
	@Id
	private long id;
	
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
	
    private Publicacao[] publicacoesSalvas;//tabela id de usuario, id de publicacao
    
    private int tempoLembreteAva; // perguntar a Joao
    
    public Usuario(long id, String nome, String token, String curso, String imagem, String descricao, Publicacao[] publicacoesSalvas,
    				 int tempoLembreteAva){
    	this.id = id;
    	this.nome = nome;
    	this.token = token;
    	this.curso = curso;
    	this.imagem = imagem;
    	this.descricao = descricao;
    	this.publicacoesSalvas = publicacoesSalvas;
    	this.tempoLembreteAva = tempoLembreteAva;
    }

	public long getId() {
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

	

	public Publicacao[] getPublicacoesSalvas() {
		return publicacoesSalvas;
	}

	public void setPublicacoesSalvas(Publicacao[] publicacoesSalvas) {
		this.publicacoesSalvas = publicacoesSalvas;
	}

	

	public int getTempoLembreteAva() {
		return tempoLembreteAva;
	}

	public void setTempoLembreteAva(int tempoLembreteAva) {
		this.tempoLembreteAva = tempoLembreteAva;
	}
    
    
}
