package controllers;


import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;

import models.Comentario;
import models.Publicacao;
import models.Usuario;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class ComentarioController extends Controller{
	Usuario usuario;
	Publicacao pub;
	
	public Result cadastrar(){
		JsonNode resultado = request().body().asJson();
		try{
			String t = session().get(UsuarioController.SESSION_TOKEN);
			usuario = Usuario.getUserToken(t); 
			pub = Publicacao.buscar(resultado.get("idPublicacao").asLong());
			
			Comentario comentario  = new Comentario(pub, usuario,resultado.get("texto").asText());
			comentario.save();
		
		return ok(Json.toJson(comentario));
		} catch (Exception e) {
			Logger.info("Erro em cadastrar Comentario ",e.getMessage());
			e.printStackTrace();
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));
	}
	public Result listar(){
		try{
			return ok(Json.toJson(Comentario.listar()));
		
		} catch (Exception e) {
			Logger.info("Erro em listar Comentario ",e.getMessage());
			e.printStackTrace();
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));
	}

	public Result remover(Long id){
		Comentario comentario = Comentario.buscar(id);
		comentario.delete();
		return ok("comentario removido");
	}
}
