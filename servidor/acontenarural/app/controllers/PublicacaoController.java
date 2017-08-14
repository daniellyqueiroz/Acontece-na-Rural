package controllers;


import com.fasterxml.jackson.databind.JsonNode;

import models.Publicacao;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.Result;

public class PublicacaoController extends Controller {

	public Result cadastrar(){
		
		return ok();
	}
	
	public Result remover(Long id){
		Publicacao pub = Publicacao.buscar(id);
		pub.delete();
		return ok("publicacao removida");
	
	}

	public Result atualizar(){
	
	return ok("");
	
	}
	
	public Result buscar(){
	
	return ok("");
	
	}
}
