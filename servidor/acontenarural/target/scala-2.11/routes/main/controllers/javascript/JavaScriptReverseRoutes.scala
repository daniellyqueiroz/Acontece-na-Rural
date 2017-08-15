
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/air/Documents/workspace/servidor/acontenarural/conf/routes
// @DATE:Tue Aug 15 00:23:11 BRT 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:10
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:17
  class ReversePublicacaoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def cadastrar: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PublicacaoController.cadastrar",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/pub"})
        }
      """
    )
  
    // @LINE:18
    def listarTodas: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PublicacaoController.listarTodas",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/pub"})
        }
      """
    )
  
  }

  // @LINE:22
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def getUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getUser",
      """
        function(id0,email1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("email", encodeURIComponent(email1))})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseUsuarioController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def sair: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuarioController.sair",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/sair"})
        }
      """
    )
  
    // @LINE:16
    def listarTodos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuarioController.listarTodos",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/listar"})
        }
      """
    )
  
    // @LINE:14
    def conecteAva: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuarioController.conecteAva",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ava"})
        }
      """
    )
  
    // @LINE:21
    def remover: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuarioController.remover",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/remover/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
    // @LINE:15
    def cadastrarUsuarioFixo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuarioController.cadastrarUsuarioFixo",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/cadastrar"})
        }
      """
    )
  
    // @LINE:13
    def requisicaoAva: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuarioController.requisicaoAva",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "requisicao"})
        }
      """
    )
  
    // @LINE:19
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UsuarioController.login",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/login"})
        }
      """
    )
  
  }


}
