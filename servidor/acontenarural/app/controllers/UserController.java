package controllers;


import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class UserController extends Controller{
	
	public Result getUser(Long id, String email){
		HashMap<String, Object> resultado = new HashMap<>();
	
		resultado.put("ehPar", id%2 ==0);	
		resultado.put("qntEmail", email.length());
	
		return ok(Json.toJson(resultado));
	}
	
	public Result postTeste(){
		JsonNode resultado = request().body().asJson();
		
		return ok (resultado.get("username"));
	}
	
}
