package controllers;

import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;

import models.Publicacao;
import models.Reacao;
import models.Reacao.TiposReacao;
import models.Usuario;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class ReacaoController extends Controller {
	Usuario usuario;
	Publicacao pub;
	TiposReacao tipo;
	
	public Result cadastrar(){
		JsonNode resultado = request().body().asJson();

		try{
			String t = session().get(UsuarioController.SESSION_TOKEN);
			usuario = Usuario.getUserToken(t); 
			pub = Publicacao.buscar(resultado.get("idPublicacao").asLong());
			int tp= resultado.get("tipo").asInt();
	
			if (tp == 0) {
				tipo = TiposReacao.DESCURTIR;
			} else {
				tipo = TiposReacao.CURTIR;
			}
			
			Reacao reacao = new Reacao(tipo, pub, usuario);
			reacao.save();
		
				return ok(Json.toJson(reacao));
		} catch (Exception e) {
			Logger.info("Erro em cadastrar Reacao ",e.getMessage());
			e.printStackTrace();
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));
	}

	public Result listar(){
		try{
	
			return ok(Json.toJson(Reacao.listar()));
		} catch (Exception e) {
			Logger.info("Erro em listar Reacao ",e.getMessage());
			e.printStackTrace();
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));

	}

	public Result buscar(Long id){
		try {
			Reacao reacao = Reacao.buscar(id);
			return ok(Json.toJson(reacao));
		} catch (Exception e) {
			Logger.info("Erro em buscar Reacao ",e.getMessage());
			e.printStackTrace();
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));
	
	}
	
	public Result remover(Long id){
		try{
			Reacao reacao = Reacao.buscar(id);
			reacao.delete();
			return ok("reacao removida");	
		} catch (Exception e) {
			Logger.info("Erro em excluir Reacao ",e.getMessage());
			e.printStackTrace();
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));

	}

}
