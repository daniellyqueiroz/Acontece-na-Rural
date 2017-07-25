import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule }   from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { BaseSiteComponent } from './site/base-site/base-site.component';
import { LoginComponent } from './site/login/login.component';
import { FeedNoticiasComponent } from './admin/feed-noticias/feed-noticias.component';
import { BaseAdminComponent } from './admin/base-admin/base-admin.component';
import { ConfiguracaoComponent } from './admin/configuracao/configuracao.component';
import { CalendarioComponent } from './admin/calendario/calendario.component';
import { NoticiasOficiaisComponent } from './admin/noticias-oficiais/noticias-oficiais.component';
import { PerfilComponent } from './admin/perfil/perfil.component';

@NgModule({
  declarations: [
    AppComponent,
    BaseSiteComponent,
    LoginComponent,
    FeedNoticiasComponent,
    BaseAdminComponent,
    ConfiguracaoComponent,
    CalendarioComponent,
    NoticiasOficiaisComponent,
    PerfilComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot([
    {
	    path: '',
	    component: BaseSiteComponent,
      children:[
        { path: '', component: LoginComponent},

        { path: 'login', component: LoginComponent}


      ]
	  },

    {
      path: 'user',
      component: BaseAdminComponent,
      children:[
        { path: '', component: FeedNoticiasComponent},
        { path: 'feed', component: FeedNoticiasComponent},
        { path: 'oficial', component: NoticiasOficiaisComponent},
        { path: 'configuracao', component: ConfiguracaoComponent},
        { path: 'calendario', component: CalendarioComponent},
        { path: 'perfil', component: PerfilComponent}
      ]
    }
  ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }




