
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/air/Documents/workspace/servidor/acontenarural/conf/routes
// @DATE:Sun Aug 20 02:34:07 BRT 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:8
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:8
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:13
  class ReversePublicacaoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def cadastrar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PublicacaoController.cadastrar",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/pub"})
        }
      """
    )
  
    // @LINE:14
    def listarTodas: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PublicacaoController.listarTodas",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/pub"})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseCalendarioAcademicoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def cadastrar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CalendarioAcademicoController.cadastrar",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/calendar"})
        }
      """
    )
  
    // @LINE:18
    def listar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CalendarioAcademicoController.listar",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/listarCalendar"})
        }
      """
    )
  
  }

  // @LINE:23
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:23
    def getUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUser",
      """
        function(id0,email1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("email", encodeURIComponent(email1))})
        }
      """
    )
  
  }

  // @LINE:15
  class ReverseComentarioController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def cadastrar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ComentarioController.cadastrar",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/comentario"})
        }
      """
    )
  
    // @LINE:16
    def listar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ComentarioController.listar",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/comentario"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseUsuarioController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def sair: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuarioController.sair",
      """
        function() {
        
          if (true) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/sair"})
          }
        
        }
      """
    )
  
    // @LINE:12
    def listarTodos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuarioController.listarTodos",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/listar"})
        }
      """
    )
  
    // @LINE:10
    def requisicaoAva2: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuarioController.requisicaoAva2",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/login"})
        }
      """
    )
  
    // @LINE:22
    def remover: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuarioController.remover",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/remover/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:20
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuarioController.login",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/user/login"})
        }
      """
    )
  
  }


}
