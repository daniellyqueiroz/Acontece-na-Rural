package controllers;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class CorsPreflightController extends Controller{
	
	
	public Result preflight(String path) {
	        return ok(Json.toJson("success"));
	}

}