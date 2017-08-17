package controllers;



import java.util.HashMap;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

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
	private static final String TAG = UsuarioController.class.getSimpleName()+": ";
	public static final String SESSION_TOKEN = "USR_TOKEN_APP_SESSION";
	public static final long TIMEOUT = 10000; 
	
	public Result requisicaoAva(){
		final JsonNode resultado = request().body().asJson();
		HashMap<String, Object> body = new HashMap<>();
		
		body.put("username", resultado.get("username"));	
		body.put("password", resultado.get("password"));
		body.put("service", "moodle_mobile_app");
		
		WSRequest request = ws.url("http://ava.ufrpe.br/login/token.php");
		WSRequest complexRequest = request
				.setQueryParameter("username", body.get("username").toString())
				.setQueryParameter("password", body.get("password").toString())
				.setQueryParameter("service", "moodle_mobile_app")
                .setRequestTimeout(3000);
        		
		CompletionStage<JsonNode> responsePromise = complexRequest
				.post(Json.toJson(body))
				.thenApply(WSResponse::asJson)
				.whenComplete((avaJson, error) -> {
		            try { 
		            	
		            	if(avaJson != null && avaJson.has("token")){
		            		String avaToken = avaJson.get("token").asText();
			        		String username = resultado.get("username").asText();
			        		Usuario user = Usuario.buscar(username);
			        		if(user == null){
			        			HashMap<String, Object> body2 = new HashMap<>();
				        		body2.put("wstoken", avaJson.get("token").asText());	
				        		body2.put("wsfunction", "core_webservice_get_site_info");
				        		
				        		avaJson = Json.toJson(body2);
				        		
				        		WSRequest request2 = ws.url("http://ava.ufrpe.br/webservice/rest/server.php?moodlewsrestformat=json");
				        		WSRequest complexRequest2 = request2
				        				.setQueryParameter("wstoken", avaToken)
				        				.setQueryParameter("wsfunction", "core_webservice_get_site_info")
				                        .setRequestTimeout(3000);
				        		CompletionStage<JsonNode> responsePromise2 = complexRequest2
				        				.post(avaJson)
				        				.thenApply(WSResponse::asJson)
				        				.whenComplete((avaJson2, error2) -> {
				        		            try {
				        		            	int [] ids = new int [1];
				        		            	ids[0] = avaJson2.get("userid").asInt();
				        		            	
				        		            	HashMap<String, Object> body3 = new HashMap<>();
				        		        		body3.put("wstoken", avaToken);	
				        		        		body3.put("wsfunction", "core_user_get_users_by_id");
				        		        		body3.put("userids[0]", avaJson2.get("userid").asInt());
				        		        		int teste = avaJson2.get("userid").asInt();;
				        		        		avaJson2 = Json.toJson(body3);				        		        		
				        		   
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
				        		        		        		
				        		        		        		usuario.setToken(avaToken);
				        		        		        		usuario.save();
				        		        		        		session().put(SESSION_TOKEN, avaToken);
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
			        		}else{
			        			session().put(SESSION_TOKEN, avaToken);
			        		}
			            }
			            	
		            }catch(Exception e) {
		            	Logger.info("avaErro",e.getMessage());
		            	e.printStackTrace();
		            }
		        });
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));
	}
	

	//
	
	public Result requisicaoAva2(){
		try {
			JsonNode resultado = request().body().asJson();
			HashMap<String, Object> body = new HashMap<>();
			
			body.put("username", resultado.get("username").asText());	
			body.put("password", resultado.get("password").asText());
			body.put("service", "moodle_mobile_app");
			
			WSRequest request = ws.url("http://ava.ufrpe.br/login/token.php");
			WSRequest complexRequest = request
					.setQueryParameter("username", body.get("username").toString())
					.setQueryParameter("password", body.get("password").toString())
					.setQueryParameter("service", "moodle_mobile_app")
	                .setRequestTimeout(TIMEOUT);
			CompletionStage<JsonNode> responsePromise = complexRequest
					.post(Json.toJson(body))
					.thenApply(WSResponse::asJson);
			
			JsonNode avaJson1 = responsePromise.toCompletableFuture().get();
			if(avaJson1 != null && avaJson1.has("token")){
				String avaToken = avaJson1.get("token").asText();
				String username = resultado.get("username").asText();
        		Usuario user = Usuario.buscar(username);
        		if(user != null){
        			// Logar
        			user.setToken(avaToken);
        			user.save();
        			session().put(SESSION_TOKEN, avaToken);
        			return ok(Json.toJson(user));
        			
        		}else{
        			// Cadastrar
        			HashMap<String, Object> body2 = new HashMap<>();
	        		body2.put("wstoken", avaJson1.get("token").asText());	
	        		body2.put("wsfunction", "core_webservice_get_site_info");
	        		
	        		// Pegar id do usuario
	        		WSRequest request2 = ws.url("http://ava.ufrpe.br/webservice/rest/server.php?moodlewsrestformat=json");
	        		WSRequest complexRequest2 = request2
	        				.setQueryParameter("wstoken", avaToken)
	        				.setQueryParameter("wsfunction", "core_webservice_get_site_info")
	                        .setRequestTimeout(TIMEOUT);
	        		CompletionStage<JsonNode> responsePromise2 = complexRequest2
	        				.post(Json.toJson(body2))
	        				.thenApply(WSResponse::asJson);
	        		JsonNode avaJson2 = responsePromise2.toCompletableFuture().get();
	    			if(avaJson2 != null && avaJson2.has("userid")){
	    				
	    				// Pegar dados do usuario
	    				int[] ids = new int[1];
		            	ids[0] = avaJson2.get("userid").asInt();
		            	
		            	HashMap<String, Object> body3 = new HashMap<>();
		        		body3.put("wstoken", avaToken);	
		        		body3.put("wsfunction", "core_user_get_users_by_id");
		        		body3.put("userids[0]", ids[0]);
		        				        		
		        		WSRequest request3 = ws.url("http://ava.ufrpe.br/webservice/rest/server.php?moodlewsrestformat=json");
		        		WSRequest complexRequest3 = request3
		        				.setQueryParameter("wstoken", avaToken)
		        				.setQueryParameter("wsfunction", "core_user_get_users_by_id")
		        				.setQueryParameter("userids[0]", ""+ ids[0])
		                        .setRequestTimeout(TIMEOUT);
		        		CompletionStage<JsonNode> responsePromise3 = complexRequest3
		        				.post(Json.toJson(body3))
		        				.thenApply(WSResponse::asJson);
		        		JsonNode avaJson3 = responsePromise3.toCompletableFuture().get();
	    				if(avaJson3 != null && avaJson3.size() > 0){
	    					
	    					// Salvar no banco
	    					JsonNode userJson = avaJson3.get(0);
	    					Usuario usuario = new Usuario(userJson.get("id").asInt(), userJson.get("idnumber").asText(), 
	    							userJson.get("username").asText(), userJson.get("fullname").asText(), userJson.get("email").asText(), 
	    							userJson.get("institution").asText(),  userJson.get("department").asText(),  userJson.get("city").asText(),
	    							userJson.get("country").asText(),userJson.get("profileimageurl").asText(),
	    							userJson.get("profileimageurlsmall").asText());
    		        		
    		        		usuario.setToken(avaToken);
    		        		usuario.save();
    		        		session().put(SESSION_TOKEN, avaToken);
	    					return ok(Json.toJson(usuario));
	    				}
	    			}
        		}
			}else{
				HashMap<String, String> map = new HashMap<>();
				map.put("message", "Usuario ou senha invalido");
				return ok(Json.toJson(map));
			}
			
		} catch (InterruptedException e) {
			Logger.info(TAG+"InterruptedException");
//			e.printStackTrace();
		} catch (ExecutionException e) {
			Logger.info(TAG+"ExecutionException");
//			e.printStackTrace();
		} catch (Exception e) {
			Logger.info(TAG+"Exception");
//			e.printStackTrace();
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));
	}
	
	
	//
	
	
	
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
