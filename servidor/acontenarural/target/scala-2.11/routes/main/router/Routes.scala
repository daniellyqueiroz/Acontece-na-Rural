
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/air/Documents/workspace/servidor/acontenarural/conf/routes
// @DATE:Tue Aug 15 00:23:11 BRT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_2: controllers.HomeController,
  // @LINE:10
  Assets_4: controllers.Assets,
  // @LINE:13
  UsuarioController_3: javax.inject.Provider[controllers.UsuarioController],
  // @LINE:17
  PublicacaoController_1: javax.inject.Provider[controllers.PublicacaoController],
  // @LINE:22
  UserController_0: javax.inject.Provider[controllers.UserController],
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_2: controllers.HomeController,
    // @LINE:10
    Assets_4: controllers.Assets,
    // @LINE:13
    UsuarioController_3: javax.inject.Provider[controllers.UsuarioController],
    // @LINE:17
    PublicacaoController_1: javax.inject.Provider[controllers.PublicacaoController],
    // @LINE:22
    UserController_0: javax.inject.Provider[controllers.UserController]
  ) = this(errorHandler, HomeController_2, Assets_4, UsuarioController_3, PublicacaoController_1, UserController_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_2, Assets_4, UsuarioController_3, PublicacaoController_1, UserController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """requisicao""", """@controllers.UsuarioController@.requisicaoAva"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ava""", """@controllers.UsuarioController@.conecteAva"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/cadastrar""", """@controllers.UsuarioController@.cadastrarUsuarioFixo()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/listar""", """@controllers.UsuarioController@.listarTodos()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/pub""", """@controllers.PublicacaoController@.cadastrar()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/pub""", """@controllers.PublicacaoController@.listarTodas()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/login""", """@controllers.UsuarioController@.login()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/sair""", """@controllers.UsuarioController@.sair()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/remover/""" + "$" + """id<[^/]+>""", """@controllers.UsuarioController@.remover(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/""" + "$" + """id<[^/]+>/""" + "$" + """email<[^/]+>""", """@controllers.UserController@.getUser(id:Long, email:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_2.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UsuarioController_requisicaoAva2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("requisicao")))
  )
  private[this] lazy val controllers_UsuarioController_requisicaoAva2_invoker = createInvoker(
    UsuarioController_3.get.requisicaoAva,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "requisicaoAva",
      Nil,
      "POST",
      """""",
      this.prefix + """requisicao"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_UsuarioController_conecteAva3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ava")))
  )
  private[this] lazy val controllers_UsuarioController_conecteAva3_invoker = createInvoker(
    UsuarioController_3.get.conecteAva,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "conecteAva",
      Nil,
      "POST",
      """""",
      this.prefix + """ava"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_UsuarioController_cadastrarUsuarioFixo4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/cadastrar")))
  )
  private[this] lazy val controllers_UsuarioController_cadastrarUsuarioFixo4_invoker = createInvoker(
    UsuarioController_3.get.cadastrarUsuarioFixo(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "cadastrarUsuarioFixo",
      Nil,
      "GET",
      """""",
      this.prefix + """user/cadastrar"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_UsuarioController_listarTodos5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/listar")))
  )
  private[this] lazy val controllers_UsuarioController_listarTodos5_invoker = createInvoker(
    UsuarioController_3.get.listarTodos(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "listarTodos",
      Nil,
      "GET",
      """""",
      this.prefix + """user/listar"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_PublicacaoController_cadastrar6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/pub")))
  )
  private[this] lazy val controllers_PublicacaoController_cadastrar6_invoker = createInvoker(
    PublicacaoController_1.get.cadastrar(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PublicacaoController",
      "cadastrar",
      Nil,
      "POST",
      """""",
      this.prefix + """user/pub"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_PublicacaoController_listarTodas7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/pub")))
  )
  private[this] lazy val controllers_PublicacaoController_listarTodas7_invoker = createInvoker(
    PublicacaoController_1.get.listarTodas(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PublicacaoController",
      "listarTodas",
      Nil,
      "GET",
      """""",
      this.prefix + """user/pub"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_UsuarioController_login8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/login")))
  )
  private[this] lazy val controllers_UsuarioController_login8_invoker = createInvoker(
    UsuarioController_3.get.login(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "login",
      Nil,
      "GET",
      """""",
      this.prefix + """user/login"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_UsuarioController_sair9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/sair")))
  )
  private[this] lazy val controllers_UsuarioController_sair9_invoker = createInvoker(
    UsuarioController_3.get.sair(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "sair",
      Nil,
      "GET",
      """""",
      this.prefix + """user/sair"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_UsuarioController_remover10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/remover/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsuarioController_remover10_invoker = createInvoker(
    UsuarioController_3.get.remover(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "remover",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """user/remover/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_UserController_getUser11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("email", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUser11_invoker = createInvoker(
    UserController_0.get.getUser(fakeValue[Long], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUser",
      Seq(classOf[Long], classOf[String]),
      "GET",
      """""",
      this.prefix + """user/""" + "$" + """id<[^/]+>/""" + "$" + """email<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_2.index)
      }
  
    // @LINE:10
    case controllers_Assets_versioned1_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:13
    case controllers_UsuarioController_requisicaoAva2_route(params) =>
      call { 
        controllers_UsuarioController_requisicaoAva2_invoker.call(UsuarioController_3.get.requisicaoAva)
      }
  
    // @LINE:14
    case controllers_UsuarioController_conecteAva3_route(params) =>
      call { 
        controllers_UsuarioController_conecteAva3_invoker.call(UsuarioController_3.get.conecteAva)
      }
  
    // @LINE:15
    case controllers_UsuarioController_cadastrarUsuarioFixo4_route(params) =>
      call { 
        controllers_UsuarioController_cadastrarUsuarioFixo4_invoker.call(UsuarioController_3.get.cadastrarUsuarioFixo())
      }
  
    // @LINE:16
    case controllers_UsuarioController_listarTodos5_route(params) =>
      call { 
        controllers_UsuarioController_listarTodos5_invoker.call(UsuarioController_3.get.listarTodos())
      }
  
    // @LINE:17
    case controllers_PublicacaoController_cadastrar6_route(params) =>
      call { 
        controllers_PublicacaoController_cadastrar6_invoker.call(PublicacaoController_1.get.cadastrar())
      }
  
    // @LINE:18
    case controllers_PublicacaoController_listarTodas7_route(params) =>
      call { 
        controllers_PublicacaoController_listarTodas7_invoker.call(PublicacaoController_1.get.listarTodas())
      }
  
    // @LINE:19
    case controllers_UsuarioController_login8_route(params) =>
      call { 
        controllers_UsuarioController_login8_invoker.call(UsuarioController_3.get.login())
      }
  
    // @LINE:20
    case controllers_UsuarioController_sair9_route(params) =>
      call { 
        controllers_UsuarioController_sair9_invoker.call(UsuarioController_3.get.sair())
      }
  
    // @LINE:21
    case controllers_UsuarioController_remover10_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UsuarioController_remover10_invoker.call(UsuarioController_3.get.remover(id))
      }
  
    // @LINE:22
    case controllers_UserController_getUser11_route(params) =>
      call(params.fromPath[Long]("id", None), params.fromPath[String]("email", None)) { (id, email) =>
        controllers_UserController_getUser11_invoker.call(UserController_0.get.getUser(id, email))
      }
  }
}
