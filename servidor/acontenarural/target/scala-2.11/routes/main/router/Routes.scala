
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/air/Documents/workspace/servidor/acontenarural/conf/routes
// @DATE:Mon Aug 14 16:01:31 BRT 2017

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
  HomeController_0: controllers.HomeController,
  // @LINE:10
  Assets_1: controllers.Assets,
  // @LINE:14
  UserController_3: javax.inject.Provider[controllers.UserController],
  // @LINE:15
  UsuarioController_2: javax.inject.Provider[controllers.UsuarioController],
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_0: controllers.HomeController,
    // @LINE:10
    Assets_1: controllers.Assets,
    // @LINE:14
    UserController_3: javax.inject.Provider[controllers.UserController],
    // @LINE:15
    UsuarioController_2: javax.inject.Provider[controllers.UsuarioController]
  ) = this(errorHandler, HomeController_0, Assets_1, UserController_3, UsuarioController_2, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, UserController_3, UsuarioController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user/new""", """@controllers.UserController@.postTeste()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """@controllers.UsuarioController@.cadastrar()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """user""", """@controllers.UsuarioController@.listarTodos()"""),
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
    HomeController_0.index,
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
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
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

  // @LINE:14
  private[this] lazy val controllers_UserController_postTeste2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/new")))
  )
  private[this] lazy val controllers_UserController_postTeste2_invoker = createInvoker(
    UserController_3.get.postTeste(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "postTeste",
      Nil,
      "POST",
      """""",
      this.prefix + """user/new"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_UsuarioController_cadastrar3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_UsuarioController_cadastrar3_invoker = createInvoker(
    UsuarioController_2.get.cadastrar(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "cadastrar",
      Nil,
      "POST",
      """""",
      this.prefix + """user"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_UsuarioController_listarTodos4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user")))
  )
  private[this] lazy val controllers_UsuarioController_listarTodos4_invoker = createInvoker(
    UsuarioController_2.get.listarTodos(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UsuarioController",
      "listarTodos",
      Nil,
      "GET",
      """""",
      this.prefix + """user"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_UsuarioController_login5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/login")))
  )
  private[this] lazy val controllers_UsuarioController_login5_invoker = createInvoker(
    UsuarioController_2.get.login(),
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

  // @LINE:18
  private[this] lazy val controllers_UsuarioController_sair6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/sair")))
  )
  private[this] lazy val controllers_UsuarioController_sair6_invoker = createInvoker(
    UsuarioController_2.get.sair(),
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

  // @LINE:19
  private[this] lazy val controllers_UsuarioController_remover7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/remover/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UsuarioController_remover7_invoker = createInvoker(
    UsuarioController_2.get.remover(fakeValue[Long]),
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

  // @LINE:20
  private[this] lazy val controllers_UserController_getUser8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("user/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("email", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_getUser8_invoker = createInvoker(
    UserController_3.get.getUser(fakeValue[Long], fakeValue[String]),
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
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:10
    case controllers_Assets_versioned1_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:14
    case controllers_UserController_postTeste2_route(params) =>
      call { 
        controllers_UserController_postTeste2_invoker.call(UserController_3.get.postTeste())
      }
  
    // @LINE:15
    case controllers_UsuarioController_cadastrar3_route(params) =>
      call { 
        controllers_UsuarioController_cadastrar3_invoker.call(UsuarioController_2.get.cadastrar())
      }
  
    // @LINE:16
    case controllers_UsuarioController_listarTodos4_route(params) =>
      call { 
        controllers_UsuarioController_listarTodos4_invoker.call(UsuarioController_2.get.listarTodos())
      }
  
    // @LINE:17
    case controllers_UsuarioController_login5_route(params) =>
      call { 
        controllers_UsuarioController_login5_invoker.call(UsuarioController_2.get.login())
      }
  
    // @LINE:18
    case controllers_UsuarioController_sair6_route(params) =>
      call { 
        controllers_UsuarioController_sair6_invoker.call(UsuarioController_2.get.sair())
      }
  
    // @LINE:19
    case controllers_UsuarioController_remover7_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_UsuarioController_remover7_invoker.call(UsuarioController_2.get.remover(id))
      }
  
    // @LINE:20
    case controllers_UserController_getUser8_route(params) =>
      call(params.fromPath[Long]("id", None), params.fromPath[String]("email", None)) { (id, email) =>
        controllers_UserController_getUser8_invoker.call(UserController_3.get.getUser(id, email))
      }
  }
}
