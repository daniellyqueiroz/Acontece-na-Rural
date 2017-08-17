
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/air/Documents/workspace/servidor/acontenarural/conf/routes
// @DATE:Thu Aug 17 09:56:10 BRT 2017

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
  Assets_5: controllers.Assets,
  // @LINE:10
  UsuarioController_4: javax.inject.Provider[controllers.UsuarioController],
  // @LINE:13
  PublicacaoController_2: javax.inject.Provider[controllers.PublicacaoController],
  // @LINE:15
  ComentarioController_3: javax.inject.Provider[controllers.ComentarioController],
  // @LINE:17
  CalendarioAcademicoController_1: javax.inject.Provider[controllers.CalendarioAcademicoController],
  // @LINE:23
  UserController_0: javax.inject.Provider[controllers.UserController],
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:8
    Assets_5: controllers.Assets,
    // @LINE:10
    UsuarioController_4: javax.inject.Provider[controllers.UsuarioController],
    // @LINE:13
    PublicacaoController_2: javax.inject.Provider[controllers.PublicacaoController],
    // @LINE:15
    ComentarioController_3: javax.inject.Provider[controllers.ComentarioController],
    // @LINE:17
    CalendarioAcademicoController_1: javax.inject.Provider[controllers.CalendarioAcademicoController],
    // @LINE:23
    UserController_0: javax.inject.Provider[controllers.UserController]
  ) = this(errorHandler, Assets_5, UsuarioController_4, PublicacaoController_2, ComentarioController_3, CalendarioAcademicoController_1, UserController_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Assets_5, UsuarioController_4, PublicacaoController_2, ComentarioController_3, CalendarioAcademicoController_1, UserController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """@controllers.UsuarioController@.requisicaoAva2()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sair""", """@controllers.UsuarioController@.sair()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/listar""", """@controllers.UsuarioController@.listarTodos()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/pub""", """@controllers.PublicacaoController@.cadastrar()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/pub""", """@controllers.PublicacaoController@.listarTodas()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/comentario""", """@controllers.ComentarioController@.cadastrar()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/comentario""", """@controllers.ComentarioController@.listar()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/calendar""", """@controllers.CalendarioAcademicoController@.cadastrar()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/listarCalendar""", """@controllers.CalendarioAcademicoController@.listar()"""),
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
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_UsuarioController_requisicaoAva21_invoker = createInvoker(
    UsuarioController_4.get.requisicaoAva2(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "requisicaoAva2",
      Nil,
      "POST",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UsuarioController_sair2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sair")))
  )
  private[this] lazy val controllers_UsuarioController_sair2_invoker = createInvoker(
    UsuarioController_4.get.sair(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "sair",
      Nil,
      "POST",
      """""",
      this.prefix + """sair"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UsuarioController_listarTodos3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/listar")))
  )
  private[this] lazy val controllers_UsuarioController_listarTodos3_invoker = createInvoker(
    UsuarioController_4.get.listarTodos(),
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

  // @LINE:13
  private[this] lazy val controllers_PublicacaoController_cadastrar4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/pub")))
  )
  private[this] lazy val controllers_PublicacaoController_cadastrar4_invoker = createInvoker(
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

  // @LINE:14
  private[this] lazy val controllers_PublicacaoController_listarTodas5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/pub")))
  )
  private[this] lazy val controllers_PublicacaoController_listarTodas5_invoker = createInvoker(
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

  // @LINE:15
  private[this] lazy val controllers_ComentarioController_cadastrar6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/comentario")))
  )
  private[this] lazy val controllers_ComentarioController_cadastrar6_invoker = createInvoker(
    ComentarioController_3.get.cadastrar(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ComentarioController",
      "cadastrar",
      Nil,
      "POST",
      """""",
      this.prefix + """user/comentario"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_ComentarioController_listar7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/comentario")))
  )
  private[this] lazy val controllers_ComentarioController_listar7_invoker = createInvoker(
    ComentarioController_3.get.listar(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ComentarioController",
      "listar",
      Nil,
      "GET",
      """""",
      this.prefix + """user/comentario"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_CalendarioAcademicoController_cadastrar8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/calendar")))
  )
  private[this] lazy val controllers_CalendarioAcademicoController_cadastrar8_invoker = createInvoker(
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

  // @LINE:18
  private[this] lazy val controllers_CalendarioAcademicoController_listar9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/listarCalendar")))
  )
  private[this] lazy val controllers_CalendarioAcademicoController_listar9_invoker = createInvoker(
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

  // @LINE:20
  private[this] lazy val controllers_UsuarioController_login10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/login")))
  )
  private[this] lazy val controllers_UsuarioController_login10_invoker = createInvoker(
    UsuarioController_4.get.login(),
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

  // @LINE:21
  private[this] lazy val controllers_UsuarioController_sair11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/sair")))
  )
  private[this] lazy val controllers_UsuarioController_sair11_invoker = createInvoker(
    UsuarioController_4.get.sair(),
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

  // @LINE:22
  private[this] lazy val controllers_UsuarioController_remover12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/remover/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsuarioController_remover12_invoker = createInvoker(
    UsuarioController_4.get.remover(fakeValue[Long]),
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

  // @LINE:23
  private[this] lazy val controllers_UserController_getUser13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("email", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUser13_invoker = createInvoker(
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
        controllers_Assets_versioned0_invoker.call(Assets_5.versioned(path, file))
      }
  
    // @LINE:10
    case controllers_UsuarioController_requisicaoAva21_route(params) =>
      call { 
        controllers_UsuarioController_requisicaoAva21_invoker.call(UsuarioController_4.get.requisicaoAva2())
      }
  
    // @LINE:11
    case controllers_UsuarioController_sair2_route(params) =>
      call { 
        controllers_UsuarioController_sair2_invoker.call(UsuarioController_4.get.sair())
      }
  
    // @LINE:12
    case controllers_UsuarioController_listarTodos3_route(params) =>
      call { 
        controllers_UsuarioController_listarTodos3_invoker.call(UsuarioController_4.get.listarTodos())
      }
  
    // @LINE:13
    case controllers_PublicacaoController_cadastrar4_route(params) =>
      call { 
        controllers_PublicacaoController_cadastrar4_invoker.call(PublicacaoController_2.get.cadastrar())
      }
  
    // @LINE:14
    case controllers_PublicacaoController_listarTodas5_route(params) =>
      call { 
        controllers_PublicacaoController_listarTodas5_invoker.call(PublicacaoController_2.get.listarTodas())
      }
  
    // @LINE:15
    case controllers_ComentarioController_cadastrar6_route(params) =>
      call { 
        controllers_ComentarioController_cadastrar6_invoker.call(ComentarioController_3.get.cadastrar())
      }
  
    // @LINE:16
    case controllers_ComentarioController_listar7_route(params) =>
      call { 
        controllers_ComentarioController_listar7_invoker.call(ComentarioController_3.get.listar())
      }
  
    // @LINE:17
    case controllers_CalendarioAcademicoController_cadastrar8_route(params) =>
      call { 
        controllers_CalendarioAcademicoController_cadastrar8_invoker.call(CalendarioAcademicoController_1.get.cadastrar())
      }
  
    // @LINE:18
    case controllers_CalendarioAcademicoController_listar9_route(params) =>
      call { 
        controllers_CalendarioAcademicoController_listar9_invoker.call(CalendarioAcademicoController_1.get.listar())
      }
  
    // @LINE:20
    case controllers_UsuarioController_login10_route(params) =>
      call { 
        controllers_UsuarioController_login10_invoker.call(UsuarioController_4.get.login())
      }
  
    // @LINE:21
    case controllers_UsuarioController_sair11_route(params) =>
      call { 
        controllers_UsuarioController_sair11_invoker.call(UsuarioController_4.get.sair())
      }
  
    // @LINE:22
    case controllers_UsuarioController_remover12_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UsuarioController_remover12_invoker.call(UsuarioController_4.get.remover(id))
      }
  
    // @LINE:23
    case controllers_UserController_getUser13_route(params) =>
      call(params.fromPath[Long]("id", None), params.fromPath[String]("email", None)) { (id, email) =>
        controllers_UserController_getUser13_invoker.call(UserController_0.get.getUser(id, email))
      }
  }
}
