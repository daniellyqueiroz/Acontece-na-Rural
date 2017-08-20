
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/air/Documents/workspace/servidor/acontenarural/conf/routes
// @DATE:Sun Aug 20 14:05:10 BRT 2017

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
  Assets_6: controllers.Assets,
  // @LINE:10
  CorsPreflightController_3: javax.inject.Provider[controllers.CorsPreflightController],
  // @LINE:12
  UsuarioController_5: javax.inject.Provider[controllers.UsuarioController],
  // @LINE:15
  PublicacaoController_2: javax.inject.Provider[controllers.PublicacaoController],
  // @LINE:17
  ComentarioController_4: javax.inject.Provider[controllers.ComentarioController],
  // @LINE:19
  CalendarioAcademicoController_1: javax.inject.Provider[controllers.CalendarioAcademicoController],
  // @LINE:25
  UserController_0: javax.inject.Provider[controllers.UserController],
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    Assets_6: controllers.Assets,
    // @LINE:10
    CorsPreflightController_3: javax.inject.Provider[controllers.CorsPreflightController],
    // @LINE:12
    UsuarioController_5: javax.inject.Provider[controllers.UsuarioController],
    // @LINE:15
    PublicacaoController_2: javax.inject.Provider[controllers.PublicacaoController],
    // @LINE:17
    ComentarioController_4: javax.inject.Provider[controllers.ComentarioController],
    // @LINE:19
    CalendarioAcademicoController_1: javax.inject.Provider[controllers.CalendarioAcademicoController],
    // @LINE:25
    UserController_0: javax.inject.Provider[controllers.UserController]
  ) = this(errorHandler, Assets_6, CorsPreflightController_3, UsuarioController_5, PublicacaoController_2, ComentarioController_4, CalendarioAcademicoController_1, UserController_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_6, CorsPreflightController_3, UsuarioController_5, PublicacaoController_2, ComentarioController_4, CalendarioAcademicoController_1, UserController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""OPTIONS""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """path<.+>""", """@controllers.CorsPreflightController@.preflight(path:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/login""", """@controllers.UsuarioController@.requisicaoAva2()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/sair""", """@controllers.UsuarioController@.sair()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/listar""", """@controllers.UsuarioController@.listarTodos()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/pub""", """@controllers.PublicacaoController@.cadastrar()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/pub""", """@controllers.PublicacaoController@.listarTodas()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/comentario""", """@controllers.ComentarioController@.cadastrar()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/comentario""", """@controllers.ComentarioController@.listar()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/calendar""", """@controllers.CalendarioAcademicoController@.cadastrar()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/listarCalendar""", """@controllers.CalendarioAcademicoController@.listar()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/login""", """@controllers.UsuarioController@.login()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/sair""", """@controllers.UsuarioController@.sair()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/remover/""" + "$" + """id<[^/]+>""", """@controllers.UsuarioController@.remover(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/user/""" + "$" + """id<[^/]+>/""" + "$" + """email<[^/]+>""", """@controllers.UserController@.getUser(id:Long, email:String)"""),
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
    Assets_6.versioned(fakeValue[String], fakeValue[Asset]),
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
  private[this] lazy val controllers_CorsPreflightController_preflight1_route = Route("OPTIONS",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("path", """.+""",false)))
  )
  private[this] lazy val controllers_CorsPreflightController_preflight1_invoker = createInvoker(
    CorsPreflightController_3.get.preflight(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CorsPreflightController",
      "preflight",
      Seq(classOf[String]),
      "OPTIONS",
      """""",
      this.prefix + """""" + "$" + """path<.+>"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UsuarioController_requisicaoAva22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/login")))
  )
  private[this] lazy val controllers_UsuarioController_requisicaoAva22_invoker = createInvoker(
    UsuarioController_5.get.requisicaoAva2(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "requisicaoAva2",
      Nil,
      "POST",
      """""",
      this.prefix + """api/login"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UsuarioController_sair3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/sair")))
  )
  private[this] lazy val controllers_UsuarioController_sair3_invoker = createInvoker(
    UsuarioController_5.get.sair(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "sair",
      Nil,
      "POST",
      """""",
      this.prefix + """api/sair"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_UsuarioController_listarTodos4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/listar")))
  )
  private[this] lazy val controllers_UsuarioController_listarTodos4_invoker = createInvoker(
    UsuarioController_5.get.listarTodos(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "listarTodos",
      Nil,
      "GET",
      """""",
      this.prefix + """api/user/listar"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_PublicacaoController_cadastrar5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/pub")))
  )
  private[this] lazy val controllers_PublicacaoController_cadastrar5_invoker = createInvoker(
    PublicacaoController_2.get.cadastrar(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PublicacaoController",
      "cadastrar",
      Nil,
      "POST",
      """""",
      this.prefix + """api/user/pub"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_PublicacaoController_listarTodas6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/pub")))
  )
  private[this] lazy val controllers_PublicacaoController_listarTodas6_invoker = createInvoker(
    PublicacaoController_2.get.listarTodas(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PublicacaoController",
      "listarTodas",
      Nil,
      "GET",
      """""",
      this.prefix + """api/user/pub"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_ComentarioController_cadastrar7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/comentario")))
  )
  private[this] lazy val controllers_ComentarioController_cadastrar7_invoker = createInvoker(
    ComentarioController_4.get.cadastrar(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ComentarioController",
      "cadastrar",
      Nil,
      "POST",
      """""",
      this.prefix + """api/user/comentario"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_ComentarioController_listar8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/comentario")))
  )
  private[this] lazy val controllers_ComentarioController_listar8_invoker = createInvoker(
    ComentarioController_4.get.listar(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ComentarioController",
      "listar",
      Nil,
      "GET",
      """""",
      this.prefix + """api/user/comentario"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_CalendarioAcademicoController_cadastrar9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/calendar")))
  )
  private[this] lazy val controllers_CalendarioAcademicoController_cadastrar9_invoker = createInvoker(
    CalendarioAcademicoController_1.get.cadastrar(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CalendarioAcademicoController",
      "cadastrar",
      Nil,
      "POST",
      """""",
      this.prefix + """api/user/calendar"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_CalendarioAcademicoController_listar10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/listarCalendar")))
  )
  private[this] lazy val controllers_CalendarioAcademicoController_listar10_invoker = createInvoker(
    CalendarioAcademicoController_1.get.listar(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CalendarioAcademicoController",
      "listar",
      Nil,
      "GET",
      """""",
      this.prefix + """api/user/listarCalendar"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_UsuarioController_login11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/login")))
  )
  private[this] lazy val controllers_UsuarioController_login11_invoker = createInvoker(
    UsuarioController_5.get.login(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "login",
      Nil,
      "GET",
      """""",
      this.prefix + """api/user/login"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_UsuarioController_sair12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/sair")))
  )
  private[this] lazy val controllers_UsuarioController_sair12_invoker = createInvoker(
    UsuarioController_5.get.sair(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "sair",
      Nil,
      "GET",
      """""",
      this.prefix + """api/user/sair"""
    )
  )

  // @LINE:24
  private[this] lazy val controllers_UsuarioController_remover13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/remover/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsuarioController_remover13_invoker = createInvoker(
    UsuarioController_5.get.remover(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "remover",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """api/user/remover/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_UserController_getUser14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/user/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("email", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUser14_invoker = createInvoker(
    UserController_0.get.getUser(fakeValue[Long], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getUser",
      Seq(classOf[Long], classOf[String]),
      "GET",
      """""",
      this.prefix + """api/user/""" + "$" + """id<[^/]+>/""" + "$" + """email<[^/]+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:8
    case controllers_Assets_versioned0_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned0_invoker.call(Assets_6.versioned(path, file))
      }
  
    // @LINE:10
    case controllers_CorsPreflightController_preflight1_route(params) =>
      call(params.fromPath[String]("path", None)) { (path) =>
        controllers_CorsPreflightController_preflight1_invoker.call(CorsPreflightController_3.get.preflight(path))
      }
  
    // @LINE:12
    case controllers_UsuarioController_requisicaoAva22_route(params) =>
      call { 
        controllers_UsuarioController_requisicaoAva22_invoker.call(UsuarioController_5.get.requisicaoAva2())
      }
  
    // @LINE:13
    case controllers_UsuarioController_sair3_route(params) =>
      call { 
        controllers_UsuarioController_sair3_invoker.call(UsuarioController_5.get.sair())
      }
  
    // @LINE:14
    case controllers_UsuarioController_listarTodos4_route(params) =>
      call { 
        controllers_UsuarioController_listarTodos4_invoker.call(UsuarioController_5.get.listarTodos())
      }
  
    // @LINE:15
    case controllers_PublicacaoController_cadastrar5_route(params) =>
      call { 
        controllers_PublicacaoController_cadastrar5_invoker.call(PublicacaoController_2.get.cadastrar())
      }
  
    // @LINE:16
    case controllers_PublicacaoController_listarTodas6_route(params) =>
      call { 
        controllers_PublicacaoController_listarTodas6_invoker.call(PublicacaoController_2.get.listarTodas())
      }
  
    // @LINE:17
    case controllers_ComentarioController_cadastrar7_route(params) =>
      call { 
        controllers_ComentarioController_cadastrar7_invoker.call(ComentarioController_4.get.cadastrar())
      }
  
    // @LINE:18
    case controllers_ComentarioController_listar8_route(params) =>
      call { 
        controllers_ComentarioController_listar8_invoker.call(ComentarioController_4.get.listar())
      }
  
    // @LINE:19
    case controllers_CalendarioAcademicoController_cadastrar9_route(params) =>
      call { 
        controllers_CalendarioAcademicoController_cadastrar9_invoker.call(CalendarioAcademicoController_1.get.cadastrar())
      }
  
    // @LINE:20
    case controllers_CalendarioAcademicoController_listar10_route(params) =>
      call { 
        controllers_CalendarioAcademicoController_listar10_invoker.call(CalendarioAcademicoController_1.get.listar())
      }
  
    // @LINE:22
    case controllers_UsuarioController_login11_route(params) =>
      call { 
        controllers_UsuarioController_login11_invoker.call(UsuarioController_5.get.login())
      }
  
    // @LINE:23
    case controllers_UsuarioController_sair12_route(params) =>
      call { 
        controllers_UsuarioController_sair12_invoker.call(UsuarioController_5.get.sair())
      }
  
    // @LINE:24
    case controllers_UsuarioController_remover13_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UsuarioController_remover13_invoker.call(UsuarioController_5.get.remover(id))
      }
  
    // @LINE:25
    case controllers_UserController_getUser14_route(params) =>
      call(params.fromPath[Long]("id", None), params.fromPath[String]("email", None)) { (id, email) =>
        controllers_UserController_getUser14_invoker.call(UserController_0.get.getUser(id, email))
      }
  }
}
