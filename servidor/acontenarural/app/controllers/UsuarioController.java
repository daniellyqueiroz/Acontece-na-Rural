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
				.post(resultado)
				.thenApply(WSResponse::asJson)
				.whenComplete((avaJson, error) -> {
		            try { 
		            	
		            	HashMap<String, Object> body2 = new HashMap<>();
		        		body2.put("wstoken", avaJson.get("token").asText());	
		        		body2.put("wsfunction", "core_webservice_get_site_info");
		        		
		        		String avaToken = avaJson.get("token").asText();
		        		avaJson = Json.toJson(body2);
		        		
		        		
		        		
		   
		        		WSRequest request2 = ws.url("http://ava.ufrpe.br/webservice/rest/server.php?moodlewsrestformat=json");
		        		WSRequest complexRequest2 = request2
		        				.setQueryParameter("wstoken", avaToken)
		        				.setQueryParameter("wsfunction", "core_webservice_get_site_info")
		                        .setRequestTimeout(3000);
		        		Logger.info(avaJson.toString());   		
		        		CompletionStage<JsonNode> responsePromise2 = complexRequest2
		        				.post(avaJson)
		        				.thenApply(WSResponse::asJson)
		        				.whenComplete((avaJson2, error2) -> {
		        					Logger.info(avaJson2.toString());
		        		            try {
		        		            	int [] ids = new int [1];
		        		            	ids[0] = avaJson2.get("userid").asInt();
		        		            	
		        		            	HashMap<String, Object> body3 = new HashMap<>();
		        		        		body3.put("wstoken", avaToken);	
		        		        		body3.put("wsfunction", "core_user_get_users_by_id");
		        		        		body3.put("userids[0]", avaJson2.get("userid").asInt());
		        		        		int teste = avaJson2.get("userid").asInt();;
		        		        		avaJson2 = Json.toJson(body3);
		        		        		Logger.info(avaJson2.toString());
		        		        		
		        		   
		        		        		WSRequest request3 = ws.url("http://ava.ufrpe.br/webservice/rest/server.php?moodlewsrestformat=json");
		        		        		WSRequest complexRequest3 = request3
		        		        				.setQueryParameter("wstoken", avaToken)
		        		        				.setQueryParameter("wsfunction", "core_user_get_users_by_id")
		        		        				.setQueryParameter("userids[0]", ""+ teste )
		        		                        .setRequestTimeout(3000);
		        		        		Logger.info(avaJson2.toString());   		
		        		        		CompletionStage<JsonNode> responsePromise3 = complexRequest3
		        		        				.post(avaJson2)
		        		        				.thenApply(WSResponse::asJson)
		        		        				.whenComplete((avaJson3, error3) -> {
		        		        					Logger.info(avaJson3.toString());
		        		        		            try {
		        		        		            	avaJson3 = avaJson3.get(0);
		        		        		            	//cadastrar Usuario do AVA no Banco
		        		        		            	
		        		        		            	Usuario usuario = new Usuario(avaJson3.get("id").asInt(),avaJson3.get("idnumber").asText(), 
		        		        		        				avaJson3.get("username").asText(), avaJson3.get("fullname").asText(), avaJson3.get("email").asText(), 
		        		        		        				 avaJson3.get("institution").asText(),  avaJson3.get("department").asText(),  avaJson3.get("city").asText(),
		        		        		        				 avaJson3.get("country").asText(),avaJson3.get("profileimageurl").asText(),
		        		        		        				 avaJson3.get("profileimageurlsmall").asText());
		        		        		        		
		        		        		        		String t = UUID.create().toString();
		        		        		        		usuario.setToken(t);
		        		        		        		usuario.save();
		        		        		            	
		        		        		            }catch(Exception e) {
		        		        		            	Logger.info("avaErro3",e.getMessage());
		        		        		            	e.printStackTrace();
		        		        		            }
		        		        		        });
		        		            	
		        		            	
		        		            }catch(Exception e) {
		        		            	Logger.info("avaErro2",e.getMessage());
		        		            	e.printStackTrace();
		        		            }
		        		        });
		            	
		            }catch(Exception e) {
		            	Logger.info("avaErro",e.getMessage());
		            	e.printStackTrace();
		            }
		        });
		
		
		
		return ok();
	}
	

	
	
	public Result listarTodos(){
//		String t = session().get("token");
//		if(t != null)
		return ok(Json.toJson(Usuario.listar()));
//		else return ok("OPS");
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
	
	
	public Result login(){
		String t = UUID.create().toString();
		session().put("token", t);
		 return ok("ok");
	}
	public Result sair(){
		
		session().clear();
		 return ok("saiu");
	}
	
	
}
