package controllers;


import com.fasterxml.jackson.databind.JsonNode;

import models.Comentario;
import models.Publicacao;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.Result;

public class ComentarioController extends Controller{
	Usuario usuario;
	Publicacao pub;
	
	public Result cadastrar(){
		JsonNode resultado = request().body().asJson();
		String t = session().get("token");
		usuario = Usuario.getUserToken(t); 
		pub = Publicacao.buscar(resultado.get("publicacaoId").asLong());
		
		Comentario comentario  = new Comentario(pub, usuario,resultado.get("texto").asText());
		comentario.save();
		
		return ok();
	}

	public Result remover(Long id){
		Comentario comentario = Comentario.buscar(id);
		comentario.delete();
		return ok("comentario removido");
	}
}
