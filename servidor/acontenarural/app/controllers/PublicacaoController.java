package controllers;


import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;

import models.Publicacao;
import models.Usuario;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class PublicacaoController extends Controller {
	Usuario usuario;
	
	//Teste
	public Result cadastrar(){
		JsonNode resultado = request().body().asJson();
		try {
			String t = session().get(UsuarioController.SESSION_TOKEN);
			usuario = Usuario.getUserToken(t);
			
			Publicacao pub = new Publicacao(usuario, resultado.get("texto").asText());
			pub.save();
			
			return ok(Json.toJson(pub));
		} catch (Exception e) {
			Logger.info("Erro Cadastro De Publicacao ",e.getMessage());
			e.printStackTrace();
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));
	}
	
	public Result listar(){
		try{
			return ok(Json.toJson(Publicacao.listar()));
		
		} catch (Exception e) {
			Logger.info("Erro em listar Publicacao ",e.getMessage());
			e.printStackTrace();
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));
	}
	
	public Result remover(Long id){
		try {
			Publicacao pub = Publicacao.buscar(id);
			pub.delete();
			return ok(Json.toJson(pub));
		} catch (Exception e) {
			Logger.info("Erro em excluir Publicacao ",e.getMessage());
			e.printStackTrace();
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));
	
	}

	
	public Result buscar(Long id){
		try {
			Publicacao pub = Publicacao.buscar(id);
			return ok(Json.toJson(pub));
		} catch (Exception e) {
			Logger.info("Erro em buscar Publicacao ",e.getMessage());
			e.printStackTrace();
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));
	
	}
	
	
}
