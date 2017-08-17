package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.CalendarioAcademico;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class CalendarioAcademicoController extends Controller{
	
	public Result cadastrar(){
		JsonNode resultado = request().body().asJson();
		
		CalendarioAcademico calendario = new CalendarioAcademico(resultado.get("title").asText(),resultado.get("start").asText(),
				resultado.get("end").asText(),resultado.get("color").asText());
		
		calendario.save();
		
		return ok("Cadastrou");
	}
public Result listar(){
		
		return ok(Json.toJson(CalendarioAcademico.listar()));
	}

}
