package controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import modelos.Comentario;
import modelos.Publicacao;
import modelos.Usuario;
import repositorios.ComentarioRepositorio;
import repositorios.PublicacaoRepositorio;
import repositorios.UsuarioRepositorio;

@RestController
@RequestMapping("/user/feed")
public class ComentarioController {
	@Autowired
	private ComentarioRepositorio comentarioRepositorio;
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private PublicacaoRepositorio publicacaoRepositorio;
	
	@RequestMapping(method=RequestMethod.POST)
	public Comentario save(@RequestBody Comentario comentario){
		return comentarioRepositorio.save(comentario);
	}
	
	//atualizar um comentário
	//NÃO ESTÁ FUNCIONANDO, NÃO ATUALIZA O COMENTARIO
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public ResponseEntity<Comentario> put(@RequestBody Comentario comentario, @PathVariable Long id){
		return new ResponseEntity<Comentario>(comentario, HttpStatus.OK);
	}
	
	//remover um comentário
	//vamos poder deletar por id?
	//se sim, deveria ter um (caminhoPubli)/comment/id
	/*@DeleteMapping(value="/{id}")
	public String deleteById(@PathVariable Long id){
		if (comentarioRepositorio.exists(id)){
			comentarioRepositorio.delete(id);
			return "removeu";
		} else {
			return "não removeu";
		}
	}	*/
	
	//VERIFICAR QUAL DESSES É MAIS CORRETO
	//o primeiro ou o segundo delete
	@DeleteMapping
	public String deleteByObject(@RequestBody Comentario comentario){
		String retorno;
		if (comentarioRepositorio.exists(comentario.getId())){
			comentarioRepositorio.delete(comentario);
			retorno = "removeu";
		} else retorno = "não removeu";
		return retorno;
		
	}
	
	@DeleteMapping
	public String deleteByObject(@RequestBody Comentario comentario, @RequestBody Usuario usuario){
		String retorno = "não removeu";
		if (comentarioRepositorio.exists(comentario.getId())){
			if (usuario.getId().equals(comentario.getUsuario().getId())){
				comentarioRepositorio.delete(comentario);
				retorno = "removeu";
			}
			
		}
		return retorno;
	}
	
	//remover todos os comentários do banco
	@DeleteMapping
	public String deleteAll(){
		comentarioRepositorio.deleteAll();
		return "Perdeu tudo. Lide com isso";
	}	

	//DA FORMA ATUAL NÃO SERIA POSSÍVEL
	//TERIA DE TER ALGO COMO (caminhoPubli)/comments/id
	//pegar um comentario apenas
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Comentario get(@PathVariable(name="id") Long id){
		if(comentarioRepositorio.exists(id)){
			return comentarioRepositorio.findOne(id);
		} else {
			return null;
		}
	}
	
	//pegar todos os comentarios de uma publicação
	@RequestMapping
	public Comentario[] getAllPubli(@RequestBody Publicacao publicacao){
		Comentario[] comentarios = null;
		if (publicacaoRepositorio.exists(publicacao.getId())){
			comentarios = publicacao.getComentarios();
		}
		return comentarios;
	}
	
	
	//pegar todos os comentários
	@RequestMapping
	public Comentario[] getAll(){
		return (Comentario[]) comentarioRepositorio.findAll().toArray();
	}
}
