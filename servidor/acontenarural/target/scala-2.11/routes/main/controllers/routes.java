
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/air/Documents/workspace/servidor/acontenarural/conf/routes
// @DATE:Sun Aug 20 14:05:10 BRT 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReversePublicacaoController PublicacaoController = new controllers.ReversePublicacaoController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCalendarioAcademicoController CalendarioAcademicoController = new controllers.ReverseCalendarioAcademicoController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseCorsPreflightController CorsPreflightController = new controllers.ReverseCorsPreflightController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseComentarioController ComentarioController = new controllers.ReverseComentarioController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUsuarioController UsuarioController = new controllers.ReverseUsuarioController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReversePublicacaoController PublicacaoController = new controllers.javascript.ReversePublicacaoController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCalendarioAcademicoController CalendarioAcademicoController = new controllers.javascript.ReverseCalendarioAcademicoController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseCorsPreflightController CorsPreflightController = new controllers.javascript.ReverseCorsPreflightController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseComentarioController ComentarioController = new controllers.javascript.ReverseComentarioController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUsuarioController UsuarioController = new controllers.javascript.ReverseUsuarioController(RoutesPrefix.byNamePrefix());
  }

}
