package controllers;

import java.util.HashMap;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import models.Usuario;
import play.Logger;
import play.libs.Json;

import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.mvc.Controller;
import play.mvc.Http.Session;
import play.mvc.Result;
import tyrex.services.UUID;

public class UsuarioController extends Controller{
	
	@Inject WSClient ws;
	
	public Result requisicaoAva(){
		JsonNode resultado = request().body().asJson();
		HashMap<String, Object> body = new HashMap<>();
		
		body.put("username", resultado.get("username"));	
		body.put("password", resultado.get("password"));
		body.put("service", "moodle_mobile_app");
		resultado = Json.toJson(body);
		WSRequest request = ws.url("http://ava.ufrpe.br/login/token.php");
		WSRequest complexRequest = request
				.setQueryParameter("username", resultado.get("username").asText())
				.setQueryParameter("password", resultado.get("password").asText())
				.setQueryParameter("service", "moodle_mobile_app")
                .setRequestTimeout(3000);
        		
		CompletionStage<JsonNode> responsePromise = complexRequest
//				.setContentType("application/json")
				.post(resultado)
				.thenApply(WSResponse::asJson)
				.whenComplete((avaJson, error) -> {
		            try { 
		            	
		            	Logger.info(avaJson.toString());
		            	
		            	HashMap<String, Object> body2 = new HashMap<>();
		        		body2.put("wstoken", avaJson.get("token").asText());	
		        		body2.put("wsfunction", "core_webservice_get_site_info");
		        		avaJson = Json.toJson(body2);
		        		
		            	WSRequest request2 = ws.url("http://ava.ufrpe.br/webservice/rest/server.php?moodlewsrestformat=json");
		        		WSRequest complexRequest2 = request2
		        				.setQueryParameter("wstoken", avaJson.get("token").asText())
		        				.setQueryParameter("wsfunction", "core_webservice_get_site_info")
		                        .setRequestTimeout(3000);
		                		        		
		        		CompletionStage<JsonNode> responsePromise2 = complexRequest2
//		        				.setContentType("application/json")
		        				.post(avaJson)
		        				.thenApply(WSResponse::asJson)
		        				.whenComplete((avaJson2, error2) -> {
		        		            try { 
		        		            	
		        		            	Logger.info(avaJson2.toString());
		        		            	
		        		            }catch(Exception e) {
		        		            	Logger.info("avaErro2",e.getMessage());
		        		            }
		        		        });
		            	
		            }catch(Exception e) {
		            	Logger.info("avaErro",e.getMessage());
		            }
		        });
		
		
		
//		Usuario usuario = new Usuario( resultado.get("nome").asText(), resultado.get("token").asText(),
//				resultado.get("curso").asText(),resultado.get("imagem").asText(),resultado.get("descricao").asText(),
//				resultado.get("tempoLembreteAva").intValue());
//		usuario.save();
		
		
		
		String t = UUID.create().toString();
		session().put("token", t);
		
		return ok(t);
	}
	public Result remover(Long id){
		Usuario u = Usuario.buscar(id);
		u.delete();
		return ok("removido");
		
	}
	
	public Result buscar(Long id){
		Usuario u = Usuario.buscar(id);
		return ok(u.getNome());
		
	}
	
	//exemplo pois o usuario nao pode atualizar ja que vem do AVA
	public Result atualizar(){
		JsonNode resultado = request().body().asJson();
		Usuario usuario = Usuario.buscar(resultado.get("id").asLong());
		//usuario.setNome(novonome);
		usuario.update();
		return ok("atualizado");
		
	}
	
	public Result login(){
		String t = UUID.create().toString();
		session().put("token", t);
		 return ok("ok");
	}
	public Result sair(){
		
		session().clear();
		 return ok("saiu");
	}
	
	public Result listarTodos(){
		String t = session().get("token");
		if(t != null)
		return ok(Json.toJson(Usuario.listar()));
		else return ok("OPS");
	}
}
