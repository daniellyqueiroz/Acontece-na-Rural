package controllers;

import com.fasterxml.jackson.databind.JsonNode;

import models.Reacao;
import play.mvc.Controller;
import play.mvc.Result;

public class ReacaoController extends Controller {
	
	public Result cadastrar(){
		JsonNode resultado = request().body().asJson();
	
		return ok();
	}
	
	public Result remover(Long id){
		Reacao reacao = Reacao.buscar(id);
		reacao.delete();
		return ok("reacao removida");	}

}
