
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/air/Documents/workspace/servidor/acontenarural/conf/routes
// @DATE:Wed Aug 16 21:07:42 BRT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:8
  Assets_4: controllers.Assets,
  // @LINE:10
  UsuarioController_3: javax.inject.Provider[controllers.UsuarioController],
  // @LINE:15
  CalendarioAcademicoController_1: javax.inject.Provider[controllers.CalendarioAcademicoController],
  // @LINE:17
  PublicacaoController_2: javax.inject.Provider[controllers.PublicacaoController],
  // @LINE:22
  UserController_0: javax.inject.Provider[controllers.UserController],
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    Assets_4: controllers.Assets,
    // @LINE:10
    UsuarioController_3: javax.inject.Provider[controllers.UsuarioController],
    // @LINE:15
    CalendarioAcademicoController_1: javax.inject.Provider[controllers.CalendarioAcademicoController],
    // @LINE:17
    PublicacaoController_2: javax.inject.Provider[controllers.PublicacaoController],
    // @LINE:22
    UserController_0: javax.inject.Provider[controllers.UserController]
  ) = this(errorHandler, Assets_4, UsuarioController_3, CalendarioAcademicoController_1, PublicacaoController_2, UserController_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_4, UsuarioController_3, CalendarioAcademicoController_1, PublicacaoController_2, UserController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """bruno""", """@controllers.UsuarioController@.requisicaoAva2()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """requisicao""", """@controllers.UsuarioController@.requisicaoAva"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/listar""", """@controllers.UsuarioController@.listarTodos()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/calendar""", """@controllers.CalendarioAcademicoController@.cadastrar()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/listarCalendar""", """@controllers.CalendarioAcademicoController@.listar()"""),
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


  // @LINE:8
  private[this] lazy val controllers_Assets_versioned0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned0_invoker = createInvoker(
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

  // @LINE:10
  private[this] lazy val controllers_UsuarioController_requisicaoAva21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("bruno")))
  )
  private[this] lazy val controllers_UsuarioController_requisicaoAva21_invoker = createInvoker(
    UsuarioController_3.get.requisicaoAva2(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "requisicaoAva2",
      Nil,
      "POST",
      """""",
      this.prefix + """bruno"""
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
  private[this] lazy val controllers_UsuarioController_listarTodos3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/listar")))
  )
  private[this] lazy val controllers_UsuarioController_listarTodos3_invoker = createInvoker(
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

  // @LINE:15
  private[this] lazy val controllers_CalendarioAcademicoController_cadastrar4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/calendar")))
  )
  private[this] lazy val controllers_CalendarioAcademicoController_cadastrar4_invoker = createInvoker(
    CalendarioAcademicoController_1.get.cadastrar(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CalendarioAcademicoController",
      "cadastrar",
      Nil,
      "POST",
      """""",
      this.prefix + """user/calendar"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_CalendarioAcademicoController_listar5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/listarCalendar")))
  )
  private[this] lazy val controllers_CalendarioAcademicoController_listar5_invoker = createInvoker(
    CalendarioAcademicoController_1.get.listar(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CalendarioAcademicoController",
      "listar",
      Nil,
      "GET",
      """""",
      this.prefix + """user/listarCalendar"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_PublicacaoController_cadastrar6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/pub")))
  )
  private[this] lazy val controllers_PublicacaoController_cadastrar6_invoker = createInvoker(
    PublicacaoController_2.get.cadastrar(),
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
    PublicacaoController_2.get.listarTodas(),
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
  
    // @LINE:8
    case controllers_Assets_versioned0_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned0_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:10
    case controllers_UsuarioController_requisicaoAva21_route(params) =>
      call { 
        controllers_UsuarioController_requisicaoAva21_invoker.call(UsuarioController_3.get.requisicaoAva2())
      }
  
    // @LINE:13
    case controllers_UsuarioController_requisicaoAva2_route(params) =>
      call { 
        controllers_UsuarioController_requisicaoAva2_invoker.call(UsuarioController_3.get.requisicaoAva)
      }
  
    // @LINE:14
    case controllers_UsuarioController_listarTodos3_route(params) =>
      call { 
        controllers_UsuarioController_listarTodos3_invoker.call(UsuarioController_3.get.listarTodos())
      }
  
    // @LINE:15
    case controllers_CalendarioAcademicoController_cadastrar4_route(params) =>
      call { 
        controllers_CalendarioAcademicoController_cadastrar4_invoker.call(CalendarioAcademicoController_1.get.cadastrar())
      }
  
    // @LINE:16
    case controllers_CalendarioAcademicoController_listar5_route(params) =>
      call { 
        controllers_CalendarioAcademicoController_listar5_invoker.call(CalendarioAcademicoController_1.get.listar())
      }
  
    // @LINE:17
    case controllers_PublicacaoController_cadastrar6_route(params) =>
      call { 
        controllers_PublicacaoController_cadastrar6_invoker.call(PublicacaoController_2.get.cadastrar())
      }
  
    // @LINE:18
    case controllers_PublicacaoController_listarTodas7_route(params) =>
      call { 
        controllers_PublicacaoController_listarTodas7_invoker.call(PublicacaoController_2.get.listarTodas())
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
