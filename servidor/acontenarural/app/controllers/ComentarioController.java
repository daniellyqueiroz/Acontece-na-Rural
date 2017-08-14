package controllers;


import models.Comentario;
import play.mvc.Controller;
import play.mvc.Result;

public class ComentarioController extends Controller{

	public Result remover(Long id){
		Comentario comentario = Comentario.buscar(id);
		comentario.delete();
		return ok("comentario removido");
	}
}
