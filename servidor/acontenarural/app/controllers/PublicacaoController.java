package controllers;


import com.fasterxml.jackson.databind.JsonNode;

import models.Publicacao;
import models.Usuario;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class PublicacaoController extends Controller {
	Usuario usuario;
	
	//Teste
	public Result cadastrar(){
		JsonNode resultado = request().body().asJson();
		String t = session().get("token");
		usuario = Usuario.getUserToken(t);
		
		Publicacao pub = new Publicacao(usuario,resultado.get("texto").asText());
		pub.save();
		
		return ok("Cadastrou");
	}
	
	public Result listarTodas(){
		
		return ok(Json.toJson(Publicacao.listar()));
	}
	
	public Result remover(Long id){
		Publicacao pub = Publicacao.buscar(id);
		pub.delete();
		return ok("publicacao removida");
	
	}

	public Result atualizar(){
	
	return ok("");
	
	}
	
	public Result buscar(){
	
	return ok("");
	
	}
	
	
}
