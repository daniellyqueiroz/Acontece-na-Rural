package controllers;

import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;

import models.CalendarioAcademico;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class CalendarioAcademicoController extends Controller{
	
	public Result cadastrar(){
		JsonNode resultado = request().body().asJson();
		try{
			CalendarioAcademico calendario = new CalendarioAcademico(resultado.get("title").asText(),resultado.get("start").asText(),
					resultado.get("end").asText(),resultado.get("color").asText());
			
			calendario.save();
			
			return ok(Json.toJson(calendario));
		} catch (Exception e) {
			Logger.info("Erro Cadastro de Calendario ",e.getMessage());
			e.printStackTrace();
		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));
	}
	
	public Result listar(){
		try{
			return ok(Json.toJson(CalendarioAcademico.listar()));
		} catch (Exception e) {
			Logger.info("Erro em Buscar Calendario ",e.getMessage());
			e.printStackTrace();
		}
	
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Erro na conexao");
		return ok(Json.toJson(map));
	}
	

}
