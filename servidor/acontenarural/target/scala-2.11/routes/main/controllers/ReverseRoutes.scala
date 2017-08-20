
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/air/Documents/workspace/servidor/acontenarural/conf/routes
// @DATE:Sun Aug 20 14:05:10 BRT 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:8
package controllers {

  // @LINE:8
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def versioned(file:Asset): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:15
  class ReversePublicacaoController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def cadastrar(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/user/pub")
    }
  
    // @LINE:16
    def listarTodas(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/user/pub")
    }
  
  }

  // @LINE:19
  class ReverseCalendarioAcademicoController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def cadastrar(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/user/calendar")
    }
  
    // @LINE:20
    def listar(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/user/listarCalendar")
    }
  
  }

  // @LINE:25
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def getUser(id:Long, email:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/user/" + implicitly[PathBindable[Long]].unbind("id", id) + "/" + implicitly[PathBindable[String]].unbind("email", dynamicString(email)))
    }
  
  }

  // @LINE:10
  class ReverseCorsPreflightController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def preflight(path:String): Call = {
      import ReverseRouteContext.empty
      Call("OPTIONS", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("path", path))
    }
  
  }

  // @LINE:17
  class ReverseComentarioController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def cadastrar(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/user/comentario")
    }
  
    // @LINE:18
    def listar(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/user/comentario")
    }
  
  }

  // @LINE:12
  class ReverseUsuarioController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def sair(): Call = {
    
      () match {
      
        // @LINE:13
        case ()  =>
          import ReverseRouteContext.empty
          Call("POST", _prefix + { _defaultPrefix } + "api/sair")
      
      }
    
    }
  
    // @LINE:14
    def listarTodos(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/user/listar")
    }
  
    // @LINE:12
    def requisicaoAva2(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/login")
    }
  
    // @LINE:24
    def remover(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/user/remover/" + implicitly[PathBindable[Long]].unbind("id", id))
    }
  
    // @LINE:22
    def login(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/user/login")
    }
  
  }


}
