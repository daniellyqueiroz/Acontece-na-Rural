package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import modelos.Publicacao;
import modelos.Usuario;
import repositorios.PublicacaoRepositorio;
import repositorios.UsuarioRepositorio;

@RestController
@RequestMapping("/user/feed")
public class PublicacaoController {
	
	@Autowired
	private PublicacaoRepositorio publicacaoRepositorio;
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	
	//POST
	@RequestMapping(method=RequestMethod.POST)
	public Publicacao save(@RequestBody Publicacao publicacao){
		return publicacaoRepositorio.save(publicacao);
	}
	
	//PUT
	//atualizar uma publicacao
	//NÃO ESTÁ FUNCIONANDO, NÃO ATUALIZA A PUBLI
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public ResponseEntity<Publicacao> put(@RequestBody Publicacao publicacao, @PathVariable Long id){
		return new ResponseEntity<Publicacao>(publicacao, HttpStatus.OK);
	}
	
	//DELETE
	
	//VERIFICAR QUAL DESSES É MAIS CORRETO
		//o primeiro ou o segundo delete
		@DeleteMapping
		public String deleteByObject(@RequestBody Publicacao publicacao){
			String retorno;
			if (publicacaoRepositorio.exists(publicacao.getId())){
				publicacaoRepositorio.delete(publicacao);
				retorno = "removeu";
			} else retorno = "não removeu";
			return retorno;
			
		}
		
		@DeleteMapping
		public String deleteByObject(@RequestBody Publicacao publicacao, @RequestBody Usuario usuario){
			String retorno = "não removeu";
			if (publicacaoRepositorio.exists(publicacao.getId())){
				if (usuario.getId().equals(publicacao.getUsuario().getId())){
					publicacaoRepositorio.delete(publicacao);
					retorno = "removeu";
				}
				
			}
			return retorno;
		}
		
		//remover todos as publi do banco
		@DeleteMapping
		public String deleteAll(){
			publicacaoRepositorio.deleteAll();
			return "Perdeu tudo. Lide com isso";
		}	
		
		//GET 
		//DA FORMA ATUAL NÃO SERIA POSSÍVEL
		//TERIA DE TER ALGO COMO /user/feed/(caminhoPubli = id)
		//pegar um publicacao apenas
		@RequestMapping(method=RequestMethod.GET, value="/{id}")
		public Publicacao get(@PathVariable(name="id") Long id){
			if(publicacaoRepositorio.exists(id)){
				return publicacaoRepositorio.findOne(id);
			} else {
				return null;
			}
		}
		
		//pegar todos as publicacoes de um usuario
		@RequestMapping
		public Publicacao[] getAllPubliSalvasUsuario(@RequestBody Usuario usuario){
			Publicacao[] publicacoes = null;
			if (usuarioRepositorio.exists(usuario.getId())){
				publicacoes = usuario.getPublicacoesSalvas();
			}
			return publicacoes;
		}

		//pegar todos os comentários
		@RequestMapping
		public Publicacao[] getAll(){
			return (Publicacao[]) publicacaoRepositorio.findAll().toArray();
		}
}
